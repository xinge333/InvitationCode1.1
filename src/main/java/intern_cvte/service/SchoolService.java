package intern_cvte.service;

import java.util.ArrayList;

/**
 * Created by zxy on 2017/8/14.
 */
public interface SchoolService {
    //查询学校是否已经注册过
    boolean isRegister(String province, String city, String district, String schoolName);

    //查询学校是否已经申请邀请码
    boolean isApplied(String province, String city, String district, String schoolName);

    //注册学校
    boolean register(String province, String city, String district, String schoolName);

    //获取邀请码
    String applyCode(String province, String city, String district, String schoolName);

    //获取所有省份
    ArrayList<String> getProvince();

    //获取省对应的市
    ArrayList<String> getCity(String province);

    //获取市对应的区
    ArrayList<String> getDistrict(String province, String city);

    //获取某个区下所有的学校
    ArrayList<String> getSchool(String province, String city, String district);
}
