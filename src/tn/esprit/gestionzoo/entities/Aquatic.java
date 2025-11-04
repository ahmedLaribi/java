package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal {
    private String habitat;

    // Constructeur par défaut
    public Aquatic() {
        super();
    }

    // Constructeur paramétré
    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    // Getter et Setter pour habitat
    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Méthode swim() abstraite - OBLIGATOIRE à redéfinir dans les classes filles
    public abstract void swim();

    // Redéfinition de la méthode toString()
    @Override
    public String toString() {
        return super.toString() + ", Habitat=" + habitat;
    }

    // Redéfinition de la méthode equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Aquatic aquatic = (Aquatic) obj;
        return this.getName().equals(aquatic.getName()) &&
                this.getAge() == aquatic.getAge() &&
                this.habitat.equals(aquatic.habitat);
    }

    // Redéfinition de hashCode()
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + habitat.hashCode();
        return result;
    }
}