package demo.dto;

import com.hand.hap.core.annotation.Children;
import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.system.dto.BaseDTO;
import org.springframework.ldap.odm.annotations.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * Created by ysh on 2017/4/23.
 */
@Table(name="my_test01")
@ExtensionAttribute(disable = true)
public class Demo extends BaseDTO {
    @Id
    @GeneratedValue(
            generator = "IDENTITY"
    )
    @Column
    private String myId;
    @Column
    @Condition(operator = "LIKE")
    private String myName;
    @Column
    private Long myAge;
    @Column
    private Date myBirthday;
    @Column
    private Double myAddress;
    @Transient
    private String regionName;

    @Children
    @Transient
    private List<Phone> phones;


    public String getMyId(){return myId;}

    public void setMyId(String myId) {this.myId = myId;}

    public String getMyName(){return myName;}

    public void setMyName(String myName){this.myName = myName;}

    public Long getMyAge(){return myAge;}

    public void setMyAge(Long myAge){this.myAge = myAge;}

    public Date getMyBirthday(){return myBirthday;}

    public void setMyBirthday(Date myBirthday){this.myBirthday = myBirthday;}

    public Double getMyAddress(){return myAddress;}

    public void setMyAddress(Double myAddress){this.myAddress = myAddress;}

    public String getRegionName(){return regionName;}

    public void setRegionName(String regionName){this.regionName = regionName;}

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}

