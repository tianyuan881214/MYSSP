/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.MerchantBusinessDaoImpl;
import com.yada.ssp.model.MerchantBusiness;
import com.yada.ssp.query.MerchantBusinessQuery;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class MerchantBusinessManager extends BaseService<MerchantBusiness, java.lang.String>{
	@Autowired
	private MerchantBusinessDaoImpl merchantBusinessDaoImpl;

	@Override
	protected BaseDao<MerchantBusiness, String> getBaseDao() {
		// TODO Auto-generated method stub
		return merchantBusinessDaoImpl;
	}
	public List<MerchantBusiness> getmerchantbusinessList(String ID) {
		return merchantBusinessDaoImpl.getmerchantbusinessList(ID);
	}
	public List<MerchantBusiness> findAll(MerchantBusinessQuery query) {
		return merchantBusinessDaoImpl.findAll(query);
	}
	
	public List<MerchantBusiness> findByMerchantId(String merchantId){
		return merchantBusinessDaoImpl.findByMerchantId(merchantId);
	}

	public MerchantBusiness findByMerchantIdAndBusinessId(MerchantBusiness merchantBusiness){
		return merchantBusinessDaoImpl.findByMerchantIdAndBusinessId(merchantBusiness);
	}
}
