package com.mynagad.apiexternal.billpaytxnstatus.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mynagad.apiexternal.billpaytxnstatus.model.dto.BillerTransactionStatusResponse;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomBillerRepositoryImpl implements ICustomBillerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List <Map<String, String>> getTransactionStatusByTxnId(String billerTableName, String txnId) {
        Query query = entityManager.createNativeQuery(
                "SELECT nagad_txn_id TXNID, nagad_txn_time TXNTIME,  nagad_txn_amount TXNAMOUNT, nagad_payer_no CUSTOMERMOBILENO FROM TECH_PM_JAKARIA_STG_TW210460 " + "." + billerTableName + " e where e.nagad_txn_id = ? ");
        query.setParameter(1, txnId);
        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);


        List <Map < String, String >> result = query.getResultList();
        return result;

    }

    @Override
    public String getBillerTableName(String serviceId) {
        Query query = entityManager.createNativeQuery(
                "SELECT billertablename BILLER_TABLE FROM TECH_PM_JAKARIA_STG_TW210460.BILLER_MAP e where e.biller = ? ");
        query.setParameter(1, serviceId);
        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

        List result = query.getResultList();
        return String.valueOf(result.get(0));

    }

}
