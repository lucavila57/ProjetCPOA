package modele.metier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Periodicite {

    private int idPerio;
    private String libelle;

    //Constructeur
    public Periodicite(int idPerio, String libelle) {
        super();
        this.setIdPerio(idPerio);
        ;
        this.setLibelle(libelle);
        ;
    }

    //Constructeur sans id
    public Periodicite(String libelle) {
        this(-1, libelle);
    }


    // Getter and Setter
    public int getIdPerio() {
        return idPerio;
    }

    public void setIdPerio(int idPerio) {

        this.idPerio = idPerio;


    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherLibelle = pattern.matcher(this.getLibelle());

        if (this.getLibelle() == null) {
            throw new IllegalArgumentException("Libelle ne peut etre null");
        } else if ("".equals(this.getLibelle())) {
            throw new IllegalArgumentException("Libelle non valide");
        } else if (!matcherLibelle.find()) {
            throw new IllegalArgumentException("Libelle non valide");
        } else {
            this.libelle = libelle;

        }
    }
    //fin Getter Setter

    //toString
    @Override
    public String toString() {
        return "Periodicite [id=" + idPerio + ", libelle=" + libelle + "]";
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
        if (idPerio != other.idPerio)
            return false;
        return true;
    }


}
