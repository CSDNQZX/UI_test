/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mining.power.list.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 审核信息Entity
 * @author Zixin
 * @version 2019-04-26
 */
public class PurchaseAudit implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderid;		// 算力编号
	private String currency;		// 币种
	private String puser;		// 购买用户
	private String power;		// 购买算力
	private String paytype;		// 支付方式
	private String paynumber;		// 付款账号
	private String cheapMoney;		// 优惠金额
	private String payMoney;		// 实际支付费用
	private String state;		// 算力状态
	private Date createTime;		// 购买日期
	private String remark;		// 预留字段
	private String remark1;		// 预留字段
	private Date beginCreateTime;		// 开始 购买日期
	private Date endCreateTime;		// 结束 购买日期

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getPaynumber() {
		return paynumber;
	}

	public void setPaynumber(String paynumber) {
		this.paynumber = paynumber;
	}

	public String getCheapMoney() {
		return cheapMoney;
	}

	public void setCheapMoney(String cheapMoney) {
		this.cheapMoney = cheapMoney;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Date getBeginCreateTime() {
		return beginCreateTime;
	}

	public void setBeginCreateTime(Date beginCreateTime) {
		this.beginCreateTime = beginCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
}