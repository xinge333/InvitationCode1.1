package intern_cvte.service;

import intern_cvte.pojo.InviCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy on 2017/8/14.
 */
public interface InviCodeService {
    //新增邀请码
    void add(int id, String code, boolean isUsed, String schoolName);

    //查询单个邀请码
    InviCode get(Integer id);
    
    //修改邀请码
    void edit(InviCode inviCode);

    //删除邀请码
    void delete(Integer id);

    //分配邀请码
    String DistributeCode(String schoolName);
}
