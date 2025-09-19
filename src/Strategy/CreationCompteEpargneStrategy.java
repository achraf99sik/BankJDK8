package Strategy;

import Model.Compte;
import Model.CompteEpargne;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CreationCompteEpargneStrategy implements CreationCompteStrategy {

    @Override
    public Compte creerCompte(Scanner input) {
        CompteEpargne compte = new CompteEpargne();

        System.out.print("Saisissez le solde du compte : ");
        compte.setSolde(input.nextDouble());

        int code = ThreadLocalRandom.current().nextInt(10000, 100000);
        compte.setCode(code);

        System.out.print("Saisissez le taux d'interet : ");
        compte.setTauxInteret(input.nextDouble());

        System.out.println("\nCompte epargne cree avec succes !");
        System.out.println("Code : " + compte.getCode());
        System.out.println("Solde : " + compte.getSolde());
        System.out.println("Taux d'interet : " + compte.getTauxInteret());

        return compte;
    }
}