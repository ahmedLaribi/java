package tn.esprit.gestionzoo.entities;

public class Animal {
    protected String family;
    protected String name;
    protected int age;
    protected boolean isMammal;

public Animal(){

}

// Constructeur paramétré
public Animal(String family, String name, int age, boolean isMammal) {
    this.family = family;
    this.name = name;
    if (age >0)
        this.age = age;
    else
        this.age = 0;
    this.isMammal = isMammal;
}

public String getFamily() { return family; }
public String getName() {
    return this.name;
}
public int getAge() {
    return age; }
public boolean isMammal() { return isMammal; }



public void setAge(int age) {
    if (age < 0) {
        System.out.println(" L’âge ne peut pas être négatif");
        this.age = 0;
    } else {
        this.age = age;
    }
}
// Méthode toString()
@Override
public String toString() {
    return "tn.esprit.gestionzoo.entities.Animal [Famille=" + family + ", Nom=" + name + ", Âge=" + age + ", Mammifère=" + isMammal + "]";
}
}