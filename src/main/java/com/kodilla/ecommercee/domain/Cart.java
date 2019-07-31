package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(targetEntity = Product.class, mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList;
}

