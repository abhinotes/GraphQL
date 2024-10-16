## Graph QL Notes
1. ### Use @SchemaMapping - Avoid Nested Dataset implementation in one method 

   - In [apibanking.graphqls](src/main/resources/graphql/apibanking.graphqls) schema if we only select Customer details and not other nested objects like Account or Transactions, It will still call all implementation if we implement in controller the conventional way 
   - To avoid all nested calls we need to do child object implementation using `@SchemaMapping`
   - Example 
   ```declarative
        @SchemaMapping(typeName = "CustomerContext", field = "accounts")
        public List<Account> getAccountsForCustomer(Customer customer) {
        log.trace("#GPQL# 2 : Populating Account number for given Customer id {} ", customer.getId());
        return customerContextService.getAccountsForCustomer(customer.getId());
        }
    ```
   - Here typeName is Parent Dataset Name & field is the actual field in schema which is implemented in this method.
   - Method will get Parent object as input in this example Customer Object 

## Kafka Setup 

```Kafdrop Docker 
    docker run -d --rm -p 9000:9000 \
        -e KAFKA_BROKERCONNECT=localhost:9092 \
        -e SERVER_SERVLET_CONTEXTPATH="/" \
        obsidiandynamics/kafdrop



```

```Kafdrop using Jar 
java --add-opens=java.base/sun.nio.ch=ALL-UNNAMED \
    -jar kafdrop-4.0.2.jar 

```

## Postman Collection 
https://www.postman.com/abhinotes/learning-suqad/overview

## Useful Web references 
https://medium.com/@praveenkumarsingh/different-ways-to-call-graphql-api-endpoints-in-spring-boot-4f409aaa101e


## Useful Scripts

#### Export Database from H2 Console 
`SCRIPT TO 'data.sql'`