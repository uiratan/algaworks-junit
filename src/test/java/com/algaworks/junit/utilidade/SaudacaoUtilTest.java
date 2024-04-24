package com.algaworks.junit.utilidade;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SaudacaoUtilTest {
    
    // triple A - Arrange, Act, Assert
    
    @Test
    void Dado_um_horario_matutino_Quando_saudar_Entao_deve_retornar_bom_dia() {
        // Arrange
        int horaValida = 9;

        // Act
        String saudacao = saudar(horaValida);

        // Assert
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    @DisplayName("Deve saudar com boa dia às 5h")
    void deveSaudarBomDiaApartir5h() {
        int horaValida = 5;

        String saudacao = saudar(horaValida);

        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    void Dado_um_horario_vespertino_Quando_saudar_Entao_deve_retornar_boa_tarde() {
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
    void Dado_um_horario_noturno_Quando_saudar_Entao_deve_retornar_boa_noite() {
        int horaValida = 4;

        String saudacao = saudar(horaValida);

        assertEquals("Boa noite", saudacao, "Saudação incorreta");
    }

    @Test
    void Dado_uma_hora_invalida_Quando_saudar_Entao_deve_lancar_Exception() {
        // Arrange
        int horaInvalida = -10;

        // Act
        Executable chamadaMetodoInvalida = () -> saudar(horaInvalida);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, chamadaMetodoInvalida);
        
        // Assert
        assertEquals("Hora inválida", e.getMessage());
    }

    @Test
    void Dado_uma_hora_valida_Quando_saudar_Entao_nao_deve_lancar_exception() {
        int horaValida = 0;

        Executable  chamadaValidaDeMetodo = () -> saudar(horaValida);
        assertDoesNotThrow(chamadaValidaDeMetodo);
    }
}
