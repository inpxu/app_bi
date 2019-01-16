package com.zhiyun.controller;


import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.FindSQL;
import com.zhiyun.internal.newstandard.dcnew.DataInterface;
import com.zhiyun.internal.newstandard.dcnew.PermissonInterface;
import com.zhiyun.internal.newstandard.dcnew.dto.DataRequestDto;
import com.zhiyun.internal.newstandard.dcnew.dto.PermissionRequestDto;
import com.zhiyun.internal.newstandard.dcnew.dto.PermissionResponsetDto;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 远程数据源
 *
 * @auther xufei
 */
@Controller
@RequestMapping(value = "/perm", produces = "application/json;charset=UTF-8")
public class PermissonController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissonController.class);

    @Resource
    private PermissonInterface permissonInterface;
    @Resource
    private DataInterface dataInterface;

    /**
     * 仓库下拉
     *
     * @return
     * @auther xufei
     * @date 2018-12-26 09:47:37
     */
    @ResponseBody
    @RequestMapping(value = "getHouse", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getHouse() {
        BaseResult<List<Object>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            Long companyId = UserHolder.getCompanyId();
            Long user = UserHolder.getUser().getId();
            String appName = "app_bi";
//            Long companyId = 234411L;
//            Long user = 234397L;
            BaseResult<PermissionResponsetDto> base = permissonInterface.getWareHouseList(null, appName, companyId, user);
            String json = base.getModel().getTempJson();
            String b = json.replace("]", "").replace("[", "");
            String c = "=" + b + "=";
            List<Object> ls = new ArrayList<>();
            if (b != null && !"==".equals(c)) {
                String[] strs = b.split("},");
                if (strs.length == 0) {
                    ls = null;
                } else {
                    List<String> keyls = new ArrayList<>();
                    keyls.add("id");
                    keyls.add("alias");
                    for (String str : strs) {
                        if (!str.endsWith("}")) {
                            str = str + "}";
                        }
                        Map jo = JSON.parseObject(str);
                        Map<Object, Object> map = new HashMap<>();
                        for (Object o : keyls) {
                            map.put(o, jo.get(o));
                        }
                        ls.add(map);
                    }
                }
            }
            baseResult.setModel(ls);
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
     * 模型下拉
     *
     * @return
     * @auther xufei
     * @date 2018-12-26 09:47:37
     */
    @ResponseBody
    @RequestMapping(value = "getModel", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getModel(@Valid Long wareHouseId) {
        BaseResult<List<Object>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            Long companyId = UserHolder.getCompanyId();
            Long user = UserHolder.getUser().getId();
            String appName = "app_bi";
//            Long companyId = 234411L;
//            Long user = 234397L;
            BaseResult<PermissionResponsetDto> base = permissonInterface.getModelList(null, appName, companyId, user, wareHouseId);
            String json = base.getModel().getTempJson();
            String b = json.replace("]", "").replace("[", "");
            List<Object> ls = new ArrayList<>();
            String[] strs = b.split("},");
            if (strs.length == 0) {
                ls = null;
            } else {
                List<String> keyls = new ArrayList<>();
                keyls.add("id");
                keyls.add("modelCode");
                keyls.add("alias");
                for (String str : strs) {
                    if (!str.endsWith("}")) {
                        str = str + "}";
                    }
                    Map jo = JSON.parseObject(str);
                    Map<Object, Object> map = new HashMap<>();
                    for (Object o : keyls) {
                        map.put(o, jo.get(o));
                    }
                    ls.add(map);
                }
            }
            baseResult.setModel(ls);
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
     * 版本号下拉
     *
     * @return
     * @auther xufei
     * @date 2018-12-26 09:47:37
     */
    @ResponseBody
    @RequestMapping(value = "getVersion", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getVersion(@Valid Long modelId) {
        BaseResult<List<Object>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            Long companyId = UserHolder.getCompanyId();
            Long user = UserHolder.getUser().getId();
            String appName = "app_bi";
//            Long companyId = 234411L;
//            Long user = 234397L;
            BaseResult<PermissionResponsetDto> base = permissonInterface.getVersionList(null, appName, companyId, user, modelId);
            String json = base.getModel().getTempJson();
            String b = json.replace("]", "").replace("[", "");
            List<Object> ls = new ArrayList<>();
            String[] strs = b.split("},");
            if (strs.length == 0) {
                ls = null;
            } else {
                List<String> keyls = new ArrayList<>();
                keyls.add("id");
                keyls.add("versionNo");
                for (String str : strs) {
                    if (!str.endsWith("}")) {
                        str = str + "}";
                    }
                    Map jo = JSON.parseObject(str);
                    Map<Object, Object> map = new HashMap<>();
                    for (Object o : keyls) {
                        map.put(o, jo.get(o));
                    }
                    ls.add(map);
                }
            }
            baseResult.setModel(ls);
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
     * 获取数据
     *
     * @return
     * @auther xufei
     * @date 2018-12-26 14:10:02
     */
    @ResponseBody
    @RequestMapping(value = "get", method = {RequestMethod.GET, RequestMethod.POST})
    public Object get(@Valid String dataModelCode, Integer version) {
        PermissionRequestDto permissionRequestDto = new PermissionRequestDto();
        Long companyId = UserHolder.getCompanyId();
        Long user = UserHolder.getUser().getId();
        String appName = "app_bi";
        permissionRequestDto.setVersion(version);
        permissionRequestDto.setOperationType("find");
        permissionRequestDto.setDataModelCode(dataModelCode);
        BaseResult<PermissionResponsetDto> base = permissonInterface.getPermissionInfo(permissionRequestDto, appName, companyId, user);
        return JSON.toJSONString(base);
    }


    /**
     * 查询数据
     *
     * @return
     * @auther xufei
     * @date 2018-12-27 10:32:50
     */
    @ResponseBody
    @RequestMapping(value = "findSql", method = {RequestMethod.GET, RequestMethod.POST})
    public Object findSql(@Valid @RequestBody FindSQL findSQL) {
        Map<String, Object> displayMap = new HashMap<String, Object>();
        List<String> list = findSQL.getFindList();
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException("数据列为空！");
        }
        for (String s : list) {
            displayMap.put(s, true);
        }
        DataRequestDto dataRequestDto = new DataRequestDto();
        List<String> find = findSQL.getFindCondList();
        if (CollectionUtils.isNotEmpty(find)) {
            //查询条件
            Map<String, Object> paramMap = new HashMap<String, Object>();
            for (String s : find) {
                String before = s.substring(0, s.indexOf(" "));
                String after = s.replaceFirst(before, "").replace(" ", "");
//                System.err.println(before + "======"+ after);
                paramMap.put(before, after);
            }
            // 查询条件
            dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));
        }

        dataRequestDto.setDataModelCode(findSQL.getDataModelCode());
        dataRequestDto.setVersion(findSQL.getVersion());
        // 查询数据
        dataRequestDto.setDisplayJson(JSON.toJSONString(displayMap));

        Long companyId = UserHolder.getCompanyId();
        Long user = UserHolder.getUser().getId();
        // 添加项目名
        String appName = "app_bi";
        BaseResult<List<Map<String, String>>> baseResult = dataInterface.doSearch(dataRequestDto, appName, companyId, user);
//        System.out.println(JSON.toJSONString(baseResult));
        return JSON.toJSONString(baseResult);
    }
}