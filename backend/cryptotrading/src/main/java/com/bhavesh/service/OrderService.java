package com.bhavesh.service;

import com.bhavesh.domain.OrderType;
import com.bhavesh.modal.Coin;
import com.bhavesh.modal.Order;
import com.bhavesh.modal.OrderItem;
import com.bhavesh.modal.User;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {

    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId) throws Exception;

    List<Order> getAllOrdersOfUser(Long userId,OrderType orderType,String assetSymbol);

    Order processOrder (Coin coin,double quantity,OrderType orderType,User user) throws Exception;

}
