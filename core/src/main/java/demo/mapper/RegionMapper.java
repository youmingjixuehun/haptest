package demo.mapper;

import com.hand.hap.mybatis.common.Mapper;
import demo.dto.Region;

import java.util.List;

/**
 * Created by ysh on 2017/5/15.
 */
public interface RegionMapper extends Mapper<Region> {
    List<Region> selectByRegion(Region region);
}
