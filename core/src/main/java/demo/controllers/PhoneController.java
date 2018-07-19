package demo.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import demo.dto.Phone;
import demo.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ysh on 2017/5/19.
 */
@Controller
@RequestMapping(path = "/phone")
public class PhoneController extends BaseController{
    @Autowired
    private IPhoneService phoneService;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData select(HttpServletRequest request, Phone condition,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest iRequest = createRequestContext(request);
        List<Phone> datas = phoneService.selectByPhone(iRequest, condition, page,
                pagesize);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<Phone> phones){
        IRequest iRequest = createRequestContext(request);
        List<Phone> datas = phoneService.updatePhone(iRequest,phones);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Phone> phones){
        IRequest iRequest = createRequestContext(request);
        phoneService.deletePhone(iRequest,phones);
        return new ResponseData();
    }

}
