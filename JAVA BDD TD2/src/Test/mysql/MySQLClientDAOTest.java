package Test.mysql;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.ClientDAO;
import dao.DAOFactory;
import dao.Persistance;
import modele.metier.Client;

class MySQLClientDAOTest {

	ClientDAO testclient = DAOFactory.getDAOFactory(Persistance.MYSQL).getClientDAO();

	@Test
	void testCreate() throws Exception {
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";

		Client cli = new Client(nom, prenom, no_rue, voie, code_postal, ville, pays);

		if (!testclient.create(cli)) {
			fail("non créer");
		}
		testclient.delete(cli);
	}

	@Test
	void testUpdate() throws Exception {
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";

		Client cli = new Client(nom, prenom, no_rue, voie, code_postal, ville, pays);

		if (!testclient.update(cli)) {
			fail("non  modifie");
		}
		testclient.delete(cli);
	}

	@Test
	void testDelete() throws Exception {
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";

		Client cli = new Client(nom, prenom, no_rue, voie, code_postal, ville, pays);

		if (!testclient.delete(cli)) {
			fail("non  supprime");
		}
	}

	@Test
	void testGetById() throws Exception {
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";
		Client cli = new Client(nom, prenom, no_rue, voie, code_postal, ville, pays);

		if (!testclient.getById(cli.getIdCl()).equals(cli)) {
			testclient.delete(cli);
			fail("non trouve");
		}
		testclient.delete(cli);

	}

	@Test
	void testFindAll() throws Exception {
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";
		Client cli = new Client(nom, prenom, no_rue, voie, code_postal, ville, pays);

		if (testclient.findAll() == null) {
			testclient.delete(cli);
			fail("non trouvé");
		}
		testclient.delete(cli);
	}

}
