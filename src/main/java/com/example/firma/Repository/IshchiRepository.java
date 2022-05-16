package com.example.firma.Repository;

import com.example.firma.Model.Ishchi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IshchiRepository extends JpaRepository<Ishchi, Integer> {
    boolean existsByIsmiAndManzili(String ismi, String manzili);
}
