package modele.metier;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Abonnement {
    DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int idAbo;
    private LocalDate dateDeb;
    private LocalDate dateFin;
    private int idCl;
    private int id_revue;

    

    //constructeur
    public Abonnement(int idAbo, LocalDate dateDeb, LocalDate dateFin, int idCl, int id_revue) {
        super();
        
        this.setIdAbo(idAbo);
        
        this.setDateDeb(dateDeb);
        this.setDateFin(dateFin);
        this.setIdCl(idCl);
        this.setIdRevue(id_revue);
    }
    //constructeur sans id
    public Abonnement(LocalDate dateDeb, LocalDate dateFin, int idCl, int id_revue) {
        this(-1, dateDeb, dateFin, idCl, id_revue);
    }
    

    // Getter and Setter

    
    public int getIdAbo() {
        return idAbo;
    }
    public void setIdAbo(int idAbo) {
        this.idAbo = idAbo;
    }
    public LocalDate getDateDeb() {
        return dateDeb;
    }
    public void setDateDeb(LocalDate dateDeb) {
        this.dateDeb = dateDeb;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    public int getIdCl() {
        return idCl;
    }
    public void setIdCl(int idCl) {
        this.idCl = idCl;
    }
    public int getId_revue() {
        return id_revue;
    }
    public void setIdRevue(int idRevue) {
        this.id_revue = idRevue;
    }
    @Override
    public String toString() {
        return "Abonnement [idAbo=" + idAbo + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + ", Cl=" + idCl
                + ", Revue=" + id_revue + "]";
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
        return Objects.equals(dateDeb, other.dateDeb) && Objects.equals(dateFin, other.dateFin) && idAbo == other.idAbo
                && idCl == other.idCl && id_revue == other.id_revue;
    }
    
    
    
    



}
