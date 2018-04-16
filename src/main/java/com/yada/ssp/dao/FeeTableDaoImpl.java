package com.yada.ssp.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.FeeTable;

@Component
public class FeeTableDaoImpl extends BaseDaoImpl<FeeTable, String> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7246014414369081664L;
	public List<FeeTable> getfeeList() {
		Map<String, String> map=new HashMap<String, String>();
		return this.getSqlSessionTemplate().selectList("FeeTable_findListByWhere",map);
	}

	public String getfeeId() {
		return this.getSqlSessionTemplate().selectOne("FeeTanle_getfeeId");
	}

}
