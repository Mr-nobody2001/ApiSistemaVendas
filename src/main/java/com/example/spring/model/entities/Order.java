package com.example.spring.model.entities;

import com.example.spring.model.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "GMT")
    @EqualsAndHashCode.Exclude
    private Instant moment;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @EqualsAndHashCode.Exclude
    private User client;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private Set<OrderItem> orderItems = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Paymant paymant;

    public Order(Instant moment, OrderStatus orderStatus, User client) {
        this.moment = moment;
        this.setOrderStatus(orderStatus);
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(this.orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getValue();
        }
    }

    public double getTotal() {
        double total = 0.0;

        for (OrderItem oi : this.orderItems) {
            total += oi.getSubTotal();
        }

        return total;
    }
}
