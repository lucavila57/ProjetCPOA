package normalisation;

public class NormalisationVille {
	
	public static String NormalVille(String args) {
		
		String maj = args;
		if(maj.equalsIgnoreCase(args))
		{
			char[] arr = maj.toCharArray();
		      arr[0] = Character.toUpperCase(arr[0]);
		  return new String(arr);
		}
		else if ((maj.contains("lès")) || (maj.contains("aux") || (maj.contains("le") || (maj.contains("sous") || (maj.contains("sur") || (maj.contains("à") || (maj.contains("la"))))))))
		{
			
		}
		return null;
	}

	
	
	
	
}
