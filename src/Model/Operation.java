package Model;

import java.time.LocalDate;
import java.util.UUID;

abstract public class Operation {
    private UUID numero;
    private LocalDate date;
    private double montant;

    public void setNumero(UUID numero) {
        this.numero = numero;
    }

    public UUID getNumero() {
        return numero;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontant() {
        return montant;
    }
}
