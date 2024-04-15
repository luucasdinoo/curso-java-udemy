package application;

import entities.Employee;
import entities.OutSourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner dado = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        System.out.println("Quantos funcionários deseja adicionar? ");
        int n = dado.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Funcionário #" + (i + 1));
            System.out.print("O funcionário é terceirizado? (y/n) ");
            char ch = dado.next().charAt(0);
            System.out.println("Name: ");
            dado.nextLine();
            String name = dado.nextLine();
            System.out.println("Horas: ");
            int hours = dado.nextInt();
            System.out.println("Valor por hora: ");
            double valuePerHour = dado.nextDouble();
            if(ch == 'y'){
                System.out.println("Cobrança adicional: ");
                double additionalCharge = dado.nextDouble();
                list.add(new OutSourcedEmployee(name, hours, valuePerHour, additionalCharge));
            }
            else{
                list.add(new Employee(name, hours,valuePerHour));
            }

        }

        System.out.println();
        System.out.println("Pagamentos: ");
        for (Employee emp : list){
            System.out.println(emp.getName() + " - $ " + String.format("%.2f" , emp.payment()));
        }
        dado.close();
    }
}
