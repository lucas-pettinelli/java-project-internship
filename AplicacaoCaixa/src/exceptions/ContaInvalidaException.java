package exceptions;

public class ContaInvalidaException extends  RuntimeException{
    public ContaInvalidaException(String menssagem){
        super(menssagem);
    }
}
