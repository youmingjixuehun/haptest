package demo.dto;

import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.system.dto.BaseDTO;
import org.springframework.ldap.odm.annotations.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by ysh on 2017/5/19.
 */
@Table(name="my_test01_phone")
@ExtensionAttribute(disable = true)
public class Phone extends BaseDTO{
    @Id
    @GeneratedValue(
            generator = "IDENTITY"
    )
    @Column
    private Long phoneId;
    @Column
    private String phoneNum;
    @Column
    private String phoneDesc;
    @Column
    private String personId;
    @Column
    private String phoneFlag;

    public Long getPhoneId() {
        return phoneId;
    }
    public void setPhoneId(Long phoneId){ this.phoneId = phoneId;}

    public String getPhoneDesc() {
        return phoneDesc;
    }
    public void setPhoneDesc(String phoneDesc){ this.phoneDesc = phoneDesc;}

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum){ this.phoneNum = phoneNum;}

    public String getPersonId() {
        return personId;
    }
    public void setPersonId(String personId){ this.personId = personId;}

    public String getPhoneFlag() {
        return phoneFlag;
    }

    public void setPhoneFlag(String phoneFlag) {
        this.phoneFlag = phoneFlag;
    }
}
