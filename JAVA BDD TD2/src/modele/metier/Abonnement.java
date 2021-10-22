package modele.metier;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Abonnement {
	private int idAbo;
	private Date dateDeb;
	private Date dateFin;
	private Client cl;
	private Revue revue;

	

	//constructeur
	public Abonnement(int idAbo, Date dateDeb, Date dateFin, Client cl, Revue revue) {
		super();
		
		this.setIdAbo(idAbo);
		
		this.setDateDeb(dateDeb);
		this.setDateFin(dateFin);
		this.setCl(cl);
		this.setRevue(revue);
	}
	//constructeur sans id
	public Abonnement(Date dateDeb, Date dateFin, Client cl, Revue revue) {
		this(-1, dateDeb, dateFin, cl, revue);
	}
	

	// Getter and Setter

	
	public int getIdAbo() {
		return idAbo;
	}
	public void setIdAbo(int idAbo) {
		this.idAbo = idAbo;
	}
	public Date getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
		return "Abonnement [idAbo=" + idAbo + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + ", cl=" + cl
				+ ", revue=" + revue + "]";
	}
	//fin getter setter

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
