package com.springproject.mvchibernate.ServiceDAO;

import com.springproject.mvchibernate.customerDAO.CustomerDAO;
import com.springproject.mvchibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicesDAOImpl implements ServiceDAO {
    @Autowired
    private CustomerDAO customerDAO;

    public ServicesDAOImpl() {
        super();
    }

    @Override
    @Transactional
    public List<Customer> getCustomer() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerID) {
        return customerDAO.getCustomers(customerID);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerID) {
        customerDAO.deleteCustomer(customerID);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomer(String customer) {
        return customerDAO.searchCustomer(customer);
    }
}
