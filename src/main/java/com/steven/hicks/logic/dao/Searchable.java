package com.steven.hicks.logic.dao;

import com.steven.hicks.logic.queryBuilders.QueryBuilder;

public interface Searchable<T, K>
{
    T get(String id);
    void search(QueryBuilder queryBuilder, int pageNumber);
    K getSearchResults();
    K searchAndGet(QueryBuilder queryBuilder, int pageNumber);
    boolean hasNextPage();
    K getNextPage(QueryBuilder queryBuilder);
    int getNumberOfPages();
}
