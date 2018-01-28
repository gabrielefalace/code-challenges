package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Developer;

import org.springframework.stereotype.Repository;

@Repository
public class DeveloperDAO {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("issue-tracker").createEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<Developer> getAllDevelopers(){
		Query query = entityManager.createNamedQuery("Developer.findAll");
		return (List<Developer>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getDevelopersNames(){
		Query query = entityManager.createNamedQuery("Developer.findAllNames");
		return (List<String>) query.getResultList();
	}
	
	
	public int getDevelopersCount(){
		Query query = entityManager.createNamedQuery("Developer.count");
		return ((Number) query.getSingleResult()).intValue();
	}
	
}
