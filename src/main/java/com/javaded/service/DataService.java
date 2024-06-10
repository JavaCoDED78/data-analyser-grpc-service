package com.javaded.service;

import com.javaded.model.Data;

import java.util.List;

public interface DataService {

    void handle(Data data);

    List<Data> getWithBatch(long batchSize);

}
