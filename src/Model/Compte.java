package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

abstract public class Compte {
    private String code;
    private double solde;
    private final HashMap<String, List<Operation>> operations = new HashMap<>();
    abstract public void retirer(double montant);
    abstract public double calculerInteret();
    public void afficherDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Code: " + this.getCode());
        System.out.println("Solde: " + this.getSolde());
        System.out.println("List de Operations: ");
        List<Operation> ops = this.getOperations(this.getCode());
        if (ops == null || ops.isEmpty()) {
            System.out.println("    Aucune operation.");
        } else {
            for (Operation op : ops) {
                System.out.println("    Numero: " + op.getNumero() + ", Montant: " + op.getMontant() + ", Date: " + op.getDate());
            }
        }
    }

    public void setOperations(String code,Operation op) {
        this.operations.computeIfAbsent(code, k -> new ArrayList<>()).add(op);
    }

    public List<Operation> getOperations(String code) {
        return this.operations.get(code);
    }

    public void setCode(int code) {
        this.code = "CPT-"+code;
    }

    public String getCode() {
        return code;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }
}
