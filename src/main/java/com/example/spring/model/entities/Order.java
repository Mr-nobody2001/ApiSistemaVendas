package com.example.spring.model.entities;

import com.example.spring.model.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "GMT")
    private Instant moment;

    @NonNull
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Integer orderStatus;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order(@NonNull Instant moment, @NonNull OrderStatus orderStatus, @NonNull User client) {
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
}
