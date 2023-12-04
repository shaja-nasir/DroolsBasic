package com.javainuse.droolbasic.service;

import com.javainuse.droolbasic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JewelService {

    private final KieContainer kieContainer;

    @Autowired
    public JewelService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Product getProductDiscount(Product product){
        KieSession kieSession = KieContainer.newSession("rulesSession");
        kieSession.insert(product);
        kieSession.fireAllRules();
        kieSession.dispose();
        return product;
    }

}
