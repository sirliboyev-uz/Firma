package com.example.firma.Controller;

import com.example.firma.Model.Ishchi;
import com.example.firma.Repository.FirmaRepository;
import com.example.firma.Repository.IshchiRepository;
import com.example.firma.Service.IshchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ishchi")
public class IshchiController {
    @Autowired
    IshchiService ishchiService;

    @Autowired
    FirmaRepository firmaRepository;

    @GetMapping
    public ResponseEntity<?> ishchilarniChiqarish(){
        return ResponseEntity.ok(ishchiService.ishchilarniChiqarish());
    }

    @PostMapping("/kiritish")
    public ResponseEntity<?> ishchilarniKiritish(@RequestBody Ishchi ishchi){
        Boolean i = ishchiService.kiritish(ishchi);
        if (i){
            return ResponseEntity.status(200).body("Joylandi");
        }
        return ResponseEntity.status(208).body("Bunday ishchi mavjud");
    }

    @PutMapping("/yangilash/{id}")
    public ResponseEntity<?> ishchiniYangilash(@PathVariable Integer id, @RequestBody Ishchi ishchi){
        Boolean y = ishchiService.yangilash(id, ishchi);
        if (y){
            return ResponseEntity.status(200).body("Muvaffaqiyatli yangilandi");
        }
        return ResponseEntity.status(208).body("Bunday ishchi mavjud emas");
    }
    @DeleteMapping("/ochirish/{id}")
    public ResponseEntity<?> ishchiniOchirish(@PathVariable Integer id){
        Boolean o = ishchiService.ochirish(id);
        if (o){
            return ResponseEntity.status(200).body("Muvaffaqiyatli ochirildi");
        }
        return ResponseEntity.status(208).body("Bunday ishchi mavjud emas");
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
