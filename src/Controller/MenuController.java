package Controller;

import Service.CompteCreatorService;
import Service.OperationService;

public class MenuController {
    private final CompteController compteController;
    private final OperationController operationController;

    public MenuController(CompteCreatorService compteCreatorService, OperationService operationService) {
        this.compteController = new CompteController(compteCreatorService);
        this.operationController = new OperationController(operationService);
    }

    public void creerCompte(){
        try {
            compteController.creerCompte();
        } catch (Exception e) {
            System.out.print("\nError while creating Account: " + e.getMessage());
        }
    }
    public void executerOperation(){
        try {
            operationController.executeOperation();
        } catch (Exception e) {
            System.out.print("\nError while creating executing Operation: " + e.getMessage());
        }
    }
    public void listerOperations(){
        try {
            operationController.listerOperations();
        } catch (Exception e) {
            System.out.print("\nError while listing Operations: " + e.getMessage());
        }
    }
    public void consulterSolde(){
        try {
            compteController.consulterSolde();
        } catch (Exception e) {
            System.out.print("\nError while consulting balance: " + e.getMessage());
        }
    }
    public void afficherDetailsCompte(){
        try {
            compteController.afficherDetailsCompte();
        } catch (Exception e) {
            System.out.print("\nError while displaying account details: " + e.getMessage());
        }
    }
}
