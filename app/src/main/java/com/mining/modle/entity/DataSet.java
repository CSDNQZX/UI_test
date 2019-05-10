/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mining.modle.entity;

import com.mining.power.list.entity.PurchaseAudit;
import com.mining.power.list.entity.Purchasingpower;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页类
 * @author Zixin
 * @version 2019-5-3
 * @param
 */
public class DataSet<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	//提示信息
	private String message;
	//状态信息 默认是成功
	private int state= 1;
	//状态  0是正常   1是存在异常
	private int until= 0;
	//数据源
	private Object object;
	//已购记录
	private List<Purchasingpower> alist;
	//已购算力
	private List<PurchaseAudit> blist;

	public DataSet() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public List<Purchasingpower> getAlist() {
		return alist;
	}

	public void setAlist(List<Purchasingpower> alist) {
		this.alist = alist;
	}

	public List<PurchaseAudit> getBlist() {
		return blist;
	}

	public void setBlist(List<PurchaseAudit> blist) {
		this.blist = blist;
	}

	public int getUntil() {
		return until;
	}

	public void setUntil(int until) {
		this.until = until;
	}
}
