package intern_cvte.pojo;

/**
 * Created by zxy on 2017/8/13.
 * command + n(实现方法)
 */
public class User {
    private String userName;
    private String pwd;
    private String schoolName;

    public User() {}

    public User(String userName, String pwd, String schoolName){
        this.userName = userName;
        this.pwd = pwd;
        this.schoolName = schoolName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }

    public String getPwd(){
        return this.pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
