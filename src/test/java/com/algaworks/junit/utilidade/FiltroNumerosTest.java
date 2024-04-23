package com.algaworks.junit.utilidade;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FiltroNumerosTest {

    @Test
    void deveRetornarNumerosPares() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        List<Integer> numerosParesEsperados = Arrays.asList(2, 4);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);

        // compara pelo equals e hashcode da classe e pela ordem dos elementos
        Assertions.assertIterableEquals(numerosParesEsperados, resultadoFiltro);

        Assertions.assertArrayEquals(numerosParesEsperados.toArray(new Object[]{}), resultadoFiltro.toArray(new Object[]{}));

    }
}
