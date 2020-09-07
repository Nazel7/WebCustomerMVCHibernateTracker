package com.springproject.mvchibernate.ServiceDAO;

import com.springproject.mvchibernate.entity.Customer;

import java.util.List;

public interface ServiceDAO {
    List<Customer> getCustomer();
    void addCustomer(Customer customer);
    Customer getCustomer(int customerID);
    void deleteCustomer(int customerID);
    List<Customer> searchCustomer(String customer);
}
