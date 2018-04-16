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
import com.yada.ssp.dao.FeeTableDaoImpl;
import com.yada.ssp.model.FeeTable;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class FeeTableManager extends BaseService<FeeTable, java.lang.String>{
	@Autowired
	private FeeTableDaoImpl feeTableDao;

	@Override
	protected BaseDao<FeeTable, String> getBaseDao() {
		// TODO Auto-generated method stub
		return feeTableDao;
	}

	public List<FeeTable> getfeeList() {
		return feeTableDao.getfeeList();
	}

	public String getfeeId(){
		return feeTableDao.getfeeId();
	}
	
	
}
