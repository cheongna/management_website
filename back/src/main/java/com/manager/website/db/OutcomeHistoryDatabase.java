package com.manager.website.db;

import com.manager.website.entity.OutcomeHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeHistoryDatabase extends JpaRepository<OutcomeHistoryEntity, Long> {
}
