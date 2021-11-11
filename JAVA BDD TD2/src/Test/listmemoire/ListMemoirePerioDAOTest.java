package Test.listmemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import modele.metier.Periodicite;

class ListMemoirePerioDAOTest {

	DAOFactory daofac = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	PeriodiciteDAO lmperio = daofac.getPeriodiciteDAO();

	@Test
	void testCreate() throws Exception {
		int id_periodicite = 1;
		String libelle = "test";
		Periodicite per = new Periodicite(id_periodicite, libelle);

		if (!lmperio.create(per)) {
			fail("non créer");
		}
		lmperio.delete(per);
	}

	@Test
	void testUpdate() throws Exception {
		int id_periodicite = 1;
		String libelle = "test";
		Periodicite per = new Periodicite(id_periodicite, libelle);
		lmperio.create(per);

		if (!lmperio.update(per)) {
			fail("non modifie");
		}
		lmperio.delete(per);
	}

	@Test
	void testDelete() throws Exception {
		int id_periodicite = 1;
		String libelle = "test";
		Periodicite per = new Periodicite(id_periodicite, libelle);
		lmperio.create(per);

		if (!lmperio.delete(per)) {
			fail("non supprime");
		}
	}

	@Test
	void testGetById() throws Exception {
		int id_periodicite = 44;
		String libelle = "test";
		Periodicite per = new Periodicite(id_periodicite, libelle);
		lmperio.create(per);

		if (!lmperio.getById(per.getId_perio()).equals(per)) {
			lmperio.delete(per);
			fail("non trouve");
		}
		lmperio.delete(per);
	}

	@Test
	void testFindAll() throws Exception {
		int id_periodicite = 1;
		String libelle = "test";
		Periodicite per = new Periodicite(id_periodicite, libelle);
		lmperio.create(per);

		if (lmperio.findAll() == null) {
			lmperio.delete(per);
			fail("non trouve");
		}
		lmperio.delete(per);
	}

}
