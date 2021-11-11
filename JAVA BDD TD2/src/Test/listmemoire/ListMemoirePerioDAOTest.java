package Test.listmemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import modele.metier.Periodicite;



class ListMemoirePerioDAOTest {
	
	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	PeriodiciteDAO lper = daos.getPeriodiciteDAO();

	@Test
	void testCreate() throws Exception {
		int id_periodicite = 1;
		String libelle = "test";		
		Periodicite per = new Periodicite(id_periodicite, libelle);
			
		if(!lper.create(per)) {
			fail("Pas implemente");
		}
		lper.delete(per);
	}

	@Test
	void testDelete() throws Exception {
		int id_periodicite = 1;
		String libelle = "test";		
		Periodicite per = new Periodicite(id_periodicite, libelle);
		lper.create(per);
	
		if(!lper.delete(per)) {
			fail("Pas supprime");
		}
	}

	@Test
	void testUpdate() throws Exception {
		int id_periodicite = 1;
		String libelle = "test";		
		Periodicite per = new Periodicite(id_periodicite, libelle);
		lper.create(per);
		
		if(!lper.update(per)) { 
			fail("Pas modifie");
		}
		lper.delete(per);
	}

	@Test
	void testGetById() throws Exception {
		int id_periodicite = 44;
		String libelle = "test";		
		Periodicite per = new Periodicite(id_periodicite, libelle);
		lper.create(per);
		
		if(!lper.getById(per.getId_perio()).equals(per)) {
			lper.delete(per);
			fail("Pas trouve");			
		}
		lper.delete(per);
	}

	@Test
	void testFindAll() throws Exception {
		int id_periodicite = 1;
		String libelle = "test";		
		Periodicite per = new Periodicite(id_periodicite, libelle);
		lper.create(per);
		
		if(lper.findAll()==null) {
			lper.delete(per);
			fail("Pas trouve");
		}
		lper.delete(per);
	}

}
