package com.esercizi.donato.model;

public class Product {
    private String productName;
    private String modelName;
    private String producer;
    private float price;
    private int productId;
    private int quantity;

    public Product(String productName, String modelName, String producer, float price, int productId, int quantity) {
        this.productName = productName;
        this.modelName = modelName;
        this.producer = producer;
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

}
