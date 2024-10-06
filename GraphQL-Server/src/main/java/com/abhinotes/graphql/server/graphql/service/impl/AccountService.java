package com.abhinotes.graphql.server.graphql.service.impl;

import com.abhinotes.graphql.server.cms.account.entity.Account;
import com.abhinotes.graphql.server.graphql.helper.RestClient;
import com.abhinotes.graphql.server.graphql.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.abhinotes.graphql.server.graphql.helper.Constants;

@Service
@Slf4j
public class AccountService implements DataService<Account> {

    private final RestClient restClient;
    private final String accountservicebaseurl;

    public AccountService(RestClient restClient, @Value("${downstream.url.account}") String accountServiceBaseUrl) {
        this.restClient = restClient;
        this.accountservicebaseurl = accountServiceBaseUrl;
    }

    @Override
    public Account create(Account account) {
        return restClient.post(accountservicebaseurl,account,Account.class);
    }

    @Override
    public Account getByID(String accountNumber) {
        return restClient.get(accountservicebaseurl.concat(Constants.FORWARDSLASH).concat(accountNumber), Account.class);
    }
}
