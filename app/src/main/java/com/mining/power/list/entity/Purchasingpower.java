/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mining.power.list.entity;

/**
 * 已认购算力列表信息Entity
 * @author Zixin
 * @version 2019-04-23
 */
public class Purchasingpower {
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;		// 用户名
	private String ctype;		// 用户编号
	private String cperiod;		// 算力周期
	private String cprice;		// 算力价格
	private String cpower;		// 算力大小
	private String referenceYields;		// 参考收益率
	private String dayYield;		// 日理论产量
	private String electricityfees;		// 电费
	private String seatfee;		// 机位费
	private String boardingfee;		// 上架费
	private String upkeep;		// 维修费
	private String surplus;		// 剩余量
	private String state;		// 状态
	private String releaseTime;		// 注册日期
	private String remark;		// 预留字段
	private String remark1;		// 预留字段
	private String beginReleaseTime;		// 开始 注册日期
	private String endReleaseTime;		// 结束 注册日期

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCperiod() {
		return cperiod;
	}

	public void setCperiod(String cperiod) {
		this.cperiod = cperiod;
	}

	public String getCprice() {
		return cprice;
	}

	public void setCprice(String cprice) {
		this.cprice = cprice;
	}

	public String getCpower() {
		return cpower;
	}

	public void setCpower(String cpower) {
		this.cpower = cpower;
	}

	public String getReferenceYields() {
		return referenceYields;
	}

	public void setReferenceYields(String referenceYields) {
		this.referenceYields = referenceYields;
	}

	public String getDayYield() {
		return dayYield;
	}

	public void setDayYield(String dayYield) {
		this.dayYield = dayYield;
	}

	public String getElectricityfees() {
		return electricityfees;
	}

	public void setElectricityfees(String electricityfees) {
		this.electricityfees = electricityfees;
	}

	public String getSeatfee() {
		return seatfee;
	}

	public void setSeatfee(String seatfee) {
		this.seatfee = seatfee;
	}

	public String getBoardingfee() {
		return boardingfee;
	}

	public void setBoardingfee(String boardingfee) {
		this.boardingfee = boardingfee;
	}

	public String getUpkeep() {
		return upkeep;
	}

	public void setUpkeep(String upkeep) {
		this.upkeep = upkeep;
	}

	public String getSurplus() {
		return surplus;
	}

	public void setSurplus(String surplus) {
		this.surplus = surplus;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	
	public String getBeginReleaseTime() {
		return beginReleaseTime;
	}

	public void setBeginReleaseTime(String beginReleaseTime) {
		this.beginReleaseTime = beginReleaseTime;
	}
	
	public String getEndReleaseTime() {
		return endReleaseTime;
	}

	public void setEndReleaseTime(String endReleaseTime) {
		this.endReleaseTime = endReleaseTime;
	}
		
}