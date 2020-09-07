package com.springproject.mvchibernate.customerDAO;

import com.springproject.mvchibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomersDAO implements CustomerDAO {
    private List<Customer> customerList;
    @Autowired
    private SessionFactory sessionFactory;

    public CustomersDAO(){
        customerList= new ArrayList<>();
    }
    @Override
    public List<Customer> getCustomers() {
        Session session=  sessionFactory.getCurrentSession();
        Query<Customer> customerQuery= session.createQuery("from Customer", Customer.class);
        this.customerList= customerQuery.getResultList();

        return this.customerList;
    }
    @Override
    public void addCustomer(Customer customer){
        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomers(int customerID) {
        Session session= sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerID);
    }

    @Override
    public void deleteCustomer(int customerID) {
        Session session= sessionFactory.getCurrentSession();
       Query customerQuery= session.createQuery("delete from Customer where id=: ctmID");
       customerQuery.setParameter("ctmID", customerID );
       customerQuery.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomer(String customer) {
        Session session= sessionFactory.getCurrentSession();
        Query<Customer> customerQuery= session
                .createQuery("from Customer where lower(first_name) LIKE :customerName " +
                        "or lower(last_name) LIKE :customerName ", Customer.class);

        if(customer.toLowerCase().trim().length() > 0){
            customerQuery
                    .setParameter("customerName",customer.toLowerCase() + "%");
            return customerQuery.getResultList();
        }
        else{
          return getCustomers();
        }
    }
}
