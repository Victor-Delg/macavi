package com.calzadomacavi.macavi.mapeo.repository;

import com.calzadomacavi.macavi.mapeo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}