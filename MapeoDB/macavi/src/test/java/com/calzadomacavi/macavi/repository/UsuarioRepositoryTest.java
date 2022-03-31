package com.calzadomacavi.macavi.repository;

import com.calzadomacavi.macavi.mapeo.domain.usuario;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@EnableAutoConfiguration
@Component

public class UsuarioRepositoryTest {

    @Autowired
    private TipoDniRepositoryTest tipoDniRepositoryTest;

    @Autowired
    private UsuarioRepositoryTest usuarioRepositoryTest;

    @Test
    @Order(1)

    void insert(){
        usuario Usuario = new usuario();
        Usuario.setEmail("dm@perroloco.com");
        Usuario.setNombre("deison");
        Usuario.setLoginUsuario("dmanosca");
        Usuario.setId(1);

        this.usuarioRepositoryTest.save(Usuario);


        Optional<usuario> optionalUsuario = this.usuarioRepositoryTest.findByNombre("deison");
        assertTrue(optionalUsuario.isPresent());

    }
}
