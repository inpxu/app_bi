package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Pager;
import com.zhiyun.internal.newstandard.dcnew.DataInterface;
import com.zhiyun.internal.newstandard.dcnew.PermissonInterface;
import com.zhiyun.internal.newstandard.dcnew.dto.DataRequestDto;
import com.zhiyun.internal.newstandard.dcnew.dto.DataResponseDto;
import com.zhiyun.internal.newstandard.dcnew.dto.PermissionRequestDto;
import com.zhiyun.internal.newstandard.dcnew.dto.PermissionResponsetDto;
import com.zhiyun.internal.server.auth.dto.AppMenuDto;
import com.zhiyun.internal.server.auth.service.InterfaceForUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {

	@Resource
	private PermissonInterface permissonInterface;
	@Resource
	private DataInterface dataInterface;
	@Resource
	private InterfaceForUser interfaceForUser;
	
	
	/**
	 * 查询用户可用的模型及版本
	 */
	@Test
	public void tes11t() {
		List<AppMenuDto> list = interfaceForUser.getUserMenuForApp("dcnew", 1, 234397l, 234411l);
		System.out.println(JSON.toJSONString(list));
	}
	/**
	 * 查询用户可用的模型及版本
	 */
	@Test
	public void test1p1() {
		BaseResult<PermissionResponsetDto> baseResult = permissonInterface.getModelAndVersion(null, "HCM", 239793L, 241230L);
		System.out.println(JSON.toJSONString(baseResult));
	}
	
	/**
	 * 查询用户权限
	 */
	@Test
	public void test1p2() {
		PermissionRequestDto permissionRequestDto = new PermissionRequestDto();
		permissionRequestDto.setDataModelCode("M0000001");
		permissionRequestDto.setVersion(1);
		BaseResult<PermissionResponsetDto> baseResult = permissonInterface.getPermissionInfo(permissionRequestDto, "CRM", 239793L, 241230L);
		System.out.println(JSON.toJSONString(baseResult));
	}
	
	/**
	 * 数据操作-查
	 */
	@Test
	public void test2p1() {
		//需要显示的字段
		Map<String, Object> displayMap = new HashMap<String, Object>();
		displayMap.put("providerId", true);
		displayMap.put("providerName", true);
		//查询条件
		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("company_id", " = '232601L'");
		
		DataRequestDto dataRequestDto = new DataRequestDto();
		dataRequestDto.setDataModelCode("BusiProvider");
		dataRequestDto.setVersion(1);
		dataRequestDto.setDisplayJson(JSON.toJSONString(displayMap));
		dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));
		BaseResult<List<Map<String, String>>> baseResult = dataInterface.doSearch(dataRequestDto, "OC", 232601L, 232526L);
		System.out.println(JSON.toJSONString(baseResult));
	}
	
	/**
	 * 数据操作-改
	 */
	@Test
	public void test2p2() {
		//需要更新的字段
		Map<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("remark", "狗蛋的申请测试");
		updateMap.put("status", "业务确认");
		//查询条件
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", " = 252");
		
		DataRequestDto dataRequestDto = new DataRequestDto();
		dataRequestDto.setDataModelCode("tradeOrderDetail");
		dataRequestDto.setVersion(1);
		dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));
		dataRequestDto.setUpdateJson(JSON.toJSONString(updateMap));
		BaseResult<String> baseResult = dataInterface.doEdit(dataRequestDto, "HCM", 232601L, 232526L);
		System.out.println(JSON.toJSONString(baseResult));
	}
	
	/**
	 * 数据操作-增
	 */
	@Test
	public void test2p3() {
		//需要新增的内容
//		Map<String, Object> addMap = new HashMap<String, Object>();
//		addMap.put("用户ID", "8898888");
//		addMap.put("登录账号", "2311");
//		
//		DataRequestDto dataRequestDto = new DataRequestDto();
//		dataRequestDto.setDataModelCode("M0000001");
//		dataRequestDto.setVersion(1);
//		dataRequestDto.setDataJson(JSON.toJSONString(addMap));
//		BaseResult<String> baseResult = dataInterface.doAdd(dataRequestDto, "HCM", 239793L, 241230L);
//		System.out.println(JSON.toJSONString(baseResult));
		
		
		Map<String, Object> addMap=new HashMap<>();
	    addMap.put("id",896);
	    addMap.put("isDefault",true);
		DataRequestDto dataRequestDto = new DataRequestDto();
		dataRequestDto.setDataModelCode("BusiBill");
		dataRequestDto.setVersion(1);
		dataRequestDto.setDataJson(JSON.toJSONString(addMap));
		BaseResult<String> baseResult=   dataInterface.doAdd(dataRequestDto, "das", 232601L, 232526L);
		System.out.println(JSON.toJSON(baseResult));
	}
	
	/**
	 * 数据操作-删
	 */
	@Test
	public void test2p4() {
		//查询条件
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", "=86");
				
		DataRequestDto dataRequestDto = new DataRequestDto();
		dataRequestDto.setDataModelCode("resapi");
		dataRequestDto.setVersion(1);
		dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));
		BaseResult<String> baseResult = dataInterface.doDel(dataRequestDto, "HCM", 232601L, 232526L);
		System.out.println(JSON.toJSONString(baseResult));
	}
	
	
	  @Test
	  public void test2p34() {
	    //需要显示的字段
	    Map<String, Object> displayMap = new HashMap<String, Object>();
	    displayMap.put("orderCode", true);
	    //displayMap.put("登录账号", true);
	    //查询条件
	    Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("orderCode", " like '201811%' ");
	    
	    DataRequestDto dataRequestDto = new DataRequestDto();
	    dataRequestDto.setDataModelCode("TradeOrder");
	    dataRequestDto.setVersion(1);
	    dataRequestDto.setDisplayJson(JSON.toJSONString(displayMap));
	    dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));
	    BaseResult<List<Map<String, String>>> baseResult = dataInterface.doSearch(dataRequestDto, "appsurvey", 232601L, 232526L);
	    System.out.println(JSON.toJSONString(baseResult));
	  }
	  
	  @Test
	  public void test2p221() {

	        Map<String, Object> displayMap = new HashMap();
	        displayMap.put("id", true);
	        displayMap.put("industry", true);
	        displayMap.put("appClass", true);
	        displayMap.put("appName", true);
	        displayMap.put("providerName", true);
	        displayMap.put("providerId", true);
	        displayMap.put("appUrl", true);
	        displayMap.put("authUrl", true);
	        displayMap.put("isNeedStorage", true);
	        displayMap.put("isNeedMsg", true);
	        displayMap.put("appDesc", true);
	        displayMap.put("appImgUrl", true);
	        displayMap.put("isPublish", true);
	        displayMap.put("publishTime", true);
	        displayMap.put("historyAuthCompanyCount", true);
	        displayMap.put("authCompanyCount", true);
	        //查询条件
	        Map<String, Object> paramMap = new HashMap();

	        DataRequestDto dataRequestDto = new DataRequestDto();
	        dataRequestDto.setDataModelCode("resapp");
	        dataRequestDto.setVersion(1);

	        dataRequestDto.setDisplayJson(JSON.toJSONString(displayMap));
	        dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));


	        BaseResult<List<Map<String, String>>>  baseResult = dataInterface.doSearch(dataRequestDto, "resapp", 232601L, 232526L);

	        System.out.println(JSON.toJSONString(baseResult));
	  }
	  
	  @Test
	  public void test2p22221() {

	        Map<String, Object> displayMap = new HashMap();
	        displayMap.put("status", true);
//	        displayMap.put("modifyBy", true);
//	        displayMap.put("balanceMoney", true);
//	        displayMap.put("orderCount", true);
//	        displayMap.put("remark", true);
//	        displayMap.put("customerName", true);
//	        displayMap.put("companyId", true);
//	        displayMap.put("createBy", true);
//	        displayMap.put("balanceType", true);
//	        displayMap.put("deleted", true);
//	        displayMap.put("modifyTime", true);
//	        displayMap.put("balanceCode", true);
//	        displayMap.put("createTime", true);
//	        displayMap.put("providerId", true);
//	        displayMap.put("customerId", true);
//	        displayMap.put("detailList", true);
//	        displayMap.put("id", true);
//	        displayMap.put("signOutTime", true);
//	        displayMap.put("sureTime", true);
//	        displayMap.put("providerName", true);
//	        displayMap.put("signOutUser", true);
//	        displayMap.put("status", true);
	        //查询条件
	        Map<String, Object> paramMap = new HashMap();
	        paramMap.put("status", "like '%待签收%'");

	        DataRequestDto dataRequestDto = new DataRequestDto();
	        dataRequestDto.setDataModelCode("TradeBalance");
	        dataRequestDto.setVersion(1);

	        dataRequestDto.setDisplayJson(JSON.toJSONString(displayMap));
	        dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));

	        Page page = new Page();
	        page.setOffset(0);
	        page.setLimit(10);
	        dataRequestDto.setPage(page);
	        
	        BaseResult<DataResponseDto>  baseResult = dataInterface.doPage(dataRequestDto, "resapp", 232601L, 232526L);

	        System.out.println(JSON.toJSONString(baseResult));
	  }
	  
	  @Test
	    public void test2p1qweq() {

	        Map<String, Object> displayMap = new HashMap();
	        displayMap.put("id", true);
	        displayMap.put("industry", true);
	        displayMap.put("appClass", true);
	        displayMap.put("appName", true);
	        displayMap.put("providerName", true);
	        displayMap.put("providerId", true);
	        displayMap.put("appUrl", true);
	        displayMap.put("authUrl", true);
	        displayMap.put("isNeedStorage", true);
	        displayMap.put("isNeedMsg", true);
	        displayMap.put("appDesc", true);
	        displayMap.put("appImgUrl", true);
	        displayMap.put("isPublish", true);
	        displayMap.put("publishTime", true);
	        displayMap.put("historyAuthCompanyCount", true);
	        displayMap.put("authCompanyCount", true);
	        //查询条件
	        Map<String, Object> paramMap = new HashMap();

	        DataRequestDto dataRequestDto = new DataRequestDto();
	        dataRequestDto.setDataModelCode("resapp");
	        dataRequestDto.setVersion(1);

	        dataRequestDto.setDisplayJson(JSON.toJSONString(displayMap));
	        dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));

	        paramMap.put("authUrl", " = '发布标识'");


	        BaseResult<List<Map<String, String>>> baseResult = dataInterface.doSearch(dataRequestDto, "resapp", 232601L, 232526L);

	        System.out.println(JSON.toJSONString(baseResult));
	    }
	  
	  @Test
	    public void test2pasd1() {

	        Map<String, Object> displayMap = new HashMap();
	        displayMap.put("id", true);


	        Pager pager = new Pager();
	        pager.setPageNo(3);
	        pager.setPageSize(2);
	        //查询条件
	        Map<String, Object> paramMap = new HashMap();

	        DataRequestDto dataRequestDto = new DataRequestDto();
	        dataRequestDto.setDataModelCode("resapi");
	        dataRequestDto.setVersion(1);
	        dataRequestDto.setPage(pager);

	        dataRequestDto.setDisplayJson(JSON.toJSONString(displayMap));
	        dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));
	        System.out.println(dataRequestDto.getPage().getOffset()+"|"+dataRequestDto.getPage().getOffsetLimit());

	        BaseResult<DataResponseDto> resapi = dataInterface.doPage(dataRequestDto, "resapi", 232601L, 232526L);

	        System.out.println(JSON.toJSONString(resapi));
	    }
	  
	  @Test
	    public void test2p2sad() {
	        //需要更新的字段
	        Map<String, Object> updateMap = new HashMap<String, Object>();
	        updateMap.put("companyName", "阿里巴巴");
	        updateMap.put("companyId", 232603L);
	        //查询条件
	        Map<String, Object> paramMap = new HashMap<String, Object>();
	        paramMap.put("id", "=324");

	        DataRequestDto dataRequestDto = new DataRequestDto();
	        dataRequestDto.setDataModelCode("BusiSettle");
	        dataRequestDto.setVersion(1);
	        dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));
	        dataRequestDto.setUpdateJson(JSON.toJSONString(updateMap));
	        BaseResult<String> baseResult = dataInterface.doEdit(dataRequestDto, "PC", 232601L, 232526L);
	        System.out.println(JSON.toJSONString(baseResult));
	    }
	  
	    @Test
	    public void test2pqwqe2() {
	        //需要更新的字段
	        Map<String, Object> updateMap = new HashMap<String, Object>();
	        updateMap.put("deleted", "T");
	        updateMap.put("modifyTime", "2018-01-01 00:00:00");
	        //查询条件
	        Map<String, Object> paramMap = new HashMap<String, Object>();

	        paramMap.put("id", " = 265145100487622656");

	        DataRequestDto dataRequestDto = new DataRequestDto();
	        dataRequestDto.setDataModelCode("modelProductTemp");
	        dataRequestDto.setVersion(1);
	        dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));
	        dataRequestDto.setUpdateJson(JSON.toJSONString(updateMap));
	        BaseResult<String> baseResult = dataInterface.doEdit(dataRequestDto, "modelProductTemp", 232601L, 232526L);
	        System.out.println(JSON.toJSONString(baseResult));
	    }
	    
	    @Test
	    public void test2pqwqesada2() {
	        //需要更新的字段
		    Boolean res = false;
				res = interfaceForUser.getIsAble(234397L, "cms", "1");
				System.out.println(res);
	    }
	    @Test
	    public void testsadsa2p1() {

	        Map<String, Object> displayMap = new HashMap();
	        displayMap.put("id", true);
	        displayMap.put("resourceDto", true);
//	        displayMap.put("province", true);

	        Pager pager = new Pager();
	        pager.setPageNo(1);
	        pager.setPageSize(20);
	        //查询条件
	        Map<String, Object> paramMap = new HashMap();

	        DataRequestDto dataRequestDto = new DataRequestDto();
	        dataRequestDto.setDataModelCode("PublishRecord");
	        dataRequestDto.setVersion(1);
	        dataRequestDto.setPage(pager);

	        dataRequestDto.setDisplayJson(JSON.toJSONString(displayMap));
	        dataRequestDto.setParamsJson(JSON.toJSONString(paramMap));


	        BaseResult<DataResponseDto> resapi = dataInterface.doPage(dataRequestDto, "PublishRecord", 232601L, 232526L);

	        System.out.println(JSON.toJSONString(resapi));
	    }
}
