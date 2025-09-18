package br.com.javadevweek.smartdelivery.modules.orders;

import br.com.javadevweek.smartdelivery.modules.orders.dto.CreateOrderRequest;
import br.com.javadevweek.smartdelivery.modules.orders.dto.CreateOrderResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private CreateOrderUseCase createOrderUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }

    @PostMapping("/")
    public CreateOrderResponse create(@RequestBody CreateOrderRequest createOrderRequest) {
        return this.createOrderUseCase.execute(createOrderRequest);

    }
}
