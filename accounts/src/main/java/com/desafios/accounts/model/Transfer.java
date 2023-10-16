package com.desafios.accounts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "tb_transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "from_acc_id")
    private Long fromAccId;

    @Column(nullable = false, name = "to_acc_id")
    private Long toAccId;

    @Column(nullable = false, name = "amount")
    private Double amount;
}
