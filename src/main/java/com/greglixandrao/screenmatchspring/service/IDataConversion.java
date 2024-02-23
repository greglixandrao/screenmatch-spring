package com.greglixandrao.screenmatchspring.service;

public interface IDataConversion {
    <T> T getData(String json, Class<T> tClass);
}
