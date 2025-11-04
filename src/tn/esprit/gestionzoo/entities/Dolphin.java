package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic {
    private float swimmingDepth;

    // Constructeur COMPLET
    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    // Constructeur SIMPLIFIÉ (doit exister pour l'utiliser avec 2 paramètres)
    public Dolphin(String name, int age) {
        super("Cétacé", name, age, true, "Océan");
        this.swimmingDepth = 100.0f; // valeur par défaut
    }

    // Autre constructeur simplifié avec profondeur
    public Dolphin(String name, int age, float swimmingDepth) {
        super("Cétacé", name, age, true, "Océan");
        this.swimmingDepth = swimmingDepth;
    }

    public float getSwimmingDepth() {
        return swimmingDepth;
    }

    public void setSwimmingDepth(float swimmingDepth) {
        this.swimmingDepth = swimmingDepth;
    }

    @Override
    public void swim() {
        System.out.println(getName() + " nage en faisant des sauts acrobatiques jusqu'à " + swimmingDepth + " mètres !");
    }

    @Override
    public String toString() {
        return "Dauphin - " + super.toString() + ", Profondeur=" + swimmingDepth + "m";
    }
}