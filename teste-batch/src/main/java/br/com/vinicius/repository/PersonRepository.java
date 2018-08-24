package br.com.vinicius.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.vinicius.entity.Person;
import br.com.vinicius.util.EntityManagerProducer;

public class PersonRepository {

	private EntityManager em;

	public PersonRepository() {
		this.em = EntityManagerProducer.producer();
	}

	@Transactional
	public Person findPersonById(Long id) {		
		return em.find(Person.class, id);
	}

	@Transactional
	public Person finPersonByCpfOrRg(String cpfOrRg) {		
		try {			
			String query = null;
			
			if (cpfOrRg.trim().length() == 7) {
				
				query = "FROM Person WHERE rg = :personRG";
						
				return em.createQuery(query, Person.class)
						 .setParameter("personRg", cpfOrRg)
						 .getSingleResult();
				
			} else {				
				query = "FROM Person WHERE cpf = :personCPF";
				
				return em.createQuery(query, Person.class)
						 .setParameter("personCPF", cpfOrRg)
						 .getSingleResult();
			}
			
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Person> findAllPersons() {
		List<Person> lista = em.createQuery("FROM Person").getResultList();
		
		return lista;
	}

	@Transactional
	public String personSave(Person pessoa) {		
		pessoa.setNomePessoa(pessoa.getNomePessoa().toUpperCase());

		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
		
		return "Pessoa " + pessoa.getNomePessoa() + " cadastrada com sucesso!";
	}

	@Transactional
	public String deletePerson(Person pessoa) {		
		em.getTransaction().begin();
		em.remove(pessoa);
		em.flush();
		em.getTransaction().commit();
		
		return "Pessoa " + pessoa.getNomePessoa() + " excluída com sucesso!";
	}

	@Transactional
	public List<Person> fullListPersonInfos() {		
		List<Person> listaPerson = new ArrayList<Person>();
		
		String query = "SELECT " + 
				"	 tp.id," + 
				"    tp.nome," + 
				"    tp.cpf," + 
				"    tp.data_nascimento," + 
				"    tp.RG," + 
				"    tp.CODIGO_ENDERECO," +
				"    ta.logradouro," + 
				"    ta.complemento," + 
				"    ta.numero," + 
				"    tn.bairro," + 
				"    tc.cidade," + 
				"    ts.estado," + 
				"    tv.modelo_veic," + 
				"    tv.cor," + 
				"    tv.ano_fabricacao," + 
				"    tv.ano_modelo," + 
				"    tvb.nome as marca" + 
				" FROM" + 
				"  tbg_person tp" + 
				" INNER JOIN tbg_address ta ON tp.CODIGO_ENDERECO = ta.id"+ 
				" INNER JOIN tbg_neighborhood tn ON ta.CODIGO_BAIRRO = tn.id" + 
				" INNER JOIN tbg_city tc ON tn.CODIGO_CIDADE = tc.id" + 
				" INNER JOIN tbg_state ts ON tc.CODIGO_ESTADO = ts.id" + 
				" INNER JOIN tbg_persON_tbg_vehicle tptv ON tp.id = tptv.PERSON_ID" + 
				" INNER JOIN tbg_vehicle tv ON tptv.LISTAVEIC_ID = tv.id" + 
				" INNER JOIN tbg_vehicle_brand tvb ON tv.CODIGO_MARCA_VEIC = tvb.id";
		
		listaPerson = em.createNativeQuery(query, Person.class).getResultList();
		
		return listaPerson;		
	}
}