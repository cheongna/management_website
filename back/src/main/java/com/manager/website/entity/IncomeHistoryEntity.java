package com.manager.website.entity;

import com.manager.website.db.ProductDatabase;
import com.manager.website.db.UserDatabase;
import com.manager.website.dto.IncomeHistoryDto;
import com.manager.website.service.ProductService;
import com.manager.website.service.UserService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "income_history")
@NoArgsConstructor
@AllArgsConstructor
public class IncomeHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private Long amount;


    @ManyToOne
    @JoinColumn(name = "manager_id")
    private UserEntity manager;

    @CreationTimestamp
    private Timestamp date;

    @PrePersist
    private void prePersist() {
        this.amount = 0L;
    }

    public static IncomeHistoryEntity convertToEntity(IncomeHistoryDto dto, ProductService productService, UserService userService) {
        return new IncomeHistoryEntity(
                null,
                ProductEntity.convertToEntity(productService.findById(dto.getProduct_id())),
                dto.getAmount(),
                userService.findUserById(dto.getManager_id()),
                dto.getDate()
        );
    }
}
