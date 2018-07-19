package demo.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import demo.dto.Region;

import java.util.List;

/**
 * Created by ysh on 2017/5/15.
 */
public interface IRegionService extends IBaseService<Region>,ProxySelf<IRegionService> {

    List<Region> selectByRegion(IRequest requestContext, Region region);
}
