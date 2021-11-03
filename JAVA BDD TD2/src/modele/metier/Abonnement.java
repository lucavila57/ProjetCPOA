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
    private int idRevue;

    

    //constructeur
    public Abonnement(int idAbo, LocalDate dateDeb, LocalDate dateFin, int idCl, int idRevue) {
        super();
        
        this.setIdAbo(idAbo);
        
        this.setDateDeb(dateDeb);
        this.setDateFin(dateFin);
        this.setIdCl(idCl);
        this.setIdRevue(idRevue);
    }
    //constructeur sans id
    public Abonnement(LocalDate dateDeb, LocalDate dateFin, int idCl, int idRevue) {
        this(-1, dateDeb, dateFin, idCl, idRevue);
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
    public int getIdRevue() {
        return idRevue;
    }
    public void setIdRevue(int idRevue) {
        this.idRevue = idRevue;
    }
    @Override
    public String toString() {
        return "Abonnement [idAbo=" + idAbo + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + ", Cl=" + idCl
                + ", Revue=" + idRevue + "]";
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
                && idCl == other.idCl && idRevue == other.idRevue;
    }
    
    
    
    



}
