package com.steven.hicks.logic.dao;

public interface DAO<T>
{
//    List<T> search();
    T get(String id);
}