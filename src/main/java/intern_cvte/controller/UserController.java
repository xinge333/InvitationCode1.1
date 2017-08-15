package intern_cvte.controller;

import com.alibaba.fastjson.JSON;
import intern_cvte.pojo.User;
import intern_cvte.service.SchoolService;
import intern_cvte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by zxy on 2017/8/13.
 */
@Controller
@RequestMapping(produces = "text/html;charset=utf-8")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/login")
    public String log(String province, String city, String district, String sName, String userName, String pwd, HttpServletRequest request) {
        String ssName = province + "," + city + "," + district + "," + sName;
        User isOK = userService.log(ssName, userName, pwd);
        if (isOK != null) {
            request.getSession().setAttribute("user", isOK);
            return "test";
        } else {
            return "index";
        }
    }


    @RequestMapping("/register")
    @ResponseBody
    public String register(String province, String city, String district, String sName, String userName, String pwd, String rpwd) throws UnsupportedEncodingException {

        String ssName = province + "," + city + "," + district + "," + sName;
        if (province.equals("")||city.equals("")||district.equals("")||sName.equals("")||userName.equals("")||pwd.equals("")||rpwd.equals("")){
            return "注册失败,输入不能为空<a href='login'>点击此处返回注册</a>";
        }
        boolean isOK = userService.register(ssName, userName, pwd, rpwd);
        if (isOK) {
            return "注册成功<a href='login'>点击此处返回登录</a>";
        }
        return "注册失败<a href='login'>点击此处返回注册</a>";
    }


    @RequestMapping("/apply")
    @ResponseBody
    public String get(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        //语法
        String schoolName = user.getSchoolName();
        String code = userService.apply(schoolName);

        return code;
    }

    @RequestMapping("/getProvince")
    @ResponseBody
    public String getProvince() {
        ArrayList<String> arrayList;
        arrayList = schoolService.getProvince();
        return JSON.toJSONString(arrayList);
    }

    @RequestMapping("/getCity")
    @ResponseBody
    public String getCity(String province) {
        ArrayList<String> arrayList;
        arrayList = schoolService.getCity(province);
        return JSON.toJSONString(arrayList);
    }

    @RequestMapping("/getDistrict")
    @ResponseBody
    public String getDistrict(String province, String city) {
        ArrayList<String> arrayList;
        arrayList = schoolService.getDistrict(province, city);
        return JSON.toJSONString(arrayList);
    }

    @RequestMapping("/getSchool")
    @ResponseBody
    public String getSchool(String province, String city, String district) {
        ArrayList<String> arrayList;
        arrayList = schoolService.getSchool(province, city, district);
        return JSON.toJSONString(arrayList);
    }

    @RequestMapping("/addSchool")
    @ResponseBody
    public String addSchool(String province, String city, String district, String schoolName) {
        if(province.equals("")||city.equals("")||district.equals("")||schoolName.equals("")){
            return "注册失败,输入不能为空<a href='login'>点击此处返回注册</a>";
        }
        boolean isOK = schoolService.register(province,city,district,schoolName);
        if (isOK) {
            return "注册成功<a href='login'>点击此处返回登录</a>";
        }
        return "注册失败<a href='login'>点击此处返回注册</a>";
    }
}
