package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner dado = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("Quantos funcionários vão ser registrados?");
        int N = dado.nextInt();
        for (int i = 0; i<N; i++){
            System.out.println();
            System.out.println("Funcionário #" + ( i + 1) + ":" );
            System.out.print("ID: ");
            Integer id = dado.nextInt();
            while (hasID(list, id)){
                System.out.println("O Id já existe, tente novamente.");
                id = dado.nextInt();
            }
            System.out.print("Name: ");
            dado.nextLine();
            String name = dado.nextLine();
            System.out.print("Salary: ");
            Double salary = dado.nextDouble();

            Employee emp = new Employee(id,name,salary);
            list.add(emp);
        }

        System.out.print("Insira o funcionário para incrementar o salário: ");
        int idSalary = dado.nextInt();
        //Integer pos = position(list, idSalary); - FORMA 1
        //FORMA 2

        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("Id não existe");
        }
        else{
            System.out.print("Entre com a porcentagem: ");
            double percent = dado.nextDouble();
            //list.get(pos).increaseSalary(percent); - Pertence a forma 1
            emp.increaseSalary(percent);
        }
        System.out.println();
        System.out.println("Lista de funcionários");

        for (Employee e :list) {
            System.out.println(e);
        }

        dado.close();
    }

    public static boolean hasID(List<Employee> list, int Id){
        Employee emp = list.stream().filter(x -> x.getId() == Id).findFirst().orElse(null);
        return emp != null;
    }
    // Pertence a forma 1
   public static Integer position(List<Employee> list, int id){
        for (int i=0; i < list.size(); i++){
            if (list.get(i).getId() == id)
                return i;
        }
        return null;
   }

}
