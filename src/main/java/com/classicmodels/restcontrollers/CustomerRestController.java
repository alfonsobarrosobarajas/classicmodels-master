package com.classicmodels.restcontrollers;

import com.classicmodels.models.Customer;
import com.classicmodels.services.CustomerService;
import com.classicmodels.utility.Messages;
import com.classicmodels.utility.UrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(UrlConstants.CUSTOMER_URL)
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping(UrlConstants.LIST_ALL)
    public List<Customer> findAll() throws Exception {
        try {
            return customerService.getAll();
        } catch (Exception e) {
            throw new Exception(Messages.NO_CUSTOMERS);
        }

    }

    @GetMapping(UrlConstants.GET_BY_ID)
    public Customer getById(@PathVariable int id) throws Exception {

        try {
            return customerService.getById(id);
        } catch (Exception e) {
            throw new Exception(Messages.CUSTOMER_NOT_FOUND);
        }
    }

    @PostMapping(UrlConstants.SAVE)
    public void save(@RequestBody Customer customer) throws Exception {

        try {
            customerService.save(customer);
        } catch (Exception e) {
            throw new Exception(Messages.CUSTOMER_SAVED_ERROR);
        }
    }

    @PutMapping(UrlConstants.UPDATE)
    public void update(@RequestBody Customer customer, @PathVariable int id) throws Exception {
        try {
            customerService.update(customer, id);
        } catch (Exception e) {
            throw new Exception(Messages.CUSTOMER_UPDATED_ERROR);
        }
    }

    @DeleteMapping(UrlConstants.DELETE_BY_ID)
    public void delete(@PathVariable int id) throws Exception {

        try {
            customerService.deleteById(id);
        } catch (Exception e) {
            throw new Exception(Messages.CUSTOMER_DELETED_ERROR);
        }

    }

}
