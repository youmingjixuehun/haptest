package demo.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;
import demo.dto.Demo;

import java.util.List;

/**
 * Created by ysh on 2017/5/8.
 */
public interface IDemoService extends IBaseService<Demo>, ProxySelf<IDemoService> {

    List<Demo> selectByDemo(IRequest requestContext, Demo demo, int page, int
            pagesize);

    List<Demo> batchUpdate(IRequest requestContext, @StdWho List<Demo>
            demos);

    void deleteDemo(IRequest requestContext, @StdWho List<Demo> demos);
}
