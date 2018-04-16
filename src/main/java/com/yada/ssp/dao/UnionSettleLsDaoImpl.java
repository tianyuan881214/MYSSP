package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.AiliCheckFile;
import com.yada.ssp.model.UnionSettleLs;
import com.yada.ssp.query.AiliCheckFileQuery;
import com.yada.ssp.query.UnionSettleLsQuery;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author xianyong
 */
@Component
public class UnionSettleLsDaoImpl extends BaseDaoImpl<UnionSettleLs,String> {
        public List<UnionSettleLs> findAll(){
            return getSqlSessionTemplate().selectList("UnionSettleLs_findListByWhere");
        }
}
