package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.VAlpBocStl;
import com.yada.ssp.query.VAlpBocStlQuery;
import com.yada.ssp.reportModel.VAlpBocStlModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xianyong
 */
@Component
public class VAlpBocStlDaoImpl extends BaseDaoImpl<VAlpBocStl,String> {

    public List<VAlpBocStl> findAll(VAlpBocStlQuery query){
        return getSqlSessionTemplate().selectList("VAlpBocStl_findAll",query);
    }

}
