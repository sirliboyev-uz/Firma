package com.example.firma.Service;

import com.example.firma.Model.Ishchi;
import com.example.firma.Repository.IshchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IshchiService {
    @Autowired
    IshchiRepository ishchiRepository;

    public List<Ishchi> ishchilarniChiqarish(){
        List<Ishchi> all = ishchiRepository.findAll();
        return all;
    }

    public Boolean kiritish(Ishchi ishchi){
        boolean b = ishchiRepository.existsByIsmiAndManzili(ishchi.getIsmi(), ishchi.getManzili());
        if (b){
            return false;
        }
        Ishchi ishchi1 = new Ishchi();
        ishchi1.setIsmi(ishchi.getIsmi());
        ishchi1.setLavozimi(ishchi.getLavozimi());
        ishchi1.setTelefonRaqami(ishchi.getTelefonRaqami());
        ishchi1.setManzili(ishchi.getManzili());
        return true;
    }

    public Boolean yangilash(Integer id, Ishchi ishchi){
        Optional<Ishchi> optionalIshchi = ishchiRepository.findById(id);
        boolean b = ishchiRepository.existsByIsmiAndManzili(ishchi.getIsmi(), ishchi.getManzili());
        if (b){
            return false;
        }
        if (optionalIshchi.isPresent()){
            Ishchi ishchi1 = optionalIshchi.get();
            ishchi1.setIsmi(ishchi.getIsmi());
            ishchi1.setLavozimi(ishchi.getLavozimi());
            ishchi1.setMaoshi(ishchi.getMaoshi());
            ishchi1.setTelefonRaqami(ishchi.getTelefonRaqami());
            ishchi1.setManzili(ishchi.getManzili());
            ishchiRepository.save(ishchi1);
            return true;
        }
        return false;
    }
    public Boolean ochirish(Integer id){
        Optional<Ishchi> ishchiOptional = ishchiRepository.findById(id);
        if (ishchiOptional.isPresent()){
            ishchiRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
