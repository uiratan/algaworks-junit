package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SaudacaoUtilTest {
    
    @Test
    void saudarTest() {
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
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
