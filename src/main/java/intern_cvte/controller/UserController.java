package intern_cvte.controller;

import intern_cvte.pojo.User;
import intern_cvte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by zxy on 2017/8/13.
 */
@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String log(String province, String city, String district, String schoolName, String userName, String pwd, HttpServletRequest request){
        String sName = province + "," + city + "," + district + "," + schoolName;
        User isOK = userService.log(sName,userName,pwd);
        if(isOK!=null){
            request.getSession().setAttribute("user",isOK);
            return "test";
        }
        else {
            return "index";
        }
    }


    @RequestMapping("/register")
    @ResponseBody
    public String register(String schoolName, String userName, String pwd, String rpwd) throws UnsupportedEncodingException {

        boolean isOK = userService.register(schoolName,userName,pwd,rpwd);
        if (isOK){
            return "注册成功<a href='login'>点击此处返回登录</a>";
        }
        return "注册失败<a href='login'>点击此处返回注册</a>";
    }


    @RequestMapping("/apply")
    @ResponseBody
    public String get(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        //语法
        String schoolName = user.getSchoolName();
        String code = userService.apply(schoolName);

        return code;
    }


}
