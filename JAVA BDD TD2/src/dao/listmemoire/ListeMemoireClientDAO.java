package dao.listmemoire;

import dao.ClientDAO;

import modele.metier.Client;

import java.util.ArrayList;
import java.util.List;

public class ListeMemoireClientDAO implements ClientDAO {

	public static ListeMemoireClientDAO Instance;
	private List<Client> donnees;

	public static ListeMemoireClientDAO getInstance() {

		if (Instance == null) {
			Instance = new ListeMemoireClientDAO();
		}
		return Instance;
	}

	private ListeMemoireClientDAO() {

		this.donnees = new ArrayList<Client>();

		this.donnees.add(new Client(1, "hugo", "reina", "10", "Rue de la liberation", "57535", "marange", "france"));
		this.donnees.add(new Client(2, "luca", "vila", "11", "Rue du Village", "57420", "Rombas", "france"));

	}

	@Override
	public Client getById(int id) {
		int idx = this.donnees.indexOf(new Client(id, "Test", "Test", "Test", "Test", "Test", "Test", "Test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public boolean create(Client objet) {
		objet.setIdCl(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setIdCl(objet.getIdCl() + 1);
		}
		boolean ok = this.donnees.add(objet);

		return ok;
	}

	@Override
	public boolean update(Client objet) {
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {

			this.donnees.set(idx, objet);
		}

		return true;
	}

	@Override
	public boolean delete(Client objet) {
		Client supprime;

		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}

		return objet.equals(supprime);
	}

	@Override
	public List<Client> getByNom(Client client) {
		//TODO
		@SuppressWarnings("null")
		int idx = this.donnees.indexOf(new Client((Integer) null, null, null, null, null, null, null, null));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède ce nom");
		} else {
			return (ArrayList<Client>) this.donnees;
		}
	}

	@Override
	public ArrayList<Client> findAll() {
		return (ArrayList<Client>) this.donnees;
	}
}
