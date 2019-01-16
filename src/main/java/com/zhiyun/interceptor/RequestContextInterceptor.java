package com.zhiyun.interceptor;

import com.zhiyun.base.config.Config;
import com.zhiyun.base.util.CommonUtils;
import com.zhiyun.client.UserHolder;
import com.zhiyun.context.OnlineUser;
import com.zhiyun.context.RequestHolder;
import com.zhiyun.entity.CasCompany;
import com.zhiyun.entity.CasUser;
import com.zhiyun.service.CasCompanyService;
import com.zhiyun.service.CasUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 请求拦截。<br>
 * @author 庄超
 */
public class RequestContextInterceptor extends HandlerInterceptorAdapter implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(RequestContextInterceptor.class);

	@Resource
	private Config config;
	@Resource
	private CasUserService casUserService;
	@Resource
	private CasCompanyService casCompanyService;

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		RequestHolder.init();
		UserHolder.clear();
		OnlineUser user = (OnlineUser) request.getSession().getAttribute("user");
		//判断是否调试模式
		if (config.getIsDev()) {
			//调试模式使用默认账户
			user = new OnlineUser();
			user.setId(232526L);
			user.setCompanyId(232601L);
			user.setUserName("p13500000000");
			user.setCompanyName("飞戎机器人");
		}else {
			if (user == null) {
				response.setHeader("Content-type", "application/json;charset=UTF-8");
				response.getWriter().write("{\"errorCode\":0,\"message\":\"您还未登录，请先登录\",\"model\":\"\",\"result\":false}");
				return false;
			}
			//通过登录账号查询用户信息
			CasUser casUser = new CasUser();
			casUser.setAccount(user.getAccountName());
			List<CasUser> casUsers = casUserService.listCasUserInAuthAuthorization(casUser);
			if (!CommonUtils.isEmpty(casUsers) && casUsers.size()==1) {
				//设置用户信息
				CasUser entity = casUsers.get(0);
				user.setCompanyId(entity.getCompanyId());
				user.setOrgId(entity.getOrgId());
				user.setUserName(entity.getName());
				user.setId(entity.getId());
				user.setIp(request.getRemoteAddr());

				//设置企业名称
				CasCompany casCompany = casCompanyService.getCasCompanyInAuthAuthorization(entity.getCompanyId());
				user.setCompanyName(casCompany.getCompanyName());

				request.getSession().setAttribute("user", user);
			}else {

				response.setHeader("Content-type", "application/json;charset=UTF-8");
				response.getWriter().write("{\"errorMsg\":\"账号信息不匹配,请重新登录\"}");
				return false;
			}

		}
		UserHolder.setUser(user);
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

}
