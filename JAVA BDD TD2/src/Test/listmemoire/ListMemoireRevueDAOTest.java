package Test.listmemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.DAOFactory;
import dao.Persistance;
import dao.RevueDAO;
import modele.metier.Revue;



class ListMemoireRevueDAOTest {
	
	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	RevueDAO lrev = daos.getRevueDAO();

	@Test
	void testCreate() throws Exception {
		int id_revue =1;
		String titre ="test";
		String description="test";
		double tarif_numero= 2;
		String visuel="test";
		int id_periodicite =1;
		 
		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel,
				id_periodicite);
		if(!lrev.create(rev)) {
			fail("Pas encore implemente");
		}
		lrev.delete(rev);
	}

	@Test
	void testDelete() throws Exception {
		int id_revue =1;
		String titre ="test";
		String description="test";
		double tarif_numero= 2;
		String visuel="1";
		int id_periodicite =1;
		 
		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel,
				id_periodicite);
		lrev.create(rev);
		if(!lrev.delete(rev)) {
			fail("Pas encore supprime");
		}
	}

	@Test
	void testUpdate() throws Exception {
		int id_revue =1;
		String titre ="test";
		String description="test";
		double tarif_numero= 2;
		String visuel="1";
		int id_periodicite =1;
		 
		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel,
				id_periodicite);
		lrev.create(rev);
		
		if(!lrev.update(rev)) {
			fail("Pas encore modifie");
		}
		lrev.delete(rev);
	}

	@Test
	void testGetById() throws Exception {
		int id_revue =1;
		String titre ="test";
		String description="test";
		double tarif_numero= 2;
		String visuel="1";
		int id_periodicite =1;
		 
		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel,
				id_periodicite);
		lrev.create(rev);
		
		if(!lrev.getById(rev.getId_revue()).equals(rev)) {
			lrev.delete(rev);
			fail("Pas trouve");			
		}
		lrev.delete(rev);
	}

	@Test
	void testFindAll() throws Exception {
		int id_revue =1;
		String titre ="test";
		String description="test";
		double tarif_numero= 2;
		String visuel="1";
		int id_periodicite =1;
		 
		Revue rev = new Revue(id_revue, titre, description, tarif_numero, visuel,
					id_periodicite);
		lrev.create(rev);
		
		if(lrev.findAll()==null) {
			lrev.delete(rev);
			fail("Pas trouve");
		}
		lrev.delete(rev);
	}

}