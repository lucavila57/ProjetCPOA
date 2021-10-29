package modele.metier;

public class Revue {
	private int idRevue;
	private String titre;
	private String description;
	private double tarifNumero;
	private String visuel;
	private int id_perio;
	
	//constructeur
	public Revue(int idRevue, String titre, String description, double tarifNumero, String visuel, int id_perio) {
		super();
		this.setIdRevue(idRevue);
		this.setTitre(titre);
		this.setDescription(description);
		this.setTarifNumero(tarifNumero);
		this.setVisuel(visuel);
		this.setId_Perio(id_perio);
	}
	
	//constructeur sans id
	public Revue(String titre, String description, double tarifNumero, String visuel, int id_perio) {
		super();
		this.idRevue = -1;
		this.titre = titre;
		this.description = description;
		this.tarifNumero = tarifNumero;
		this.visuel = visuel;
		this.id_perio = id_perio;
	}
	
	//debut getter setter
	public int getIdRevue() {
		return idRevue;
	}
	public void setIdRevue(int idRevue) {
		this.idRevue = idRevue;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTarifNumero() {
		return tarifNumero;
	}
	public void setTarifNumero(double tarifNumero) {
		this.tarifNumero = tarifNumero;
	}
	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	public int getId_Perio() {
		return id_perio;
	}
	public void setId_Perio(int id_perio) {
		this.id_perio = id_perio;
	}

	@Override
	public String toString() {
		return "Revue [idRevue=" + idRevue + ", titre=" + titre + ", description=" + description + ", tarifNumero="
				+ tarifNumero + ", visuel=" + visuel + ", id_perio=" + id_perio + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revue other = (Revue) obj;
		if (idRevue != other.idRevue)
			return false;
		return true;
	}
	
	//fin getter setter
	
	
	
	
}
