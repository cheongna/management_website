package com.manager.website.db;

import com.manager.website.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDatabase extends JpaRepository<CompanyEntity, Long> {
}
