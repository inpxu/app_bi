/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class EmpFolderHcm extends BaseEntity<Long> {

	private static final long serialVersionUID = 7639711746996682722L;

	// ~~~~实体属性
	// 员工工号
	@Pattern(regexp="[\\S]{0,30}", message="员工工号字段过长")
	private String empNo;
	// 员工姓名
	@Pattern(regexp="[\\S]{0,40}", message="员工姓名字段过长")
	private String empName;
	// 英文名
	@Pattern(regexp="[\\S]{0,48}", message="英文名字段过长")
	private String engName;
	// 用户主键
	@Max(value=9223372036854775807L,message="用户主键字段过长")
	private Long userId;
	// 入职日期
	private java.util.Date joinDate;
	// 性别
	@Pattern(regexp="[\\S]{0,1}", message="性别字段过长")
	private String sexly;
	// 国籍
	@Pattern(regexp="[\\S]{0,30}", message="国籍字段过长")
	private String country;
	// 籍贯
	@Pattern(regexp="[\\S]{0,80}", message="籍贯字段过长")
	private String ancestral;
	// 户口所在地
	@Pattern(regexp="[\\S]{0,80}", message="户口所在地字段过长")
	private String householdAdd;
	// 现居地
	@Pattern(regexp="[\\S]{0,80}", message="现居地字段过长")
	private String domicile;
	// 学历
	@Pattern(regexp="[\\S]{0,10}", message="学历字段过长")
	private String education;
	// 毕业院校
	@Pattern(regexp="[\\S]{0,40}", message="毕业院校字段过长")
	private String collegeName;
	// 身份证号
	@Pattern(regexp="[\\S]{0,28}", message="身份证号字段过长")
	private String idNumber;
	// 社保地
	@Pattern(regexp="[\\S]{0,1}", message="社保地字段过长")
	private String social;
	// 社保号
	@Pattern(regexp="[\\S]{0,30}", message="社保号字段过长")
	private String isSursance;
	// 联系电话
	@Pattern(regexp="[\\S]{0,20}", message="联系电话字段过长")
	private String phone;
	// email
	@Pattern(regexp="[\\S]{0,40}", message="email字段过长")
	private String email;
	// 紧急联系方式
	@Pattern(regexp="[\\S]{0,20}", message="紧急联系方式字段过长")
	private String urgentPhone;
	// 组别
	@Pattern(regexp="[\\S]{0,20}", message="组别字段过长")
	private String teamId;
	// 出生日期
	private java.util.Date birthday;
	// 毕业日期
	private java.util.Date graduationDate;
	// 政治面貌
	@Pattern(regexp="[\\S]{0,20}", message="政治面貌字段过长")
	private String isParty;
	// 在职状态(5已经离职)
	@Pattern(regexp="[\\S]{0,20}", message="在职状态(5已经离职)字段过长")
	private String isHire;
	// 直间接标记
	private Boolean isOperating;
	// 绩效考核
	private Boolean isPerformance;
	// 是否计薪
	private Boolean isSal;
	// 是否考勤
	private Boolean isAtt;
	// 是否试用期
	private Boolean isShake;
	// 考勤方案
	@Max(value=9223372036854775807L,message="考勤方案字段过长")
	private Long schId;
	// 绩效方案（先空着）
	@Max(value=9223372036854775807L,message="绩效方案（先空着）字段过长")
	private Long performance;
	// 职称
	@Pattern(regexp="[\\S]{0,30}", message="职称字段过长")
	private String zc;
	// 民族
	@Pattern(regexp="[\\S]{0,18}", message="民族字段过长")
	private String nation;
	// 感情状态 0单身\1恋爱\2已婚\3已育\4离异\5丧偶
	@Pattern(regexp="[\\S]{0,1}", message="感情状态 0单身\1恋爱\2已婚\3已育\4离异\5丧偶字段过长")
	private String emotionStyle;
	// 紧急联系人
	@Pattern(regexp="[\\S]{0,30}", message="紧急联系人字段过长")
	private String urgent;
	// 户籍
	@Pattern(regexp="[\\S]{0,10}", message="户籍字段过长")
	private String census;
	// 星座
	@Pattern(regexp="[\\S]{0,10}", message="星座字段过长")
	private String constellatory;
	// 血型
	@Pattern(regexp="[\\S]{0,10}", message="血型字段过长")
	private String blood;
	//  健康状况
	@Pattern(regexp="[\\S]{0,10}", message=" 健康状况字段过长")
	private String health;
	// 
	@Max(value=9223372036854775807L,message="字段过长")
	private Long performanceId;
	// 照片
	@Pattern(regexp="[\\S]{0,255}", message="照片字段过长")
	private String photo;
	// 公司id
	@Max(value=9223372036854775807L,message="公司id字段过长")
	private Long companyId;
	// 
	private Boolean isIdCard;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 员工工号
	 */
	public String getEmpNo() {
		return this.empNo;
	}

	/**
	 * 员工工号
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	/**
	 * 员工姓名
	 */
	public String getEmpName() {
		return this.empName;
	}

	/**
	 * 员工姓名
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	/**
	 * 英文名
	 */
	public String getEngName() {
		return this.engName;
	}

	/**
	 * 英文名
	 */
	public void setEngName(String engName) {
		this.engName = engName;
	}
	
	/**
	 * 用户主键
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * 用户主键
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * 入职日期
	 */
	public java.util.Date getJoinDate() {
		return this.joinDate;
	}

	/**
	 * 入职日期
	 */
	public void setJoinDate(java.util.Date joinDate) {
		this.joinDate = joinDate;
	}
	
	/**
	 * 性别
	 */
	public String getSexly() {
		return this.sexly;
	}

	/**
	 * 性别
	 */
	public void setSexly(String sexly) {
		this.sexly = sexly;
	}
	
	/**
	 * 国籍
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * 国籍
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * 籍贯
	 */
	public String getAncestral() {
		return this.ancestral;
	}

	/**
	 * 籍贯
	 */
	public void setAncestral(String ancestral) {
		this.ancestral = ancestral;
	}
	
	/**
	 * 户口所在地
	 */
	public String getHouseholdAdd() {
		return this.householdAdd;
	}

	/**
	 * 户口所在地
	 */
	public void setHouseholdAdd(String householdAdd) {
		this.householdAdd = householdAdd;
	}
	
	/**
	 * 现居地
	 */
	public String getDomicile() {
		return this.domicile;
	}

	/**
	 * 现居地
	 */
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	
	/**
	 * 学历
	 */
	public String getEducation() {
		return this.education;
	}

	/**
	 * 学历
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	
	/**
	 * 毕业院校
	 */
	public String getCollegeName() {
		return this.collegeName;
	}

	/**
	 * 毕业院校
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	/**
	 * 身份证号
	 */
	public String getIdNumber() {
		return this.idNumber;
	}

	/**
	 * 身份证号
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	/**
	 * 社保地
	 */
	public String getSocial() {
		return this.social;
	}

	/**
	 * 社保地
	 */
	public void setSocial(String social) {
		this.social = social;
	}
	
	/**
	 * 社保号
	 */
	public String getIsSursance() {
		return this.isSursance;
	}

	/**
	 * 社保号
	 */
	public void setIsSursance(String isSursance) {
		this.isSursance = isSursance;
	}
	
	/**
	 * 联系电话
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 紧急联系方式
	 */
	public String getUrgentPhone() {
		return this.urgentPhone;
	}

	/**
	 * 紧急联系方式
	 */
	public void setUrgentPhone(String urgentPhone) {
		this.urgentPhone = urgentPhone;
	}
	
	/**
	 * 组别
	 */
	public String getTeamId() {
		return this.teamId;
	}

	/**
	 * 组别
	 */
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
	/**
	 * 出生日期
	 */
	public java.util.Date getBirthday() {
		return this.birthday;
	}

	/**
	 * 出生日期
	 */
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * 毕业日期
	 */
	public java.util.Date getGraduationDate() {
		return this.graduationDate;
	}

	/**
	 * 毕业日期
	 */
	public void setGraduationDate(java.util.Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	
	/**
	 * 政治面貌
	 */
	public String getIsParty() {
		return this.isParty;
	}

	/**
	 * 政治面貌
	 */
	public void setIsParty(String isParty) {
		this.isParty = isParty;
	}
	
	/**
	 * 在职状态(5已经离职)
	 */
	public String getIsHire() {
		return this.isHire;
	}

	/**
	 * 在职状态(5已经离职)
	 */
	public void setIsHire(String isHire) {
		this.isHire = isHire;
	}
	
	/**
	 * 直间接标记
	 */
	public Boolean getIsOperating() {
		return this.isOperating;
	}

	/**
	 * 直间接标记
	 */
	public void setIsOperating(Boolean isOperating) {
		this.isOperating = isOperating;
	}
	
	/**
	 * 绩效考核
	 */
	public Boolean getIsPerformance() {
		return this.isPerformance;
	}

	/**
	 * 绩效考核
	 */
	public void setIsPerformance(Boolean isPerformance) {
		this.isPerformance = isPerformance;
	}
	
	/**
	 * 是否计薪
	 */
	public Boolean getIsSal() {
		return this.isSal;
	}

	/**
	 * 是否计薪
	 */
	public void setIsSal(Boolean isSal) {
		this.isSal = isSal;
	}
	
	/**
	 * 是否考勤
	 */
	public Boolean getIsAtt() {
		return this.isAtt;
	}

	/**
	 * 是否考勤
	 */
	public void setIsAtt(Boolean isAtt) {
		this.isAtt = isAtt;
	}
	
	/**
	 * 是否试用期
	 */
	public Boolean getIsShake() {
		return this.isShake;
	}

	/**
	 * 是否试用期
	 */
	public void setIsShake(Boolean isShake) {
		this.isShake = isShake;
	}
	
	/**
	 * 考勤方案
	 */
	public Long getSchId() {
		return this.schId;
	}

	/**
	 * 考勤方案
	 */
	public void setSchId(Long schId) {
		this.schId = schId;
	}
	
	/**
	 * 绩效方案（先空着）
	 */
	public Long getPerformance() {
		return this.performance;
	}

	/**
	 * 绩效方案（先空着）
	 */
	public void setPerformance(Long performance) {
		this.performance = performance;
	}
	
	/**
	 * 职称
	 */
	public String getZc() {
		return this.zc;
	}

	/**
	 * 职称
	 */
	public void setZc(String zc) {
		this.zc = zc;
	}
	
	/**
	 * 民族
	 */
	public String getNation() {
		return this.nation;
	}

	/**
	 * 民族
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	/**
	 * 感情状态 0单身\1恋爱\2已婚\3已育\4离异\5丧偶
	 */
	public String getEmotionStyle() {
		return this.emotionStyle;
	}

	/**
	 * 感情状态 0单身\1恋爱\2已婚\3已育\4离异\5丧偶
	 */
	public void setEmotionStyle(String emotionStyle) {
		this.emotionStyle = emotionStyle;
	}
	
	/**
	 * 紧急联系人
	 */
	public String getUrgent() {
		return this.urgent;
	}

	/**
	 * 紧急联系人
	 */
	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}
	
	/**
	 * 户籍
	 */
	public String getCensus() {
		return this.census;
	}

	/**
	 * 户籍
	 */
	public void setCensus(String census) {
		this.census = census;
	}
	
	/**
	 * 星座
	 */
	public String getConstellatory() {
		return this.constellatory;
	}

	/**
	 * 星座
	 */
	public void setConstellatory(String constellatory) {
		this.constellatory = constellatory;
	}
	
	/**
	 * 血型
	 */
	public String getBlood() {
		return this.blood;
	}

	/**
	 * 血型
	 */
	public void setBlood(String blood) {
		this.blood = blood;
	}
	
	/**
	 *  健康状况
	 */
	public String getHealth() {
		return this.health;
	}

	/**
	 *  健康状况
	 */
	public void setHealth(String health) {
		this.health = health;
	}
	
	/**
	 * 
	 */
	public Long getPerformanceId() {
		return this.performanceId;
	}

	/**
	 * 
	 */
	public void setPerformanceId(Long performanceId) {
		this.performanceId = performanceId;
	}
	
	/**
	 * 照片
	 */
	public String getPhoto() {
		return this.photo;
	}

	/**
	 * 照片
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	/**
	 * 公司id
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 公司id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * 
	 */
	public Boolean getIsIdCard() {
		return this.isIdCard;
	}

	/**
	 * 
	 */
	public void setIsIdCard(Boolean isIdCard) {
		this.isIdCard = isIdCard;
	}
}
