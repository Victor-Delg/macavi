package com.calzadomacavi.macavi.mapeo.repository;

import com.calzadomacavi.macavi.mapeo.domain.TipoDni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoDniRepository extends JpaRepository<TipoDni, Long> {
}