package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

public class SysParaQuery extends BaseQuery implements Serializable {

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
