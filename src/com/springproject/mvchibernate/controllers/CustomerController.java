package com.springproject.mvchibernate.controllers;

import com.springproject.mvchibernate.ServiceDAO.ServiceDAO;
import com.springproject.mvchibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ServiceDAO serviceDAO;

    @GetMapping("/customerList")
    public String customerList(Model model){
        List<Customer> customers= serviceDAO.getCustomer();
        model.addAttribute("customer", customers);
        return "list-customer";
    }
    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model){
        Customer customer= new Customer();
        model.addAttribute("customer", customer);
       return "show-form-add";
    }
    @PostMapping("/showCustomer")
    public String showCustomer(@ModelAttribute("customer") Customer customer){
        serviceDAO.addCustomer(customer);
        return "redirect:/customer/customerList";
    }
    @GetMapping("/customerUpdate")
public String showCustomerUpdate(@RequestParam("customerID") int id, Model model){
        Customer customer= serviceDAO.getCustomer(id);
        model.addAttribute("customer", customer);
       return "show-form-add" ;
    }
    @GetMapping("customerDelete")
    public String customerDelete(@RequestParam("customerDeleteID") int customerID){
        serviceDAO.deleteCustomer(customerID);
        return "redirect:/customer/customerList";
    }
    @GetMapping("/Search")
    public String searchCustomer(@RequestParam("searchCustomer") String customer, Model model){
     List<Customer> customerList=  serviceDAO.searchCustomer(customer);
     model.addAttribute("customer", customerList);
     if(customerList == null){
         return "redirect:/customer/customerList";

     }else{
         return "list-customer";
        }

    }
}
