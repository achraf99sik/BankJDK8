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
    abstract public void afficherDetails();

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
