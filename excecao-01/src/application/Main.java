package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner dado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número da reserva: ");
            int number = dado.nextInt();
            System.out.println("Data de check-in: ");
            Date checkIn = sdf.parse(dado.next());
            System.out.println("Data de check-out: ");
            Date checkOut = sdf.parse(dado.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.println("Entre com uma data para atualizar a reserva: ");
            System.out.println("Data de check-in: ");
            checkIn = sdf.parse(dado.next());
            System.out.println("Data de check-out: ");
            checkOut = sdf.parse(dado.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reserva: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Data inválida");
        }
        catch (DomainException e){
            System.out.println("Erro: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado");
        }

        dado.close();
    }
}
