package modele.metier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Revue {
    private int id_revue;
    private String titre;
    private String description;
    private double tarifNumero;
    private String visuel;
    private int id_perio;

    //constructeur
    public Revue(int id_revue, String titre, String description, double tarifNumero, String visuel, int id_perio) {
        super();
        this.setId_revue(id_revue);
        this.setTitre(titre);
        this.setDescription(description);
        this.setTarifNumero(tarifNumero);
        this.setVisuel(visuel);
        this.setId_perio(id_perio);
    }

    //constructeur sans id
    public Revue(String titre, String description, double tarifNumero, String visuel, int id_perio) {
        super();
        this.id_revue = -1;
        this.titre = titre;
        this.description = description;
        this.tarifNumero = tarifNumero;
        this.visuel = visuel;
        this.id_perio = id_perio;
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

    

    public int getId_perio() {
        return id_perio;
    }

    public void setId_perio(int id_perio) {
        this.id_perio = id_perio;
    }

    @Override
    public String toString() {
        return "Revue [id_revue=" + id_revue + ", titre=" + titre + ", description=" + description + ", tarifNumero="
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
        if (id_revue != other.id_revue)
            return false;
        return true;
    }

    //fin getter setter


}
