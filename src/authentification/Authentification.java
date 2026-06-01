package auth;

import java.util.ArrayList;

public class Authentification {
    private static ArrayList<String[]> admins = new ArrayList<>();
    private static ArrayList<String[]> resStructs=new ArrayList<>();

    static {
        admins.add(new String[]{"admin", "1234"});
    }

    static{
        resStructs.add(new String[]{"responsable struture","5678"});
    }

    // Gestion Login et signup des admins
    public static boolean connecterAdmin(String login, String mdp) {
        for (String[] admin : admins) {
            if (admin[0].equals(login) && admin[1].equals(mdp)) {
                return true;
            }
        }
        return false;
    }

    public static void ajouterAdmin(String login, String mdp) {
        admins.add(new String[]{login, mdp});
        System.out.println("Nouvel administrateur créé avec succès !");
    }

    public static boolean loginExisteAdmin(String login) {
        for (String[] admin : admins) {
            if (admin[0].equals(login)) return true;
        }
        return false;
    }

    // Gestion Login et signup des responsable des structure
    public static boolean connecterResStruct(String nStruct, String mdp) {
        for (String[] resStruct : resStructs) {
            if (resStruct[0].equals(nStruct) && resStruct[1].equals(mdp)) {
                return true;
            }
        }
        return false;
    }

    public static void ajouterResStruct(String nStruct, String mdp) {
        resStructs.add(new String[]{nStruct, mdp});
        System.out.println("Nouvel responsable de structure créé avec succès !");
    }

    public static boolean loginExisteResStruct(String nStruct) {
        for (String[] resStruct : resStructs) {
            if (resStruct[0].equals(nStruct)) return true;
        }
        return false;
    }
}