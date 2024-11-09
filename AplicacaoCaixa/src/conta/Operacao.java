package conta;

import exceptions.ContaInvalidaException;
import exceptions.OperacaoInvalidaException;
import exceptions.SaldoInsuficienteException;

public interface Operacao {
    public void sacar(Double valor) throws SaldoInsuficienteException;

    public void depositar(Double valor);

    public void transfere(Conta contaDestino, Double valor) throws SaldoInsuficienteException, OperacaoInvalidaException, ContaInvalidaException;
}
