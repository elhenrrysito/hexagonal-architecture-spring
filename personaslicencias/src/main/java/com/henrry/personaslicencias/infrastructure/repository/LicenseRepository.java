package com.henrry.personaslicencias.infrastructure.repository;

import com.henrry.personaslicencias.infrastructure.entity.License;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends BaseRepository<License> {
    List<License> findTopByOrderByNumberDesc();
}
