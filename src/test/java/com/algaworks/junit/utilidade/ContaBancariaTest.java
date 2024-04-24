package com.algaworks.junit.utilidade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ContaBancariaTest {
  
    @Nested
    class Saldo {
        @Test
        void saldo() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(10));
            assertEquals(BigDecimal.valueOf(10), contaBancaria.saldo());
        }    

        @Test
        void saldoInicialDaContaNaoDeveSerNulo() {
            IllegalArgumentException assertThrows = assertThrows(
                IllegalArgumentException.class, 
                () -> new ContaBancaria(null));
            
            assertEquals("Valor inválido", assertThrows.getMessage());
        }
    
        @Test
        void saldoInicialPodeSerZero() {
            BigDecimal saldoZero = BigDecimal.ZERO;
            ContaBancaria contaBancaria = new ContaBancaria(saldoZero);
            assertEquals(saldoZero, contaBancaria.saldo());
        }
    
        @Test
        void saldoInicialPodeSerNegativo() {
            BigDecimal saldoNegativo = BigDecimal.valueOf(-10);
            ContaBancaria contaBancaria = new ContaBancaria(saldoNegativo);
            assertEquals(saldoNegativo, contaBancaria.saldo());
        }
    }

    @Nested
    class Deposito {
    
        @Test
        void depositoNaoDeveSerNulo() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
            IllegalArgumentException assertThrows = assertThrows(
                IllegalArgumentException.class, 
                () -> contaBancaria.deposito(null));
            
            assertEquals("Valor inválido", assertThrows.getMessage());
        }
    
        @Test
        void depositoNaoDeveSerZero() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
            IllegalArgumentException assertThrows = assertThrows(
                IllegalArgumentException.class, 
                () -> contaBancaria.deposito(BigDecimal.ZERO));
            
            assertEquals("Valor inválido", assertThrows.getMessage());
        }
    
        @Test
        void depositoNaoDeveSerNegativo() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
            IllegalArgumentException assertThrows = assertThrows(
                IllegalArgumentException.class, 
                () -> contaBancaria.deposito(BigDecimal.valueOf(-10)));
            
            assertEquals("Valor inválido", assertThrows.getMessage());
        }
    
        @Test
        void deposito() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
            contaBancaria.deposito(BigDecimal.valueOf(10));
            assertEquals(BigDecimal.valueOf(10), contaBancaria.saldo());
        }
    }

    @Nested
    class Saque {
        @Test
        void saqueNaoDeveSerNulo() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
            IllegalArgumentException assertThrows = assertThrows(
                IllegalArgumentException.class, 
                () -> contaBancaria.saque(null));
            
            assertEquals("Valor inválido", assertThrows.getMessage());
        }

        @Test
        void saqueNaoDeveSerZero() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
            IllegalArgumentException assertThrows = assertThrows(
                IllegalArgumentException.class, 
                () -> contaBancaria.saque(BigDecimal.ZERO));
            
            assertEquals("Valor inválido", assertThrows.getMessage());
        }

        @Test
        void saqueNaoDeveSerNegativo() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
            IllegalArgumentException assertThrows = assertThrows(
                IllegalArgumentException.class, 
                () -> contaBancaria.saque(BigDecimal.valueOf(-10)));
            
            assertEquals("Valor inválido", assertThrows.getMessage());
        }

        @Test
        void saqueDeveTerSaldo() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
            RuntimeException assertThrows = assertThrows(
                RuntimeException.class, 
                () -> contaBancaria.saque(BigDecimal.valueOf(10)));
            
            assertEquals("Saldo insuficiente", assertThrows.getMessage());
        }

        @Test
        void saque() {
            ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(10));
            contaBancaria.saque(BigDecimal.valueOf(10));
            assertEquals(BigDecimal.ZERO, contaBancaria.saldo());
        }

    }



    
}
