package com.esercizi.donato.Controller;

import com.esercizi.donato.model.Order;
import com.esercizi.donato.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    Map<Integer,Order> orderMap = new HashMap<>();

    @GetMapping("/show-orders")
    public ResponseEntity<Map<Integer,Order>> showOrders(){
        return ResponseEntity.ok(orderMap);
    }

    @PostMapping("/make-order")
    public ResponseEntity<Order> makeOrder(){
        SecureRandom secureRandom = new SecureRandom();
        int secureRandomIdValue = Math.abs(secureRandom.nextInt());
        orderMap.put(secureRandomIdValue, new Order("Processing..."));

        return ResponseEntity.ok(orderMap.get(secureRandomIdValue));
    }

    @PutMapping("/add-to-order/{id}")
    public ResponseEntity<Order> addProductToOrder(@PathVariable("id") int id, @RequestBody Product product){
        Order order = orderMap.get(id);
        order.addProduct(product);

        return ResponseEntity.ok(order);
    }

    @PatchMapping("/change-order-status/{id}")
    public ResponseEntity<Order> changeOrderStatus(@PathVariable("id")int id, @RequestParam("status") String status){
        Order order = orderMap.get(id);
        order.setStatus(status);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/show-order-status/{id}")
    public ResponseEntity<?> showOrderStatus(@PathVariable("id") int id){
        Order order = orderMap.get(id);
        return ResponseEntity.ok("Order " + id + " status: " + order.getStatus());
    }

}
