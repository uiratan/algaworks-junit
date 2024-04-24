package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SaudacaoUtilTest {
    
    @Test
    void deveSaudarBomDia() {
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBoaTarde() {
        String saudacao = SaudacaoUtil.saudar(15);
        assertEquals("Boa tarde", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBomNoite() {
        String saudacao = SaudacaoUtil.saudar(19);
        assertEquals("Boa noite", saudacao, "Saudação incorreta");
    }

    @Test
    void deveLancarException() {
        IllegalArgumentException assertThrows = assertThrows(
            IllegalArgumentException.class, 
            () -> SaudacaoUtil.saudar(-10));
        
        assertEquals("Hora inválida", assertThrows.getMessage());
    }

    @Test
    void naoDeveLancarException() {
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
    }
}
