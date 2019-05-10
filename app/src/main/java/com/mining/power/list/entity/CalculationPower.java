/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mining.power.list.entity;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 算力信息列表管理Entity
 * @author Zixin
 * @version 2019-04-26
 */
public class CalculationPower<T>{
	private static final long serialVersionUID = 1L;
	private String ctype;		// 编号
	private String currency;		// 币种
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
	private Date releaseTime;		// 发布日期
	private String remark;		// 预留字段
	private String remark1;		// 预留字段


	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型
	 * @param clazz
	 * @return 返回第一个类型
	 */
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型
	 * @param clazz
	 * @param
	 */
	public static Class getSuperClassGenricType(Class clazz, int index)
			throws IndexOutOfBoundsException {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
	
	public CalculationPower() {
		super();
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
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
}