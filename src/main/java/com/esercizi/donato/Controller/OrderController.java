package com.esercizi.donato.Controller;

import com.esercizi.donato.model.Order;
import com.esercizi.donato.model.Product;
import com.esercizi.donato.utils.RandomIdGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    Map<Integer, Order> orderMap = new HashMap<>();
    RandomIdGenerator randomIdGenerator = new RandomIdGenerator();

    @GetMapping("/show-orders")
    public ResponseEntity<Map<Integer, Order>> showOrders() {
        return ResponseEntity.ok(orderMap);
    }

    @PostMapping("/make-order")
    public ResponseEntity<Order> makeOrder() {
        int randomIdValue = randomIdGenerator.generateRandomId();
        orderMap.put(randomIdValue, new Order("Processing..."));

        return ResponseEntity.ok(orderMap.get(randomIdValue));
    }

    @PutMapping("/add-to-order/{id}")
    public ResponseEntity<Order> addProductToOrder(@PathVariable("id") int id, @RequestBody List<Product> productList) {
        Order order = orderMap.get(id);

        for (Product product : productList) {
            order.addProduct(product);
        }

        return ResponseEntity.ok(order);
    }

    @PatchMapping("/change-order-status/{id}")
    public ResponseEntity<Order> changeOrderStatus(@PathVariable("id") int id, @RequestParam("status") String status) {
        Order order = orderMap.get(id);
        order.setStatus(status);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/show-order-status/{id}")
    public ResponseEntity<?> showOrderStatus(@PathVariable("id") int id) {
        Order order = orderMap.get(id);
        return ResponseEntity.ok("Order " + id + " status: " + order.getStatus());
    }

    //Debugging
    @GetMapping("/get-existing-ids")
    public ResponseEntity<?> getExistingIds(){
        return ResponseEntity.ok(randomIdGenerator.getExistingIds());
    }
}
