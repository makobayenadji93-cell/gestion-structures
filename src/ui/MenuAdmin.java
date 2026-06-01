package ui;


import java.util.Scanner;
import model.*;

public class MenuAdmin {

    private GestionStructure gestion;
    private Scanner sc;

    public MenuAdmin(GestionStructure gestion) {
        this.gestion = gestion;
        this.sc = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix;
        do {
            ConsoleStyle.titre("MENU ADMINISTRATEUR");
            ConsoleStyle.option("[1] Ajouter une structure");
            ConsoleStyle.option("[2] Supprimer une structure");
            ConsoleStyle.option("[3] Modifier le nom");
            ConsoleStyle.option("[4] Afficher toutes les structures");
            ConsoleStyle.option("[5] Consulter par ID");
            ConsoleStyle.option("[0] Déconnexion");
            ConsoleStyle.ligneSimple();
            System.out.print(ConsoleStyle.CYAN + "  Votre choix : " + ConsoleStyle.RESET);

            // CORRECTION
            try {
                choix = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choix = -1;
            }

            switch (choix) {
                case 1 -> ajouterStructure();
                case 2 -> supprimerStructure();
                case 3 -> modifierStructure();
                case 4 -> gestion.afficherToutesStructures();
                case 5 -> consulterStructure();
                case 0 -> ConsoleStyle.succes("Déconnexion réussie.");
                default -> ConsoleStyle.erreur("Choix invalide.");
            }
        } while (choix != 0);
    }

    private void ajouterStructure() {
        ConsoleStyle.titre("AJOUTER UNE STRUCTURE");
        ConsoleStyle.option("[1] École Primaire");
        ConsoleStyle.option("[2] Collège");
        ConsoleStyle.option("[3] Lycée");
        ConsoleStyle.option("[4] Centre de Formation");
        System.out.print(ConsoleStyle.CYAN + "  Type : " + ConsoleStyle.RESET);

        // CORRECTION
        int type;
        try { type = Integer.parseInt(sc.nextLine().trim()); } catch (NumberFormatException e) { type = -1; }

        int id=gestion.getStructureLength()+1;// objet pour retourner id

        System.out.print(ConsoleStyle.JAUNE + "  Nom          : " + ConsoleStyle.RESET); String nom = sc.nextLine();
        System.out.print(ConsoleStyle.JAUNE + "  Adresse      : " + ConsoleStyle.RESET); String adr = sc.nextLine();
        System.out.print(ConsoleStyle.JAUNE + "  Téléphone    : " + ConsoleStyle.RESET); String tel = sc.nextLine();
        System.out.print(ConsoleStyle.JAUNE + "  Email        : " + ConsoleStyle.RESET); String email = sc.nextLine();

        int annee;
        System.out.print(ConsoleStyle.JAUNE + "  Année créa.  : " + ConsoleStyle.RESET);
        try { annee = Integer.parseInt(sc.nextLine().trim()); } catch (NumberFormatException e) { ConsoleStyle.erreur("Année invalide."); return; }

        switch (type) {
            case 1 -> gestion.ajouterStructure(new EcolePrimaire(id, nom, adr, tel, email, annee));
            case 2 -> gestion.ajouterStructure(new College(id, nom, adr, tel, email, annee));
            case 3 -> gestion.ajouterStructure(new Lycee(id, nom, adr, tel, email, annee));
            case 4 -> gestion.ajouterStructure(new CentreFormation(id, nom, adr, tel, email, annee));
            default -> { ConsoleStyle.erreur("Type invalide."); return; }
        }
        ConsoleStyle.succes("Structure ajoutée avec succès !");
    }
    private void consulterStructure() {
    ConsoleStyle.titre("CONSULTER UNE STRUCTURE");
    gestion.getStructureDisponible();
    System.out.print(ConsoleStyle.JAUNE + "  ID : " + ConsoleStyle.RESET);

    try {
        int id = Integer.parseInt(sc.nextLine().trim());
        StructureFormation sf = gestion.consulterParId(id);
        if (sf != null) sf.afficherInfos();
        else ConsoleStyle.erreur("Structure non trouvée.");
    } catch (NumberFormatException e) {
        ConsoleStyle.erreur("ID invalide.");
    }
}

    private void supprimerStructure() {
        ConsoleStyle.titre("SUPPRIMER UNE STRUCTURE");
        gestion.getStructureDisponible();
        System.out.print(ConsoleStyle.JAUNE + "  ID : " + ConsoleStyle.RESET);

        // CORRECTION
        try {
            int id = Integer.parseInt(sc.nextLine().trim());
            gestion.supprimerStructure(id);
            ConsoleStyle.succes("Structure supprimer avec succes");
        } catch (NumberFormatException e) {
            ConsoleStyle.erreur("ID invalide.");
        }
    }
    private void modifierStructure() {
        ConsoleStyle.titre("MODIFIER UNE STRUCTURE");
        gestion.getStructureDisponible();
        System.out.print(ConsoleStyle.JAUNE + "  ID           : " + ConsoleStyle.RESET);

        int id;
        try { id = Integer.parseInt(sc.nextLine().trim()); } catch (NumberFormatException e) { ConsoleStyle.erreur("ID invalide."); return; }

        System.out.print(ConsoleStyle.JAUNE + "  Nouveau nom  : " + ConsoleStyle.RESET);
        String nom = sc.nextLine();
        gestion.modifierNom(id, nom);
        ConsoleStyle.succes("Modification effectuer avec succes");
    }

}