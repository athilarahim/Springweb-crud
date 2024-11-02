package com.example.Ecommerce.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Ecommerce.Model.Products;

@Service
public class ProductService {

    List<Products> products = new ArrayList<>(Arrays.asList(
        new Products(101,"iPhone",50000),
        new Products(102,"Macbook",200000),
        new Products(103,"iPad",60000)
    ));
    public List<Products> getproducts(){
        return products;
    }
    public Products getProductsById(int prodId){
        return products.stream()
        .filter(p -> p.getProdId() == prodId )
        .findFirst().orElse(new Products(100,"Not found",0));
    }
    
    public void addProduct(Products prod){
        products.add(prod);
    }

    public void updateProduct(Products prod){
        int index=0;
        for(int i=0;i<products.size();i++){
            if(prod.getProdId()==products.get(i).getProdId())
                index=i;
        }
        products.set(index, prod);
    }

    public void deleteProduct(int prodId){
        int index = 0;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProdId()==prodId){
                index = i;
            }
        }
        products.remove(index);
    }
}
