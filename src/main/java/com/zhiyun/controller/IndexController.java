package com.zhiyun.controller;

import com.zhiyun.base.controller.BaseController;
import com.zhiyun.client.UserHolder;
import com.zhiyun.entity.Report;
import com.zhiyun.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/index")
public class IndexController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private ReportService reportService;

    /**
     * 配置页面
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("request in");
        model.addAttribute("userName", UserHolder.getUser().getUserName());
        model.addAttribute("accountName", UserHolder.getUser().getAccountName());
        model.addAttribute("companyName", UserHolder.getUser().getCompanyName());
        return "demo/index";
    }

    /**
     * 展示页面
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/page", method = {RequestMethod.GET, RequestMethod.POST})
    public String page(Model model, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("request in");
        model.addAttribute("userName", UserHolder.getUser().getUserName());
        model.addAttribute("accountName", UserHolder.getUser().getAccountName());
        model.addAttribute("companyName", UserHolder.getUser().getCompanyName());
//        model.addAttribute("id", request.getParameter("id"));
//        Long id = Long.valueOf(Long.parseLong(request.getParameter("id")));
//        Report report = reportService.get(id);
//        model.addAttribute("reportName", report.getAlias());
        return "demo/page";
    }
}