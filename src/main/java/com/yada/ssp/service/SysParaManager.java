/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.SysParaDaoImpl;
import com.yada.ssp.model.SysPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class SysParaManager extends BaseService<SysPara, String>{
	@Autowired
	private SysParaDaoImpl sysParaDao;

	@Override
	protected BaseDao<SysPara, String> getBaseDao() {
		// TODO Auto-generated method stub
		return sysParaDao;
	}

}
