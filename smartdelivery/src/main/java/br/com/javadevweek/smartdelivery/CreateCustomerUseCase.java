package br.com.javadevweek.smartdelivery;

import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCase {

    public void execute(CustomerEntity customerEntity) {
        System.out.println(customerEntity);
    }
}
