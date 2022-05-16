package com.example.firma.Repository;

import com.example.firma.Model.Firma;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;

public interface FirmaRepository extends JpaRepository<Firma, Integer> {
    boolean existsByFirmaNomiAndManzili(@NotNull(message = "Firma nomi bo'sh bo'lmasligi krak") String firmaNomi, @NotNull(message = "Manzil bo'sh bo'lmasligi kerak") String manzili);
}
