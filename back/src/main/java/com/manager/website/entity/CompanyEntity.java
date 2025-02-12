package com.manager.website.entity;

import com.manager.website.dto.CompanyDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String company_name;

    @Column(nullable = false)
    private String president;

    private String phone;

    private String address;

    public static CompanyEntity convertToEntity(CompanyDto dto) {
        return new CompanyEntity(
                null,
                dto.getCompany_name(),
                dto.getPresident(),
                dto.getPhone(),
                dto.getAddress()
        );
    }
}
