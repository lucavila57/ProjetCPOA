package modele.metier;

public class Revue {
	private int idRevue;
	private String titre;
	private String description;
	private float tarifNumero;
	private String visuel;
	private Periodicite perio;
	
	//constructeur
	public Revue(int idRevue, String titre, String description, float tarifNumero, String visuel, Periodicite perio) {
		super();
		this.setIdRevue(idRevue);
		this.setTitre(titre);
		this.setDescription(description);
		this.setTarifNumero(tarifNumero);
		this.setVisuel(visuel);
		this.setPerio(perio);
	}
	
	//constructeur sans id
	public Revue(String titre, String description, float tarifNumero, String visuel, Periodicite perio) {
		this(-1,titre,description, tarifNumero, visuel, perio);
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
	public float getTarifNumero() {
		return tarifNumero;
	}
	public void setTarifNumero(float tarifNumero) {
		this.tarifNumero = tarifNumero;
	}
	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	public Periodicite getPerio() {
		return perio;
	}
	public void setPerio(Periodicite perio) {
		this.perio = perio;
	}

	@Override
	public String toString() {
		return "Revue [idRevue=" + idRevue + ", titre=" + titre + ", description=" + description + ", tarifNumero="
				+ tarifNumero + ", visuel=" + visuel + ", perio=" + perio + "]";
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
