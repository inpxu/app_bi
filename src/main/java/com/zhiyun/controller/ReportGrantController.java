package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.EmpFolderHcmDto;
import com.zhiyun.dto.ReportGrantDto;
import com.zhiyun.entity.EmpFolderHcm;
import com.zhiyun.entity.LayoutFolder;
import com.zhiyun.entity.ReportGrant;
import com.zhiyun.service.EmpFolderHcmService;
import com.zhiyun.service.ReportGrantService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * 权限设置
 * @auther xufei
 */
@Controller
@RequestMapping(value = "/grant", produces = "application/json;charset=UTF-8")
public class ReportGrantController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    @Resource
    private ReportGrantService reportGrantService;
    @Resource
    private EmpFolderHcmService empFolderHcmService;

    /**
     *  新增
     * @param reportGrant
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-7 10:07:19
     */
    @ResponseBody
    @RequestMapping(value = "add", method = { RequestMethod.GET, RequestMethod.POST })
    public Object add(@Valid ReportGrant reportGrant, BindingResult bindingResult) {
        BaseResult<ReportGrant> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        try {
        vaildParamsDefault(baseResult, bindingResult);
            reportGrant.setCompanyId(UserHolder.getCompanyId());
            reportGrantService.add(reportGrant);
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
     *  员工查询下拉
     * @param empFolderHcm
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-11 14:12:05
     */
    @ResponseBody
    @RequestMapping(value = "getEmp", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getEmp(@Valid EmpFolderHcm empFolderHcm, BindingResult bindingResult) {
        BaseResult<List<EmpFolderHcmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            empFolderHcm.setCompanyId(UserHolder.getCompanyId());
            List<EmpFolderHcmDto> list = empFolderHcmService.getEmp(empFolderHcm);
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

    /**
     *  删除
     * @param ids
     * @return
     * @auther xufei
     * @date 2018-12-12 10:07:19
     */
    @ResponseBody
    @RequestMapping(value = "del", method = { RequestMethod.GET, RequestMethod.POST })
    public Object del(@Valid Long[] ids) {
        BaseResult<ReportGrant> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        try {
            if (ArrayUtils.isEmpty(ids)) {
                throw new BusinessException("请选择需要删除的信息！");
            }
            for (Long id : ids) {
                reportGrantService.delete(id);
            }
            baseResult.setMessage("删除成功");
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
     * @param reportGrant
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-12 10:07:19
     */
    @ResponseBody
    @RequestMapping(value = "upd", method = { RequestMethod.GET, RequestMethod.POST })
    public Object upd(@Valid ReportGrant reportGrant, BindingResult bindingResult) {
        BaseResult<ReportGrant> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        try {
            vaildParamsDefault(baseResult, bindingResult);
            reportGrant.setCompanyId(UserHolder.getCompanyId());
            reportGrantService.update(reportGrant);
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
     * @param reportGrant
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-12 16:09:12
     */
    @ResponseBody
    @RequestMapping(value = "get", method = { RequestMethod.GET, RequestMethod.POST })
    public Object get(@Valid ReportGrant reportGrant, BindingResult bindingResult) {
        BaseResult<List<ReportGrantDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        try {
            vaildParamsDefault(baseResult, bindingResult);
            reportGrant.setCompanyId(UserHolder.getCompanyId());
            baseResult.setModel(reportGrantService.getGrant(reportGrant));
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