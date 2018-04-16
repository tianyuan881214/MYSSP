/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.RateTable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RateDaoImpl extends BaseDaoImpl<RateTable,String>{

    public List<RateTable> getRateList() {
        return this.getSqlSessionTemplate().selectList("RateTable_findListByWhere");
    }
    public void insert(RateTable rateTable) {
        this.getSqlSessionTemplate().insert("RateTable_insert",rateTable);
    }

    public RateTable getById(String rateId) {
        return this.getSqlSessionTemplate().selectOne("RateTable_getById", rateId);
    }

}
