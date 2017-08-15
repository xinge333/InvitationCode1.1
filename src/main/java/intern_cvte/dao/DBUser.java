package intern_cvte.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zxy on 2017/8/13.
 */
public class DBUser {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/InvitationCode?useUnicode=true&characterEncoding=utf-8";
    private static final String UNAME = "root";
    private static final String PWD = "root";
    private static Connection conn = null;

    static {
        try {
            // 1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获得数据库的连接
            conn = DriverManager.getConnection(URL, UNAME, PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }

}
