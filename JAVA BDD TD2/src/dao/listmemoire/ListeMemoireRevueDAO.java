package dao.listmemoire;

import dao.RevueDAO;


import modele.metier.Revue;

import java.util.ArrayList;
import java.util.List;

public class ListeMemoireRevueDAO implements RevueDAO {

	public static ListeMemoireRevueDAO Instance;

	private List<Revue> donnees;

	public static ListeMemoireRevueDAO getInstance() {

		if (Instance == null) {
			Instance = new ListeMemoireRevueDAO();
		}
		return Instance;
	}

	private ListeMemoireRevueDAO() {

		this.donnees = new ArrayList<Revue>();

		this.donnees.add(new Revue(1, "Les miserables", "Livre des miserables", 5, "neuf", 1));
		this.donnees.add(new Revue(2, "Dora", "Livre de Dora l'exploratrice ", 3, "bon etat", 2));

	}

	@Override
	public Revue getById(int id) {

		int idx = this.donnees.indexOf(new Revue(id, "Test", "Test", 0, "Test", 0));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public boolean create(Revue objet) {
		objet.setId_revue(3);
		while (this.donnees.contains(objet)) {

			objet.setId_revue(objet.getId_revue() + 1);
		}
		boolean ok = this.donnees.add(objet);

		return ok;
	}

	@Override
	public boolean update(Revue objet) {
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {

			this.donnees.set(idx, objet);
		}

		return true;
	}

	@Override
	public boolean delete(Revue objet) {
		Revue supprime;

		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}

		return objet.equals(supprime);
	}

	public ArrayList<Revue> findAll() {
		return (ArrayList<Revue>) this.donnees;
	}
}
