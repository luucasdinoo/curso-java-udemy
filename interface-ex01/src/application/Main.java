package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner dado = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        int number = dado.nextInt();
        System.out.println("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(dado.next(),fmt);
        System.out.print("Valor do contrato: ");
        double totalValue = dado.nextDouble();

        Contract contract = new Contract(number, date, totalValue);
        System.out.print("Entre com o número de parcelas: ");
        int n = dado.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract,n);

        System.out.println("Parcelas: ");
        for (Installment installment : contract.getInstallments())
            System.out.println(installment);

        dado.close();
    }
}
