package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.*;

public class ZooManagment {
    public static void main(String[] args) {
        // Création du zoo
        Zoo myZoo = new Zoo("Parc Zoologique", "Tunis");

        System.out.println("=== TEST AVEC VALIDATION D'ÂGE ET CAPACITÉ (Instructions 33-34) ===");

        // Création d'animaux avec différents âges
        Animal lion = new Animal("Félin", "Simba", 5, true);           // ✅ Âge valide
        Animal elephant = new Animal("Éléphantidé", "Dumbo", -3, true);  // ❌ Âge négatif
        Animal giraffe = new Animal("Giraffidé", "Gigi", 7, true);     // ✅ Âge valide
        Animal tiger = new Animal("Félin", "Tigrou", -1, true);        // ❌ Âge négatif
        Animal zebra = new Animal("Équidé", "Ziggy", 4, true);         // ✅ Âge valide (doit déclencher ZooFullException)

        // Test 1 : Animal valide
        try {
            myZoo.addAnimal(lion);
            System.out.println("✅ Animal valide ajouté - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (ZooFullException e) {
            System.out.println("❌ ZooFullException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (InvalidAgeException e) {
            System.out.println("❌ InvalidAgeException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        }

        // Test 2 : Animal avec âge négatif
        try {
            myZoo.addAnimal(elephant);
            System.out.println("✅ Animal ajouté - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (ZooFullException e) {
            System.out.println("❌ ZooFullException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (InvalidAgeException e) {
            System.out.println("❌ InvalidAgeException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        }

        // Test 3 : Animal valide
        try {
            myZoo.addAnimal(giraffe);
            System.out.println("✅ Animal valide ajouté - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (ZooFullException e) {
            System.out.println("❌ ZooFullException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (InvalidAgeException e) {
            System.out.println("❌ InvalidAgeException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        }

        // Test 4 : Animal avec âge négatif
        try {
            myZoo.addAnimal(tiger);
            System.out.println("✅ Animal ajouté - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (ZooFullException e) {
            System.out.println("❌ ZooFullException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (InvalidAgeException e) {
            System.out.println("❌ InvalidAgeException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        }

        // Test 5 : Animal valide (doit déclencher ZooFullException)
        try {
            myZoo.addAnimal(zebra);
            System.out.println("✅ Animal valide ajouté - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (ZooFullException e) {
            System.out.println("❌ ZooFullException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        } catch (InvalidAgeException e) {
            System.out.println("❌ InvalidAgeException : " + e.getMessage() + " - Nombre d'animaux : " + myZoo.getNbrAnimals());
        }

        // Afficher les animaux terrestres
        System.out.println("\n--- Animaux terrestres du zoo ---");
        myZoo.displayAnimals();

        // Test recherche
        System.out.println("\nRecherche de Simba : index = " + myZoo.searchAnimal(lion));
        System.out.println("Recherche d'un animal inexistant : index = " +
                myZoo.searchAnimal(new Animal("Oiseau", "Rio", 2, true)));

        // Test suppression
        Animal crocodile = new Animal("Reptile", "Croc", 7, false);
        System.out.println("\nSuppression de Croc (qui n'existe pas) : " + myZoo.removeAnimal(crocodile));
        myZoo.displayAnimals();

        // Test zoo plein
        System.out.println("\nLe zoo est-il plein ? " + myZoo.isZooFull());

        // Comparaison entre deux zoos
        Zoo zoo2 = new Zoo("Zoo Safari", "Sousse");
        try {
            zoo2.addAnimal(new Animal("Oiseau", "Rio", 2, true));
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("❌ Exception dans zoo2 : " + e.getMessage());
        }

        Zoo biggerZoo = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("\nLe zoo avec le plus d'animaux est : " + biggerZoo.getName());

        System.out.println("\n=== TEST DES ANIMAUX AQUATIQUES ===");

        // Création d'animaux aquatiques
        Aquatic dolphin1 = new Dolphin("Flipper", 5);
        Aquatic dolphin2 = new Dolphin("Dolly", 4, 80.0f);
        Aquatic penguin1 = new Penguin("Tux", 3, 50.5f);
        Aquatic penguin2 = new Penguin("Pingu", 2, 35.2f);
        Aquatic penguin3 = new Penguin("Skipper", 4, 65.8f);

        // Ajout au zoo (pas d'exception pour les aquatiques pour l'instant)
        myZoo.addAquaticAnimal(dolphin1);
        myZoo.addAquaticAnimal(dolphin2);
        myZoo.addAquaticAnimal(penguin1);
        myZoo.addAquaticAnimal(penguin2);
        myZoo.addAquaticAnimal(penguin3);

        // Affichage des animaux aquatiques
        System.out.println("\n--- Animaux aquatiques du zoo ---");
        myZoo.displayAquaticAnimals();

        // Test de la méthode swim()
        System.out.println("\n--- COMPORTEMENT DE NAGE ---");
        myZoo.displaySwim();

        // Instruction 29 : Profondeur maximale des pingouins
        System.out.println("\n--- INSTRUCTION 29 ---");
        float maxDepth = myZoo.maxPenguinSwimmingDepth();
        System.out.println("Profondeur maximale de nage des pingouins : " + maxDepth + " mètres");

        // Instruction 30 : Nombre par type
        System.out.println("\n--- INSTRUCTION 30 ---");
        myZoo.displayNumberOfAquaticsByType();

        // TEST DE LA MÉTHODE EQUALS() POUR ANIMAUX AQUATIQUES
        System.out.println("\n=== TEST DE LA MÉTHODE EQUALS() ===");

        Aquatic testPenguin1 = new Penguin("Test", 3, 40.0f);
        Aquatic testPenguin2 = new Penguin("Test", 3, 45.0f); // Même nom, même âge, même habitat
        Aquatic testPenguin3 = new Penguin("Test", 4, 40.0f); // Âge différent

        System.out.println("Test 1 - Pingouins identiques (nom, âge, habitat) : " + testPenguin1.equals(testPenguin2));
        System.out.println("Test 2 - Pingouins avec âge différent : " + testPenguin1.equals(testPenguin3));

        // Test d'ajout d'un doublon (doit être refusé)
        System.out.println("\nTentative d'ajout d'un doublon :");
        if (myZoo.isAquaticAnimalExists(testPenguin1)) {
            System.out.println("❌ L'animal " + testPenguin1.getName() + " existe déjà dans le zoo !");
        } else {
            myZoo.addAquaticAnimal(testPenguin1);
        }

        // Le programme continue normalement malgré les exceptions
        System.out.println("\n=== LE PROGRAMME CONTINUE MALGRÉ LES EXCEPTIONS ===");

        // Affichage final complet du zoo
        System.out.println("\n=== ÉTAT FINAL DU ZOO ===");
        myZoo.displayZoo();

        System.out.println("\nNombre total d'animaux terrestres : " + myZoo.getNbrAnimals());
        System.out.println("Nombre total d'animaux aquatiques : " + myZoo.getAquaticCount());
        System.out.println("Programme terminé avec succès !");
    }
}