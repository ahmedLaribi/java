package tn.esprit.gestionzoo.entities;

public class Animal {
    protected String family;
    protected String name;
    protected int age;
    protected boolean isMammal;
    private String habitat;
    private int weight;

    // Constructeur par défaut
    public Animal() {
    }

    // Constructeur paramétré avec 4 arguments
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        if (age > 0)
            this.age = age;
        else
            this.age = 0;
        this.isMammal = isMammal;
    }

    // Constructeur avec tous les attributs (6 paramètres)
    public Animal(String family, String name, int age, boolean isMammal, String habitat, int weight) {
        this.family = family;
        this.name = name;
        if (age > 0)
            this.age = age;
        else
            this.age = 0;
        this.isMammal = isMammal;
        this.habitat = habitat;
        this.weight = weight;
    }

    // Getters
    public String getFamily() {
        return family;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMammal() {
        return isMammal;
    }

    public String getHabitat() {
        return habitat;
    }

    public int getWeight() {
        return weight;
    }

    // Setters
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("L'âge ne peut pas être négatif");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setWeight(int weight) {
        if (weight < 0) {
            System.out.println("Le poids ne peut pas être négatif");
            this.weight = 0;
        } else {
            this.weight = weight;
        }
    }

    // Méthode toString()
    @Override
    public String toString() {
        String baseInfo = "Animal [Famille=" + family + ", Nom=" + name + ", Âge=" + age + ", Mammifère=" + isMammal;
        if (habitat != null && weight > 0) {
            return baseInfo + ", Habitat=" + habitat + ", Poids=" + weight + "kg]";
        } else {
            return baseInfo + "]";
        }
    }

    // Méthode equals pour comparer deux animaux
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return name.equals(animal.name) && family.equals(animal.family);
    }
}