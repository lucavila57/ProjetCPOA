package modele.metier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Periodicite {

    private int id_perio;
    private String libelle;

    //Constructeur
    public Periodicite(int id_perio, String libelle) {
        super();
        this.setId_perio(id_perio);
        ;
        this.setLibelle(libelle);
        ;
    }

    //Constructeur sans id
    public Periodicite(String libelle) {
        this(-1, libelle);
    }


    // Getter and Setter
    public int getId_perio() {
        return id_perio;
    }

    public void setId_perio(int id_perio) {

        this.id_perio = id_perio;


    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
            this.libelle = libelle;

        }
    
    //fin Getter Setter

    //toString
    @Override
    public String toString() {
        return "Periodicite [id_perio=" + id_perio + ", libelle=" + libelle + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Periodicite other = (Periodicite) obj;
        if (id_perio != other.id_perio)
            return false;
        return true;
    }


}
