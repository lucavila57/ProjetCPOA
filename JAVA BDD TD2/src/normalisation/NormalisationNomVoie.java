package normalisation;




public class NormalisationNomVoie 
{
	public static String NormalVoieboulevard(String args)
	{
		if (args.contains("bd ")|| args.contains(" bd ")||args.contains("boul ")||args.contains(" boul ")||args.contains("boul. ")||args.contains(" boul. "))
		{
		args=args.replace("bd ", "boulevard ");
		args=args.replace(" bd ", " boulevard ");
		args=args.replace("boul ", "boulevard ");
		args=args.replace(" boul ", " boulevard ");
		args=args.replace("boul. ", "boulevard ");
		args=args.replace(" boul. ", " boulevard ");
		
		}

		
		return args;
	}
	
	public static String NormalVoieAvenue(String args)
	{
		if (args.contains("av. ")|| args.contains(" av. "))
		{
		args=args.replace("av. ", "avenue ");
		args=args.replace(" av. ", " avenue ");
		}
		return args;
	}
	
	public static String NormalVoieFaubourg(String args)
	{
		if (args.contains("faub. ")|| args.contains(" faub. ")||args.contains("fg ")|| args.contains(" fg "))
		{
		args=args.replace("faub. ", "faubourg ");
		args=args.replace(" faub. ", " faubourg ");
		args=args.replace("fg ", "faubourg ");
		args=args.replace(" fg ", " faubourg ");
		}
		return args;
	}
	
	public static String NormalVoiePlace(String args)
	{
		if (args.contains("pl. ")|| args.contains(" pl. "))
		{
		args=args.replace("pl. ", "place ");
		args=args.replace(" pl. ", " place ");
		}
		return args;
	}
}
