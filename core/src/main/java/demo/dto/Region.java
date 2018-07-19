package demo.dto;

import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.system.dto.BaseDTO;
import org.springframework.ldap.odm.annotations.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by ysh on 2017/5/15.
 */
@Table(name="region")
@ExtensionAttribute(disable = true)
public class Region extends BaseDTO{
    @Id
    @GeneratedValue(
            generator = "IDENTITY"
    )
    @Column
    private Double regionId;
    @Column
    private String regionCode;
    @Column
    private String regionName;
    @Column
    private Double parentId;
    @Column
    private Double regionLevel;
    @Column
    private Double regionOrder;
    @Column
    private String regionNameEn;
    @Column
    private String regionShortnameEn;

    public Double getRegionId(){return regionId;}
    public String getRegionCode(){return regionCode;}
    public String getRegionName(){return regionName;}
    public Double getParentId(){return parentId;}
    public Double getRegionLevel(){return regionLevel;}
    public Double getRegionOrder(){return regionOrder;}
    public String getRegionNameEn(){return regionNameEn;}
    public String getRegionShortnameEn(){return regionShortnameEn;}
}
