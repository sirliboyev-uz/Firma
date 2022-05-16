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
public class Ishchi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "Ishchi ismi bo'sh bo'lmasligi kerak")
    private String ismi;

    @Column(nullable = false)
    @NotNull(message = "Telefon raqami bo'sh bo'lmasligi kerak")
    private String telefonRaqami;

    @Column(nullable = false)
    @NotNull(message = "Maoshi bo'sh bo'lmasligi kerak")
    private Integer maoshi;

    @Column(nullable = false)
    @NotNull(message = "Lavozimi bo'sh bo'lmasligi kerak")
    private String lavozimi;

    @Column(nullable = false)
    @NotNull(message = "Manzili bo'sh bo'lmasligi kerak")
    private String manzili;
}