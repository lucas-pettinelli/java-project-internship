package exceptions;

public class OperacaoInvalidaException extends RuntimeException{
    public OperacaoInvalidaException(String menssagem){
        super(menssagem);
    }
}
