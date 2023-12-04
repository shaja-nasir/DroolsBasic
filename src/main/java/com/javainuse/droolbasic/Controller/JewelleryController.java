package com.javainuse.droolbasic.Controller;

import com.javainuse.droolbasic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JewelleryController {
    private final JewelService jewelService;

    @Autowired
    public JewelleryController(JewelService jewelService) {
        this.jewelService = jewelService;
    }

    @RequestMapping(method = "GET", path = "/getDiscount", produces = "application/json")
    public Product getQuestions(String type) {
        Product product = new Product();
        product.setType(type);
        jewelService.getProductDiscount(product);
        return product;
    }


}
