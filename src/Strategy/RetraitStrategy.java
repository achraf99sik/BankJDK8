package Strategy;

import Model.Operation;
import Model.Retrait;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class RetraitStrategy implements OperationStrategy {
    @Override
    public Operation executeOperation(Scanner input){
        Retrait operation = new Retrait();
        operation.setDate(LocalDate.now());

        operation.setNumero(UUID.randomUUID());

        System.out.print("Saisissez le Montant du operation : ");
        operation.setMontant(input.nextDouble());
        input.nextLine();

        System.out.println("1 : Distributeur ATM");
        System.out.println("2 : Chèque");
        System.out.println("3 : Virement sortant");
        System.out.print("Saisissez la destination du operation : ");
        try {
            HashMap<Integer, String> destinations = new HashMap<>();
            destinations.put(1,"Distributeur ATM");
            destinations.put(2,"Chèque");
            destinations.put(3,"Virement sortant");
            int choice;
            String destination;
            while (true) {
                try {
                    choice = input.nextInt();
                    input.nextLine();
                    destination = destinations.get(choice);
                    if (destination != null) {
                        operation.setDestination(destination);
                        break;
                    } else {
                        System.out.print("Choix invalide, essayez encore: ");
                    }
                } catch (Exception e) {
                    System.out.print("Entrée invalide, essayez encore: ");
                    input.nextLine();
                }
            }
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
        return operation;
    }

}
