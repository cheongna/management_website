package com.manager.website.db;

import com.manager.website.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageDatabase extends JpaRepository<StorageEntity, Long> {
}
