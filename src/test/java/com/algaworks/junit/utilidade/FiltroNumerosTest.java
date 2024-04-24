package com.algaworks.junit.utilidade;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FiltroNumerosTest {

    // BDD - behavior driven develpment
    // Given, When, Then = Dado, Quando, Então

    @Test
    void Dado_uma_lista_de_numeros_Quando_filtrar_por_pares_Entao_deve_retornar_apenas_numeros_pares() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        List<Integer> numerosParesEsperados = Arrays.asList(2, 4);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);

        // compara pelo equals e hashcode da classe e pela ordem dos elementos
        Assertions.assertIterableEquals(numerosParesEsperados, resultadoFiltro);

        Assertions.assertArrayEquals(numerosParesEsperados.toArray(new Object[]{}), resultadoFiltro.toArray(new Object[]{}));

    }

    @Test
    void Dado_uma_lista_de_numeros_Quando_filtrar_por_impares_Entao_deve_retornar_apenas_numeros_impares() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        List<Integer> numerosImaresEsperados = Arrays.asList(1, 3);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosImpares(numeros);

        // compara pelo equals e hashcode da classe e pela ordem dos elementos
        Assertions.assertIterableEquals(numerosImaresEsperados, resultadoFiltro);

        Assertions.assertArrayEquals(numerosImaresEsperados.toArray(new Object[]{}), resultadoFiltro.toArray(new Object[]{}));

    }
}
