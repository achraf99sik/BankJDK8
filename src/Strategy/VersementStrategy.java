package Strategy;

import Model.Operation;
import Model.Retrait;
import Model.Versement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class VersementStrategy implements OperationStrategy {
    @Override
    public Operation executeOperation(Scanner input){
        Versement operation = new Versement();
        operation.setDate(LocalDate.now());

        operation.setNumero(UUID.randomUUID());

        System.out.print("Saisissez le Montant du operation : ");
        operation.setMontant(input.nextDouble());
        input.nextLine();

        System.out.println("1 : Virement externe");
        System.out.println("2 : Dépôt especes");
        System.out.println("3 : Salaire");
        System.out.print("Saisissez la Source du operation : ");
        try {
            HashMap<Integer, String> sources = new HashMap<>();
            sources.put(1,"Virement externe");
            sources.put(2,"Dépôt especes");
            sources.put(3,"Salaire");
            int choice;
            String source;
            while (true) {
                try {
                    choice = input.nextInt();
                    input.nextLine();
                    source = sources.get(choice);
                    if (source != null) {
                        operation.setSource(source);
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
