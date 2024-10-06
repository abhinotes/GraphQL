package com.abhinotes.graphql.server.graphql.service;

public interface DataService <T> {

    public T create(T t);
    public T getByID(String t);
}
