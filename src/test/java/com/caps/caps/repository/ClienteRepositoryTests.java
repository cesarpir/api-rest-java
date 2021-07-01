package com.caps.caps.repository;

import com.caps.caps.model.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClienteRepositoryTests {

    @Autowired
    private ClienteRepository repository;

    @Test
    public void insertCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(0L);
        cliente.setName("CESAR ALEXANDRE");
        repository.save(cliente);
        Integer countCliente = repository.findAll().size();
        assertEquals(1, countCliente);
    }
}
