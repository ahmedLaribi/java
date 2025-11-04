package tn.esprit.gestionzoo.entities;

public class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        super("Âge d'animal invalide : l'âge ne peut pas être négatif.");
    }

    public InvalidAgeException(String message) {
        super(message);
    }

    public InvalidAgeException(int invalidAge) {
        super("Âge d'animal invalide : " + invalidAge + " n'est pas autorisé. L'âge ne peut pas être négatif.");
    }
}