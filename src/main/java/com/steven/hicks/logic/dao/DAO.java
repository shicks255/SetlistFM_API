package com.steven.hicks.logic.dao;

//692ab4ce-9835-4040-8bb8-d6bb77ba54f8

import com.steven.hicks.logic.queryBuilders.QueryBuilder;

import java.util.List;

public interface DAO<T>
{

    public <T> List<?> search(QueryBuilder builder);

    public T get(String id);

}
