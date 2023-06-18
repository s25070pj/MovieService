package com.example.NBP.service;

import com.example.NBP.Repository.NbpRepository;
import com.example.NBP.model.NbpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpService {
    private static final String NBP_API_BASE_URL = "http://api.nbp.pl/api/exchangerates/rates";
    private final RestTemplate restTemplate;
    public NbpService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public NbpResponse getCurrencyRates(String table, String code, int lastDays) {
        String url = String.format("%s/%s/%s/last/%d", NBP_API_BASE_URL, table, code, lastDays);
        return restTemplate.getForObject(url, NbpResponse.class);
    }
}
