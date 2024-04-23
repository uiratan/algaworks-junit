package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SaudacaoUtilTest {
    
    @Test
    void saudarTest() {
        String saudacao = SaudacaoUtil.saudar(9);
        Assertions.assertTrue(saudacao.equals("Bom dia"));
    }
}
