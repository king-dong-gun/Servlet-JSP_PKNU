package com.example.servlet.day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductService {
    // 빠른검색을 위해 키, 값으로 저장하는 방식 -> HashMap
    Map<String, Product> products = new HashMap<>();
    public ProductService() {
        Product p = new Product("101", "아이폰", 1600000, "애플", "2024.05.27");
        products.put("101", p);

        p = new Product("102", "갤럭시", 1000000, "삼성전자", "2024.05.26");
        products.put("102", p);

        p = new Product("103", "맥북 프로", 2500000, "애플", "2024.05.25");
        products.put("103", p);
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
    public Product find(String id) {
        return products.get(id);
    }
}
