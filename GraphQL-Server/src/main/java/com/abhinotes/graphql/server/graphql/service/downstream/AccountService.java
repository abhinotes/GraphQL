package com.abhinotes.graphql.server.graphql.service.downstream;

import com.abhinotes.graphql.server.cms.account.entity.Account;
import com.abhinotes.graphql.server.cms.customer.entity.Customer;
import com.abhinotes.graphql.server.graphql.helper.RestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.abhinotes.graphql.server.graphql.helper.Constants;

import java.util.List;

@Service
@Slf4j
public class AccountService{

    private final RestClient restClient;
    private final String accountservicebaseurl;

    public AccountService(RestClient restClient, @Value("${downstream.url.account}") String accountServiceBaseUrl) {
        this.restClient = restClient;
        this.accountservicebaseurl = accountServiceBaseUrl;
    }

    public Account create(Account account) {
        return restClient.post(accountservicebaseurl,account,Account.class);
    }

    public List<Account> getByCustomerID(Long customerID) {
        return restClient.get(
                accountservicebaseurl
                        .concat(Constants.CUSTOMEREP)
                        .concat(String.valueOf(customerID)),
                List.class);
    }
}
