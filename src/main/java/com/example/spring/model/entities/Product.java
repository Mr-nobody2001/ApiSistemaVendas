package com.example.spring.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    @EqualsAndHashCode.Exclude
    private String name;
    @NonNull
    @EqualsAndHashCode.Exclude
    private String description;
    @NonNull
    @EqualsAndHashCode.Exclude
    private Double price;
    @NonNull
    @EqualsAndHashCode.Exclude
    private String imgUrl;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @EqualsAndHashCode.Exclude
    private Set<Category> categories = new HashSet<>();

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.product")
    @EqualsAndHashCode.Exclude
    private Set<OrderItem> orderItems = new HashSet<>();

    public Set<Order> getOrders() {
        Set<Order> orders = new HashSet<>();
        for (OrderItem x : this.orderItems) {
            orders.add(x.getOrder());
        }

        return orders;
    }
}
