package tn.esprit.gestionzoo.entities;

public class Terrestres extends Animal {
    private int nbrLegs;
    public Terrestres(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }
}
