package Strategy;

import Model.Compte;

import java.util.Scanner;

public interface CreationCompteStrategy {
    Compte creerCompte(Scanner input);
}
