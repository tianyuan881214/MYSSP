package com.yada.ssp.dao;

import com.yada.security.base.BaseDaoImpl;
import com.yada.ssp.model.MerchantGrpLs;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xianyong
 */
@Component
public class MerchantGrpLsDaoImpl extends BaseDaoImpl<MerchantGrpLs,String> {

    public List<MerchantGrpLs> getmerchantList(){
        Map<String, String> map=new HashMap<String, String>();
        return this.getSqlSessionTemplate().selectList("MerchantGrpLs_findListByWhere",map);
    }
}
