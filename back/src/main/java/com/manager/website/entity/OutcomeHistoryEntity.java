package com.manager.website.entity;

import com.manager.website.dto.OutcomeHistoryDto;
import com.manager.website.service.CompanyService;
import com.manager.website.service.ProductService;
import com.manager.website.service.UserService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "outcome_history")
@NoArgsConstructor
@AllArgsConstructor
public class OutcomeHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private UserEntity manager;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @PrePersist
    private void prePersist() {
        this.amount = 0L;
    }

    public static OutcomeHistoryEntity convertToEntity(OutcomeHistoryDto dto, CompanyService companyService, UserService userService, ProductService productService) {
        return new OutcomeHistoryEntity(
                null,
                dto.getAmount(),
                ProductEntity.convertToEntity(productService.findById(dto.getProduct_id())),
                userService.findUserById(dto.getManager_id()),
                CompanyEntity.convertToEntity(companyService.findById(dto.getCompany_id()))
        );
    }
}
