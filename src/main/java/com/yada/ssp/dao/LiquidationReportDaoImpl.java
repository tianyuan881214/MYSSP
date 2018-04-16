/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.LiquidationReport;
import com.yada.ssp.query.LiquidationReportQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LiquidationReportDaoImpl extends BaseDaoImpl<LiquidationReport,String>{

    public  List<LiquidationReport>findAll(LiquidationReportQuery query){
        return this.getSqlSessionTemplate().selectList("LiquidationReport_findAll",query);
    }

}
