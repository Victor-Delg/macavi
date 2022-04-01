package com.calzadomacavi.macavi.repository;

import com.calzadomacavi.macavi.mapeo.domain.TipoDni;
import com.calzadomacavi.macavi.mapeo.repository.TipoDniRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TipoDniRepositoryTest {

    @Autowired// injection de dependencia evita hacer el new
    private TipoDniRepository tipoDniRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void insertar(){
        TipoDni tipoDocumento = new TipoDni();
        tipoDocumento.setId(1);
        tipoDocumento.setNombreDni("cedula de ciudadania");
        this.tipoDniRepository.save(tipoDocumento);

        // consultando en la base de datos el id 1
        Optional<TipoDni> tipoDniOptional = this.tipoDniRepository.findById(1L);
        // existe el documento con el id 1 ?
        assertTrue(!tipoDniOptional.isEmpty());
        // validar que los nombre de documentos sean iguales
        assertEquals(tipoDniOptional.get().getNombreDni(), tipoDocumento.getNombreDni());
    }

    @Test
    @Order(20)
    void update(){
        Optional<TipoDni> tipoDniOptional = this.tipoDniRepository.findById(1L);
        tipoDniOptional.get().setNombreDni("cedula colombiana");
        this.tipoDniRepository.save(tipoDniOptional.get());
        // validar que se actualizo
        tipoDniOptional = this.tipoDniRepository.findById(1L);
        // quedo en la base de datos el nuevo nombre
        assertEquals(tipoDniOptional.get().getNombreDni(), "cedula colombiana");
    }


    @Test
    @Order(30)
    void findAll(){
        List<TipoDni> lista =this.tipoDniRepository.findAll();
        // verifico que la base de datos no esta vacia
        assertTrue(!lista.isEmpty());
    }

    @Test
    @Order(31)
    void findByPrimaryKey(){
        Optional<TipoDni> tipoDniOptional = this.tipoDniRepository.findById(1L);
        // verifica que existe el id 1
        assertTrue(tipoDniOptional.isPresent());

    }

    @Test
    @Order(40)
    void delete(){
        this.tipoDniRepository.deleteById(1L);
        Optional<TipoDni> tipoDniOptional = this.tipoDniRepository.findById(1L);
        // verifica en la base de datos que no exista el id 1
        assertTrue(tipoDniOptional.isEmpty());
    }
}
