package model;

import java.util.ArrayList;
import ui.ConsoleStyle;

public class GestionStructure {

    private ArrayList<StructureFormation> structures;

    public GestionStructure() {
        structures = new ArrayList<>();
    }

    // AJOUTER
    public void ajouterStructure(StructureFormation sf) {
        structures.add(sf);
    }

    // SUPPRIMER par ID
    public void supprimerStructure(int id) {
        structures.removeIf(sf -> sf.getId() == id);
        System.out.println("Structure supprimée.");
    }

    // MODIFIER le nom par ID
    public void modifierNom(int id, String nouveauNom) {
        for (StructureFormation sf : structures) {
            if (sf.getId() == id) {
                sf.setNom(nouveauNom);
                System.out.println("Nom modifié avec succès.");
                return;
            }
        }
        System.out.println("Structure non trouvée.");
    }

    // AFFICHER TOUTES
    public void afficherToutesStructures() {
        if (structures.isEmpty()) {
            System.out.println("Aucune structure enregistrée.");
            return;
        }
        for (StructureFormation sf : structures) {
            sf.afficherInfos();
            System.out.println();
        }
    }

    // RECHERCHER par nom
    public StructureFormation rechercherParNom(String nom) {
        for (StructureFormation sf : structures) {
            if (sf.getNom().equalsIgnoreCase(nom)) {
                return sf;
            }
        }
        return null;
    }

    // CONSULTER par ID
    public StructureFormation consulterParId(int id) {
        for (StructureFormation sf : structures) {
            if (sf.getId() == id) return sf;
        }
        return null;
    }

    public int getStructureLength() { return structures.size(); }

    public void getStructureDisponible(){
        ConsoleStyle.titre("Liste des structure disponible");
        for(StructureFormation sf : structures){
            System.out.println("/ ID :"+sf.getId()+" ,Nom Structure :"+sf.getNom()+" /");
        }
    }
}