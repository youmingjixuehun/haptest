package demo.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import demo.dto.Demo;
import demo.dto.Region;
import demo.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ysh on 2017/5/15.
 */
@RestController
@RequestMapping(path = "/region")
public class RegionController extends BaseController{
    @Autowired
    private IRegionService regionService;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectList(HttpServletRequest request, Region condition) {
        IRequest iRequest = createRequestContext(request);
        List<Region> datas = regionService.selectByRegion(iRequest, condition);
        return new ResponseData(datas);
    }
}
