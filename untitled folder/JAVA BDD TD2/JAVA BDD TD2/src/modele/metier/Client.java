package modele.metier;

public class Client {
	private int id_cl;
	private String nom;
	private String prenom;
	private String no_rue;
	private String voie;
	private String code_postal;
	private String ville;
	private String pays;
	
	
	//constructeur
	public Client(int id_cl, String nom, String prenom, String no_rue, String voie, String code_postal, String ville,
			String pays) {
		super();
		this.id_cl = id_cl;
		this.nom = nom;
		this.prenom = prenom;
		this.no_rue = no_rue;
		this.voie = voie;
		this.code_postal = code_postal;
		this.ville = ville;
		this.pays = pays;
	}

	//debut getter setter
	public int getId_cl() {
		return id_cl;
	}
	public void setId_cl(int id_cl) {
		this.id_cl = id_cl;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNo_rue() {
		return no_rue;
	}
	public void setNo_rue(String no_rue) {
		this.no_rue = no_rue;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Client [id_cl=" + id_cl + ", nom=" + nom + ", prenom=" + prenom + ", no_rue=" + no_rue + ", voie="
				+ voie + ", code_postal=" + code_postal + ", ville=" + ville + ", pays=" + pays + "]";
	}
	//fin getter setter

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code_postal == null) ? 0 : code_postal.hashCode());
		result = prime * result + id_cl;
		result = prime * result + ((no_rue == null) ? 0 : no_rue.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		result = prime * result + ((voie == null) ? 0 : voie.hashCode());
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
		Client other = (Client) obj;
		if (id_cl != other.id_cl)
			return false;
		
		return true;
	}

	
	
}
