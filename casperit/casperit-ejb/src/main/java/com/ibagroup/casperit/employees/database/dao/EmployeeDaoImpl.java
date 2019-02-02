package com.ibagroup.casperit.employees.database.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ibagroup.casperit.employees.database.dto.Employee;

//Use @RequestScoped
//https://stackoverflow.com/questions/27149388/no-bean-is-eligible-for-injection-to-the-injection-point

/*
* We suppress the warning about not specifying a serialVersionUID, as we are still developing this app, and want the JVM to
* generate the serialVersionUID for us. When we put this app into production, we'll generate and embed the serialVersionUID
*/
@SuppressWarnings("serial")
@RequestScoped
public class EmployeeDaoImpl implements Serializable {

@PersistenceContext(unitName = "primary")
private EntityManager em;

@Inject
private Event<Employee> EmployeeEventSrc;

/**
 * <p> Return all Employee if other parameters are null </p>
 * @param search parameters
 * @return list of Employee
 */
public List<Employee> retrieveEmployeeByParams(EmployeeSearchParams params) throws NonUniqueResultException {
	if (params.getId() != null || params.getFirstName() != null || params.getLastName() != null || params.getPhone() != null || params.getSpecialization() != null) {
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.id = :id OR e.firstName = :firstName OR e.lastName = :lastName OR e.specialization = :specialization OR e.phone = :phone", Employee.class);
	  	  	if (params.getId() != null)
		  			query.setParameter("id", params.getId());
		  		else query.setParameter("id", null);
			if (params.getFirstName() != null)
					query.setParameter("firstName", params.getFirstName());
				else query.setParameter("firstName", null);
			if (params.getLastName() != null)
					query.setParameter("lastName", params.getLastName());
				else  query.setParameter("lastName", null);
			if (params.getPhone() != null)
					query.setParameter("phone", params.getPhone());
				else query.setParameter("phone", null);
			if (params.getSpecialization() != null)
					query.setParameter("specialization", params.getSpecialization());
				else query.setParameter("specialization", null);
			try {
				return (List<Employee>) query.getResultList();
			} catch (NoResultException exc) {
				return null;
			}
	} else {
		TypedQuery<Employee> query = em.createQuery("SELECT DISTINCT e FROM Employee e ORDER BY e.id", Employee.class);
		try {
			return (List<Employee>) query.getResultList();
		} catch (NoResultException exc) {
			return null;
		}
	}
}

//Some code example	
//
//public Order findOrderSubmittedAt(Date date) throws NonUniqueResultException {
//	Query q = entityManager.createQuery(
//		"SELECT e FROM " + entityClass.getName() + " e WHERE date = :date_at");
//	q.setParameter("date_at", date);
//	try {
//		return (Order) q.getSingleResult();
//	} catch (NoResultException exc) {
//		return null;
//	}
//}
// 
//public Order getOrderSubmittedAt(Date date) throws NoResultException, NonUniqueResultException {
//	Query q = entityManager.createQuery(
//		"SELECT e FROM " + entityClass.getName() + " e WHERE date = :date_at");
//	q.setParameter("date_at", date);
//	return (Order) q.getSingleResult();
//}
//
//
//https://xebia.com/blog/jpa-implementation-patterns-data-access-objects/#JpaDao
//
//public class JpaOrderDao extends JpaDao<Integer, Order> implements OrderDao {
//	public List<Order> findOrdersSubmittedSince(Date date) {
//		Query q = entityManager.createQuery(
//			"SELECT e FROM " + entityClass.getName() + " e WHERE date >= :date_since");
//		q.setParameter("date_since", date);
//		return (List<Order>) q.getResultList();
//	}
//}
//

public void createNewEmployee(Employee entity) throws Exception {
    em.persist(entity);
    EmployeeEventSrc.fire(entity);
}

//public Response update(Long id, EmployeeDto dto) {
//      TypedQuery<Employee> findByIdQuery = em.createQuery("SELECT DISTINCT c FROM Employee c WHERE c.id = :entityId ORDER BY c.id", Employee.class);
//      findByIdQuery.setParameter("entityId", id);
//      Employee entity;
//      try {
//         entity = findByIdQuery.getSingleResult();
//      }
//      catch (NoResultException nre) {
//         entity = null;
//      }
//      entity = dto.fromDto(entity, em);
//      try {
//         entity = em.merge(entity);
//      }
//      catch (OptimisticLockException e) {
//         return Response.status(Response.Status.CONFLICT).entity(e.getEntity()).build();
//      }
//      return Response.noContent().build();
//   }
 
 public void deleteEmployeeById(Long id) {
	  Employee entity = em.find(Employee.class, id);
      if (entity == null) {
         entity = new Employee();
      }
      em.remove(entity);
   }
 
}
