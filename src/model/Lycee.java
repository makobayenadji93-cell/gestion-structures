package model;
import ui.ConsoleStyle;

public class Lycee extends StructureFormation {

    public Lycee(int id, String nom, String adresse,
                 String telephone, String email,
                 int anneeCreation) {

        super(id, nom, adresse, telephone, email, anneeCreation);
    }

    @Override
    public void afficherInfos() {
        ConsoleStyle.ligneDbl();
        ConsoleStyle.info("TYPE     :", "LYCEE");
        ConsoleStyle.ligneSep();
        ConsoleStyle.info("ID       :", String.valueOf(id));
        ConsoleStyle.info("Nom      :", nom);
        ConsoleStyle.info("Adresse  :", adresse);
        ConsoleStyle.info("Tél      :", telephone);
        ConsoleStyle.info("Email    :", email);
        ConsoleStyle.info("Année    :", String.valueOf(anneeCreation));
        ConsoleStyle.ligneDblBas();
    }
}
