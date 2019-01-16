package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.DatasourceLocationValueDto;
import com.zhiyun.entity.DatasourceLocationValue;
import com.zhiyun.service.DatasourceLocationValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 本地数据源
 * @auther xufei
 */
@Controller
@RequestMapping(value = "/loc/val", produces = "application/json;charset=UTF-8")
public class LocationValueController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationValueController.class);

    @Resource
    private DatasourceLocationValueService datasourceLocationValueService;


    /**
     *  新增
     * @param datasourceLocationValue
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-8 10:18:27
     */
    @ResponseBody
    @RequestMapping(value = "add", method = { RequestMethod.GET, RequestMethod.POST })
    public Object add(@Valid DatasourceLocationValue datasourceLocationValue, BindingResult bindingResult) {
        BaseResult<DatasourceLocationValueDto> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationValue.setCompanyId(UserHolder.getCompanyId());
            baseResult.setModel(datasourceLocationValueService.add(datasourceLocationValue));
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
     * @param datasourceLocationValue
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-8 10:19:37
     */
    @ResponseBody
    @RequestMapping(value = "upd", method = { RequestMethod.GET, RequestMethod.POST })
    public Object upd(@Valid DatasourceLocationValueDto datasourceLocationValue, BindingResult bindingResult) {
        BaseResult<DatasourceLocationValue> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationValue.setCompanyId(UserHolder.getCompanyId());
            baseResult.setModel(datasourceLocationValueService.upd(datasourceLocationValue));
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
     * @param datasourceLocationValue
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-8 10:20:45
     */
    @ResponseBody
    @RequestMapping(value = "get", method = { RequestMethod.GET, RequestMethod.POST })
    public Object get(@Valid DatasourceLocationValue datasourceLocationValue, BindingResult bindingResult) {
        BaseResult<List<DatasourceLocationValue>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationValue.setCompanyId(UserHolder.getCompanyId());
            baseResult.setModel(datasourceLocationValueService.find(datasourceLocationValue));
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
     *  通过key值查询
     * @param datasourceLocationValueDto
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-8 10:22:13
     */
    @ResponseBody
    @RequestMapping(value = "getByKey", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getByKey(@RequestBody @Valid DatasourceLocationValueDto datasourceLocationValueDto, BindingResult bindingResult) {
        BaseResult<DatasourceLocationValueDto> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationValueDto.setCompanyId(UserHolder.getCompanyId());
            baseResult.setModel(datasourceLocationValueService.getByKey(datasourceLocationValueDto));
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
     * 删除
     * @param datasourceLocationValue
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "del", method = { RequestMethod.GET, RequestMethod.POST })
    public Object del(@Valid DatasourceLocationValue datasourceLocationValue, BindingResult bindingResult) {
        BaseResult<DatasourceLocationValue> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("删除成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationValueService.delete(datasourceLocationValue.getId());
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
     * 远端保存
     * @param datasourceLocationValueDto
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addOrUpd", method = { RequestMethod.GET, RequestMethod.POST })
    public Object addOrUpd(@Valid @RequestBody DatasourceLocationValueDto datasourceLocationValueDto, BindingResult bindingResult) {
        BaseResult<DatasourceLocationValueDto> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("保存成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationValueDto.setCompanyId(UserHolder.getCompanyId());
            DatasourceLocationValueDto value = datasourceLocationValueService.addOrUpd(datasourceLocationValueDto);
            baseResult.setModel(value);
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
     * 远端信息获取
     * @param datasourceLocationValue
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "longGet", method = { RequestMethod.GET, RequestMethod.POST })
    public Object longGet(@Valid DatasourceLocationValue datasourceLocationValue, BindingResult bindingResult) {
        BaseResult<List<DatasourceLocationValue>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            datasourceLocationValue.setCompanyId(UserHolder.getCompanyId());
            List<DatasourceLocationValue> list = datasourceLocationValueService.find(datasourceLocationValue);
            baseResult.setModel(list);
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