/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;
import javax.validation.constraints.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.LinkageDao;
import com.zhiyun.dto.DatasourceLocationValueDto;
import com.zhiyun.entity.Linkage;
import com.zhiyun.internal.newstandard.dcnew.DataInterface;
import com.zhiyun.internal.newstandard.dcnew.dto.DataRequestDto;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.DatasourceLocationValueDao;
import com.zhiyun.entity.DatasourceLocationValue;
import com.zhiyun.service.DatasourceLocationValueService;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 本地数据域Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("datasourceLocationValueService")
public class DatasourceLocationValueServiceImpl extends BaseServiceImpl<DatasourceLocationValue, Long> implements DatasourceLocationValueService {

    @Resource
    private DatasourceLocationValueDao datasourceLocationValueDao;

    @Resource
    private LinkageDao linkageDao;
    @Resource
    private DataInterface dataInterface;

    @Override
    protected BaseDao<DatasourceLocationValue, Long> getBaseDao() {
        return this.datasourceLocationValueDao;
    }

    @Override
    public DatasourceLocationValueDto add(DatasourceLocationValue datasourceLocationValue) {
        String domain = datasourceLocationValue.getDomain();
        Long boardId = datasourceLocationValue.getBoardId();
        String reportId = datasourceLocationValue.getReportId();
        if (domain == null || "".equals(domain)) {
            throw new BusinessException("数据不能为空");
        }
        DatasourceLocationValueDto datasourceLocationValueDto = new DatasourceLocationValueDto();
        // String 转 map
        String b = domain.replace("]", "").replace("[", "").replace("\n","");
        String[] strs = b.split("},");
//		System.err.println(strs);
        List<Object> ls = new ArrayList<>();
        for (String str : strs) {
            if (!str.replace("\"","").endsWith("}")) {
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
        if (CollectionUtils.isEmpty(ls)) {
            throw new BusinessException("数据域格式不正确");
        }
        DatasourceLocationValue value = new DatasourceLocationValueDto();
        value.setCompanyId(UserHolder.getCompanyId());
        value.setBoardId(boardId);
        value.setReportId(reportId);
        List<DatasourceLocationValue> list = datasourceLocationValueDao.find(value);
        if (CollectionUtils.isEmpty(list)) {
            for (DatasourceLocationValue locationValue : list) {
                datasourceLocationValueDao.delete(locationValue.getId());
            }
            datasourceLocationValueDao.insert(datasourceLocationValue);
        } else {
            for (DatasourceLocationValue locationValue : list) {
                datasourceLocationValue.setId(locationValue.getId());
                datasourceLocationValueDao.update(datasourceLocationValue);
            }

        }
        BeanUtils.copyProperties(datasourceLocationValue, datasourceLocationValueDto);
        // 添加json中解析出的key值
        datasourceLocationValueDto.setKeyls(ls);
        return datasourceLocationValueDto;
    }

    @Override
    @Transactional
    public DatasourceLocationValueDto upd(DatasourceLocationValueDto datasourceLocationValue) {
        String domain = datasourceLocationValue.getDomain();
        if (domain == null || "".equals(domain)) {
            throw new BusinessException("数据不能为空");
        }
        DatasourceLocationValueDto datasourceLocationValueDto = new DatasourceLocationValueDto();
        // String 转 map
        String b = domain.replace("]", "").replace("[", "").replace("\n","");
        String[] strs = b.split("},");
//		System.err.println(strs);
        List<Object> ls = new ArrayList<>();
        for (String str : strs) {
            if (!str.replace("\"","").endsWith("}")) {
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
        if (CollectionUtils.isEmpty(ls)) {
            throw new BusinessException("数据域格式不正确");
        }
        datasourceLocationValueDao.update(datasourceLocationValue);
        // 判断页面是否可以联动(页面如果是表格或卡片是不能联动的, 需要删除之前页面配置的联动信息)
        if (datasourceLocationValue.getForm() != null) {
            Boolean form = datasourceLocationValue.getForm();
            if (form) {
                String reportId = datasourceLocationValue.getReportId();
                Long boardId = datasourceLocationValue.getBoardId();
                Linkage data = new Linkage();
                data.setBoardId(boardId);
                data.setFromId(reportId);
                data.setCompanyId(UserHolder.getCompanyId());
                List<Linkage> list = linkageDao.find(data);
                if (CollectionUtils.isNotEmpty(list)) {
                    for (Linkage value : list) {
                        linkageDao.delete(value.getId());
                    }
                }
            }
        }
        BeanUtils.copyProperties(datasourceLocationValue, datasourceLocationValueDto);
        // 添加json中解析出的key值
        datasourceLocationValueDto.setKeyls(ls);
        return datasourceLocationValueDto;
    }

    @Override
    public DatasourceLocationValueDto getByKey(DatasourceLocationValueDto datasourceLocationValueDto) {
        DatasourceLocationValue da = datasourceLocationValueDao.get(datasourceLocationValueDto.getId());
        String type = da.getType();
        // 本地数据
        if (!"远程".equals(type)) {
            String domain = datasourceLocationValueDao.get(datasourceLocationValueDto.getId()).getDomain();
            List<Object> keyls = datasourceLocationValueDto.getKeyls();
            String b = domain.replace("]", "").replace("[", "");
            String[] strs = b.split("},");
            List<Object> ls = new ArrayList<>();
            for (String str : strs) {
                if (!str.endsWith("}")) {
                    str = str + "}";
                }
                Map jo = JSON.parseObject(str);
                Map<Object, Object> map = new HashMap<>();
                String values = datasourceLocationValueDto.getValues();
                if (CollectionUtils.isNotEmpty(keyls)) {
                    if (values == null) {
                        for (Object o : keyls) {
                            map.put(o, jo.get(o));
                        }
                        ls.add(JSONObject.toJSONString(map));
                    } else {
                        for (Object o : keyls) {
                            values = values.replace("\"", "").replace("{", "").replace("}", "");
                            String[] st = values.split(":");
                            String key = st[0];
                            String val = st[1];
                            String ov = String.valueOf(jo.get(o));
                            String oo = String.valueOf(o);
                            if (oo.equals(key) && ov.equals(val)) {
                                for (Object o1 : keyls) {
                                    map.put(o1, jo.get(o1));
                                }
                            }
                        }
                        if (!map.isEmpty()) {
                            ls.add(JSONObject.toJSONString(map));
                        }
                    }
                }
            }
            datasourceLocationValueDto.setMaps(ls);
            // 远端数据
        } else {
            BeanUtils.copyProperties(da, datasourceLocationValueDto);
            String find = da.getFindDate();
            String[] strs = find.split(",");
            List<String> list2 = new ArrayList<>();
            for (String str : strs) {
                list2.add(str);
            }
            datasourceLocationValueDto.setFindList(list2);
            Map<String, Object> paramMap = new HashMap<String, Object>();
            String json = da.getFindCondList();
            if (json != null) {
                for (Object o : JSON.parseArray(json)) {
                    String ob = String.valueOf(o);
                    String before = ob.substring(0, ob.indexOf(" "));
                    String after = ob.replaceFirst(before, "").replace(" ", "");
                    paramMap.put(before, after);
                }
            }
            Map<String, Object> displayMap = new HashMap<String, Object>();
            for (String s : list2) {
                displayMap.put(s, true);
            }
            // 调用数据中心的接口获取数据
            DataRequestDto dataRequestDto = new DataRequestDto();
            dataRequestDto.setDataModelCode(da.getDataModelCode());
            dataRequestDto.setVersion(da.getVersion());
            dataRequestDto.setDisplayJson(JSON.toJSONString(displayMap));
            dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));
            Long companyId = UserHolder.getCompanyId();
            Long user = UserHolder.getUser().getId();
            String appName = "app_bi";
            BaseResult<List<Map<String, String>>> baseResult = dataInterface.doSearch(dataRequestDto, appName, companyId, user);
            List<Object> ls = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(baseResult.getModel())) {
                for (Object o : baseResult.getModel()) {
                    ls.add(o);
                }
            }
            // 添加查询出的数据
            datasourceLocationValueDto.setMaps(ls);
        }
        // 添加当前时间
        datasourceLocationValueDto.setNowTime(new Date());
        return datasourceLocationValueDto;
    }

    @Override
    @Transactional
    public DatasourceLocationValueDto addOrUpd(DatasourceLocationValueDto datasourceLocationValueDto) {
        Long id = datasourceLocationValueDto.getId();
        DatasourceLocationValue datasourceLocationValue = new DatasourceLocationValue();
        BeanUtils.copyProperties(datasourceLocationValueDto, datasourceLocationValue);
        // 获取数据列,解析添加
        List<String> find = datasourceLocationValueDto.getFindList();
        String a = "";
        if (CollectionUtils.isNotEmpty(find)) {
            for (String s : find) {
                if (a == "") {
                    a = s;
                } else {
                    a = a + "," + s;
                }
            }
        }
        if (a == "") {
            a = null;
        }
        datasourceLocationValue.setFindDate(a);

        // 获取过滤规则
        List<String> b = datasourceLocationValueDto.getFindCond();
        if (CollectionUtils.isNotEmpty(b)) {
            String bc = JSON.toJSONString(b);
            datasourceLocationValue.setFindCondList(bc);
        }
        // 判断是新增还是编辑
        if (id == null) {
            Long bo = datasourceLocationValue.getBoardId();
            String re = datasourceLocationValue.getReportId();
            DatasourceLocationValue value = new DatasourceLocationValueDto();
            value.setBoardId(bo);
            value.setReportId(re);
            value.setCompanyId(UserHolder.getCompanyId());
            List<DatasourceLocationValue> list = datasourceLocationValueDao.find(value);
            if (CollectionUtils.isNotEmpty(list)) {
                for (DatasourceLocationValue locationValue : list) {
                    datasourceLocationValueDao.delete(locationValue.getId());
                }
            }

            datasourceLocationValueDao.insert(datasourceLocationValue);
        } else {
            int ac = datasourceLocationValueDao.update(datasourceLocationValue);
            System.err.println(ac);
            if (datasourceLocationValueDto.getForm() != null) {
                // 判断页面是否可以联动(页面如果是表格或卡片是不能联动的, 需要删除之前页面配置的联动信息)
                Boolean form = datasourceLocationValueDto.getForm();
                if (form) {
                    String reportId = datasourceLocationValue.getReportId();
                    Long boardId = datasourceLocationValue.getBoardId();
                    Linkage data = new Linkage();
                    data.setBoardId(boardId);
                    data.setFromId(reportId);
                    data.setCompanyId(UserHolder.getCompanyId());
                    List<Linkage> list = linkageDao.find(data);
                    if (CollectionUtils.isNotEmpty(list)) {
                        for (Linkage value : list) {
                            linkageDao.delete(value.getId());
                        }
                    }
                }
            }
        }

        DatasourceLocationValueDto valueDto = new DatasourceLocationValueDto();
        valueDto.setId(datasourceLocationValue.getId());
        valueDto.setFindList(find);
        return valueDto;
    }
}
