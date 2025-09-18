package Strategy;

import Model.Compte;
import Model.CompteCourant;

import java.util.Scanner;

public class CreationCompteCourantStrategy implements CreationCompteStrategy {

    @Override
    public Compte creerCompte(Scanner input) {
        CompteCourant compte = new CompteCourant();

        System.out.print("Saisissez le solde du compte : ");
        compte.setSolde(input.nextDouble());

        System.out.print("Saisissez le code du compte : ");
        compte.setCode(input.nextInt());

        System.out.print("Saisissez le decouvert autorise : ");
        compte.setDecouvert(input.nextDouble());

        System.out.println("\nCompte courant cree avec succes !");
        System.out.println("Code : " + compte.getCode());
        System.out.println("Solde : " + compte.getSolde());
        System.out.println("Decouvert : " + compte.getDecouvert());

        return compte;
    }
}