package com.javainuse.droolbasic.service;

import com.javainuse.droolbasic.model.Product;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JewelService {

    @Autowired
    private  KieContainer kieContainer;

    public Product getProductDiscount(Product product){
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(product);
        kieSession.fireAllRules();
        kieSession.dispose();
        return product;
    }

}
