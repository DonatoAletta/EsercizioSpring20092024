package com.esercizi.donato.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String status;
    private List<Product> productList;
    private float totalPrice;

    public Order(String status) {
        this.status = status;
        this.productList = new ArrayList<>();
        this.totalPrice = 0.0f;
    }

    public Order() {
    }

    public void addProduct(Product product){
        if(productList.stream().anyMatch(product1 -> product1.getProductId() == product.getProductId())){
            product.setQuantity(product.getQuantity() + 1);
        }else{
            productList.add(product);
        }
        totalPrice += product.getQuantity() * product.getPrice();
    }

    public boolean removeProduct(int id){
      return productList.removeIf(product -> product.getProductId() == id);
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        switch (status){
            case "Shipping" -> this.status = "Shipping";
            case "Delivering" -> this.status = "Delivering";
            case "Delivered" -> this.status = "Delivered";
            default -> this.status = "Processing";
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
