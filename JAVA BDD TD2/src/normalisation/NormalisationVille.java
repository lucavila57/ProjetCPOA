package normalisation;


public class NormalisationVille {

    public static String NormalVille(String args) {
        if (args.startsWith(args.substring(0, 1)) == args.startsWith(args.substring(0, 1).toLowerCase())) {

            char c = args.charAt(0);
            String premierCaractereVille = Character.toString(c);
            args = args.substring(1);
            args = (premierCaractereVille.toUpperCase() + args);
        }

        return args;
    }

    public static String NormalVilleLedeb(String args) {
        if (args.contains("Le ") || args.contains("le ")) {

            args = args.substring(3);
            args = ("Le-" + args);
        }
        return args;

    }

    public static String NormalVilleLe(String args) {
        if (args.contains(" le ") || args.contains(" Le ")) {

            args = args.replace(" le ", "-le-");
            args = args.replace(" Le ", "-le-");

        }

        return args;
    }

    public static String NormalVilleLesdeb(String args) {
        if (args.contains("L�s ") || args.contains("l�s ")) {

            args = args.substring(4);
            args = ("L�s-" + args);
        }
        return args;

    }

    public static String NormalVilleles(String args) {
        if (args.contains(" l�s ") || args.contains(" L�s ")) {

            args = args.replace(" l�s ", "-l�s-");
            args = args.replace(" L�s ", "-l�s-");

        }
        return args;
    }

    public static String NormalVilleSousdeb(String args) {
        if (args.contains("Sous ") || args.contains("sous ")) {

            args = args.substring(5);
            args = ("Sous-" + args);
        }
        return args;

    }

    public static String NormalVillesous(String args) {
        if (args.contains(" sous ") || args.contains(" Sous ")) {

            args = args.replace(" sous ", "-sous-");
            args = args.replace(" Sous ", "-sous-");

        }
        return args;
    }

    public static String NormalVilleSurdeb(String args) {
        if (args.contains("Sur ") || args.contains("sur ")) {

            args = args.substring(4);
            args = ("Sur-" + args);
        }
        return args;

    }

    public static String NormalVillesur(String args) {
        if (args.contains(" sur ") || args.contains(" Sur ")) {

            args = args.replace(" sur ", "-sur-");
            args = args.replace(" Sur ", "-sur-");

        }
        return args;
    }

    public static String NormalVilledeba(String args) {
        if (args.contains("� ") || args.contains("A ")) {

            args = args.substring(2);
            args = ("�-" + args);
        }
        return args;

    }

    public static String NormalVillea(String args) {
        if (args.contains(" � ") || args.contains(" A ")) {

            args = args.replace(" � ", "-�-");
            args = args.replace(" A ", "-�-");

        }
        return args;
    }

    public static String NormalVilleauxdeb(String args) {
        if (args.contains("aux ") || args.contains("Aux ")) {

            args = args.substring(4);
            args = ("Aux-" + args);
        }
        return args;

    }


    public static String NormalVilleaux(String args) {
        if (args.contains(" aux ") || args.contains(" Aux ")) {

            args = args.replace(" aux ", "-aux-");
            args = args.replace(" Aux ", "-aux-");

        }
        return args;
    }

    public static String NormalVilleStdeb(String args) {
        if (args.contains("St ")) {

            args = args.substring(3);
            args = ("Saint-" + args);
        }
        return args;

    }

    public static String NormalVilleStedeb(String args) {
        if (args.contains("Ste ")) {

            args = args.substring(4);
            args = ("Sainte-" + args);
        }
        return args;

    }

    public static String NormalVilleSt(String args) {
        if (args.contains(" St ")) {

            args = args.replace(" St ", "-Saint-");

        }
        return args;
    }

    public static String NormalVilleSte(String args) {
        if (args.contains(" Ste ")) {

            args = args.replace(" Ste ", "-Sainte-");

        }
        return args;
    }

}
