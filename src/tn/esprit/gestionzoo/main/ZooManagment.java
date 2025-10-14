package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class ZooManagment {
    public static void main(String[] args) {
        // Création du zoo
        Zoo myZoo = new Zoo("Parc Zoologique", "Tunis");

        // Création d’animaux
        Animal lion = new Animal("Félin", "Simba", 5, true);
        Animal elephant = new Animal("Éléphantidé", "Dumbo", 10, true);
        Animal crocodile = new Animal("Reptile", "Croc", 7, false);
        Animal lion2 = new Animal("Félin", "Simba", 6, true); // même nom → doublon

        //  Test ajout
        myZoo.addAnimal(lion);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(crocodile);
        myZoo.addAnimal(lion2);

        //  Afficher les animaux
        System.out.println("\n--- Animaux du zoo ---");
        myZoo.displayAnimals();

        //  Test recherche
        System.out.println("\nRecherche de Simba : index = " + myZoo.searchAnimal(lion));
        System.out.println("Recherche d’un animal inexistant : index = " + myZoo.searchAnimal(new Animal("Oiseau", "Rio", 2, true)));

        //  Test suppression
        System.out.println("\nSuppression de Croc : " + myZoo.removeAnimal(crocodile));
        myZoo.displayAnimals();

        //  Test zoo plein
        System.out.println("\nLe zoo est-il plein ? " + myZoo.isZooFull());

        // Comparaison entre deux zoos
        Zoo zoo2 = new Zoo("tn.esprit.gestionzoo.entities.Zoo Safari", "Sousse");
        zoo2.addAnimal(new Animal("Oiseau", "Rio", 2, true));

        Zoo biggerZoo = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("\nLe zoo avec le plus d’animaux est : " + biggerZoo.getName());
    }
}