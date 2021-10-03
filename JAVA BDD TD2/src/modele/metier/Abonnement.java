package modele.metier;
import java.sql.Date;

public class Abonnement {
	private int id_abo;
	private Date date_deb;
	private Date date_fin;
	private Client cl;
	private Revue revue;
	
	
	//constructeur
	public Abonnement(int id_abo, Date date_deb, Date date_fin, Client cl, Revue revue) {
		super();
		this.id_abo = id_abo;
		this.date_deb = date_deb;
		this.date_fin = date_fin;
		this.cl = cl;
		this.revue = revue;
	}

	// Getter and Setter

	
	public int getId_abo() {
		return id_abo;
	}
	public void setId_abo(int id_abo) {
		this.id_abo = id_abo;
	}
	public Date getDate_deb() {
		return date_deb;
	}
	public void setDate_deb(Date date_deb) {
		this.date_deb = date_deb;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public Client getCl() {
		return cl;
	}
	public void setCl(Client cl) {
		this.cl = cl;
	}
	public Revue getRevue() {
		return revue;
	}
	public void setRevue(Revue revue) {
		this.revue = revue;
	}
	@Override
	public String toString() {
		return "Abonnement [id_abo=" + id_abo + ", date_deb=" + date_deb + ", date_fin=" + date_fin + ", cl=" + cl
				+ ", revue=" + revue + "]";
	}
	//fin getter setter

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cl == null) ? 0 : cl.hashCode());
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
		Abonnement other = (Abonnement) obj;
		if (cl == null) {
			if (other.cl != null)
				return false;
		} else if (!cl.equals(other.cl))
			return false;
		return true;
	}

	
}
