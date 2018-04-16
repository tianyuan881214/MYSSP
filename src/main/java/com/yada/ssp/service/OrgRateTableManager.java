/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.OrgRateTableDaoImpl;
import com.yada.ssp.model.OrgRateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class OrgRateTableManager extends BaseService<OrgRateTable, String>{
	@Autowired
	private OrgRateTableDaoImpl orgRateTableDao;

	@Override
	protected BaseDao<OrgRateTable, String> getBaseDao() {
		// TODO Auto-generated method stub
		return orgRateTableDao;
	}

}
