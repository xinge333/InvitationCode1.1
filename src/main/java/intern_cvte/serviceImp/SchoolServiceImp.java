package intern_cvte.serviceImp;

import intern_cvte.dao.SchoolDao;
import intern_cvte.pojo.School;
import intern_cvte.service.Action;
import intern_cvte.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by zxy on 2017/8/14.
 */
public class SchoolServiceImp implements SchoolService {
    @Autowired
    private SchoolDao schoolDao = new SchoolDao();

    public boolean isRegister(String province, String city, String district, String schoolName) {

        try {
            if(schoolDao.isRegisted(province,city,district,schoolName)){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isApplied(String province, String city, String district, String schoolName) {
        try {
            if(schoolDao.queryCodeByName(province,city,district,schoolName) != null){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean register(String province, String city, String district, String schoolName) {
        if (isRegister(province,city,district,schoolName))
            return false;
        School school = new School(province,city,district,schoolName,null);
        try {
            schoolDao.addSchool(school);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public String applyCode(String province, String city, String district, String schoolName) {
        if (isApplied(province,city,district,schoolName)){
            try {
                return "您已经申请过了邀请码："+schoolDao.queryCodeByName(province,city,district,schoolName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //拼接完整学校名称
        String sName = province + "," + city + "," + district + "," + schoolName;
        //从数据获取邀请码的逻辑
        Action oprator = new Action();
        String code = null;
        try {
            code = oprator.DistributeCode(sName);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        School school = new School(province,city,district,schoolName,code);
        try {
            //更新school数据库的值
            schoolDao.updateSchoolCode(school);
        }catch (Exception e){
            e.printStackTrace();
        }
        return code;
    }

    public ArrayList<String> getProvince() {
        try {
            return schoolDao.getProvince();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getCity(String province) {
        try {
            return schoolDao.getCity(province);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getDistrict(String province, String city) {
        try {
            return schoolDao.getDistrict(province,city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getSchool(String province, String city, String district) {
        try {
            return schoolDao.getSchool(province,city,district);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
