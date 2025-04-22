package com.fooddelivery.orderpayment.services;

import com.fooddelivery.orderpayment.dto.ProductRequest;
import com.fooddelivery.orderpayment.dto.StripeResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

//    @Value("${stripe.secretKey}")
    private String secretKey;

    public StripeResponse checkoutProducts(ProductRequest productRequest){
//         Stripe.apiKey = secretKey;

        SessionCreateParams.LineItem.PriceData.ProductData productData =  new SessionCreateParams.LineItem.PriceData.ProductData.Builder()
                .setName(productRequest.getName()).build();

        SessionCreateParams.LineItem.PriceData priceData = new SessionCreateParams.LineItem.PriceData.Builder()
                .setCurrency(productRequest.getCurrency()==null?"USD": productRequest.getCurrency())
                .setUnitAmount(productRequest.getAmount()*100)
                .setProductData(productData)
                .build();


        // lineItem has all data
        SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
                .setQuantity(productRequest.getQuantity())
                .setPriceData(priceData)
                .build();

        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:3000/cart")  // success navigate to this endpoint
                .setCancelUrl("http://localhost:8080/cancel")
                .addLineItem(lineItem)
                .build();

        Session session=null;

        try{
            session = Session.create(params);
        }catch(StripeException ex){
            System.out.println(ex.getMessage());
        }


        return StripeResponse.builder()
                .status("SUCCESS")
                .message("Payment session crated")
                .sessionId(session.getId())
                .sessionUrl(session.getUrl())
                .build();



    }

}
