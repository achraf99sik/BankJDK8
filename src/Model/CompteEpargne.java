package Model;


import java.util.List;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    public void retirer(double montant){
        if (montant > 0 && this.getSolde() >= montant) {
            this.setSolde(this.getSolde() - montant);
            System.out.println("Retrait de " + montant + " effectué.");
        } else {
            System.out.println("Solde insuffisant ou montant invalide.");
        }
    };
    public double calculerInteret(){
        return this.getSolde() * this.tauxInteret;
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
        System.out.println("Taux interet: "+this.getTauxInteret());
        System.out.println("----------------------------------------");
    };

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
