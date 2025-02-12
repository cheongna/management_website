package com.manager.website.db;

import com.manager.website.entity.IncomeHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeHistoryDatabase extends JpaRepository<IncomeHistoryEntity, Long> {
}
