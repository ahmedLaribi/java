public class ZooManagment {
    public static void main (String[] args) {
        // Création d’animaux avec constructeur
        Animal lion = new Animal("Félin", "Simba", 5, true);
        Animal elephant = new Animal("Éléphantidé", "Dumbo", 10, true);

        // Affichage direct (grâce à toString)
        System.out.println(lion);
        System.out.println(elephant);

        // Création d’un zoo avec constructeur
        Zoo myZoo = new Zoo("Parc Zoologique", "Tunis", 20);

        // Affichage avec displayZoo()
        myZoo.displayZoo();

        // Affichage direct avec toString()
        System.out.println(myZoo);
    }
}
