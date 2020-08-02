package com.moctho.mockthoapi.exception;

public class SSLRelatedException extends  IllegalStateException {

    private String message;

    private  static  final  long serialVersionUID = 187884830160378455L;

    public SSLRelatedException(Throwable cause){
        super(cause);
    }

    public SSLRelatedException(String message, Throwable cause){
        super(message,cause);
        this.message  = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
