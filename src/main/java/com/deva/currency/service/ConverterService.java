package com.deva.currency.service;

import com.deva.currency.model.CurrencyResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ConverterService {
    public double convert(String from,String to,double amount){
        from = from.trim().toUpperCase();
        to   = to.trim().toUpperCase();
        String url="https://api.exchangerate-api.com/v4/latest/"+from;

        RestTemplate restTemplate = new RestTemplate();
        CurrencyResponse response= restTemplate.getForObject(url,CurrencyResponse.class);
        if (response == null || response.getRates() == null) {
            throw new RuntimeException("Invalid currency code: " + from);
        }
        Double rate=response.getRates().get(to);
        if (rate == null) {
            throw new RuntimeException("Invalid currency code: " + to);
        }
        return amount*rate;



    }
}
