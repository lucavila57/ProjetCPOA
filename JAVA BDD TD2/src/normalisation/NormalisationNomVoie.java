package normalisation;

public class NormalisationNomVoie {
	
	public static String  NormalNomVoie(String args) {
	
	String [] boul = {"boul ", "boul.", "bd ", "bd." };
	String [] av  = {"av ", "av."};
	String [] faub = {"faub.", "faub ", "fg ", "fg."};
	String [] place = {"pl.", "pl "};
	String maj = args;
	String boule;
	
	for(int i=0; i<boul.length; i++)
	{
		if(maj.contains(boul[i]))
		{
			args.replace(boul[i], "boulevard ");

				return args;


		}
		else return args;
	}
	return args;
	
	}

}
