package com.deva.currency.model;

import java.util.*;

public class CurrencyResponse {
    private Map<String,Double> rates;
    public Map<String,Double> getRates(){
        return rates;
    }
    public void setRates(Map<String,Double> rates){
        this.rates=rates;
    }
}
