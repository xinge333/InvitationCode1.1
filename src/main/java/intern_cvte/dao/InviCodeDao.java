package intern_cvte.dao;


import intern_cvte.pojo.InviCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy on 2017/8/10.
 * 数据层处理
 */
public class InviCodeDao {
    /**
     * 查询全部的邀请码
     */
    public List<InviCode> queryAll() throws SQLException {
        List<InviCode> goddessList = new ArrayList<InviCode>();

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        StringBuilder sb = new StringBuilder();
        sb.append("select id,code,isUsed,schoolName from InvitationCode.InviCode");

        // 通过数据库的连接操作数据库，实现增删改查
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        ResultSet rs = ptmt.executeQuery();

        InviCode inviCode = null;

        while (rs.next()) {
            inviCode = new InviCode();
            inviCode.setId(rs.getInt("id"));
            inviCode.setCode(rs.getString("code"));
            inviCode.setUsed(rs.getBoolean("isUsed"));
            inviCode.setSchoolName(rs.getString("schoolName"));
            goddessList.add(inviCode);
        }
        return goddessList;
    }

    /**
     * 根据某个ID号查询邀请码
     *
     * @throws SQLException
     */
    public InviCode queryById(Integer id) throws SQLException {
        InviCode inviCode = null;

        Connection conn = DBUtil.getConnection();

        String sql = " select * from InviCode " + " where id=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, id);

        ResultSet rs = ptmt.executeQuery();

        while (rs.next()) {
            inviCode = new InviCode();
            inviCode.setId(rs.getInt("id"));
            inviCode.setCode(rs.getString("code"));
            inviCode.setUsed(rs.getBoolean("isUsed"));
            inviCode.setSchoolName(rs.getString("schoolName"));
        }
        return inviCode;
    }

    /**
     * 任意选出一个没有被占用的邀请码
     */
    public InviCode selectOneFree() throws SQLException {
        InviCode inviCode = null;
        Connection conn = DBUtil.getConnection();

        String sql = " select * from InviCode " + " where isUsed=? " + " limit 1";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setBoolean(1, false);

        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            inviCode = new InviCode();
            inviCode.setId(rs.getInt("id"));
            inviCode.setCode(rs.getString("code"));
            inviCode.setUsed(rs.getBoolean("isUsed"));
            inviCode.setSchoolName(rs.getString("schoolName"));
        }
        return inviCode;
    }


    /**
     * 添加邀请码
     *
     * @throws SQLException
     */
    public void addInviCode(InviCode inviCode) throws SQLException {
        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "insert into InviCode(id,code,isUsed,schoolName) values(?,?,?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, inviCode.getId());
        ptmt.setString(2, inviCode.getCode());
        ptmt.setBoolean(3, inviCode.getIsUsed());
        ptmt.setString(4, inviCode.getSchoolName());

        ptmt.execute();
    }

    /**
     * 修改邀请码资料
     *
     * @throws SQLException
     */
    public void updateInviCode(InviCode inviCode) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "update InviCode set id=?,code=?,isUsed=?,schoolName=? where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, inviCode.getId());
        ptmt.setString(2, inviCode.getCode());
        ptmt.setBoolean(3, inviCode.getIsUsed());
        ptmt.setString(4, inviCode.getSchoolName());
        ptmt.setInt(5, inviCode.getId());

        ptmt.execute();
    }

    /**
     * 删除字段
     *
     * @throws SQLException
     */
    public void deleteInviCode(Integer id) throws SQLException {
        Connection conn = DBUtil.getConnection();

        String sql = "delete from InviCode where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, id);

        ptmt.execute();
    }


}
