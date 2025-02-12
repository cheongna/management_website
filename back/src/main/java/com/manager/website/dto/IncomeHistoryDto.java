package com.manager.website.dto;

import com.manager.website.entity.IncomeHistoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeHistoryDto {
    private long id;
    private long amount;
    private Timestamp date;
    private long product_id;
    private long manager_id;

    public static IncomeHistoryDto convertToDto(IncomeHistoryEntity entity) {
        return new IncomeHistoryDto(
                entity.getId(),
                entity.getAmount(),
                entity.getDate(),
                entity.getProduct().getId(),
                entity.getManager().getId()
        );
    }
}
