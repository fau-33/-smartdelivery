package br.com.javadevweek.smartdelivery.modules.customers;

import br.com.javadevweek.smartdelivery.ViaCepDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CreateCustomerUseCase {

    private CustomerRepository customerRepository;

    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    private CreateCustomerUseCase createCustomerUseCase;

    private final RestTemplate restTemplate = new RestTemplate();


    public void execute(CustomerEntity customerEntity) {
        String url = "https://viacep.com.br/ws/"+customerEntity.getZipCode()+"/json/";

        try {
            ViaCepDTO viaCepDTO = restTemplate.getForObject(url, ViaCepDTO.class);
            customerEntity.setAddress(viaCepDTO.getLogradouro());
        }catch (Exception e) {
            throw new IllegalArgumentException("Erro ao consertar o CEP: " + customerEntity.getZipCode());
        }

        // Buscar customer por email
        this.customerRepository.findByEmail(customerEntity.getEmail())
                .ifPresent(item -> {
                    throw new IllegalArgumentException("Email já existe");
                });

        // Salvar customer
        this.customerRepository.save(customerEntity);
        System.out.println(customerEntity);
    }
}
