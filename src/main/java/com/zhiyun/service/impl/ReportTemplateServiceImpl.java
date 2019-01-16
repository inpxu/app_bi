/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;
import javax.rmi.CORBA.Util;

import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ReportTemplateDto;
import com.zhiyun.util.GetUrl;
import com.zhiyun.util.ReadZipFile;
import com.zhiyun.util.ZipUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ReportTemplateDao;
import com.zhiyun.entity.ReportTemplate;
import com.zhiyun.service.ReportTemplateService;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * 专业模板库Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("reportTemplateService")
public class ReportTemplateServiceImpl extends BaseServiceImpl<ReportTemplate, Long> implements ReportTemplateService {

    @Value("${file_path}")
    private String FILE_PATH = "";

    @Value("${unzip_file_path}")
    private String UNZIP_FILE_PATH = "";

    @Value("${found_path}")
    private String FOUND_PATH = "";

    @Resource
    private ReportTemplateDao reportTemplateDao;

    @Override
    protected BaseDao<ReportTemplate, Long> getBaseDao() {
        return this.reportTemplateDao;
    }

    @Override
    @Transactional
    public void addTemplate(ReportTemplate reportTemplate) {
        String name = reportTemplate.getAlias();
        String path = reportTemplate.getTemplatePath();
        if (path == null) {
            throw new BusinessException("上传失败，请重新上传！");
        }
        ReportTemplate re = new ReportTemplate();
        re.setAlias(name);
        re.setCompanyId(UserHolder.getCompanyId());
        List<ReportTemplate> list = reportTemplateDao.find(re);
        if (CollectionUtils.isNotEmpty(list)) {
            throw new BusinessException("模板名称已存在！");
        }
//        reportTemplateDao.insert(reportTemplate);
        String fileName = (path.substring(path.lastIndexOf("/"))).replace("/", "");
        String filePath = UNZIP_FILE_PATH;
        // 下载客户上传的文件
        File file = GetUrl.saveUrlAs(path, filePath + fileName, "GET");
        File[] listFiles = file.listFiles();
        // 判断下载的文件是否为空
        if (listFiles.length <= 0) {
            throw  new BusinessException("添加文件异常，请重新添加！");
        }
//        System.out.println(file);
        String path1 = filePath + fileName + "\\" + (path.substring(path.lastIndexOf("/"))).replace("/", "");
        try {
            // 解析文件是否符合要求
            ReadZipFile.readZipFile(path1);
            try {
                // 解压下载的文件
                ZipUtil.unzip(path1, FILE_PATH + (path.substring(path.lastIndexOf("/"))).replace("/", "") + "\\");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        reportTemplateDao.insert(reportTemplate);
    }

    @Override
    public DataGrid<ReportTemplateDto> getPage(Params params, Pager pager) {
        DataGrid<ReportTemplateDto> dataGrid = reportTemplateDao.getPage(params, pager);
        for (ReportTemplateDto templateDto : dataGrid.getItems()) {
            Long com = UserHolder.getCompanyId();
            String userName = UserHolder.getUser().getUserName();
            String createName = templateDto.getCreateBy();
            if (userName == null) {
                throw new BusinessException("登录信息已失效！");
            }
            // 比较创建人与当前登录人 来确定是否能删除
            if (userName.equals(createName)) {
                templateDto.setDel(true);
            } else {
                templateDto.setDel(false);
            }
            String path = templateDto.getTemplatePath();
            path = FOUND_PATH + (path.substring(path.lastIndexOf("/"))).replace("/", "") + "/";
            File file = new File(FILE_PATH + (templateDto.getTemplatePath().substring(templateDto.getTemplatePath().lastIndexOf("/"))).replace("/", ""));
            String file1 = new String();
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file2 = files[i];
                // 获取文件内的图片名称
                if (String.valueOf(file2).endsWith(".jpg")) {
                    file1 = String.valueOf(file2.getName());
                }
            }
            templateDto.setUnzipPath(path + "index.html");
            templateDto.setPic(path + file1);
        }
        return dataGrid;
    }
}
