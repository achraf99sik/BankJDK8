package Service;

import Model.Compte;
import Model.CompteEpargne;
import Strategy.CreationCompteCourantStrategy;
import Strategy.CreationCompteEpargneStrategy;
import Strategy.CreationCompteStrategy;

import java.util.HashMap;
import java.util.Scanner;

public class CompteCreatorService {
    private CreationCompteStrategy strategy;
    private HashMap<String, Compte> Comptes;

    public CompteCreatorService() {
        this.Comptes = new HashMap<>();
    }

    public void setStrategy(CreationCompteStrategy strategy) {
        this.strategy = strategy;
    }

    public void executerCreation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Choisissez le type de compte (1 : Courant, 2 : Épargne) : ");
        int type = input.nextInt();

        if (type == 1) {
            this.setStrategy(new CreationCompteCourantStrategy());
        } else if (type == 2) {
            this.setStrategy(new CreationCompteEpargneStrategy());
        } else {
            System.out.println("Type de compte non valide.");
        }

        if (strategy == null) {
            throw new IllegalStateException("Aucune strategie de creation n'a ete definie.");
        }

        Compte nouveauCompte = this.strategy.creerCompte(input);
        this.Comptes.put(nouveauCompte.getCode(), nouveauCompte);
        System.out.println("\nOperation terminee, Le compte avec le code " + nouveauCompte.getCode() + " a bien ete enregistre.");
    }

    public HashMap<String, Compte> getComptes() {
        return Comptes;
    }

    public Compte getCompteByCode(String code) {
        return Comptes.get(code);
    }
}