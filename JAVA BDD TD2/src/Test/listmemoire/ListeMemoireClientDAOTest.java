package Test.listmemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.ClientDAO;
import dao.DAOFactory;
import dao.Persistance;
import modele.metier.Client;



class ListeMemoireClientDAOTest {

	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	ClientDAO lcli = daos.getClientDAO();

	@Test
	void testCreate() throws Exception {
		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie ="rue de la liberation";
		String code_postal= "57535";
		String ville = "Metz";
		String pays = "France";
		 
		Client cli = new Client(id_client,  nom,  prenom,  no_rue,  voie,  code_postal,
			 ville,  pays);
		
		if(!lcli.create(cli)) {
			fail("Pas encore implemente");
		}
		lcli.delete(cli);
	}

	@Test
	void testDelete() throws Exception {
		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie ="rue de la liberation";
		String code_postal= "57535";
		String ville = "Metz";
		String pays = "France";
		 
		Client cli = new Client(id_client,  nom,  prenom,  no_rue,  voie,  code_postal,
			 ville,  pays);
		lcli.create(cli);
		
		if(!lcli.delete(cli)) {
			fail("Pas encore supprime");
		}
	}

	@Test
	void testUpdate() throws Exception {
		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie ="rue de la liberation";
		String code_postal= "57535";
		String ville = "Metz";
		String pays = "France";
		 
		Client cli = new Client(id_client,  nom,  prenom,  no_rue,  voie,  code_postal,
			 ville,  pays);
		lcli.create(cli);
		
		if(!lcli.update(cli)) {
			fail("Pas encore modifie");
		}
		lcli.delete(cli);
	}
	
	@Test
	void testGetById() throws Exception {
		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie ="rue de la liberation";
		String code_postal= "57535";
		String ville = "Metz";
		String pays = "France";
		 
		Client cli = new Client(id_client,  nom,  prenom,  no_rue,  voie,  code_postal,
			 ville,  pays);
		lcli.create(cli);
		
		if(!lcli.getById(cli.getIdCl()).equals(cli)) {
			lcli.delete(cli);
			fail("Pas trouve");			
		}
		lcli.delete(cli);
	}

	@Test
	void testFindAll() throws Exception {

		int id_client = 1;
		String nom = "Vila";
		String prenom = "Luca";
		String no_rue = "4";
		String voie ="rue de la liberation";
		String code_postal= "57535";
		String ville = "Metz";
		String pays = "France";		
		Client cli = new Client(id_client,  nom,  prenom,  no_rue,  voie,  code_postal,
		 ville,  pays);
		lcli.create(cli);
		
		if(lcli.findAll()==null) {
			lcli.delete(cli);
			fail("Pas trouve");
		}
		lcli.delete(cli);
	}	
}