package com.example.firma.Controller;

import com.example.firma.Model.Firma;
import com.example.firma.Service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/firma")
public class FirmaController {
    @Autowired
    FirmaService firmaService;

    @GetMapping("/chiqarish")
    public ResponseEntity<?> firmaShow(){
        return ResponseEntity.ok(firmaService.chiqarish());
    }

    @PostMapping("/kiritish")
    public ResponseEntity<?> firmaInput(@RequestBody Firma firma){
        Boolean kiritish = firmaService.kiritish(firma);
        if (kiritish){
            return ResponseEntity.status(200).body("Joylandi");
        }
        return ResponseEntity.status(208).body("Joylanmadi");
    }
    @PutMapping("/yangilash/{id}")
    public ResponseEntity<?> firmaUpdate(@RequestBody Firma firma, @PathVariable Integer id){
        Boolean yangilash = firmaService.yangilash(firma, id);
        if (yangilash){
            return ResponseEntity.status(200).body("Muvaffaqiyatli yangilandi");
        }
        return ResponseEntity.status(208).body("Bunday id mavjud emas");
    }
    @DeleteMapping("/ochirish/{id}")
    public ResponseEntity<?> firmaDelete(@PathVariable Integer id){
        Boolean d = firmaService.ochirish(id);
        if (d){
            return ResponseEntity.status(200).body("O'chirildi");
        }
        return ResponseEntity.status(208).body("Bunday id mavjud emas");
    }
}
