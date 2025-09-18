package Strategy;

import Model.Operation;
import Model.Retrait;
import Model.Versement;

import java.time.LocalDate;
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

        System.out.print("Saisissez la Source du operation : ");
        operation.setSource(input.nextLine());
        return operation;
    }
}
