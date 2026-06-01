package main;

import auth.Authentification;
import java.util.Scanner;
import model.*;
import ui.ConsoleStyle;
import ui.MenuAdmin;
import ui.MenuResponsableStructure;
import ui.MenuUtilisateur;

public class Main {
    public static void main(String[] args) {

        GestionStructure gestion = new GestionStructure();
        gestion.ajouterStructure(new EcolePrimaire(1, "Ecole Publique Groupe 1", "Ngaoundéré", "699112233", "epg1@gmail.com", 2005));
        gestion.ajouterStructure(new Lycee(2, "Lycée Classique", "Ngaoundéré", "677089900", "lycee@gmail.com", 1998));
        gestion.ajouterStructure(new College(3, "College Moderne", "Ngaoundéré", "655443322", "college@gmail.com", 2010));
        gestion.ajouterStructure(new CentreFormation(4, "Centre Informatique", "Ngaoundéré", "688776655", "centre@gmail.com", 2020));

        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            ConsoleStyle.titre("GESTION DES STRUCTURES");
            ConsoleStyle.option("[1] Administrateur");
            ConsoleStyle.option("[2] Responsable Structure");
            ConsoleStyle.option("[3] Utilisateur");
            ConsoleStyle.option("[0] Quitter");
            ConsoleStyle.ligneSimple();
            System.out.print(ConsoleStyle.CYAN + "  Votre choix : " + ConsoleStyle.RESET);

            // CORRECTION
            try {
                choix = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choix = -1;
            }

            switch (choix) {
                case 1 -> {
                    ConsoleStyle.ligneSimple();
                    System.out.print(ConsoleStyle.JAUNE + "  Avez deja un compte (oui/non) ?     : " + ConsoleStyle.RESET);
                    String reponse=sc.nextLine();
                    if(reponse.equals("oui")){
                        System.out.print(ConsoleStyle.JAUNE + "  [LOGIN/Connexion] Nom    : " + ConsoleStyle.RESET);
                        String login = sc.nextLine();
                        System.out.print(ConsoleStyle.JAUNE + "  Mot de passe : " + ConsoleStyle.RESET);
                        String mdp = sc.nextLine();
                        if (Authentification.connecterAdmin(login, mdp)) {
                            ConsoleStyle.succes("Connexion réussie !");
                            new MenuAdmin(gestion).afficherMenu();
                        } else {
                            ConsoleStyle.erreur("Login ou mot de passe incorrect.");
                        }
                    }else if(reponse.equals("non")){
                        System.out.print(ConsoleStyle.JAUNE + "  [SIGNUP/inscription] Nom    : " + ConsoleStyle.RESET);
                        String login = sc.nextLine();
                        System.out.print(ConsoleStyle.JAUNE + "  Mot de passe : " + ConsoleStyle.RESET);
                        String mdp = sc.nextLine();
                        if(Authentification.loginExisteAdmin(login)){
                            System.out.println(login+" possede deja un compte");
                        }else{
                            Authentification.ajouterAdmin(login,mdp);
                            ConsoleStyle.succes("Connexion réussie !");
                            new MenuAdmin(gestion).afficherMenu();
                        }
                    }
                }
                case 2 ->{
                    ConsoleStyle.ligneSimple();
                    System.out.print(ConsoleStyle.JAUNE + "  Avez deja un compte (oui/non) ?     : " + ConsoleStyle.RESET);
                    String reponse=sc.nextLine();
                    if(reponse.equals("oui")){
                        System.out.print(ConsoleStyle.JAUNE + "  [LOGIN/Connexion] Nom    : " + ConsoleStyle.RESET);
                        String login = sc.nextLine();
                        System.out.print(ConsoleStyle.JAUNE + "  Mot de passe : " + ConsoleStyle.RESET);
                        String mdp = sc.nextLine();
                        if (Authentification.connecterResStruct(login, mdp)) {
                            ConsoleStyle.succes("Connexion réussie !");
                            new MenuResponsableStructure(gestion).afficherMenu();
                        } else {
                            ConsoleStyle.erreur("Login ou mot de passe incorrect.");
                        }
                    }else if(reponse.equals("non")){
                        System.out.print(ConsoleStyle.JAUNE + "  [SIGNUP/inscription] Nom    : " + ConsoleStyle.RESET);
                        String login = sc.nextLine();
                        System.out.print(ConsoleStyle.JAUNE + "  Mot de passe : " + ConsoleStyle.RESET);
                        String mdp = sc.nextLine();
                        if(Authentification.loginExisteAdmin(login)){
                            System.out.println(login+" possede deja un compte");
                        }else{
                            Authentification.ajouterResStruct(login,mdp);
                            ConsoleStyle.succes("Connexion réussie !");
                            new MenuResponsableStructure(gestion).afficherMenu();
                        }
                    }
                }
                case 3 -> new MenuUtilisateur(gestion).afficherMenu();
                case 0 -> {
                    ConsoleStyle.titre("AU REVOIR !");
                }
                default -> ConsoleStyle.erreur("Choix invalide.");
            }
        } while (choix != 0);
        sc.close(); 
    }
}