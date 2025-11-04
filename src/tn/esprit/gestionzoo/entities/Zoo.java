package tn.esprit.gestionzoo.entities;

public class Zoo {

    private static final int MAX_CAGES = 3;
    private static final int MAX_AQUATIC = 10;
    private Animal[] animals = new Animal[MAX_CAGES];
    private Aquatic[] aquaticAnimals = new Aquatic[MAX_AQUATIC];
    private String name;
    private String city;
    private int nbrAnimals;        // Compteur pour animaux terrestres
    private int aquaticCount;      // Compteur pour animaux aquatiques

    // Constructeur
    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        this.nbrAnimals = 0;
        this.aquaticCount = 0;
    }

    // Getters
    public String getName() { return name; }
    public String getCity() { return city; }
    public int getNbrAnimals() { return nbrAnimals; }
    public int getAquaticCount() { return aquaticCount; }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Le nom du zoo ne peut pas être vide. Valeur par défaut 'Zoo Inconnu' appliquée.");
            this.name = "Zoo Inconnu";
        } else {
            this.name = name;
        }
    }

    // ============ MÉTHODES POUR ANIMAUX TERRESTRES ============


    // INSTRUCTION 32 : Modification de addAnimal (void au lieu de boolean)
    // INSTRUCTION 33 : Modification de addAnimal avec exception
    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        // Vérification de l'âge (Instruction 34)
        if (animal.getAge() < 0) {
            throw new InvalidAgeException(animal.getAge());
        }

        // Vérification de capacité (Instruction 33)
        if (nbrAnimals >= MAX_CAGES) {
            throw new ZooFullException();
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        System.out.println("Animal " + animal.getName() + " ajouté avec succès !");
    }

    // Afficher les animaux terrestres
    public void displayAnimals() {
        if (nbrAnimals == 0) {
            System.out.println("Aucun animal terrestre dans le zoo.");
        } else {
            System.out.println("Animaux terrestres dans le zoo '" + name + "' :");
            for (int i = 0; i < nbrAnimals; i++) {
                System.out.println("- " + animals[i]);
            }
        }
    }

    // Rechercher un animal terrestre (par nom)
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    // Supprimer un animal terrestre
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

    // Vérifier si le zoo est plein (animaux terrestres)
    public boolean isZooFull() {
        return nbrAnimals >= MAX_CAGES;
    }

    // Vérifier si le zoo aquatique est plein
    public boolean isAquaticZooFull() {
        return aquaticCount >= MAX_AQUATIC;
    }

    // ============ MÉTHODES POUR ANIMAUX AQUATIQUES ============

    // Ajouter un animal aquatique
    public void addAquaticAnimal(Aquatic aquatic) {
        if (isAquaticZooFull()) {
            System.out.println("Le zoo aquatique est plein ! Impossible d'ajouter : " + aquatic.getName());
            return;
        }

        // Vérifier doublon avec equals()
        if (isAquaticAnimalExists(aquatic)) {
            System.out.println("L'animal aquatique " + aquatic.getName() + " existe déjà !");
            return;
        }

        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;
        System.out.println("Animal aquatique " + aquatic.getName() + " ajouté avec succès !");
    }

    // Afficher tous les animaux aquatiques
    public void displayAquaticAnimals() {
        if (aquaticCount == 0) {
            System.out.println("Aucun animal aquatique dans le zoo.");
        } else {
            System.out.println("Animaux aquatiques dans le zoo '" + name + "' :");
            for (int i = 0; i < aquaticCount; i++) {
                System.out.println("- " + aquaticAnimals[i]);
            }
        }
    }

    // Afficher le comportement de nage
    public void displaySwim() {
        if (aquaticCount == 0) {
            System.out.println("Aucun animal aquatique à faire nager.");
        } else {
            System.out.println("Comportement de nage des animaux aquatiques :");
            for (int i = 0; i < aquaticCount; i++) {
                System.out.print(aquaticAnimals[i].getName() + " : ");
                aquaticAnimals[i].swim();
            }
        }
    }

    // Instruction 29 : Profondeur maximale des pingouins
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    // Instruction 30 : Nombre d'animaux aquatiques par type
    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;
        int otherAquaticCount = 0;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            } else {
                otherAquaticCount++;
            }
        }

        System.out.println("=== NOMBRE D'ANIMAUX AQUATIQUES PAR TYPE ===");
        System.out.println("Dauphins : " + dolphinCount);
        System.out.println("Pingouins : " + penguinCount);
        System.out.println("Autres animaux aquatiques : " + otherAquaticCount);
        System.out.println("TOTAL : " + aquaticCount + " animaux aquatiques");
    }

    // Vérifier si un animal aquatique existe déjà
    public boolean isAquaticAnimalExists(Aquatic aquatic) {
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i].equals(aquatic)) {
                return true;
            }
        }
        return false;
    }

    // ============ MÉTHODES GÉNÉRALES ============

    // Comparer deux zoos (par nombre d'animaux terrestres)
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals)
            return z1;
        else
            return z2;
    }

    // Afficher infos générales du zoo
    public void displayZoo() {
        System.out.println("Zoo [Nom=" + name + ", Ville=" + city +
                ", Animaux terrestres=" + nbrAnimals +
                ", Animaux aquatiques=" + aquaticCount + "]");
    }

    @Override
    public String toString() {
        String str = "Zoo [Nom=" + name + ", Ville=" + city +
                ", Animaux terrestres=" + nbrAnimals + "/" + MAX_CAGES +
                ", Animaux aquatiques=" + aquaticCount + "/" + MAX_AQUATIC + "]\n";

        str += "Liste des animaux terrestres :\n";
        for (int i = 0; i < nbrAnimals; i++) {
            str += animals[i].toString() + "\n";
        }

        str += "Liste des animaux aquatiques :\n";
        for (int i = 0; i < aquaticCount; i++) {
            str += aquaticAnimals[i].toString() + "\n";
        }

        return str;
    }

    // Tri des animaux terrestres par nom
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
        System.out.println("✅ Animaux terrestres triés par nom.");
    }

    // Tri des animaux terrestres par âge
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
        System.out.println("✅ Animaux terrestres triés par âge.");
    }
}