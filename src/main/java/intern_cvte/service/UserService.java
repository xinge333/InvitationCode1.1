package intern_cvte.service;

import intern_cvte.pojo.InviCode;
import intern_cvte.pojo.User;

/**
 * Created by zxy on 2017/8/13.
 */
public interface UserService {

    //用户登录
    User log(String schoolName, String userName, String pwd);

    //用户注册
    boolean register(String schoolName, String userName, String pwd, String rpwd);

    //用户申请邀请码
    String apply(String schoolName);

}
