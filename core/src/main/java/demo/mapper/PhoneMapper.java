package demo.mapper;

import com.hand.hap.mybatis.common.Mapper;
import demo.dto.Phone;

import java.util.List;

/**
 * Created by ysh on 2017/5/19.
 */
public interface PhoneMapper extends Mapper<Phone> {
    List<Phone> selectByPhone(Phone phone);
    int insertPhone(Phone phone);
    int updatePhone(Phone phone);
    int deletePhone(Phone phone);

    int deletePersonPhone(Phone phone);
}
