/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.RateDaoImpl;
import com.yada.ssp.model.RateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class RateTableManager extends BaseService<RateTable, String>{
	@Autowired
	private RateDaoImpl rateTableDao;

	@Override
	protected BaseDao<RateTable, String> getBaseDao() {
		// TODO Auto-generated method stub
		return rateTableDao;
	}
	public List<RateTable> getRateList() {
		return rateTableDao.getRateList();
	}

	public void insert(RateTable rateTable) {
		rateTableDao.insert(rateTable);
	}

	public RateTable getById(String rateId) {
		return rateTableDao.getById(rateId);
	}
}
