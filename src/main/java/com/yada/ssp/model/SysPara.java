package com.yada.ssp.model;

import java.io.Serializable;

public class SysPara implements Serializable {

	private static final long serialVersionUID = -3098394328729995462L;

	public static final String TABLE_ALIAS = "系统参数维护";
	public static final String PARA_ID = "建";
	public static final String PARA_VALUE = "值";
	public static final String REMARK = "说明";

	private  String paraId;
	private  String paraValue;
	private  String remark;

	public String getParaId() {
		return paraId;
	}

	public void setParaId(String paraId) {
		this.paraId = paraId;
	}

	public String getParaValue() {
		return paraValue;
	}

	public void setParaValue(String paraValue) {
		this.paraValue = paraValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
