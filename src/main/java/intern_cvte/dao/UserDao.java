package intern_cvte.dao;


import intern_cvte.pojo.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zxy on 2017/8/13.
 */

@Component
public class UserDao {
    //根据用户名查询某个用户
    public User queryByName(String schoolName, String userName, String pwd) throws SQLException {
        User user = null;
        Connection conn = DBUser.getConnection();
        String sql = " select * from User " + " where userName=? AND password=? and schoolName=?";


        System.out.print(sql+"------------------"+schoolName);
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, userName);
        ptmt.setString(2, pwd);
        ptmt.setString(3, schoolName);

        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            user = new User();
            user.setUserName(rs.getString("userName"));
            user.setPwd(rs.getString("password"));
            user.setSchoolName(rs.getString("schoolName"));
        }
        return user;
    }

    //增加用户
    public void addUser(User user) throws SQLException {
        Connection conn = DBUser.getConnection();
        String sql = " insert into user (userName,password,schoolName) values(?,?,?) ";

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, user.getUserName());
        ptmt.setString(2, user.getPwd());
        ptmt.setString(3, user.getSchoolName());

        ptmt.execute();
    }

    //根据用户名和学校删除某个用户
    public void deleteUser(String userName, String schoolName) throws SQLException {
        Connection conn = DBUser.getConnection();
        String sql = "delete from User where userName=? and schoolName=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, userName);
        ptmt.setString(2, schoolName);

        ptmt.execute();
    }

    //修改某个用户信息
    public void updateUser(User user) throws SQLException {
        Connection conn = DBUser.getConnection();
        String sql = "update User set userName=?,password=?,schoolName=? where userName=? and schoolName=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, user.getUserName());
        ptmt.setString(2, user.getPwd());
        ptmt.setString(3, user.getSchoolName());
        ptmt.setString(4, user.getUserName());
        ptmt.setString(5, user.getSchoolName());

        ptmt.execute();

    }
}
