package com.example.myconverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ConstantValues {
    public static final LinkedHashMap<String, Double> currencyWeight;
    static {
        currencyWeight = new LinkedHashMap<>();
        currencyWeight.put("USD", 24842.5);
        currencyWeight.put("EUR", 25462.07);
        currencyWeight.put("VND", 1.0);
        currencyWeight.put("BTC", 401872154.0);
        currencyWeight.put("ETH", 28148291.5);
        currencyWeight.put("DOGE", 1883.8);

    }
    public static final ArrayList<String> currency = new ArrayList<>(currencyWeight.keySet());
}
