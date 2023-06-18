package com.example.NBP.Repository;

import com.example.NBP.model.CurrencyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NbpRepository extends JpaRepository<CurrencyData, Long> {
}
