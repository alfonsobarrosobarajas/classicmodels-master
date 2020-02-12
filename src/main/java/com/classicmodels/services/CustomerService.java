package com.classicmodels.services;

import com.classicmodels.models.Customer;
import com.classicmodels.repositories.CustomerRepository;
import com.classicmodels.repositories.ICRUD;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICRUD<Customer> {


    CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public Customer getById(int id) throws Exception {
        return repository.findById(id).get();
    }

    @Override
    public void save(Customer obj) throws Exception {
        repository.save(obj);
    }

    @Override
    public void update(Customer obj, int id) throws Exception {

        obj.setCustomerNumber(id);
        repository.save(obj);
    }

    @Override
    public void deleteById(int id) throws Exception {
        repository.deleteById(id);
    }
}
