package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.VAlpMersStlLs;
import com.yada.ssp.reportModel.VAlpMersStlLsReportQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xianyong
 */
@Component
public class VAlpMersStlLsDaoImpl extends BaseDaoImpl<VAlpMersStlLs,String> {
    public List<VAlpMersStlLs> findAll(VAlpMersStlLsReportQuery query){
        return getSqlSessionTemplate().selectList("VAlpBocStl_findAll",query);
    }
}
