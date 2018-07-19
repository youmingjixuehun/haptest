package demo.controllers;

import com.fasterxml.jackson.databind.JavaType;
import com.hand.hap.core.IRequest;
import com.hand.hap.excel.dto.ColumnInfo;
import com.hand.hap.excel.dto.ExportConfig;
import com.hand.hap.excel.service.IExportService;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import demo.dto.Demo;
import demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ysh on 2017/5/8.
 */
@Controller
@RequestMapping(path = "/demo")
public class DemoController  extends BaseController {

    @Autowired
    private IDemoService demoService;

    @Autowired
    IExportService excelService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData selectList(HttpServletRequest request, Demo condition,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        System.out.print("->/demo/query:selectList");
        IRequest iRequest = createRequestContext(request);
        List<Demo> datas = demoService.selectByDemo(iRequest, condition, page,
                pagesize);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submit(HttpServletRequest request, @RequestBody
            List<Demo> demos) {
        IRequest iRequest = createRequestContext(request);
        List<Demo> datas = demoService.batchUpdate(iRequest, demos);
        return new ResponseData(datas);
    }



    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody
            List<Demo> demos) {
        System.out.print("->/demo/delete: delete");
        IRequest iRequest = createRequestContext(request);
        //demoService.batchDelete(demos);
        demoService.deleteDemo(iRequest,demos);
        return new ResponseData();
    }

    @RequestMapping(value = "/export")
    public void createXLSForDemo(HttpServletRequest request, @RequestParam String config,
                                    HttpServletResponse httpServletResponse) {
        System.out.println("-------------------------------------------------");
        System.out.println("createXLSForDemo");
        System.out.println("-------------------------------------------------");
        IRequest requestContext = createRequestContext(request);
        try {

            JavaType type = objectMapper.getTypeFactory().constructParametrizedType(ExportConfig.class,
                    ExportConfig.class, Demo.class, ColumnInfo.class);

            ExportConfig<Demo, ColumnInfo> exportConfig = objectMapper.readValue(config, type);
            excelService.exportAndDownloadExcel("demo.mapper.DemoMapper.selectByDemo",
                    exportConfig, request, httpServletResponse, requestContext);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

