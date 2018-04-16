package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.AlpConfigParam;
import org.springframework.stereotype.Component;

/**
 * @author xianyong
 */
@Component
public class AlpConfigParamDaoImpl extends BaseDaoImpl<AlpConfigParam, String> {

    public AlpConfigParam findAll() {
        return this.getSqlSessionTemplate().selectOne("AlpConfigParam_findAll");
    }

    public int updateList(AlpConfigParam alpConfigParam) {
        return this.getSqlSessionTemplate().update("AlpConfigParam_updateList", alpConfigParam);
    }
}
