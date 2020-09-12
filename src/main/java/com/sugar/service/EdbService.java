package com.sugar.service;

import com.sugar.infrastructure.client.EDBClient;
import com.sugar.infrastructure.edb.EdbTradeGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zhanghongqun on 2020/7/13.
 */
@Service
public class EdbService {

    final EDBClient edbClient;

    @Autowired
    public EdbService(EDBClient edbClient) {
        this.edbClient = edbClient;
    }

    public Map<String, String> getOrder(String orderNo) {
        EdbTradeGet edbTradeGet = new EdbTradeGet();
        edbTradeGet.setOut_tid(orderNo);
        return edbClient.get(edbTradeGet.getRequestMap());
    }
}
