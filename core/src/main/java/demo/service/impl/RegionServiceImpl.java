package demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import demo.dto.Region;
import demo.mapper.RegionMapper;
import demo.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ysh on 2017/5/15.
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class RegionServiceImpl extends BaseServiceImpl<Region> implements IRegionService{
    @Autowired
    private RegionMapper regionMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor =
            Exception.class)
    public List<Region> selectByRegion(IRequest requestContext, Region region) {
        //PageHelper.startPage(page, pagesize);
        return regionMapper.selectByRegion(region);
    }
}
