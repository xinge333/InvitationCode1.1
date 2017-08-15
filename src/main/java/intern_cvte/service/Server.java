package intern_cvte.service;


import intern_cvte.dao.InviCodeDao;
import intern_cvte.dao.SchoolDao;
import intern_cvte.pojo.InviCode;
import intern_cvte.pojo.School;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zxy on 2017/8/11.
 */
public class Server {
    //定义默认服务器端口
    private int port = 8189;

    public void service() {
        int i = 1; //表示连接到服务器的个数
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            //循环监听客户端请求
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("第" + i + "个客户连接成功！");
                i++;
                new Thread(new ServerThread(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        System.out.println("正在监听连接...");
        new Server().service();
    }

}

class ServerThread implements Runnable {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public boolean isBlank(String s) {
        if (s == "" || s == "\t" || s == "\r" || s == "\n" || s == "\b")
            return true;
        return false;
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    //为每一个申请的客户提供一个邀请码
    public synchronized void run() {
        School school;
        InviCode inviCode;
        SchoolDao schoolDao = new SchoolDao();
        InviCodeDao inviCodeDao = new InviCodeDao();
        Action operator = new Action(); //邀请码操作

        try {
            //读取客户端发送过来的信息的流
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //发送给客户端的流
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            try {
                while (true) {
                    //读取来自客户端的信息(学校名)
                    String shoolName = dataInputStream.readUTF();
                    String[] sName = shoolName.split(",");
                    if (sName.length <= 4) {
                        dataOutputStream.writeUTF("学校名称不完整，请重新输入：");
                        dataOutputStream.flush();
                    }
                    //判断是否已经获取过
                    else if (schoolDao.isRegisted(sName[0], sName[1], sName[2], sName[3])) {
                        dataOutputStream.writeUTF("您已经申请过邀请码，请不要重复申请" + "\n" + "您申请的邀请码为：" + schoolDao.queryCodeByName(sName[0], sName[1], sName[2], sName[3]));
                        dataOutputStream.flush();
                    } else {
                        //获得一个邀请码
                        String code = operator.DistributeCode(shoolName);
                        school = new School(sName[0], sName[1], sName[2], sName[3], code);
                        schoolDao.addSchool(school);    //数据库添加该客户
                        //由邀请码获得该邀请码的ID
                        inviCode = new InviCode(Resolution.deCode(code.toCharArray()), code, true, shoolName);
                        inviCodeDao.updateInviCode(inviCode);    //数据库更新该值
                        dataOutputStream.writeUTF("您申请的邀请码为： " + code);
                        dataOutputStream.flush();
                    }
                }
            } catch (IOException e) {
                System.out.println("客户端连接中断...." + socket);
            } finally {// 建立连接失败的话不会执行socket.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
