package Controller;

import Service.OperationService;
import Model.Operation;
import java.util.List;
import java.util.Scanner;

public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService){
        this.operationService = operationService;
    }
    public void executeOperation() {
        operationService.executerOperation();
    }

    public void listerOperations() {
        Scanner input = new Scanner(System.in);
        System.out.print("Saisissez le code du compte pour lister les operations : ");
        String accountNumber = input.next();

        List<Operation> operations = operationService.listOperations(accountNumber);

        if (operations != null && !operations.isEmpty()) {
            System.out.println("\nOperations pour le compte " + accountNumber + ":");
            for (Operation op : operations) {
                System.out.println("Numero: " + op.getNumero() + ", Date: " + op.getDate() + ", Montant: " + op.getMontant());
            }
        } else {
            System.out.println("Aucune operation trouvee pour le compte " + accountNumber + " ou le compte n'existe pas.");
        }
    }
}
