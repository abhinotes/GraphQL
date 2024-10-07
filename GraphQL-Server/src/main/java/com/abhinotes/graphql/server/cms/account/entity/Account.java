package com.abhinotes.graphql.server.cms.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String accountNumber;
    private String accountType;
    private Long customerID;
    private String dateOpened;
    private Float balance;
    private String status;

    public Account(Long customerID, String dateOpened, String status) {
        this.customerID = customerID;
        this.dateOpened = dateOpened;
        this.status = status;
    }
}
