package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner dado = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel: ");
        System.out.print("Modelo do carro: ");
        String carModel = dado.nextLine();
        System.out.println("Retirada (dd/MM/yyyy hh:mm)");
        LocalDateTime start = LocalDateTime.parse(dado.nextLine(), fmt);
        System.out.println("Retorno (dd/MM/yyyy hh:mm)");
        LocalDateTime finish = LocalDateTime.parse(dado.nextLine(), fmt);

        CarRental cr = new CarRental(start,finish, new Vehicle(carModel));

        System.out.println("Entre com o preço por hora");
        double pricePerHour = dado.nextDouble();
        System.out.println("Entre com o preço por Dia");
        double pricePerDay = dado.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay,pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(cr);
        System.out.println("Fatura: ");
        System.out.println("Pagamento básico: "  + cr.getInvoice().getBasicPayment());
        System.out.println("Imposto: " + cr.getInvoice().getTax());
        System.out.println("Pagamento total: " + cr.getInvoice().getTotalPayment());


        dado.close();
    }
}
