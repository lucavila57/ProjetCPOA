package modele.metier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private int idCl;
    private String nom;
    private String prenom;
    private String noRue;
    private String voie;
    private String codePostal;
    private String ville;
    private String pays;


    //constructeur
    public Client(int idCl, String nom, String prenom, String noRue, String voie, String codePostal, String ville,
                  String pays) {
        super();
        this.setIdCl(idCl);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNoRue(noRue);
        this.setVoie(voie);
        this.setCodePostal(codePostal);
        this.setVille(ville);
        this.setPays(pays);
    }

    //constructeur sans id
    public Client(String nom, String prenom, String noRue, String voie, String codePostal, String ville,
                  String pays) {
        this(-1, nom, prenom, noRue, voie, codePostal, ville, pays);
    }


    //debut getter setter
    public int getIdCl() {


        return idCl;
    }

    public void setIdCl(int idCl) {
        this.idCl = idCl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherNom = pattern.matcher(this.getNom());

        if (this.getNom() == null) {
            throw new IllegalArgumentException("Nom ne peut etre null");
        } else if ("".equals(this.getNom())) {
            throw new IllegalArgumentException("Nom non valide");
        } else if (!matcherNom.find()) {
            throw new IllegalArgumentException("Nom non valide");
        } else {
            this.nom = nom;
        }

    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherPrenom = pattern.matcher(this.getPrenom());

        if (this.getPrenom() == null) {
            throw new IllegalArgumentException("Prenom ne peut etre null");
        } else if ("".equals(this.getPrenom())) {
            throw new IllegalArgumentException("Prenom non valide");
        } else if (!matcherPrenom.find()) {
            throw new IllegalArgumentException("Prenom non valide");
        } else {
            this.prenom = prenom;
        }

    }

    public String getNoRue() {
        return noRue;
    }

    public void setNoRue(String noRue) {
        this.noRue = noRue;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherVoie = pattern.matcher(this.getVoie());

        if (this.getVoie() == null) {
            throw new IllegalArgumentException("Voie ne peut etre null");
        } else if ("".equals(this.getVoie())) {
            throw new IllegalArgumentException("Voie non valide");
        } else if (!matcherVoie.find()) {
            throw new IllegalArgumentException("Voie non valide");
        } else {
            this.voie = voie;

        }
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherVille = pattern.matcher(this.getVille());

        if (this.getVille() == null) {
            throw new IllegalArgumentException("Ville ne peut etre null");
        } else if ("".equals(this.getVille())) {
            throw new IllegalArgumentException("Ville non valide");
        } else if (!matcherVille.find()) {
            throw new IllegalArgumentException("Ville non valide");
        } else {
            this.ville = ville;
        }
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
        Matcher matcherPays = pattern.matcher(this.getPays());

        if (this.getPays() == null) {
            throw new IllegalArgumentException("Pays ne peut etre null");
        } else if ("".equals(this.getPays())) {
            throw new IllegalArgumentException("Pays non valide");
        } else if (!matcherPays.find()) {
            throw new IllegalArgumentException("Pays non valide");
        } else {
            this.pays = pays;
        }
    }

    @Override
    public String toString() {
        return "Client [idCl=" + idCl + ", nom=" + nom + ", prenom=" + prenom + ", noRue=" + noRue + ", voie="
                + voie + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays + "]";
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
        Client other = (Client) obj;
        if (idCl != other.idCl)
            return false;

        return true;
    }


}
