package com.yalcin.event;

import com.yalcin.entity.Order;
import com.yalcin.entity.Product;
import com.yalcin.entity.User;
import com.yalcin.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SellerProductEmailListener implements ApplicationListener<SellerProductSuccessEvent>{

    @Autowired
    EmailSender emailSender;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Override
    public void onApplicationEvent(SellerProductSuccessEvent event){
        try {
            this.confirmRegistration(event);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }

    }


    private void confirmRegistration(SellerProductSuccessEvent event) throws MessagingException, IOException {
        User user = event.getUser();
        Order order=event.getOrder();
        String recipient = order.getUser().getEmail();
        String productName=order.getProduct().getProductName();
        Map model = new HashMap();
        model.put("username", order.getUser().getUsername());
        model.put("productName", productName);
        model.put("name", user.getUsername());
        model.put("signature", "Ürün sipariş onayı");

        Context context = new Context();
        context.setVariables(model);
        String content = templateEngine.process("db-seller-product_email", context);

        emailSender.sendSimpleMessage(content ,recipient, "Ürün Sipariş Onayı");
    }
}