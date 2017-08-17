package intern_cvte.service;


import intern_cvte.dao.InviCodeDao;
import intern_cvte.pojo.InviCode;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zxy on 2017/8/10.
 */
public class Action {
    private volatile static InviCodeDao inviCodeDao = new InviCodeDao();
    private volatile static InviCode inviCode;

    /**
     * 新增邀请码
     *
     * @param inviCode
     * @throws Exception
     */
    public void add(InviCode inviCode, int id, String code, boolean isUsed, String schoolName) throws Exception {
        InviCodeDao dao = new InviCodeDao();
        inviCode.setId(id);
        inviCode.setCode(code);
        inviCode.setUsed(isUsed);
        inviCode.setSchoolName(schoolName);
        dao.addInviCode(inviCode);
    }

    /**
     * 查询单个邀请码
     */
    public InviCode get(Integer id) throws SQLException {
        InviCodeDao dao = new InviCodeDao();
        return dao.queryById(id);
    }

    /**
     * 修改邀请码
     */
    public void edit(InviCode inviCode) throws Exception {
        InviCodeDao dao = new InviCodeDao();
        dao.updateInviCode(inviCode);
    }

    /**
     * 删除邀请码
     */
    public void delete(Integer id) throws SQLException {
        InviCodeDao dao = new InviCodeDao();
        dao.deleteInviCode(id);
    }

    /**
     * 查询全部邀请码
     */
    public List<InviCode> query() throws Exception {
        InviCodeDao dao = new InviCodeDao();
        return dao.queryAll();
    }

    //分配邀请码
    public synchronized String DistributeCode(String schoolName) throws SQLException {
        inviCode = inviCodeDao.selectOneFree();     //选出一个未使用的邀请码
        //根据学校名，为其分配，并持久化
        inviCode.setUsed(true);
        inviCode.setSchoolName(schoolName);
        //更新邀请码数据库中的值
        inviCodeDao.updateInviCode(inviCode);
        return inviCode.getCode();  //返回邀请码
    }

}
