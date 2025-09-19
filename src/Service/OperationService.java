package Service;


import Model.Compte;
import Model.Operation;
import Model.Retrait;
import Model.Versement;
import Strategy.OperationStrategy;
import Strategy.RetraitStrategy;
import Strategy.VersementStrategy;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class OperationService {
    private OperationStrategy strategy;
    private CompteCreatorService compteCreatorService;

    public OperationService(CompteCreatorService compteCreatorService) {
        this.compteCreatorService = compteCreatorService;
    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }
    public void executerOperation(){
        Scanner input = new Scanner(System.in);
        System.out.print("Choisissez le type de Operation (1 : Versement, 2 : Retrait, 3 : Virement) : ");
        int type = input.nextInt();
        Compte compte = null;
        if (type == 1 || type == 2) {
            System.out.print("Saisissez le code du compte : ");
            String code = input.next();
            compte = this.compteCreatorService.getCompteByCode(code);
            if (compte == null) {
                System.out.println("Compte non trouve.");
                return;
            }
        }
        switch (type){
            case 1:
                this.setStrategy(new VersementStrategy());
                {
                    Operation operation = this.strategy.executeOperation(input);
                    compte.setOperations(compte.getCode(),operation);
                    compte.setSolde(compte.getSolde()+operation.getMontant());
                    System.out.println("\nOperation terminee, Le Operation avec le numero '" + operation.getNumero() + "' a bien ete enregistre.");
                }
                break;
            case 2:
                this.setStrategy(new RetraitStrategy());
                {
                    Operation operation = this.strategy.executeOperation(input);
                    compte.setOperations(compte.getCode(),operation);
                    compte.setSolde(compte.getSolde()-operation.getMontant());
                    System.out.println("\nOperation terminee, Le Operation avec le numero '" + operation.getNumero() + "' a bien ete enregistre.");
                }
                break;
            case 3:
                System.out.print("Saisissez le code du compte source : ");
                String codeSource = input.next();
                Compte compteSource = this.compteCreatorService.getCompteByCode(codeSource);
                if (compteSource == null) {
                    System.out.println("Compte source non trouve.");
                    return;
                }
                System.out.print("Saisissez le code du compte destination : ");
                String codeDestination = input.next();
                while(codeSource.equals(codeDestination)){
                    System.out.println("Vous ne pouvez pas faire un virement vers vous-même!!");
                    System.out.print("Saisissez le code du compte destination : ");
                    codeDestination = input.next();
                }
                Compte compteDestination = this.compteCreatorService.getCompteByCode(codeDestination);
                if (compteDestination == null) {
                    System.out.println("Compte destination non trouve.");
                    return;
                }

                this.setStrategy(new RetraitStrategy());
                Operation retrait = this.strategy.executeOperation(input);
                compteSource.setOperations(compteSource.getCode(), retrait);
                compteSource.setSolde(compteSource.getSolde() - retrait.getMontant());

                Versement versement = new Versement();
                versement.setDate(retrait.getDate());
                versement.setNumero(UUID.randomUUID());
                versement.setMontant(retrait.getMontant());
                versement.setSource("Virement de " + codeSource);

                compteDestination.setOperations(compteDestination.getCode(), versement);
                compteDestination.setSolde(compteDestination.getSolde() + versement.getMontant());

                System.out.println("\nVirement terminé :");
                System.out.println("Retrait n° '" + retrait.getNumero() + "' du compte " + codeSource);
                System.out.println("Versement n° '" + versement.getNumero() + "' sur le compte " + codeDestination);
                break;
            default:
                System.out.println("Type de Operation non valide.");
                break;
        }
    }

    public List<Operation> listOperations(String accountNumber) {
        Compte compte = compteCreatorService.getCompteByCode(accountNumber);
        if (compte != null) {
            return compte.getOperations(accountNumber);
        } else {
            return null;
        }
    }
}
