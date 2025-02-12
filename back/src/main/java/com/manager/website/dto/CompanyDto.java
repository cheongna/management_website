package com.manager.website.dto;

import com.manager.website.entity.CompanyEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private long id;
    private String address;
    private String company_name;
    private String phone;
    private String president;

    public static CompanyDto convertToDto(CompanyEntity entity) {
        return new CompanyDto(
                entity.getId(),
                entity.getAddress(),
                entity.getCompany_name(),
                entity.getPhone(),
                entity.getPresident()
        );
    }
}
