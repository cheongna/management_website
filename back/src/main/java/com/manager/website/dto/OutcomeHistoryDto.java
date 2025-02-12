package com.manager.website.dto;

import com.manager.website.entity.OutcomeHistoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutcomeHistoryDto {
    private long id;
    private long amount;
    private long company_id;
    private long manager_id;
    private long product_id;

    public static OutcomeHistoryDto convertToDto(OutcomeHistoryEntity entity) {
        return new OutcomeHistoryDto(
                entity.getId(),
                entity.getAmount(),
                entity.getCompany().getId(),
                entity.getManager().getId(),
                entity.getProduct().getId()
        );
    }
}
