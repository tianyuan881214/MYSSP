package com.yada.ssp.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.BusinessBase;

@Component
public class BusinessBaseDaoImpl extends BaseDaoImpl<BusinessBase, String> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7246014414369081664L;
	public List<BusinessBase> getbusinessList() {
		Map<String, String> map=new HashMap<String, String>();
		return this.getSqlSessionTemplate().selectList("BusinessBase_findListByWhere",map);
	}

	/**
	 * 获取序列充当businessId
	 * @return businessId
     */
	public String getBusinessId() {
		return this.getSqlSessionTemplate().selectOne("BusinessBase_nextVal");
	}

	/**
	 * 获取全部业务
	 * @return List<BusinessBase>
     */
	public List<BusinessBase> findAll(){
		return this.getSqlSessionTemplate().selectList("BusinessBase_findAll");
	}

}
