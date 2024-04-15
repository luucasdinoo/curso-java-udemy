package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevelEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner dado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do departamento: ");
        String departamentName = dado.nextLine();
        System.out.println("Insira os dados do trabalhador");
        System.out.print("Name: ");
        String workerName = dado.nextLine();
        System.out.print("Level: ");
        String workerLevel = dado.nextLine();
        System.out.print("Salário Base: ");
        double baseSalary = dado.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevelEnum.valueOf(workerLevel),baseSalary, new Departament(departamentName));

        System.out.print("Quantos contratos você vai ter?");
        int n = dado.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Contrato #" + i + "data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(dado.next());
            System.out.print("Valor por hora: ");
            double valuePerHour = dado.nextDouble();
            System.out.print("Duração do contrato: ");
            int hours = dado.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }
        System.out.println("");
        System.out.print("Entre com mês e ano para calcular o salário (MM/YY: ");
        String monthAdnYear = dado.next();
        int month = Integer.parseInt(monthAdnYear.substring(0,2));
        int year = Integer.parseInt(monthAdnYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartament().getName());
        System.out.println("Renda para " + monthAdnYear + ": " + String.format("%.2f", worker.income(year, month)));

        dado.close();
    }
}
