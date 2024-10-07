package com.abhinotes.graphql.server.graphql.service.downstream;

import com.abhinotes.graphql.server.banking.transaction.entity.Transaction;
import com.abhinotes.graphql.server.graphql.helper.RestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionService {

    private final RestClient restClient;
    private final String transactionServiceBaseUrl;

    public TransactionService(RestClient restClient,  @Value("${downstream.url.transaction}") String transactionServiceBaseUrl) {
        this.restClient = restClient;
        this.transactionServiceBaseUrl = transactionServiceBaseUrl;
    }

    public Transaction create(Transaction transaction) {
        return restClient.post(transactionServiceBaseUrl,transaction,Transaction.class);
    }

    public Transaction getByID(String transactionNumber) {
        return restClient.get(transactionServiceBaseUrl.concat("/").concat(transactionNumber), Transaction.class);
    }
}
