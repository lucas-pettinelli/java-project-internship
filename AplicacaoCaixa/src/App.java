import conta.Conta;
import conta.Corrente;
import conta.Poupanca;
import exceptions.SaldoInsuficienteException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws SaldoInsuficienteException {
        LocalDateTime registroFiscalDataHora = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy   hh:mm:ss");
        String registraDataHoraFormatado = registroFiscalDataHora.format(formater);

        Poupanca clientePoupanca2 = new Poupanca();
        LocalDate nascimentoClientePoupanca2 = LocalDate.of(1995, 12, 12);
        clientePoupanca2.setNome("Bart Simpsons");
        clientePoupanca2.setNascimento(nascimentoClientePoupanca2);
        clientePoupanca2.setAgencia(1010);
        clientePoupanca2.setConta(1206228 - 6);
        clientePoupanca2.depositar(Double.valueOf(150));

        Poupanca clientePoupanca1 = new Poupanca();
        LocalDate nascimentoClientePoupanca1 = LocalDate.of(1995, 12, 12);
        clientePoupanca1.setNome("Liza Simpsons");
        clientePoupanca1.setNascimento(nascimentoClientePoupanca1);
        clientePoupanca1.setAgencia(1010);
        clientePoupanca1.setConta(1206228 - 6);
        clientePoupanca1.depositar(Double.valueOf(500));

        try {
            clientePoupanca1.sacar(Double.valueOf(100));
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }


        Corrente clienteCorrente1 = new Corrente();
        LocalDate nascimentoClienteCorrente1 = LocalDate.of(2001, 10, 5);
        clienteCorrente1.setNome("Marge SImpsons");
        clienteCorrente1.setNascimento(nascimentoClienteCorrente1);
        clienteCorrente1.setAgencia(2020);
        clienteCorrente1.setConta(123550 - 8);
        clienteCorrente1.depositar(Double.valueOf(2000));


        try {
            clienteCorrente1.sacar(Double.valueOf(300));
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        Corrente clienteCorrete2 = new Corrente();
        LocalDate nascimentoClienteCorrente2 = LocalDate.of(1980, 6, 21);
        clienteCorrete2.setNome("Homer Simpsons");
        clienteCorrete2.setNascimento(nascimentoClienteCorrente2);
        clienteCorrete2.setAgencia(2020);
        clienteCorrete2.setConta(128899 - 7);
        clienteCorrete2.depositar(Double.valueOf(400));


        //validar se ir conseguir realizar operacao
        clienteCorrente1.transfere(clienteCorrete2, Double.valueOf(200));


        clienteCorrete2.sacar(Double.valueOf(50));


        //List< COntas Poupanças> ArrayLust

        System.out.println("========= NOTA I =========\n");
        clientePoupanca1.exibirDadosDaConta();
        System.out.println("============================");

        System.out.println();
        System.out.println("\n========= NOTA II =========\n");
        clienteCorrente1.exibirDadosDaConta();
        System.out.println("============================");

        System.out.println();
        System.out.println("\n========= NOTA III =========\n");
        clienteCorrete2.exibirDadosDaConta();
        System.out.println("============================");


        List<Corrente> correntes = new ArrayList<>();
        correntes.add(clienteCorrente1);
        correntes.add(clienteCorrete2);

        System.out.println();

        Collections.sort(correntes, Comparator.comparing(Conta::getNome));
        System.out.println("============================");
        correntes.forEach(Corrente::exibirDadosDaConta);

        System.out.println("\nA âgencia do(a) cliente  "
                + clienteCorrente1.getNome() + " é igual a de "
                + clienteCorrete2.getNome() + "?"
                + "\nResultado: " + clienteCorrente1.equals(clienteCorrete2));

        System.out.println("\nData e horário: " + registraDataHoraFormatado);
        System.out.println("============================");

        System.out.println("Saldo cliente1: " + clienteCorrente1.getSaldo());
        System.out.println("Saldo cliente2: " + clienteCorrete2.getSaldo());

    }
}
