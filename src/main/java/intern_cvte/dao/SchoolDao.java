package intern_cvte.dao;


import intern_cvte.pojo.School;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by zxy on 2017/8/11.
 */
@Component
public class SchoolDao {

    //根据名称判断某个学校是否注册过
    public boolean isRegisted(String province, String city, String district, String schoolName) throws SQLException {
        Connection conn = DBschool.getConnection();

        String sql = " select count(*) number from School " + " where province=? and city=? and district=? and schoolName=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1,province);
        ptmt.setString(2,city);
        ptmt.setString(3,district);
        ptmt.setString(4,schoolName);

        ResultSet rs = ptmt.executeQuery();
        int num = rs.getInt("number");
        if(num > 0){
            return true;
        }
        else {
            return false;
        }
    }

    //添加某个学校
    public void addSchool(School school)throws SQLException{
        Connection conn = DBschool.getConnection();

        String sql = "insert into School(province,city,district,schoolName,code) values(?,?,?,?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,school.getProvince());
        ptmt.setString(2,school.getCity());
        ptmt.setString(3,school.getDistrict());
        ptmt.setString(4,school.getSchoolName());
        ptmt.setString(5,school.getCode());

        ptmt.execute();
    }

    //删除某个学校
    public void deleteSchool(String province, String city, String district, String schoolName) throws SQLException {
        Connection conn = DBschool.getConnection();

        String sql = "delete from School where province=? and city=? and district=? and schoolName=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,province);
        ptmt.setString(2,city);
        ptmt.setString(3,district);
        ptmt.setString(4,schoolName);

        ptmt.execute();
    }

    //修改某个学校对应的邀请码
    public void updateSchoolCode(School school) throws SQLException {
        Connection conn = DBschool.getConnection();

        String sql = "update School set province=?,city=?,district=?,schoolName=?,code=? where province=? and city=? and district=? and schoolName=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,school.getProvince());
        ptmt.setString(2,school.getCity());
        ptmt.setString(3,school.getDistrict());
        ptmt.setString(4,school.getSchoolName());
        ptmt.setString(5,school.getCode());
        ptmt.setString(6,school.getProvince());
        ptmt.setString(7,school.getCity());
        ptmt.setString(8,school.getDistrict());
        ptmt.setString(9,school.getSchoolName());

        ptmt.execute();
    }

    //根据名称查询某个学校的邀请码
    public String queryCodeByName(String province, String city, String district, String schoolName) throws SQLException {

        String code = null;
        Connection conn = DBschool.getConnection();

        String sql = " select * from School " + " where province=? and city=? and district=? and schoolName=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,province);
        ptmt.setString(2,city);
        ptmt.setString(3,district);
        ptmt.setString(4,schoolName);

        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            code = rs.getString("code");
        }
        return code;
    }

    //获取全部省份
    public ArrayList<String> getProvince() throws SQLException {
        ArrayList<String> arrayList = new ArrayList<String>();
        Connection conn = DBschool.getConnection();
        String sql = " select distinct province from School ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            arrayList.add(rs.getString("province"));
        }
        return arrayList;
    }

    //获取某个省对应啊的全部市
    public ArrayList<String> getCity(String province) throws SQLException {
        ArrayList<String> arrayList = new ArrayList<String>();
        Connection conn = DBschool.getConnection();
        String sql = " select distinct city from School " + "where province=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1,province);
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            arrayList.add(rs.getString("city"));
        }
        return arrayList;
    }

    //获取某个市对应的区
    public ArrayList<String> getDistrict(String province, String city) throws SQLException {
        ArrayList<String> arrayList = new ArrayList<String>();
        Connection conn = DBschool.getConnection();
        String sql = " select distinct district from School " + "where province=? and city=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1,province);
        ptmt.setString(2,city);
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            arrayList.add(rs.getString("district"));
        }
        return arrayList;
    }

    //获取某个区的全部学校
    public ArrayList<String> getSchool(String province, String city, String district) throws SQLException {
        ArrayList<String> arrayList = new ArrayList<String>();
        Connection conn = DBschool.getConnection();
        String sql = " select distinct shoolName from School " + "where province=? and city=? and district=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1,province);
        ptmt.setString(2,city);
        ptmt.setString(3,district);
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            arrayList.add(rs.getString("shoolName"));
        }
        return arrayList;
    }

}
