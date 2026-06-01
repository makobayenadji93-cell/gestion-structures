package ui;

public class ConsoleStyle {
    // Couleurs
    public static final String RESET  = "\u001B[0m";
    public static final String ROUGE  = "\u001B[31m";
    public static final String VERT   = "\u001B[32m";
    public static final String JAUNE  = "\u001B[33m";
    public static final String BLEU   = "\u001B[34m";
    public static final String CYAN   = "\u001B[36m";
    public static final String BLANC  = "\u001B[37m";
    public static final String GRAS   = "\u001B[1m";

    // Bordures
    public static void ligneDbl() {
        System.out.println(CYAN + "╔══════════════════════════════════════╗" + RESET);
    }
    public static void ligneDblBas() {
        System.out.println(CYAN + "╚══════════════════════════════════════╝" + RESET);
    }
    public static void ligneSep() {
        System.out.println(CYAN + "╠══════════════════════════════════════╣" + RESET);
    }
    public static void ligneSimple() {
        System.out.println(CYAN + "──────────────────────────────────────" + RESET);
    }

    public static void titre(String texte) {
        ligneDbl();
        int padding = (38 - texte.length()) / 2;
        String pad = " ".repeat(Math.max(0, padding));
        System.out.println(CYAN + "║" + RESET + GRAS + JAUNE + pad + texte + pad + RESET + CYAN + "║" + RESET);
        ligneDblBas();
    }

    public static void option(String texte) {
        System.out.println(BLANC + "  " + texte + RESET);
    }

    public static void succes(String texte) {
        System.out.println(VERT + "  ✔ " + texte + RESET);
    }

    public static void erreur(String texte) {
        System.out.println(ROUGE + "  ✘ " + texte + RESET);
    }

    public static void info(String label, String valeur) {
        System.out.println(JAUNE + "  " + label + RESET + " " + valeur);
    }
}