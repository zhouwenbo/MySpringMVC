package com.fheebiy.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by bob zhou on 14-4-19.
 */
@Document(collection="mg_phone")
public class Phone {

    @Id
    private String id;

    private long phone_id;

    private String name;

    private double size;

    private double price;

    private int weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(long phone_id) {
        this.phone_id = phone_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

   /* @PersistenceConstructor
    public Phone(long phone_id, String name, double size, double price, int weight,ObjectId id) {
        this.id = id;
        this.phone_id = phone_id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.weight = weight;
    }*/
}
