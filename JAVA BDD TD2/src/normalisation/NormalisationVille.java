package normalisation;

public class NormalisationVille {
	
	public static String NormalVille(String args) {
		
		String [] tab = {" lès ", "-lès ", " lès-", " le ", "-le ", " le-",
						" sous ", "-sous ", " sous-", " sur ", "-sur ", " sur-"," à ", "-à ", " à-",
						" aux ", "-aux ", " aux-"};
		String[] tab2 = {"Ste", "St", "ste", "st"};
		String maj = args;
		String fin;
		String Ste;
	
		for ( int i=0; i<tab.length; i++ ) 
		{
			if(maj.contains(tab[i]))
			{
		        String mots[] = maj.split(tab[i],5);
		        
		        fin = String.join("-", mots);
		        return fin;
			}
				
		for (int y=0; y<tab2.length; y++)
		{
			if(maj.contains(tab[y]))
			{
				String mot[] = maj.split(tab[y],2);
				
				mot[0] = "Saint"; 
				Ste = String.join("-", mot);
				return Ste;
				
			}
		}
		}
		if(maj.equalsIgnoreCase(args))
		{
			char[] arr = maj.toCharArray();
		      arr[0] = Character.toUpperCase(arr[0]);
		  return new String(arr);
		}
		return args;

			}

	
	
	
	
}
