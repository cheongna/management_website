package com.manager.website.entity;

import com.manager.website.dto.StorageDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "storage")
@NoArgsConstructor
@AllArgsConstructor
public class StorageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private long total_amount;

    @PrePersist
    public void prePersist() {
        this.total_amount = 0;
    }

    public static StorageEntity convertToEntity(StorageDto dto) {
        return new StorageEntity(
                dto.getId(),
                dto.getName(),
                dto.getTotal_amount()
        );
    }
}
