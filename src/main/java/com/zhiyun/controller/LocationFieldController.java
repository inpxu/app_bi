package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.entity.DatasourceLocationField;
import com.zhiyun.entity.LayoutFolder;
import com.zhiyun.service.DatasourceLocationFieldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 共享参数//
 * @auther xufei
 */
@Controller
@RequestMapping(value = "/loc/fld", produces = "application/json;charset=UTF-8")
public class LocationFieldController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationFieldController.class);

    @Resource
    private DatasourceLocationFieldService datasourceLocationFieldService;


    /**
     *  新增
     * @param datasourceLocationField
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-8 10:18:27
     */
    @ResponseBody
    @RequestMapping(value = "add", method = { RequestMethod.GET, RequestMethod.POST })
    public Object add(@Valid DatasourceLocationField datasourceLocationField, BindingResult bindingResult) {
        BaseResult<DatasourceLocationField> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationField.setCompanyId(UserHolder.getCompanyId());
            datasourceLocationFieldService.insert(datasourceLocationField);
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
     * @param datasourceLocationField
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-8 10:19:37
     */
    @ResponseBody
    @RequestMapping(value = "upd", method = { RequestMethod.GET, RequestMethod.POST })
    public Object upd(@Valid DatasourceLocationField datasourceLocationField, BindingResult bindingResult) {
        BaseResult<DatasourceLocationField> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationField.setCompanyId(UserHolder.getCompanyId());
            datasourceLocationFieldService.update(datasourceLocationField);
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
     *  查询
     * @param datasourceLocationField
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-8 10:20:45
     */
    @ResponseBody
    @RequestMapping(value = "get", method = { RequestMethod.GET, RequestMethod.POST })
    public Object get(@Valid DatasourceLocationField datasourceLocationField, BindingResult bindingResult) {
        BaseResult<List<DatasourceLocationField>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationField.setCompanyId(UserHolder.getCompanyId());
            baseResult.setModel(datasourceLocationFieldService.find(datasourceLocationField));
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
     * @param datasourceLocationField
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-8 10:22:13
     */
    @ResponseBody
    @RequestMapping(value = "del", method = { RequestMethod.GET, RequestMethod.POST })
    public Object del(@Valid DatasourceLocationField datasourceLocationField, BindingResult bindingResult) {
        BaseResult<DatasourceLocationField> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("删除成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationFieldService.delete(datasourceLocationField.getId());
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