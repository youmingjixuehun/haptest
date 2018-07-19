package demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import demo.dto.Demo;
import demo.dto.Phone;
import demo.mapper.DemoMapper;
import demo.mapper.PhoneMapper;
import demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ysh on 2017/5/8.
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class DemoServiceImpl extends BaseServiceImpl<Demo> implements IDemoService {
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private PhoneMapper phoneMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor =
            Exception.class)
    public List<Demo> selectByDemo(IRequest requestContext, Demo demo, int
            page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return demoMapper.selectByDemo(demo);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Demo> batchUpdate(IRequest requestContext, List<Demo> demos){
        for (Demo demo : demos) {
            if (demo.get__status() != null) {
                switch (demo.get__status()) {
                    case DTOStatus.ADD:
                        demoMapper.insertDemo(demo);
                        System.out.println("-----------------------");
                        System.out.println("demoMapper.insertDemo");
                        System.out.println("-----------------------");
                        if(demo.getPhones() != null) {
                            processPhone(demo);
                        }
                        break;
                    case DTOStatus.UPDATE:
                        demoMapper.updateDemo(demo);
                        System.out.println("-----------------------");
                        System.out.println("updateDemo");
                        System.out.println("-----------------------");
                        if(demo.getPhones() != null) {
                            processPhone(demo);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return demos;
    }


    private void processPhone(Demo demo){
        System.out.println("-----------------------");
        System.out.println("processPhone");
        System.out.println("-----------------------");
        for(Phone phone : demo.getPhones()){
            System.out.println("-----------------------");
            System.out.println(" in processPhone");
            System.out.println("-----------------------");
            if(phone.getPhoneId() == null){
                phone.setPersonId(demo.getMyId());
                phoneMapper.insertPhone(phone);
            }
            else if (phone.getPhoneId() != null){
                phoneMapper.updatePhone(phone);
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteDemo(IRequest requestContext, List<Demo> demos) {
        for (Demo demo: demos){
            System.out.println("-----------------------");
            System.out.println("deleteDemo");
            System.out.println("-----------------------");
            if (demo.get__status() != null) {
                Phone phone = new Phone();
                phone.setPersonId(demo.getMyId());
                phoneMapper.deletePersonPhone(phone);
                /*if (demo.getPhones() != null){  //demo.getPhones() is null
                    processDeletePhone(demo);
                }*/
                demoMapper.deleteDemo(demo);
            }
        }
    }

    private void processDeletePhone(Demo demo){
        System.out.println("-----------------------");
        System.out.println("processDeletePhone");
        System.out.println("-----------------------");
        for(Phone phone : demo.getPhones()){
            System.out.println("-----------------------");
            System.out.println(" in processDeletePhone");
            System.out.println("-----------------------");
                phone.setPersonId(demo.getMyId());
                phoneMapper.deletePersonPhone(phone);
        }
    }

}

