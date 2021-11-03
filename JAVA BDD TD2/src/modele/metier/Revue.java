package modele.metier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Revue {
    private int idRevue;
    private String titre;
    private String description;
    private double tarifNumero;
    private String visuel;
    private int id_perio;

    //constructeur
    public Revue(int idRevue, String titre, String description, double tarifNumero, String visuel, int id_perio) {
        super();
        this.setIdRevue(idRevue);
        this.setTitre(titre);
        this.setDescription(description);
        this.setTarifNumero(tarifNumero);
        this.setVisuel(visuel);
        this.setId_Perio(id_perio);
    }

    //constructeur sans id
    public Revue(String titre, String description, double tarifNumero, String visuel, int id_perio) {
        super();
        this.idRevue = -1;
        this.titre = titre;
        this.description = description;
        this.tarifNumero = tarifNumero;
        this.visuel = visuel;
        this.id_perio = id_perio;
    }

    //debut getter setter
    public int getIdRevue() {
        return idRevue;
    }

    public void setIdRevue(int idRevue) {
        this.idRevue = idRevue;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherTitre = pattern.matcher(this.getTitre());

        if (this.getTitre() == null) {
            throw new IllegalArgumentException("Titre ne peut etre null");
        } else if ("".equals(this.getTitre())) {
            throw new IllegalArgumentException("Titre non valide");
        } else if (!matcherTitre.find()) {
            throw new IllegalArgumentException("Titre non valide");
        } else {
            this.titre = titre;

        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherDescription = pattern.matcher(this.getDescription());

        if (this.getDescription() == null) {
            throw new IllegalArgumentException("Description ne peut etre null");
        } else if ("".equals(this.getDescription())) {
            throw new IllegalArgumentException("Description non valide");
        } else if (!matcherDescription.find()) {
            throw new IllegalArgumentException("Description non valide");
        } else {
            this.description = description;

        }
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
        Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherVisuel = pattern.matcher(this.getVisuel());

        if (this.getVisuel() == null) {
            throw new IllegalArgumentException("Visuel ne peut etre null");
        } else if ("".equals(this.getVisuel())) {
            throw new IllegalArgumentException("Visuel non valide");
        } else if (!matcherVisuel.find()) {
            throw new IllegalArgumentException("Visuel non valide");
        } else {
            this.visuel = visuel;

        }

    }

    public int getId_Perio() {
        return id_perio;
    }

    public void setId_Perio(int id_perio) {
        this.id_perio = id_perio;
    }

    @Override
    public String toString() {
        return "Revue [idRevue=" + idRevue + ", titre=" + titre + ", description=" + description + ", tarifNumero="
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
        if (idRevue != other.idRevue)
            return false;
        return true;
    }

    //fin getter setter


}
