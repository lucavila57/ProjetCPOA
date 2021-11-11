package Test.listmemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.ClientDAO;
import dao.DAOFactory;
import dao.Persistance;
import modele.metier.Client;

class ListeMemoireClientDAOTest {

	DAOFactory daofac = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	ClientDAO lmclient = daofac.getClientDAO();

	@Test
	void testCreate() throws Exception {
		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";

		Client cli = new Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);

		if (!lmclient.create(cli)) {
			fail("non créer");
		}
		lmclient.delete(cli);
	}

	@Test
	void testUpdate() throws Exception {
		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";

		Client cli = new Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
		lmclient.create(cli);

		if (!lmclient.update(cli)) {
			fail("non modifie");
		}
		lmclient.delete(cli);
	}

	@Test
	void testDelete() throws Exception {
		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";

		Client cli = new Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
		lmclient.create(cli);

		if (!lmclient.delete(cli)) {
			fail("Pas encore supprime");
		}
	}

	@Test
	void testGetById() throws Exception {
		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";

		Client cli = new Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
		lmclient.create(cli);

		if (!lmclient.getById(cli.getIdCl()).equals(cli)) {
			lmclient.delete(cli);
			fail("non trouve");
		}
		lmclient.delete(cli);
	}

	@Test
	void testFindAll() throws Exception {

		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie = "rue de la liberation";
		String code_postal = "57535";
		String ville = "Metz";
		String pays = "France";
		Client cli = new Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays);
		lmclient.create(cli);

		if (lmclient.findAll() == null) {
			lmclient.delete(cli);
			fail("non trouve");
		}
		lmclient.delete(cli);
	}
}