package com.abhinotes.graphql.server.graphql.service.impl;

import com.abhinotes.graphql.server.banking.transaction.entity.Transaction;
import com.abhinotes.graphql.server.graphql.helper.RestClient;
import com.abhinotes.graphql.server.graphql.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionService implements DataService<Transaction> {

    private final RestClient restClient;
    private final String TRANSACTIONSERVICEBASEURL;

    public TransactionService(RestClient restClient,  @Value("${downstream.url.transaction}") String transactionServiceBaseUrl) {
        this.restClient = restClient;
        TRANSACTIONSERVICEBASEURL = transactionServiceBaseUrl;
    }

    @Override
    public Transaction create(Transaction transaction) {
        return restClient.post(TRANSACTIONSERVICEBASEURL,transaction,Transaction.class);
    }

    @Override
    public Transaction getByID(String transactionNumber) {
        return restClient.get(TRANSACTIONSERVICEBASEURL.concat("/").concat(transactionNumber), Transaction.class);
    }
}
