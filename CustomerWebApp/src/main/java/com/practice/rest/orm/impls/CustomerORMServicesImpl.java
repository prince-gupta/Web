package com.practice.rest.orm.impls;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.practice.rest.entity.Customer;
import com.practice.rest.orm.IORMServices;
import com.practice.rest.utils.SessionUtils;

public class CustomerORMServicesImpl implements IORMServices<Customer> {

	private Session session;

	public CustomerORMServicesImpl() {
		session = SessionUtils.getSession();
	}

	public Customer save(Customer t) {
		Transaction transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		return t;
	}

	public List<Customer> get() {
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();
	}

	public Customer get(Integer id) {
		return (Customer) session.get(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> search(Customer customer) {
		Criteria criteria = session.createCriteria(Customer.class);
		if (customer.getId() > 0)
			criteria.add(Restrictions.eq("id", customer.getId()));
		if (customer.getFirstName() != null
				&& !"".equals(customer.getFirstName()))
			criteria.add(Restrictions.eq("firstName", customer.getFirstName()));
		if (customer.getLastName() != null
				&& !"".equals(customer.getLastName()))
			criteria.add(Restrictions.eq("lastName", customer.getLastName()));
		return criteria.list();
	}

	public boolean delete(Customer t) {
		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery("delete from Customer c where c.id= :id");
		query.setInteger("id", t.getId());
		query.executeUpdate();
		transaction.commit();
		return true;
	}

}
