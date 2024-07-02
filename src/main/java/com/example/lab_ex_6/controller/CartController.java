package com.example.lab_ex_6.controller;

import com.example.lab_ex_6.model.CartItem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private List<CartItem> shoppingCart = new ArrayList<>();
    private long idCounter = 1;

    //GET
    @GetMapping
    public List<CartItem> getAllItems() {
        return shoppingCart;
    }

    //POST
    @PostMapping
    public CartItem addItem(@RequestBody CartItem newItem) {
        newItem.setId(idCounter++);
        shoppingCart.add(newItem);
        return newItem;
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void removeItem(@PathVariable Long id) {
        shoppingCart.removeIf(item -> item.getId().equals(id));
    }




}
