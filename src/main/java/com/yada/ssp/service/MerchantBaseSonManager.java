/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.MerchantBaseSonDaoImpl;
import com.yada.ssp.model.MerchantBaseSon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Service
public class MerchantBaseSonManager extends BaseService<MerchantBaseSon,java.lang.String>{
	@Autowired
	private MerchantBaseSonDaoImpl merchantBaseSonDao;

	@Override
	protected BaseDao<MerchantBaseSon, String> getBaseDao() {
		// TODO Auto-generated method stub
		return merchantBaseSonDao;
	}
	public List<MerchantBaseSon> getmerbusinessList(String Id) {

		return merchantBaseSonDao.getmerbusinessList(Id);
	}
	public List<MerchantBaseSon> findByMerGrpId(String merGrpId){
		return merchantBaseSonDao.findByMerGrpId(merGrpId);
	}
}
