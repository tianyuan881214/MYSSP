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
import com.yada.ssp.dao.BusinessBaseDaoImpl;
import com.yada.ssp.model.BusinessBase;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class BusinessBaseManager extends BaseService<BusinessBase, java.lang.String>{
	@Autowired
	private BusinessBaseDaoImpl businessBaseDao;

	@Override
	protected BaseDao<BusinessBase, String> getBaseDao() {
		// TODO Auto-generated method stub
		return businessBaseDao;
	}

	public List<BusinessBase> getbusinessList() {
		return businessBaseDao.getbusinessList();
	}

	public String getBusinessId(){
		return businessBaseDao.getBusinessId();
	}

	public List<BusinessBase> findAll(){
		return businessBaseDao.findAll();
	}
	
	
}
