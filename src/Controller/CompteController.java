package Controller;

import Model.Compte;
import Model.Operation;
import Service.CompteCreatorService;
import Service.OperationService;
import java.util.Scanner;

public class CompteController {
    private final CompteCreatorService compteCreatorService;

    public CompteController(CompteCreatorService compteCreatorService){
        this.compteCreatorService = compteCreatorService;
    }
    public void creerCompte() {
        compteCreatorService.executerCreation();
    }
    public void consulterSolde() {
        Scanner input = new Scanner(System.in);
        System.out.print("Saisissez le code du compte pour consulter le solde : ");
        String accountNumber = input.next();

        Compte compte = compteCreatorService.getCompteByCode(accountNumber);

        if (compte != null) {
            System.out.println("\nSolde du compte " + accountNumber + ": " + compte.getSolde());
        } else {
            System.out.println("Compte non trouve.");
        }
    }
    public void afficherDetailsCompte() {
        Scanner input = new Scanner(System.in);
        System.out.print("Saisissez le code du compte pour afficher les details : ");
        String accountNumber = input.next();

        Compte compte = compteCreatorService.getCompteByCode(accountNumber);

        if (compte != null) {
            compte.afficherDetails();
        } else {
            System.out.println("Compte non trouve.");
        }
    }
}
