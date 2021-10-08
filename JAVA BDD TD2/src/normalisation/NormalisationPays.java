package normalisation;

public class NormalisationPays {


public static String NormalPays(String args) {
	
	String sui = "Suisse";
	String bel = "Belgique";
	String lux = "Luxembourg";
	String arg1 = args.replaceAll("\\s+","");
	if(arg1.equalsIgnoreCase("letzebuerg"))
	{
		return lux;
	}
	else if (arg1.equalsIgnoreCase("belgium"))
	{
	return bel;
	}
	else if ((arg1.equalsIgnoreCase("Switzerland")) || (args.equalsIgnoreCase("Schweiz")))
	{
		return sui;
	}
	else 
		return arg1;
	
}
}