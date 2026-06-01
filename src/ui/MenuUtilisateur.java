package ui;

import java.util.Scanner;
import model.*;

public class MenuUtilisateur {

    private GestionStructure gestion;
    private Scanner sc;

    public MenuUtilisateur(GestionStructure gestion) {
        this.gestion = gestion;
        this.sc = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix;
        do {
            ConsoleStyle.titre("MENU UTILISATEUR");
            ConsoleStyle.option("[1]  Rechercher une structure");
            ConsoleStyle.option("[2]  Afficher toutes les structures");
            ConsoleStyle.option("[0]  Quitter");
            ConsoleStyle.ligneSimple();
            System.out.print(ConsoleStyle.CYAN + "  Votre choix : " + ConsoleStyle.RESET);
            
            // CORRECTION : remplacement de sc.nextInt() par parsing sécurisé
            try {
                choix = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choix = -1;
            }

            switch (choix) {
                case 1 -> rechercherStructure();
                case 2 -> gestion.afficherToutesStructures();
                case 0 -> ConsoleStyle.succes("Au revoir !");
                default -> ConsoleStyle.erreur("Choix invalide.");
            }

        } while (choix != 0);
    }

    private void rechercherStructure() {
        ConsoleStyle.titre("RECHERCHE");
        System.out.print(ConsoleStyle.JAUNE + "  Nom : " + ConsoleStyle.RESET);
        String nom = sc.nextLine();
        StructureFormation sf = gestion.rechercherParNom(nom);
        if (sf != null) sf.afficherInfos();
        else ConsoleStyle.erreur("Aucune structure trouvée.");
    }
}