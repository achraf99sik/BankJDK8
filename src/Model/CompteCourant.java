package Model;

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
        super.afficherDetails();
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
