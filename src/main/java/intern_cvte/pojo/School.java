package intern_cvte.pojo;

import java.io.Serializable;

/**
 * Created by zxy on 2017/8/11.
 */
public class School implements Serializable{

    //学校所属省份
    private String province;


    //学校所属市
    private String city;

    //学校所在区
    private String district;

    //学校名称
    private String schoolName;

    //四位邀请码
    private String code;

    public School(){}

    public School(String province, String city, String district, String schoolName, String code){
        this.province = province;
        this.city = city;
        this.district = district;
        this.schoolName = schoolName;
        this.code = code;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getSchoolName()
    {
        return schoolName;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
