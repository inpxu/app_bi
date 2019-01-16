package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ReportDto;
import com.zhiyun.dto.ReportFolderDto;
import com.zhiyun.entity.LayoutFolder;
import com.zhiyun.entity.Report;
import com.zhiyun.entity.ReportFolder;
import com.zhiyun.service.ReportFolderService;
import com.zhiyun.service.ReportService;
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
 * 看板中心
 * @auther xufei
 */
@Controller
@RequestMapping(value = "/report", produces = "application/json; charset=utf-8")
public class ReportController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

    @Resource
    private ReportFolderService reportFolderService;
    @Resource
    private ReportService reportService;

    /**
     *  新增文件夹
     * @param reportFolder
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-5 14:06:07
     */
    @ResponseBody
    @RequestMapping(value = "addFolder", method = { RequestMethod.GET, RequestMethod.POST })
    public Object addFolder(@Valid ReportFolder reportFolder, BindingResult bindingResult) {
        BaseResult<ReportFolder> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            reportFolder.setCompanyId(UserHolder.getCompanyId());
            reportFolderService.add(reportFolder);
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
     *  编辑布局文件夹
     * @param reportFolder
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-5 14:13:42
     */
    @ResponseBody
    @RequestMapping(value = "upFolder", method = { RequestMethod.GET, RequestMethod.POST })
    public Object updateFolder(@Valid ReportFolder reportFolder, BindingResult bindingResult) {
        BaseResult<LayoutFolder> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            reportFolder.setCompanyId(UserHolder.getCompanyId());
            reportFolderService.upd(reportFolder);
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
     *  删除文件夹
     * @param reportFolder
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-5 14:44:54
     */
    @ResponseBody
    @RequestMapping(value = "delFolder", method = { RequestMethod.GET, RequestMethod.POST })
    public Object delFolder(@Valid ReportFolder reportFolder, BindingResult bindingResult) {
        BaseResult<LayoutFolder> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("删除成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            reportFolder.setCompanyId(UserHolder.getCompanyId());
            reportFolderService.del(reportFolder);
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
     * 获取文件树
     * @param reportFolder
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-5 16:58:02
     */
    @ResponseBody
    @RequestMapping(value = "getTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getTree(@Valid ReportFolder reportFolder, BindingResult bindingResult) {
        BaseResult<List<ReportFolderDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            List<ReportFolderDto> reportFolderDtos =  reportFolderService.getTree(reportFolder);
            baseResult.setModel(reportFolderDtos);
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
     *  新增看板
     * @param reportDto
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-6 09:13:08
     */
    @ResponseBody
    @RequestMapping(value = "addRe", method = { RequestMethod.GET, RequestMethod.POST })
    public Object addRe(@Valid ReportDto reportDto, BindingResult bindingResult) {
        BaseResult<Report> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            reportDto.setCompanyId(UserHolder.getCompanyId());
            reportDto.setId(null);
            reportService.add(reportDto);
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
     *  复制看板
     * @param reportDto
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-6 09:13:08
     */
    @ResponseBody
    @RequestMapping(value = "copy", method = { RequestMethod.GET, RequestMethod.POST })
    public Object copy(@Valid ReportDto reportDto, BindingResult bindingResult) {
        BaseResult<Report> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("复制成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            reportDto.setCompanyId(UserHolder.getCompanyId());
            reportService.copy(reportDto);
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
     *  编辑看板
     * @param reportDto
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-6 09:15:00
     */
    @ResponseBody
    @RequestMapping(value = "upRe", method = { RequestMethod.GET, RequestMethod.POST })
    public Object upDesign(@Valid ReportDto reportDto, BindingResult bindingResult) {
        BaseResult<Report> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            reportDto.setCompanyId(UserHolder.getCompanyId());
            reportService.upRe(reportDto);
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
     *  删除看板
     * @param report
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-6 13:04:57
     */
    @ResponseBody
    @RequestMapping(value = "delRe", method = { RequestMethod.GET, RequestMethod.POST })
    public Object delDesign(@Valid Report report, BindingResult bindingResult) {
        BaseResult<Report> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("删除成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            if (report.getId() != null) {
                reportService.del(report.getId());
            }
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
     * 看板详情
     * @param report
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-6 13:05:02
     */
    @ResponseBody
    @RequestMapping(value = "getRe", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getDesign(@Valid Report report, BindingResult bindingResult) {
        BaseResult<Report> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            baseResult.setModel(reportService.getRe(report));
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