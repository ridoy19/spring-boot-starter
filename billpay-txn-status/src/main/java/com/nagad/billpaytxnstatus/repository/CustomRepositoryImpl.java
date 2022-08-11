package com.nagad.billpaytxnstatus.repository;

import com.nagad.billpaytxnstatus.models.TransactionStatusResponseBiller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomRepositoryImpl implements ICustomRepository {
    @PersistenceContext
    private EntityManager entityManager;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public TransactionStatusResponseBiller runNativeQuery(String txnId) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM TECH_PM_JAKARIA_STG_TW210460.B_NESCO_PREPAID_DATA e where e.nagad_txn_id = ? ");
        query.setParameter(1, txnId);
        Object singleResult = query.getSingleResult();
        logger.info("Response from database: {}", singleResult);
        return (TransactionStatusResponseBiller) singleResult;
    }
}
