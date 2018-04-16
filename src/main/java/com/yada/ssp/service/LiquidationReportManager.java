/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.LiquidationReportDaoImpl;
import com.yada.ssp.model.LiquidationReport;
import com.yada.ssp.query.LiquidationReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class LiquidationReportManager extends BaseService<LiquidationReport, String>{
	@Autowired
	private LiquidationReportDaoImpl liquidationReportDao;

	@Override
	protected BaseDao<LiquidationReport, String> getBaseDao() {
		// TODO Auto-generated method stub
		return liquidationReportDao;
	}

		 public	List<LiquidationReport> findAll(LiquidationReportQuery query){
			return liquidationReportDao.findAll(query);
		}
}
