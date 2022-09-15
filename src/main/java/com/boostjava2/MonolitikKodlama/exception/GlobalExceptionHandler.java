package com.boostjava2.MonolitikKodlama.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 1- Method a tamamen keyfidir. İstediğiniz gibi isimlendirebilirsiniz.
     * 2- Geridönüş tipi de keyfidir. İstenilen bir değer döndürülebilir.
     * **** Ancak, buraya kontrol edilebilen ve sınıflandırılmış mesajlar koymak doğru yaklaşım olacaktır. ***
     * 3- Method içi parametreleri yakalamak istediğiniz istisnaını türünde olmalı.
     * 4- Spring' in otomatik olarak yakalayacağı istisnanın türünü bildirmeniz gerekir.
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.ok("Beklenmeyen bir hata oluştu: " + ex.getMessage());
    }
}
