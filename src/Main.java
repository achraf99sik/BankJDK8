import Controller.MenuController;
import Service.CompteCreatorService;
import Service.OperationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CompteCreatorService compteCreatorService = new CompteCreatorService();
        OperationService operationService = new OperationService(compteCreatorService);
        MenuController menu = new MenuController(compteCreatorService, operationService);
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\nMenu \n1 : Creer un compte\n2 : Fair un operation\n3 : Consulter solde\n4 : Afficher details compte\n5 : Lister les operations\n6 : Quitter");
            System.out.print("\nChoisissez un option: ");
            int option = input.nextInt();
            switch (option){
                case 1:
                    menu.creerCompte();
                    break;
                case 2:
                    menu.executerOperation();
                    break;
                case 3:
                    menu.consulterSolde();
                    break;
                case 4:
                    menu.afficherDetailsCompte();
                    break;
                case 5:
                    menu.listerOperations();
                    break;
                case 6:
                    System.out.println("Au revoir");
                    input.close();
                    return;
                default:
                    System.out.println("Option non valide Veuillez reessayer");
                    break;
            }
        }
    }
}