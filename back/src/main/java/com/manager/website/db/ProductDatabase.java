package com.manager.website.db;

import com.manager.website.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDatabase extends JpaRepository<ProductEntity, Long> {
}
