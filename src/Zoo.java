class Zoo {

    private static final int MAX_CAGES = 25;

    Animal[] animals = new Animal[25]; // tableau de max 25 animaux
    String name;
    String city;
    int nbrAnimals = 0;

    // Constructeur paramétré
    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println(" Zoo plein, impossible d’ajouter : " + animal.name);
            return false;
        }
        // Vérifier si l’animal existe déjà
        if (searchAnimal(animal) != -1) {
            System.out.println("⚠ L’animal " + animal.name + " existe déjà !");
            return false;
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }


    // Méthode displayZoo()
    public void displayAnimals() {
        if (nbrAnimals == 0) {
            System.out.println("Aucun animal dans le zoo.");
        } else {
            for (int i = 0; i < nbrAnimals; i++) {
                System.out.println(animals[i]);
            }
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }

    //  Instruction 13 : Supprimer un animal
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) return false;

        // Décaler les animaux après l’index
        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null; // libérer la dernière case
        nbrAnimals--;
        return true;
    }

    //  Instruction 15 : Vérifier si le zoo est plein
    public boolean isZooFull() {
        return nbrAnimals >= MAX_CAGES;
    }

    //  Instruction 16 : Comparer deux zoos
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals) {
            return z1;
        } else {
            return z2;
        }
    }

    // Afficher infos zoo
    public void displayZoo() {
        System.out.println("Zoo [Nom=" + name + ", Ville=" + city + ", Nombre d’animaux=" + nbrAnimals + "]");
    }

    @Override
    public String toString() {
        return "Zoo [Nom=" + name + ", Ville=" + city + ", Animaux=" + nbrAnimals + "/" + MAX_CAGES + "]";
    }
}