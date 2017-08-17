package intern_cvte.pojo;

import java.io.Serializable;

/**
 * Created by zxy on 2017/8/10.
 */
public class InviCode implements Serializable {
    /**
     * 唯一主键
     */
    private Integer id;

    //四位邀请码
    private String code;

    //表示是否被申请
    private Boolean isUsed;

    //拥有此邀请码的学校
    private String schoolName;

    public InviCode() {

    }

    public InviCode(int id, String code, boolean isUsed, String schoolName) {
        this.id = id;
        this.code = code;
        this.isUsed = isUsed;
        this.schoolName = schoolName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return (this.getId() + "," + this.getCode()
                + "," + this.getIsUsed() + "," + this.getSchoolName());
    }
}

