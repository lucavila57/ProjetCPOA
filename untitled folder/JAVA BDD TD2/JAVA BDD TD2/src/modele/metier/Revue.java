package modele.metier;

public class Revue {
	private int id_revue;
	private String titre;
	private String description;
	private float tarif_numero;
	private String visuel;
	private Periodicite perio;
	
	//constructeur
	public Revue(int id_revue, String titre, String description, float tarif_numero, String visuel, Periodicite perio) {
		super();
		this.id_revue = id_revue;
		this.titre = titre;
		this.description = description;
		this.tarif_numero = tarif_numero;
		this.visuel = visuel;
		this.perio = perio;
	}
	
	//debut getter setter
	public int getId_revue() {
		return id_revue;
	}
	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
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
	public float getTarif_numero() {
		return tarif_numero;
	}
	public void setTarif_numero(float tarif_numero) {
		this.tarif_numero = tarif_numero;
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
		return "Revue [id_revue=" + id_revue + ", titre=" + titre + ", description=" + description + ", tarif_numero="
				+ tarif_numero + ", visuel=" + visuel + ", perio=" + perio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_revue;
		return result;
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
		if (id_revue != other.id_revue)
			return false;
		return true;
	}
	
	//fin getter setter
	
	
	
	
}
