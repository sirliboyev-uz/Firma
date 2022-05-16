package com.example.firma.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "Firma nomi bo'sh bo'lmasligi krak")
    private String firmaNomi;

    @Column(nullable = false)
    @NotNull(message = "Boshqaruvchi ismi bo'sh bo'lmasligi kerak")
    private String boshqaruvchiIsmi;

    @Column(nullable = false)
    @NotNull(message = "Manzil bo'sh bo'lmasligi kerak")
    private String manzili;
}
