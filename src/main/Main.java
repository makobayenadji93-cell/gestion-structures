package main;

import auth.Authentification;
import java.util.Scanner;
import model.*;
import ui.ConsoleStyle;
import ui.MenuAdmin;
import ui.MenuUtilisateur;

public class Main {

    public static void main(String[] args) {

        // GestionStructure charge automatiquement le fichier structures.txt s'il existe.
        // Les structures de démonstration ne sont ajoutées que si aucune donnée n'est sauvegardée.
        GestionStructure gestion = new GestionStructure();

        if (gestion.getStructures().isEmpty()) {
            gestion.ajouterStructure(new EcolePrimaire(1, "Ecole Publique Groupe 1", "Ngaoundéré", "699112233", "epg1@gmail.com", 2005));
            gestion.ajouterStructure(new Lycee(2, "Lycée Classique", "Ngaoundéré", "677089900", "lycee@gmail.com", 1998));
            gestion.ajouterStructure(new College(3, "College Moderne", "Ngaoundéré", "655443322", "college@gmail.com", 2010));
            gestion.ajouterStructure(new CentreFormation(4, "Centre Informatique", "Ngaoundéré", "688776655", "centre@gmail.com", 2020));
            System.out.println("[INFO] Données de démonstration chargées.");
        }

        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            ConsoleStyle.titre("GESTION DES STRUCTURES");
            ConsoleStyle.option("[1] Administrateur");
            ConsoleStyle.option("[2] Utilisateur");
            ConsoleStyle.option("[0] Quitter");
            ConsoleStyle.ligneSimple();
            System.out.print(ConsoleStyle.CYAN + "  Votre choix : " + ConsoleStyle.RESET);

            try {
                choix = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choix = -1;
            }

            switch (choix) {
                case 1 -> {
                    ConsoleStyle.ligneSimple();
                    System.out.print(ConsoleStyle.JAUNE + "  Login      : " + ConsoleStyle.RESET);
                    String login = sc.nextLine();
                    System.out.print(ConsoleStyle.JAUNE + "  Mot de passe : " + ConsoleStyle.RESET);
                    String mdp = sc.nextLine();
                    if (Authentification.connecter(login, mdp)) {
                        ConsoleStyle.succes("Connexion réussie !");
                        new MenuAdmin(gestion).afficherMenu();
                    } else {
                        ConsoleStyle.erreur("Login ou mot de passe incorrect.");
                    }
                }
                case 2 -> new MenuUtilisateur(gestion).afficherMenu();
                case 0 -> {
                    ConsoleStyle.titre("AU REVOIR !");
                    sc.close();
                }
                default -> ConsoleStyle.erreur("Choix invalide.");
            }
        } while (choix != 0);
    }
}
