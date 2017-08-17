package intern_cvte.serviceImp;

import intern_cvte.dao.InviCodeDao;
import intern_cvte.pojo.InviCode;
import intern_cvte.service.InviCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by zxy on 2017/8/17.
 */
@Service
public class InviCodeServiceImp implements InviCodeService {
    @Autowired
    private InviCodeDao inviCodeDao = new InviCodeDao();
    InviCode inviCode = new InviCode();

    public void add(int id, String code, boolean isUsed, String schoolName) {
        inviCode.setId(id);
        inviCode.setCode(code);
        inviCode.setUsed(isUsed);
        inviCode.setSchoolName(schoolName);
        try {
            inviCodeDao.addInviCode(inviCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public InviCode get(Integer id) {
        try {
            return inviCodeDao.queryById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void edit(InviCode inviCode) {
        try {
            inviCodeDao.updateInviCode(inviCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            inviCodeDao.deleteInviCode(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String DistributeCode(String schoolName) {
        try {
            inviCode = inviCodeDao.selectOneFree();     //选出一个未使用的邀请码
            //根据学校名，为其分配，并持久化
            inviCode.setUsed(true);
            inviCode.setSchoolName(schoolName);
            //更新邀请码数据库中的值
            inviCodeDao.updateInviCode(inviCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inviCode.getCode();  //返回邀请码
    }
}
