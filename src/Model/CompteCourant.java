package Model;

import java.util.List;

public class CompteCourant extends Compte {
    private double decouvert;

    public void retirer(double montant){
        if (montant > 0 && this.getSolde()+this.getDecouvert() >= montant) {
            this.setSolde(this.getSolde() - montant);
            System.out.println("Retrait de " + montant + " effectue.");
        } else {
            System.out.println("Solde insuffisant ou montant invalide.");
        }
    };
    public double calculerInteret(){
        return 0;
    };
    public void afficherDetails(){
        System.out.println("----------------------------------------");
        System.out.println("Code: " + this.getCode());
        System.out.println("Solde: " + this.getSolde());
        System.out.println("Interets: " + this.calculerInteret());
        System.out.println("List de Operations: ");
        List<Operation> ops = this.getOperations(this.getCode());
        if (ops == null || ops.isEmpty()) {
            System.out.println("    Aucune operation.");
        } else {
            for (Operation op : ops) {
                System.out.println("    Numero: " + op.getNumero() + ", Montant: " + op.getMontant() + ", Date: " + op.getDate());
            }
        }
        System.out.println("Decouvert: " + this.getDecouvert());
        System.out.println("----------------------------------------");
    };

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
