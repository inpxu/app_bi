package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.ReportTemplateDto;
import com.zhiyun.entity.LayoutFolder;
import com.zhiyun.entity.ReportTemplate;
import com.zhiyun.service.ReportTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 专业看板库
 * @auther xufei
 */
@Controller
@RequestMapping(value = "/template", produces = "application/json;charset=UTF-8")
public class TemplateController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    @Resource
    private ReportTemplateService reportTemplateService;

    /**
     *  新增专业看板
     * @param reportTemplate
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-3 16:21:17
     */
    @ResponseBody
    @RequestMapping(value = "addTemplate", method = { RequestMethod.GET, RequestMethod.POST })
    public Object addTemplate(@Valid ReportTemplate reportTemplate, BindingResult bindingResult) {
        BaseResult<LayoutFolder> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            reportTemplateService.addTemplate(reportTemplate);
        } catch (BusinessException be) {
            LOGGER.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            LOGGER.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult);
    }

    /**
     *  模糊查询
     * @param reportTemplate
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-4 13:34:09
     */
    @ResponseBody
    @RequestMapping(value = "getPage", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getPage(@Valid ReportTemplate reportTemplate, Pager pager, BindingResult bindingResult) {
        BaseResult<DataGrid<ReportTemplateDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            Params params = Params.create();
            params.add("entity",reportTemplate);
            baseResult.setModel(reportTemplateService.getPage(params,pager));
        } catch (BusinessException be) {
            LOGGER.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            LOGGER.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult);
    }

    /**
     *  删除专业看板
     * @param reportTemplate
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-4 13:34:09
     */
    @ResponseBody
    @RequestMapping(value = "del", method = { RequestMethod.GET, RequestMethod.POST })
    public Object del(@Valid ReportTemplate reportTemplate, BindingResult bindingResult) {
        BaseResult<DataGrid<ReportTemplateDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            Long id = reportTemplate.getId();
            if (id == null) {
                throw new BusinessException("请选择要删除的看板");
            }
            reportTemplateService.delete(id);
        } catch (BusinessException be) {
            LOGGER.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            LOGGER.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult);
    }
}