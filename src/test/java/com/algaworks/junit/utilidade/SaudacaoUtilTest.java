package com.algaworks.junit.utilidade;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

class SaudacaoUtilTest {
    
    // triple A - Arrange, Act, Assert
    
    @Test
    void deveSaudarBomDia() {
        // Arrange
        int horaValida = 9;

        // Act
        String saudacao = saudar(horaValida);

        // Assert
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBomDiaApartir5h() {
        int horaValida = 5;

        String saudacao = saudar(horaValida);

        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBoaTarde() {
        int horaValida = 15;

        String saudacao = saudar(horaValida);

        assertEquals("Boa tarde", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBoaNoite() {
        int horaValida = 19;

        String saudacao = saudar(horaValida);

        assertEquals("Boa noite", saudacao, "Saudação incorreta");
    }

    @Test
    void deveSaudarBoaNoiteAs4h() {
        int horaValida = 4;

        String saudacao = saudar(horaValida);

        assertEquals("Boa noite", saudacao, "Saudação incorreta");
    }

    @Test
    void deveLancarException() {
        // Arrange
        int horaInvalida = -10;

        // Act
        Executable chamadaMetodoInvalida = () -> saudar(horaInvalida);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, chamadaMetodoInvalida);
        
        // Assert
        assertEquals("Hora inválida", e.getMessage());
    }

    @Test
    void naoDeveLancarException() {
        int horaValida = 0;

        Executable  chamadaValidaDeMetodo = () -> saudar(horaValida);
        assertDoesNotThrow(chamadaValidaDeMetodo);
    }
}
