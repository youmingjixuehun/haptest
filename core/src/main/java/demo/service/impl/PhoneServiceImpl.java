package demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import demo.dto.Phone;
import demo.mapper.PhoneMapper;
import demo.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.util.List;

/**
 * Created by ysh on 2017/5/19.
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class PhoneServiceImpl extends BaseServiceImpl<Phone> implements IPhoneService {
    @Autowired
    private PhoneMapper phoneMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<Phone> selectByPhone(IRequest iRequest, Phone phone, int page, int pagesize) {
        PageHelper.startPage(page,pagesize);
        return phoneMapper.selectByPhone(phone);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Phone> updatePhone(IRequest iRequest, @StdWho List<Phone> phones) {
        for(Phone phone : phones){
            if(phone.get__status() != null){
                switch (phone.get__status()) {
                    case DTOStatus.ADD:
                        phoneMapper.insertPhone(phone);
                        break;
                    case DTOStatus.UPDATE:
                        phoneMapper.updatePhone(phone);
                        break;
                    default:
                        break;
                }
            }
        }
        return phones;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletePhone(IRequest iRequest, @StdWho List<Phone> phones) {
        for(Phone phone : phones){
            if(phone.get__status() != null){
                switch (phone.get__status()){
                    case DTOStatus.DELETE:
                        phoneMapper.deletePhone(phone);
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
