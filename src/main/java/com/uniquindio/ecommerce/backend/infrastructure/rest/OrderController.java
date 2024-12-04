package com.uniquindio.ecommerce.backend.infrastructure.rest;

import com.uniquindio.ecommerce.backend.application.OrderService;
import com.uniquindio.ecommerce.backend.domain.model.Order;
import com.uniquindio.ecommerce.backend.domain.model.enums.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@Slf4j//PARA MOSTRAR LOS LOGS
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/saveOrder")
    public ResponseEntity<Order> save(@RequestBody Order order) {

        if(order.getState().toString().equals(OrderState.CANCELLED.toString())) {
            order.setState(OrderState.CANCELLED);
        }else {
            order.setState(OrderState.CONFIRMED);
        }
        return ResponseEntity.ok(orderService.save(order));
    }


    @PostMapping("/update/state/order")
    public ResponseEntity updateStateById(@RequestParam Integer id,
                                          @RequestParam String state) {
        orderService.updateStateByOrderId(id, state);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAllOrders")
    public ResponseEntity<Iterable<Order>> findAllOrders() {
        return new ResponseEntity(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findOrderById/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping("/findByUserId/{id}")
    public ResponseEntity<Iterable<Order>> findByUserId(@PathVariable("id") Integer userId) {
        return ResponseEntity.ok(orderService.findByUserId(userId));
    }
}
