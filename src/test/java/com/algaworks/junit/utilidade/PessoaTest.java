package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PessoaTest {

    @Test
    void assercaoAgrupada() {   
        Pessoa pessoa = new Pessoa("Alex", "Silva");

        assertAll("Asserções de pessoa",
            () -> assertEquals("Alex", pessoa.getNome()),
            () -> assertEquals("Silva", pessoa.getSobrenome())
        );
    }
}
