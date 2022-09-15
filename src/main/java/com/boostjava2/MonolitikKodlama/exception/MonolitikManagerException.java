package com.boostjava2.MonolitikKodlama.exception;

import lombok.Getter;

@Getter
public class MonolitikManagerException extends RuntimeException{
    /**
     * Uygujlama içinde fırlatılacak olan özelleştirilmiş hatalar için kullanılacaktır.
     */
    private final ErrorType errorType;

    public MonolitikManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MonolitikManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }

}
