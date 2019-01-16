package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.LayoutFolderDto;
import com.zhiyun.entity.Layout;
import com.zhiyun.entity.LayoutFolder;
import com.zhiyun.service.LayoutFolderService;
import com.zhiyun.service.LayoutService;
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
 * 布局文件
 * @auther xufei
 */
@Controller
@RequestMapping(value = "/layout", produces = "application/json;charset=UTF-8")
public class LayoutController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LayoutController.class);

    @Resource
    private LayoutService layoutService;
    @Resource
    private LayoutFolderService layoutFolderService;

    /**
     *  新增布局文件夹
     * @param layoutFolder
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-11-29 14:04:35
     */
    @ResponseBody
    @RequestMapping(value = "addFolder", method = { RequestMethod.GET, RequestMethod.POST })
    public Object addFolder(@Valid LayoutFolder layoutFolder, BindingResult bindingResult) {
        BaseResult<LayoutFolder> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            layoutFolder.setCompanyId(UserHolder.getCompanyId());
            layoutFolderService.addFolder(layoutFolder);
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
     * @param layoutFolder
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-11-29 14:42:40
     */
    @ResponseBody
    @RequestMapping(value = "upFolder", method = { RequestMethod.GET, RequestMethod.POST })
    public Object updateFolder(@Valid LayoutFolder layoutFolder, BindingResult bindingResult) {
        BaseResult<LayoutFolder> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            layoutFolder.setCompanyId(UserHolder.getCompanyId());
            layoutFolderService.upFolder(layoutFolder);
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
     *  删除布局文件夹
     * @param layoutFolder
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-11-29 14:42:40
     */
    @ResponseBody
    @RequestMapping(value = "delFolder", method = { RequestMethod.GET, RequestMethod.POST })
    public Object delFolder(@Valid LayoutFolder layoutFolder, BindingResult bindingResult) {
        BaseResult<LayoutFolder> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("删除成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            layoutFolderService.delFolder(layoutFolder);
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
     * 获取布局文件树
     * @param layoutFolder
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-11-29 15:27:20
     */
    @ResponseBody
    @RequestMapping(value = "getFolder", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getFolder(@Valid LayoutFolder layoutFolder, BindingResult bindingResult) {
        BaseResult<List<LayoutFolderDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            List<LayoutFolderDto> layoutFolderDtos =  layoutFolderService.getFolder(layoutFolder);
            baseResult.setModel(layoutFolderDtos);
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
     *  新增布局设计
     * @param layout
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-11-29 15:32:35
     */
    @ResponseBody
    @RequestMapping(value = "addDesign", method = { RequestMethod.GET, RequestMethod.POST })
    public Object addDesign(@Valid Layout layout, BindingResult bindingResult) {
        BaseResult<Layout> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            layout.setCompanyId(UserHolder.getCompanyId());
            layout.setId(null);
            layoutService.insert(layout);
            baseResult.setModel(layout);
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
     *  编辑布局设计
     * @param layout
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-11-29 15:36:09
     */
    @ResponseBody
    @RequestMapping(value = "upDesign", method = { RequestMethod.GET, RequestMethod.POST })
    public Object upDesign(@Valid Layout layout, BindingResult bindingResult) {
        BaseResult<Layout> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            layout.setCompanyId(UserHolder.getCompanyId());
            layoutService.update(layout);
            baseResult.setModel(layout);
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
     *  删除布局设计
     * @param layout
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-11-29 15:47:23
     */
    @ResponseBody
    @RequestMapping(value = "delDesign", method = { RequestMethod.GET, RequestMethod.POST })
    public Object delDesign(@Valid Layout layout, BindingResult bindingResult) {
        BaseResult<Layout> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("删除成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            if (layout.getId() != null) {
                layoutService.delete(layout.getId());
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
     * 布局设计详情
     * @param layout
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-11-30 08:49:08
     */
    @ResponseBody
    @RequestMapping(value = "getDesign", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getDesign(@Valid Layout layout, BindingResult bindingResult) {
        BaseResult<Layout> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            baseResult.setModel(layoutService.get(layout.getId()));
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
     * 布局设计下拉
     * @param layout
     * @param bindingResult
     * @return
     * @auther xufei
     * @date 2018-12-5 08:40:20
     */
    @ResponseBody
    @RequestMapping(value = "layoutDrop", method = { RequestMethod.GET, RequestMethod.POST })
    public Object layoutDrop(@Valid Layout layout, BindingResult bindingResult) {
        BaseResult<List<Layout>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("下拉成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            layout.setCompanyId(UserHolder.getCompanyId());
            UserHolder.getUserName();
            baseResult.setModel(layoutService.layoutDrop(layout));
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