/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.CompanyRateTableDaoImpl;
import com.yada.ssp.model.CompanyRateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class CompanyRateTableManager extends BaseService<CompanyRateTable, String>{
	@Autowired
	private CompanyRateTableDaoImpl companyRateDao;

	@Override
	protected BaseDao<CompanyRateTable, String> getBaseDao() {
		// TODO Auto-generated method stub
		return companyRateDao;
	}

}
