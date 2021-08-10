package com.yalcin.event;
import com.yalcin.entity.Order;
import com.yalcin.entity.User;
import org.springframework.context.ApplicationEvent;

public class SellerProductSuccessEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private User user;
    private Order order;

    public SellerProductSuccessEvent(User user, Order order) {
        super(user);
        this.user = user;
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}