package dao.listmemoire;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;

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
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateDeb1 = LocalDate.parse("13/09/2020",formatage) ;
		LocalDate dateFin1 = LocalDate.parse("13/10/2020",formatage);
		LocalDate dateDeb2 = LocalDate.parse("12/01/2021",formatage) ;
		LocalDate dateFin2 = LocalDate.parse("12/03/2021",formatage);
		this.donnees.add(new Abonnement(dateDeb1, dateFin1, 1, 2));
		this.donnees.add(new Abonnement(dateDeb2,dateFin2, 2, 3));

	}
	
	
	
	
	

	@Override
	public Abonnement getById(int id) throws Exception {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int idx = this.donnees.indexOf(new Abonnement(id, LocalDate.parse("13/10/2020",formatage), LocalDate.parse("13/11/2020",formatage), 1 ,1));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
			
		}else {
			return this.donnees.get(idx);
		}
		
	}

	@Override
	public boolean create(Abonnement objet) throws Exception {
		objet.setIdAbo(3);
		while (this.donnees.contains(objet)) {
			objet.setIdAbo(objet.getIdAbo() + 1);
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

	@Override
	public ArrayList<Abonnement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Abonnement getById(int idCl, int idRevue) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
