package com.angryzyh.order.service;

import com.angryzyh.order.mapper.OrderMapper;
import com.angryzyh.order.pojo.Order;
import com.angryzyh.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        Order order = orderMapper.findById(orderId);
        String url = "http://userservice/users/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }
}
