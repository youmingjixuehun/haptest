package demo.mapper;

import com.hand.hap.mybatis.common.Mapper;
import demo.dto.Demo;
import demo.dto.Phone;

import java.util.List;

/**
 * Created by ysh on 2017/5/8.
 */
public interface DemoMapper extends Mapper<Demo> {
    List<Demo> selectByDemo(Demo demo);
    int insertDemo(Demo demo);
    int updateDemo(Demo demo);
    int deleteDemo(Demo demo);
}

