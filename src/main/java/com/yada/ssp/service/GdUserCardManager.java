/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseDao;
import com.yada.security.base.BaseService;

import java.util.*;

import com.yada.ssp.dao.*;
import com.yada.ssp.model.*;
import com.yada.ssp.query.*;
import com.yada.ssp.service.*;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Service
public class GdUserCardManager extends BaseService<GdUserCard, java.lang.String>{
	@Autowired
	private GdUserCardDaoImpl gdUserCardDao;

	@Override
	protected BaseDao<GdUserCard, java.lang.String> getBaseDao() {
		return gdUserCardDao;
	}

}
