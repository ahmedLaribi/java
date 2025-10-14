package tn.esprit.gestionzoo.entities;

public class Zoo {

    private static final int MAX_CAGES = 25;
    private Animal[] animals = new Animal[MAX_CAGES];
    private String name;
    private String city;
    private int nbrAnimals;


    // Constructeur
    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        this.nbrAnimals = 0;
    }
    public String getName() { return name; }
    public String getCity() { return city; }
    public int getNbrAnimals() { return nbrAnimals; }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println(" Le nom du zoo ne peut pas être vide. Valeur par défaut 'tn.esprit.gestionzoo.entities.Zoo Inconnu' appliquée.");
            this.name = "tn.esprit.gestionzoo.entities.Zoo Inconnu";
        } else {
            this.name = name;
        }
    }

    // Ajouter un animal
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println(" Le zoo est plein ! Impossible d'ajouter : " + animal.getName());
            return false;
        }

        // Vérifier doublon
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                System.out.println(" L’animal " + animal.getName() + " existe déjà !");
                return false;
            }
        }

        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    // Afficher les animaux
    public void displayAnimals() {
        if (nbrAnimals == 0) {
            System.out.println("Aucun animal dans le zoo.");
        } else {
            for (int i = 0; i < nbrAnimals; i++) {
                System.out.println(animals[i]);
            }
        }
    }


    // Rechercher un animal (par nom)
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }


    // Supprimer un animal
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) return false;

        // Décaler les éléments à gauche
        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }

        // Supprimer la dernière référence
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    // Vérifier si le zoo est plein
    public boolean isZooFull() {
        return nbrAnimals >= MAX_CAGES;
    }

    // Comparer deux zoos
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals)
            return z1;
        else
            return z2;
    }

    // Afficher infos générales
    public void displayZoo() {
        System.out.println("tn.esprit.gestionzoo.entities.Zoo [Nom=" + name + ", Ville=" + city + ", Nombre d’animaux=" + nbrAnimals + "]");
    }

    @Override
    public String toString() {
        String str = "tn.esprit.gestionzoo.entities.Zoo [Nom=" + name + ", Ville=" + city + ", Animaux=" + nbrAnimals + "/" + MAX_CAGES + "]\n";
        str += "Liste des animaux :\n";

        for (int i = 0; i < nbrAnimals; i++) {
            str += animals[i].toString() + "\n";
        }

        return str;
    }

    public void sortByName() {
        for (int i = 0; i < nbrAnimals - 1; i++) {
            for (int j = i + 1; j < nbrAnimals; j++) {
                if (animals[i].getName().compareToIgnoreCase(animals[j].getName()) > 0) {
                    Animal temp = animals[i];
                    animals[i] = animals[j];
                    animals[j] = temp;
                }
            }
        }
        System.out.println("✅ Animaux triés par nom.");
    }

    // Tri par âge
    public void sortByAge() {
        for (int i = 0; i < nbrAnimals - 1; i++) {
            for (int j = i + 1; j < nbrAnimals; j++) {
                if (animals[i].getAge() > animals[j].getAge()) {
                    Animal temp = animals[i];
                    animals[i] = animals[j];
                    animals[j] = temp;
                }
            }
        }
        System.out.println("✅ Animaux triés par âge.");
    }
}


