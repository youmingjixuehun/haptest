package demo.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;
import demo.dto.Phone;

import java.util.List;

/**
 * Created by ysh on 2017/5/19.
 */
public interface IPhoneService extends IBaseService<Phone>,ProxySelf<IPhoneService>{
    List<Phone> selectByPhone(IRequest iRequest,Phone phone,int page,int pagesize);
    List<Phone> updatePhone(IRequest iRequest, @StdWho List<Phone> phones);
    void deletePhone(IRequest iRequest, @StdWho List<Phone> phones);
}
