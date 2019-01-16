package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.entity.ReportConfig;
import com.zhiyun.service.ReportConfigService;
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
 * 看板布局变动
 * @auther xufei
 */
@Controller
@RequestMapping(value = "/repConfig", produces = "application/json;charset=UTF-8")
public class ReportConfigController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportConfigController.class);

    @Resource
    private ReportConfigService reportConfigService;
    /**
     *  编辑看板布局
     * @param reportConfig
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-24 10:27:39
     */
    @ResponseBody
    @RequestMapping(value = "upd", method = { RequestMethod.GET, RequestMethod.POST })
    public Object upd(@Valid ReportConfig reportConfig, BindingResult bindingResult) {
        BaseResult<ReportConfig> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("修改成功");
        try {
            vaildParamsDefault(baseResult, bindingResult)    ;
            reportConfig.setCompanyId(UserHolder.getCompanyId());
            reportConfigService.upd(reportConfig);
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