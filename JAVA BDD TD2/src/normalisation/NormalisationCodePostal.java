package normalisation;

public class NormalisationCodePostal {

    public static String NormalCodePostal(String args) {
        String z = "0";
        if (args.length() < 5) {
            args = z + args;
            return args;
        } else if (args.startsWith(args.substring(0, 1)) == args.startsWith(args.substring(0, 1).toUpperCase())) ;
        {
            args = args.substring(2);
        }
        return args;
    }

}
