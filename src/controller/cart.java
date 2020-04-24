package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import VO.productVO;

public class cart {
    HashMap<String, productVO> cartItems;
    public cart(){
     cartItems = new HashMap<String, productVO>();
      
    }
    public HashMap<String, productVO> getCartItems(){
        return cartItems;
    }
    public void addToCart(String productName, productVO obj){
        cartItems.put(productName, obj);
    }
    
    public void deleteCart(String productName){
        cartItems.remove(productName);
    }
     
}

