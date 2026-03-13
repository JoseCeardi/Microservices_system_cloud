package com.example.ms_customers.services;

import com.example.ms_customers.dtos.CustomerDTO;
import com.example.ms_customers.entities.CustomerEntity;
import com.example.ms_customers.exceptions.CustomApiException;
import com.example.ms_customers.mappers.CustomerMapper;
import com.example.ms_customers.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomers(){
        List<CustomerEntity> customers = customerRepository.findAll();
        if (customers.isEmpty()){
            throw new CustomApiException("No hay clientes registrados", HttpStatus.NOT_FOUND);
        }
        return CustomerMapper.toDtoList(customers);
    }
}

