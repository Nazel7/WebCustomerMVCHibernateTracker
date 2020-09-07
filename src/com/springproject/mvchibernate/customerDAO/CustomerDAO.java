package com.springproject.mvchibernate.customerDAO;

import com.springproject.mvchibernate.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    void addCustomer(Customer customer);
    Customer getCustomers(int customerID);
    void deleteCustomer(int customerID);
    List<Customer> searchCustomer(String customer);
}
