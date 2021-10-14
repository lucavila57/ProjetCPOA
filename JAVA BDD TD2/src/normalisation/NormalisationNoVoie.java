package normalisation;

public class NormalisationNoVoie {

	public static String NormalPays(String args) {
		
		String num;
		String fin;
		String maj=args;
		
		if(maj.contains(","))
		{
			return args;
		}else
		{
	        String mots[] = maj.split("",2);
	        
	        num = mots[0];
	        mots[0] = num + ",";
	        fin = String.join("", mots);
	        return fin;
		}
		
		
	}

}
