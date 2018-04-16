/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.dao.GdCardPhoneBindDaoImpl;
import com.yada.ssp.model.GdCardPhoneBind;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class GdCardPhoneBindManager extends BaseService<GdCardPhoneBind, java.lang.String>{
	@Autowired
	private GdCardPhoneBindDaoImpl gdCardPhoneBindDao;

	@Override
	protected BaseDao<GdCardPhoneBind, java.lang.String> getBaseDao() {
		return gdCardPhoneBindDao;
	}

}
