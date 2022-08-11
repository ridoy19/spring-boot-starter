package com.nagad.billpaytxnstatus.repository;

import com.nagad.billpaytxnstatus.model.TransactionStatusResponseBiller;
import com.nagad.billpaytxnstatus.model.dto.TransactionStatusInfo;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CustomBillerRepositoryImpl implements ICustomBillerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List <Map< String, String >>  getTransactionStatusByTxnId(String txnId) {
        Query query = entityManager.createNativeQuery(
                "SELECT nagad_payer_no CUSTOMERMOBILENO, nagad_txn_amount TXNAMOUNT FROM TECH_PM_JAKARIA_STG_TW210460.B_NESCO_PREPAID_DATA e where e.nagad_txn_id = ? ");
        query.setParameter(1, txnId);
//        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
//        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
//
//        query.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.aliasToBean(TransactionStatusResponseBiller.class)).list();
//
//        List<TransactionStatusInfo> result_list = query.getResultList();

        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List <Map < String, String >> result = query.getResultList();
        for (Map map: result) {
            System.out.println("after request  ::: " + map);
        }
        return result;
    }
}
