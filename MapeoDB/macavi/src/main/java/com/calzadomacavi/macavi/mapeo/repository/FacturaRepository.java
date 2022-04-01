package com.calzadomacavi.macavi.mapeo.repository;

import com.calzadomacavi.macavi.mapeo.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}