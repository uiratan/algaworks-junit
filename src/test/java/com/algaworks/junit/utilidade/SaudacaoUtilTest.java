package com.algaworks.junit.utilidade;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SaudacaoUtilTest {
    
    @Test
    void deveSaudarBomDia() {
        String saudacao = saudar(9);
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBomDiaApartir5h() {
        String saudacao = saudar(5);
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBoaTarde() {
        String saudacao = saudar(15);
        assertEquals("Boa tarde", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBoaNoite() {
        String saudacao = saudar(19);
        assertEquals("Boa noite", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBoaNoiteAs4h() {
        String saudacao = saudar(4);
        assertEquals("Boa noite", saudacao, "Saudação incorreta");
    }

    @Test
    void deveLancarException() {
        IllegalArgumentException assertThrows = assertThrows(
            IllegalArgumentException.class, 
            () -> saudar(-10));
        
        assertEquals("Hora inválida", assertThrows.getMessage());
    }

    @Test
    void naoDeveLancarException() {
        assertDoesNotThrow(() -> saudar(0));
    }
}
