package com.manager.website.db;

import com.manager.website.entity.InventoryEntity;
import com.manager.website.entity.InventoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDatabase extends JpaRepository<InventoryEntity, InventoryId> {
}
