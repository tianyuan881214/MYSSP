/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.dao;

import java.util.*;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.*;
import com.yada.ssp.dao.*;
import com.yada.ssp.service.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public class MerchantBaseSonDaoImpl extends BaseDaoImpl<MerchantBaseSon,java.lang.String>{
	public List<MerchantBaseSon> getmerbusinessList(String Id) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("Id", Id);
		return this.getSqlSessionTemplate().selectList("MerchantBaseSon_getmerchantenterb",map);
	}

	public List<MerchantBaseSon> findByMerGrpId(String merGrpId){
		return this.getSqlSessionTemplate().selectList("MerchantBaseSon_findByMerGrpId",merGrpId);
	}
}
