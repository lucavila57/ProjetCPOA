package dao.listmemoire;

import java.util.ArrayList;
import java.util.List;

import dao.AbonnementDAO;
import modele.metier.Abonnement;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {

public static ListeMemoireAbonnementDAO Instance;

private List<Abonnement> donnees;
		
	public static ListeMemoireAbonnementDAO getInstance() {
		
		if(Instance==null) {
			Instance = new ListeMemoireAbonnementDAO();
		}
		return Instance;
	}
	
	private ListeMemoireAbonnementDAO() {
		this.donnees = new ArrayList<Abonnement>();
	
		this.donnees.add(new Abonnement(1, null, null, null, null));
		this.donnees.add(new Abonnement(2, null, null, null, null));

	}
	
	
	
	
	

	@Override
	public Abonnement getById(int id) throws Exception {
		int idx = this.donnees.indexOf(new Abonnement(id, null, null, null, null));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
			
		}else {
			return this.donnees.get(idx);
		}
		
	}

	@Override
	public boolean create(Abonnement objet) throws Exception {
		objet.setId_abo(3);
		while (this.donnees.contains(objet)) {
			objet.setId_abo(objet.getId_abo() + 1);
		}
		boolean ok = this.donnees.add(objet);
		return ok;
	}

	@Override
	public boolean update(Abonnement objet) throws Exception {
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		}else {
			this.donnees.set(idx, objet);
		}
		return true;
	}

	@Override
	public boolean delete(Abonnement objet) throws Exception {
		Abonnement supprime;
		
		int idx = this.donnees.indexOf(objet);
		if (idx== -1) {
			throw new IllegalArgumentException("Tentative de suppressiion d'une objet inexistant");
		}else {
			supprime = this.donnees.remove(idx);
		}
		return objet.equals(supprime);
	}

	public ArrayList<Abonnement> findall() {
		
		//TODO
		return (ArrayList<Abonnement>) this.donnees;
	}

}
