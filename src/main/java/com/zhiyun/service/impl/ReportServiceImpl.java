/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.*;
import com.zhiyun.dto.DatasourceLocationValueDto;
import com.zhiyun.dto.ReportDto;
import com.zhiyun.entity.*;
import com.zhiyun.util.VarToMapList;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.service.ReportService;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 看板信息Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("reportService")
public class ReportServiceImpl extends BaseServiceImpl<Report, Long> implements ReportService {

    @Value("${found_path}")
    private String FOUND_PATH = "";

    @Resource
    private ReportDao reportDao;
    @Resource
    private LayoutDao layoutDao;
    @Resource
    private ReportConfigDao reportConfigDao;
    @Resource
    private ReportTemplateDao reportTemplateDao;
    @Resource
    private DatasourceLocationValueDao datasourceLocationValueDao;
    @Resource
    private LinkageDao linkageDao;

    @Override
    protected BaseDao<Report, Long> getBaseDao() {
        return this.reportDao;
    }

    @Override
    @Transactional
    public void add(ReportDto reportDto) {
        reportDto.setCreateUserId(UserHolder.getUser().getId());
        String type = reportDto.getReportType();
        if ("自定义".equals(type)) {
            Long layId = reportDto.getLayoutId();
            if (layId == null) {
                throw new BusinessException("布局为空！");
            }
            reportDao.insert(reportDto);
            Layout layout = layoutDao.get(layId);
            if (layout == null) {
                throw new BusinessException("数据错误！");
            }
            ReportConfig reportConfig = new ReportConfig();
            reportConfig.setLayoutConfig(layout.getConfig());
            reportConfig.setReportId(reportDto.getId());
            reportConfig.setCompanyId(UserHolder.getCompanyId());
            reportConfig.setLayoutId(layId);
            reportConfigDao.insert(reportConfig);
        }
        if ("专业模板".equals(type)) {
            reportDao.insert(reportDto);
        }

    }

    @Override
    public ReportDto getRe(Report report) {
        Report rep = reportDao.get(report.getId());
        String type = rep.getReportType();
        ReportDto reportDto = new ReportDto();
        BeanUtils.copyProperties(rep, reportDto);
        Long userId = UserHolder.getUser().getId();
        Report rept = new Report();
        rept.setId(report.getId());
        rept.setCreateUserId(userId);
        rept.setFolderId(rep.getFolderId());
        rept.setCompanyId(UserHolder.getCompanyId());
        List<ReportDto> lis = reportDao.getTree(rept);
        if (CollectionUtils.isNotEmpty(lis)) {
            ReportDto report1 = lis.get(0);
            Long is = report1.getIsDesisn();
            Long cid = report1.getCreateUserId();
            if (is == null || is == 0) {
                reportDto.setDesisn(false);
            } else if (is == 1) {
                reportDto.setDesisn(true);
            }
            if (cid.equals(userId)) {
                reportDto.setDesisn(true);
                reportDto.setGiveDes(true);
            } else {
                reportDto.setGiveDes(false);
            }
        } else {
            reportDto.setDesisn(false);
            reportDto.setGiveDes(false);
        }
        if ("自定义".equals(type)) {
            ReportConfig reportConfig = new ReportConfig();
            reportConfig.setReportId(report.getId());
            reportConfig.setCompanyId(UserHolder.getCompanyId());
            List<ReportConfig> list = reportConfigDao.find(reportConfig);
            if (CollectionUtils.isNotEmpty(list)) {
                reportDto.setId(report.getId());
                reportDto.setConfig(list.get(0).getConfig());
                reportDto.setLayoutConfig(list.get(0).getLayoutConfig());
                reportDto.setLayoutId(list.get(0).getLayoutId());
                DatasourceLocationValue value = new DatasourceLocationValueDto();
                value.setBoardId(report.getId());
                value.setCompanyId(UserHolder.getCompanyId());
                List<DatasourceLocationValue> list1 = datasourceLocationValueDao.find(value);
                List<DatasourceLocationValueDto> dtos = new ArrayList<>();
                if (CollectionUtils.isNotEmpty(list1)) {
                    for (DatasourceLocationValue loc : list1) {
                        DatasourceLocationValueDto valueDto = new DatasourceLocationValueDto();
                        BeanUtils.copyProperties(loc, valueDto);
                        if (!"远程".equals(loc.getType())) {
                            String figure = loc.getFigure();
                            String veidoo = loc.getVeidoo();
                            valueDto.setFigure(figure);
                            valueDto.setVeidoo(veidoo);
                            List<String> fl = new ArrayList<>();
                            if (figure != null) {
                                figure = figure.replace("]", "").replace("[", "");
                                if (!figure.equals("")) {
                                    fl = VarToMapList.varToKey(figure);
                                }
                            }
                            List<String> vl = new ArrayList<>();
                            if (veidoo != null) {
                                if (!veidoo.equals("")) {
                                    veidoo = veidoo.replace("]", "").replace("[", "");
                                    vl = VarToMapList.varToKey(veidoo);
                                }
                            }
                            if (CollectionUtils.isNotEmpty(fl) && CollectionUtils.isNotEmpty(vl)) {
                                vl.addAll(fl);
                            }
                            if (CollectionUtils.isEmpty(vl)) {
                                vl = fl;
                            }
                            if (CollectionUtils.isEmpty(vl)) {
                                valueDto.setFigureValue(null);
                            } else {
                                String domain = datasourceLocationValueDao.get(loc.getId()).getDomain();
                                if (domain != null) {
                                    String b = domain.replace("]", "").replace("[", "");
                                    String[] strs = b.split("},");

                                    List<Object> lm = new ArrayList<>();
                                    for (String str : strs) {
                                        if (!str.endsWith("}")) {
                                            str = str + "}";
                                        }
                                        Map jo = JSON.parseObject(str);
                                        Map<Object, Object> map = new HashMap<>();
                                        for (Object o : vl) {
                                            map.put(o, jo.get(o));
                                        }
                                        lm.add(JSONObject.toJSONString(map));
                                    }
                                    valueDto.setMaps(lm);

                                    List<Object> ls = new ArrayList<>();
                                    for (String str : strs) {
                                        if (!str.endsWith("}")) {
                                            str = str + "}";
                                        }
                                        // 获取key
                                        Map jo = JSON.parseObject(str);
                                        for (Object obj : jo.keySet()) {
                                            ls.add(obj);
                                        }
                                    }
                                    // 去除重复的key
                                    HashSet h = new HashSet(ls);
                                    ls.clear();
                                    ls.addAll(h);
                                    valueDto.setKeyls(ls);
                                    dtos.add(valueDto);
                                }
                            }
                        } else {
                            String find = loc.getFindDate();
                            String json = loc.getFindCondList();
                            String[] strs = find.split(",");
                            List<String> list2 = new ArrayList<>();
                            if (find != null && find != "") {
                                for (String str : strs) {
                                    list2.add(str);
                                }
                            }
                            valueDto.setFindList(list2);
                            if (json != null) {

                            }
                            dtos.add(valueDto);
                        }
                    }
                }
                reportDto.setDatasourceLocationValueDtos(dtos);
                Linkage linkage = new Linkage();
                linkage.setBoardId(report.getId());
                linkage.setCompanyId(UserHolder.getCompanyId());
                List<Linkage> linkages = linkageDao.find(linkage);
                reportDto.setLinkages(linkages);
            }
        }
        if ("专业模板".equals(type)) {
            Long id = rep.getTemplateId();
            ReportTemplate reportTemplate = reportTemplateDao.get(id);
            String path = rep.getTemplateUrl();
            path = FOUND_PATH + (path.substring(path.lastIndexOf("/"))).replace("/", "") + "/";
            // index页面路径
            reportDto.setUnzipPath(path + "index.html");
            // 图片展示路径
            reportDto.setPic(path + "index.jpg");
        }
        return reportDto;
    }

    @Override
    @Transactional
    public void upRe(ReportDto reportDto) {
        reportDao.update(reportDto);
        // 看板主键
        Long reportId = reportDto.getId();
        // 看板信息
        Report report = reportDao.get(reportId);
        // 配置主键
        Long layId = reportDto.getLayoutId();
        ReportConfig reportConfig = new ReportConfig();
        reportConfig.setCompanyId(UserHolder.getCompanyId());
        reportConfig.setReportId(reportId);
        List<ReportConfig> list = reportConfigDao.find(reportConfig);
        if (CollectionUtils.isNotEmpty(list)) {
            reportConfig.setId(list.get(0).getId());
        }
        if (layId != null) {
            // 配置信息
            reportConfig.setLayoutConfig(reportDto.getLayoutConfig());
            // 配置主键
            reportConfig.setLayoutId(layId);
        }
        reportConfig.setConfig(reportDto.getConfig());
        reportConfig.setReportId(report.getId());
        reportConfigDao.update(reportConfig);
    }

    @Override
    @Transactional
    public void copy(ReportDto reportDto) {
        String type = reportDto.getReportType();
        if ("自定义".equals(type)) {
            Report report = reportDao.get(reportDto.getId());
            report.setId(null);
            reportDao.insert(report);
            ReportConfig reportConfig = new ReportConfig();
            reportConfig.setReportId(reportDto.getId());
            reportConfig.setCompanyId(UserHolder.getCompanyId());
            List<ReportConfig> list = reportConfigDao.find(reportConfig);
            if (CollectionUtils.isNotEmpty(list)) {
                ReportConfig rg = reportConfigDao.get(list.get(0).getId());
                rg.setId(null);
                rg.setReportId(report.getId());
                reportConfigDao.insert(rg);
            }
            DatasourceLocationValue value = new DatasourceLocationValueDto();
            value.setBoardId(reportDto.getId());
            value.setCompanyId(UserHolder.getCompanyId());
            List<DatasourceLocationValue> list1 = datasourceLocationValueDao.find(value);
            if (CollectionUtils.isNotEmpty(list1)) {
                for (DatasourceLocationValue locationValue : list1) {
                    locationValue.setId(null);
                    locationValue.setBoardId(report.getId());
                    datasourceLocationValueDao.insert(locationValue);
                }
            }
        }
        if ("专业模板".equals(type)) {
            reportDao.insert(reportDto);
        }
    }

    @Override
    @Transactional
    public void del(Long id) {
        reportDao.delete(id);
        DatasourceLocationValue da = new DatasourceLocationValueDto();
        da.setBoardId(id);
        da.setCompanyId(UserHolder.getCompanyId());
        List<DatasourceLocationValue> list = datasourceLocationValueDao.find(da);
        if (CollectionUtils.isNotEmpty(list)) {
            for (DatasourceLocationValue value : list) {
                datasourceLocationValueDao.delete(value.getId());
            }
        }
    }
}
