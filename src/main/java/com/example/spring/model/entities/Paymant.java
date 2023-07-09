package com.example.spring.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "tb_payment")
public class Paymant implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    @EqualsAndHashCode.Exclude
    private Instant moment;
    @NonNull
    @EqualsAndHashCode.Exclude
    @OneToOne
    @MapsId
    @JsonIgnore
    private Order order;
}
