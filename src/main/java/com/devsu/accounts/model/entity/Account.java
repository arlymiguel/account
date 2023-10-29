package com.devsu.accounts.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String accountNumber;   

    private String type;
    
    private Double initialBalance;
    
    private boolean state;
    
    @Column(name="client_id")
    private Long clientId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Movement> movements;
    
}