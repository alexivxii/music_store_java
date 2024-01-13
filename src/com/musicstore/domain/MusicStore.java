package com.musicstore.domain;

import com.musicstore.exceptions.CustomerExistsException;

import java.util.*;

public class MusicStore {

    private final Set<Customer> customers = new HashSet<>();

    public MusicStore() {

    }

    public Set<Customer> getCustomers()  {
        return Collections.unmodifiableSet(customers);
    }

    //here to throw customer already exists exception
    public void addCustomer(final Customer customer) throws CustomerExistsException{
        if(customers.contains(customer)){
            //throw exception
            throw new CustomerExistsException("Customer already exists");
        }

        customers.add(customer);

    }

}
