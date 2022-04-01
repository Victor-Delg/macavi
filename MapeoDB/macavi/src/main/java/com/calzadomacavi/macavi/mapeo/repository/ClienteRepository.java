package com.calzadomacavi.macavi.mapeo.repository;

import com.calzadomacavi.macavi.mapeo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}