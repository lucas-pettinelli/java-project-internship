package conta;

import exceptions.EntradaDeDadosNulaException;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Conta implements Operacao {
    private String nome;
    private Integer agencia;
    private Integer conta;
    private Double saldo;
    LocalDate nascimento;

    public Conta() {
        this.setSaldo(Double.valueOf(0));
    }

    public void depositar(Double valor) {
        this.saldo += valor;
    }

    public String getNome() {
        if (this.nome == null || this.nome.trim().isEmpty()) {
            throw new EntradaDeDadosNulaException("Nome não pode ser nulo!");
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        if (nascimento == null) {
            throw new EntradaDeDadosNulaException("Idade não pode ser nula!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;

        return Objects.equals(agencia, conta.agencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia);
    }

    /*@Override
    public String toString() {
        return "Conta\n" +2
                "nome:'" + nome + '\'' +
                ", agencia: " + agencia +
                ", conta:" + conta +
                "\n saldo=" + saldo +
                '}';
    }*/
}

