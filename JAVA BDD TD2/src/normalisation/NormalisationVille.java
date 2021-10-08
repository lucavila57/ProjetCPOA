package normalisation;

public class NormalisationVille {
	
	public static String NormalVille(String args) {
		
		String [] tab = {" lès ", "-lès ", " lès-", " le ", "-le ", " le-",
						" sous ", "-sous ", " sous-", " sur ", "-sur ", " sur-"," à ", "-à ", " à-",
						" aux ", "-aux ", " aux-"};
		String maj = args;
		if(maj.equalsIgnoreCase(args))
		{
			char[] arr = maj.toCharArray();
		      arr[0] = Character.toUpperCase(arr[0]);
		  return new String(arr);
		}
		
		
		for ( int i=0; i<tab.length; i++ ) 
		{
			if(maj.contains(tab[i]))
			{
		        String mots[] = maj.split(" ");
		        
				return null;
			}
		}
			
		return null;
	}

	
	
	
	
}
