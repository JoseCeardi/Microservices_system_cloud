package com.example.ms_customers.services;

import com.example.ms_customers.dtos.CustomerDTO;
import com.example.ms_customers.dtos.GenericKardexRequestDTO;
import com.example.ms_customers.entities.CustomerEntity;
import com.example.ms_customers.enums.KardexMovementType;
import com.example.ms_customers.exceptions.CustomApiException;
import com.example.ms_customers.feignclients.KardexClient;
import com.example.ms_customers.mappers.CustomerMapper;
import com.example.ms_customers.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final KardexClient kardexClient;

    @Transactional
    public CustomerDTO createCustomer(CustomerDTO dto) {

        if (customerRepository.existsByRut(dto.getRut())) {
            throw new CustomApiException("El cliente con RUT " + dto.getRut() + " ya existe.", HttpStatus.BAD_REQUEST);
        }

        CustomerEntity entity = CustomerMapper.toEntity(dto);
        CustomerEntity savedEntity = customerRepository.save(entity);

        GenericKardexRequestDTO kardex = new GenericKardexRequestDTO();
        kardex.setRutClient(savedEntity.getRut());
        kardex.setDescription("Creación cliente RUT: " + savedEntity.getRut());
        kardex.setMovementType(KardexMovementType.CUSTOMER_CREATE);
        kardex.setUserResponsible("USER SYSTEM");

        kardexClient.registrarEvento(kardex);

        return CustomerMapper.toDto(savedEntity);
    }



    public List<CustomerDTO> getAllCustomers() {
        return CustomerMapper.toDtoList(customerRepository.findAll());
    }

    public CustomerDTO getCustomerByRut(String rut) {
        CustomerEntity entity = customerRepository.getCustomerByRut(rut);
        return CustomerMapper.toDto(entity);
    }


}