package conta;

import exceptions.OperacaoInvalidaException;
import exceptions.SaldoInsuficienteException;

public class Poupanca extends Conta {

    public Poupanca() {
        super();
    }

    public void exibirDadosDaConta() {
        System.out.println("Nome completo: " + getNome());
        System.out.println("Data nascimento: " + getNascimento());
        System.out.println("Agência: " + getAgencia());
        System.out.println("conta.Conta: " + getConta());
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
    public void transfere(Conta contaDestino, Double valor) throws OperacaoInvalidaException {
        throw new OperacaoInvalidaException("Operação de transferência inválida para conta poupança!");
    }


}
