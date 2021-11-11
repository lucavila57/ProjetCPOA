package Test.mysql;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import modele.metier.Periodicite;

class MySQLPeriodiciteDAOTest {

	PeriodiciteDAO testperio = DAOFactory.getDAOFactory(Persistance.MYSQL).getPeriodiciteDAO();

	@Test
	void testCreate() throws Exception {
		String libelle = "test";
		Periodicite per = new Periodicite(libelle);

		if (!testperio.create(per)) {
			fail("non créer");
		}
		testperio.delete(per);
	}

	@Test
	void testUpdate() throws Exception {
		String libelle = "test update";
		Periodicite per = new Periodicite(libelle);

		if (!testperio.update(per)) {
			fail("Pas modifie");
		}
		testperio.delete(per);
	}

	@Test
	void testDelete() throws Exception {
		String libelle = "test";
		Periodicite per = new Periodicite(libelle);

		if (!testperio.delete(per)) {
			fail("non supprimé");
		}
	}

	@Test
	void testGetById() throws Exception {
		String libelle = "test";
		Periodicite per = new Periodicite(libelle);

		if (!testperio.getById(per.getId_perio()).equals(per)) {
			testperio.delete(per);
			fail("non trouvé");
		}
		testperio.delete(per);

	}

	@Test
	void testFindAll() throws Exception {
		String libelle = "test";
		Periodicite per = new Periodicite(libelle);

		if (testperio.findAll() == null) {
			testperio.delete(per);
			fail("non trouve");
		}
		testperio.delete(per);
	}

}
