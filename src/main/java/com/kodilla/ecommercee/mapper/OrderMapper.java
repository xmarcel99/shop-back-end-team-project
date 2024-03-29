package com.kodilla.ecommercee.mapper;
import com.kodilla.ecommercee.controller.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    UserService userService;

    public Order mapToOrder(OrderDto orderDto) throws UserNotFoundException {
        return new Order(orderDto.getId(),orderDto.getDate(),orderDto.isCompleted(),userService.returnUserById(orderDto.getUserId()).orElseThrow(UserNotFoundException::new));
    }

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto(order.getId(),order.getDate(),order.isCompleted(),order.getUser().getId());
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orders) {
        return  orders.stream()
                .map(o -> new OrderDto(o.getId(),o.getDate(),o.isCompleted(),o.getUser().getId()))
                .collect(Collectors.toList());
    }
}
