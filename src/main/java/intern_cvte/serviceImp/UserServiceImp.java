package intern_cvte.serviceImp;

import intern_cvte.dao.UserDao;
import intern_cvte.pojo.InviCode;
import intern_cvte.pojo.School;
import intern_cvte.pojo.User;
import intern_cvte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zxy on 2017/8/13.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;


    public User log(String schoolName, String userName, String pwd) {
        try {
            User user = userDao.queryByName(schoolName,userName,pwd);
            return user;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean register(String schoolName, String userName, String pwd, String rpwd) {
        if(schoolName.equals("") || userName.equals("") || pwd.equals("") || rpwd.equals(""))
            return false;
        if(!pwd .equals(rpwd)){
            return false;
        }
        else {
            try {
                //判断是否已经注册
                User u = userDao.queryByName(schoolName,userName,pwd);
                if(u != null){
                    return false;
                }
                User user = new User(userName,pwd,schoolName);
                userDao.addUser(user);  //将新用户写进数据库

                return true;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public String apply(String sName) {
        //申请邀请码由所属的学校去完成
        SchoolServiceImp schoolServiceImp = new SchoolServiceImp();
        String [] strings = sName.split(",");
        String code = schoolServiceImp.applyCode(strings[0],strings[1],strings[2],strings[3]);
        return code;
    }



}
