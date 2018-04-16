/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yada.ssp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;
import com.yada.ssp.model.*;
import com.yada.ssp.dao.*;
import com.yada.ssp.service.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Service
public class CurSignLsManager extends BaseService<CurSignLs,java.lang.String>{
	@Autowired
	private CurSignLsDaoImpl curSignLsDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	
	@Override
	protected BaseDao<CurSignLs, java.lang.String> getBaseDao() {
		return curSignLsDao;
	}
	
	/*public void setCurSignLsDao(CurSignLsDao dao) {
		this.curSignLsDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.curSignLsDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(CurSignLsQuery query) {
		return curSignLsDao.findPage(query);
	}
	*/
}
