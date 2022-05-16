package com.example.firma.Service;

import com.example.firma.Model.Firma;
import com.example.firma.Repository.FirmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirmaService {
    @Autowired
    FirmaRepository firmaRepository;
    public List<Firma> chiqarish(){
        List<Firma> firmaList = firmaRepository.findAll();
        return firmaList;
    }

    public Boolean kiritish(Firma firma){
        boolean b = firmaRepository.existsByFirmaNomiAndManzili(firma.getFirmaNomi(), firma.getManzili());
        if (b){
            return false;
        }
        Firma firma1 = new Firma();
        firma1.setFirmaNomi(firma.getFirmaNomi());
        firma1.setBoshqaruvchiIsmi(firma.getBoshqaruvchiIsmi());
        firma1.setManzili(firma.getManzili());
        firmaRepository.save(firma1);
        return true;
    }

    public Boolean yangilash(Firma firma, Integer id){
        Optional<Firma> optionalFirma = firmaRepository.findById(id);
        boolean b = firmaRepository.existsByFirmaNomiAndManzili(firma.getFirmaNomi(), firma.getManzili());
        if (b){
            return false;
        }
        if (optionalFirma.isPresent()){
            Firma firma1 = optionalFirma.get();
            firma1.setBoshqaruvchiIsmi(firma.getBoshqaruvchiIsmi());
            firma1.setFirmaNomi(firma.getFirmaNomi());
            firma1.setManzili(firma.getManzili());
            firmaRepository.save(firma1);
            return true;
        }
        return false;
    }
    public Boolean ochirish(Integer id){
        Optional<Firma> optionalFirma = firmaRepository.findById(id);
        if (optionalFirma.isPresent()){
            firmaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
