package Strategy;

import Model.Operation;
import Model.Retrait;

import java.time.LocalDate;
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

        System.out.print("Saisissez la destination du operation : ");
        operation.setDestination(input.nextLine());
        return operation;
    }

}
