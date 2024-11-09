package conta;

import exceptions.ContaInvalidaException;
import exceptions.SaldoInsuficienteException;

public class Corrente extends Conta {

    public Corrente() {
        super();
    }

    public void exibirDadosDaConta() {
        System.out.println("Nome completo: " + getNome());
        System.out.println("Data nascimento: " + getNascimento());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Conta: " + getConta());
        System.out.println("Saldo: R$ " + getSaldo());
    }

    @Override
    public void sacar(Double valor) throws SaldoInsuficienteException {
        if (valor <= super.getSaldo()) {
            super.setSaldo(super.getSaldo() - valor);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque de R$ " + valor);
        }
    }

    @Override
    public void transfere(Conta contaDestino, Double valor) throws SaldoInsuficienteException, ContaInvalidaException {
        if (this.getSaldo() >= valor) {
            if (contaDestino == this) {
                throw new ContaInvalidaException("Conta inválidan, não foi possível realizar a transferência para mesma conta.");
            }
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para a transferência de R$ " + valor);
        }
    }

}
