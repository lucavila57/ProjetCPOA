package dao.listmemoire;
import modele.metier.Periodicite;

import java.util.ArrayList;
import java.util.List;

import dao.AbonnementDAO;
import dao.RevueDAO;
import modele.metier.Revue;

public class ListeMemoireRevueDAO implements RevueDAO{

	
public static ListeMemoireRevueDAO Instance;
	
	private List<Revue> donnees;
	
	public static ListeMemoireRevueDAO getInstance() {
		
		if(Instance==null) {
			Instance = new ListeMemoireRevueDAO();
		}
		return Instance;
	}
	
	private ListeMemoireRevueDAO() {

		this.donnees = new ArrayList<Revue>();
		
		this.donnees.add(new Revue(1,"Les miserables", "Livre des miserables", 5, "neuf",null));
		this.donnees.add(new Revue(2,"Dora", "Livre de Dora l'exploratrice ", 3, "bon etat", null));

		
	}
	

	@Override
	public Revue getById(int id) throws Exception {
		@SuppressWarnings("null")
		int idx = this.donnees.indexOf(new Revue(id, null, null, (Float) null, null, null));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public boolean create(Revue objet) throws Exception {
		objet.setId_revue(3);
		while (this.donnees.contains(objet)) {

			objet.setId_revue(objet.getId_revue() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Revue objet) throws Exception {
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean delete(Revue objet) throws Exception {
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
