package com.example.NBP.controller;

import com.example.NBP.Repository.NbpRepository;
import com.example.NBP.model.CurrencyData;
import com.example.NBP.model.NbpResponse;
import com.example.NBP.model.Rate;
import com.example.NBP.service.NbpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class NbpController {
    private final NbpService nbpService;
    public final NbpRepository nbpRepository;

    public NbpController(NbpService nbpService, NbpRepository nbpRepository) {
        this.nbpService = nbpService;
        this.nbpRepository = nbpRepository;
    }

    @Operation(summary = "Pobiera średni kurs waluty za ostatnie dni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Zapytanie wykonane poprawnie"),
            @ApiResponse(responseCode = "400", description = "Nieprawidłowy kod waluty lub liczba dni"),
            @ApiResponse(responseCode = "404", description = "Nie znaleziono danych dla podanego kodu waluty"),
            @ApiResponse(responseCode = "500", description = "Błąd serwera NBP lub błąd wewnętrzny serwera")
    })
    @GetMapping("/rate/{currency}")
    public ResponseEntity<CurrencyData> getCurrencyRate(
            @PathVariable("currency") String currency,
            @RequestParam(defaultValue = "1") int lastDays) {
        NbpResponse nbpResponse = nbpService.getCurrencyRates("A", currency, lastDays);

        // Obliczanie średniego kursu
        double averageRate = nbpResponse.getRates().stream()
                .mapToDouble(Rate::getMid)
                .average()
                .orElseThrow(() -> new RuntimeException("Nie można obliczyć średniego kursu"));

        // Zapisywanie informacji do bazy danych
        CurrencyData history = new CurrencyData();
        history.setCurrency(currency);
        history.setDays(lastDays);
        history.setAverageRate(averageRate);
        history.setQueryDateTime(LocalDateTime.now());

        nbpRepository.save(history);

        return ResponseEntity.ok(history);
    }
}
