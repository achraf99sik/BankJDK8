package Model;


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
        super.afficherDetails();
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
