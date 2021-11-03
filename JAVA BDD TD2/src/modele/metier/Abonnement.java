package modele.metier;

import java.time.LocalDate;

public class Abonnement {
    private int idAbo;
    private LocalDate dateDeb;
    private LocalDate dateFin;
    private Client Cl;
    private Revue Revue;


    //constructeur
    public Abonnement(int idAbo, LocalDate dateDeb, LocalDate dateFin, Client Cl, Revue Revue) {
        super();

        this.setIdAbo(idAbo);

        this.setDateDeb(dateDeb);
        this.setDateFin(dateFin);
        this.setCl(Cl);
        this.setRevue(Revue);
    }

    //constructeur sans id
    public Abonnement(LocalDate dateDeb, LocalDate dateFin, Client Cl, Revue Revue) {
        this(-1, dateDeb, dateFin, Cl, Revue);
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

    public Client getCl() {
        return Cl;
    }

    public void setCl(Client cl) {
        this.Cl = cl;
    }

    public Revue getRevue() {
        return Revue;
    }

    public void setRevue(Revue Revue) {
        this.Revue = Revue;
    }

    @Override
    public String toString() {
        return "Abonnement [idAbo=" + idAbo + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + ", Cl=" + Cl
                + ", Revue=" + Revue + "]";
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
        if (Cl == null) {
            if (other.Cl != null)
                return false;
        } else if (!Cl.equals(other.Cl))
            return false;
        if (Revue == null) {
            if (other.Revue != null)
                return false;
        } else if (!Revue.equals(other.Revue))
            return false;
        if (dateDeb == null) {
            if (other.dateDeb != null)
                return false;
        } else if (!dateDeb.equals(other.dateDeb))
            return false;
        if (dateFin == null) {
            if (other.dateFin != null)
                return false;
        } else if (!dateFin.equals(other.dateFin))
            return false;
        if (idAbo != other.idAbo)
            return false;
        return true;
    }


}
