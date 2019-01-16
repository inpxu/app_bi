package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.entity.LayoutFolder;
import com.zhiyun.entity.Linkage;
import com.zhiyun.service.LinkageService;
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
 * 看板联动
 * @auther xufei
 */
@Controller
@RequestMapping(value = "/link", produces = "application/json;charset=UTF-8")
public class LinkageController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkageController.class);

    @Resource
    private LinkageService linkageService;

    /**
     *  新增
     * @param linkage
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-24 09:28:21
     */
    @ResponseBody
    @RequestMapping(value = "add", method = { RequestMethod.GET, RequestMethod.POST })
    public Object add(@Valid Linkage linkage, BindingResult bindingResult) {
        BaseResult<Linkage> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            linkage.setCompanyId(UserHolder.getCompanyId());
            linkageService.insert(linkage);
            baseResult.setModel(linkage);
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
     *  编辑
     * @param linkage
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-24 09:29:27
     */
    @ResponseBody
    @RequestMapping(value = "upd", method = { RequestMethod.GET, RequestMethod.POST })
    public Object upd(@Valid Linkage linkage, BindingResult bindingResult) {
        BaseResult<Linkage> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            linkage.setCompanyId(UserHolder.getCompanyId());
            linkageService.update(linkage);
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
     *  删除
     * @param linkage
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-24 15:18:00
     */
    @ResponseBody
    @RequestMapping(value = "del", method = { RequestMethod.GET, RequestMethod.POST })
    public Object del(@Valid Linkage linkage, BindingResult bindingResult) {
        BaseResult<Linkage> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("删除成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            linkage.setCompanyId(UserHolder.getCompanyId());
            linkageService.delete(linkage.getId());
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