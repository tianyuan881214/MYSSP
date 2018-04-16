package com.yada.ssp.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Component;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.MerchantBaseSon;
import com.yada.ssp.model.MerchantBusiness;
import com.yada.ssp.query.MerchantBusinessQuery;

@Component
public class MerchantBusinessDaoImpl extends BaseDaoImpl<MerchantBusiness, String> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<MerchantBusiness> getmerchantbusinessList(String Id) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("Id", Id);
		return this.getSqlSessionTemplate().selectList("MerchantBusiness_findListByWhere1",map);
	}
	public List<MerchantBusiness> findAll(MerchantBusinessQuery query) {
		Map filters = new HashMap();
		Map parameterObject;
		try {
			parameterObject = PropertyUtils.describe(query);
			filters.putAll(parameterObject);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.getSqlSessionTemplate().selectList("MerchantBusiness_findListByWhere1",filters);
	}

	public List<MerchantBusiness> findByMerchantId(String paymerchantBases){
		return this.getSqlSessionTemplate().selectList("MerchantBusiness_getMerchantId",paymerchantBases);
	}

	public int deleteMerchant(String paymerchantBases){
		return this.getSqlSessionTemplate().delete("MerchantBusiness_MerchantId_delete",paymerchantBases);
	}

	public MerchantBusiness findByMerchantIdAndBusinessId(MerchantBusiness merchantBusiness){
		return this.getSqlSessionTemplate().selectOne("MerchantBusiness_getByMerchantIdAndBusinessId",merchantBusiness);
	}

}
