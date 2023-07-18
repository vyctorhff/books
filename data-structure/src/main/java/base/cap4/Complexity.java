package base.cap4;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Função constante
 * Função linear
 * Função logarítmica
 * Função n-log n
 * Função quadrática
 * Função cúbica
 * Função exponencial
 *
 * Todas elas são funções polinomiais
 *
 * Operações primitiva são aquelas que contam com tempo de 1
 * - atribuição de variável
 * - chamada de métodos
 * - operações aritméticas
 * - comparação de números
 * - acesso a arranjo
 * - seguir referência a objeto
 * - retorno de método
 */
public class Complexity {

    public static void main(String[] args) {
        funcaoConstante(2);
        funcaoLinear(2);
        funcaoLogN(2);
        funcaoNlogN(2);
        funcaoQuadratica(2);
        funcaoCubica(2);
        funcaoExponencial(2);
    }

    private static int funcaoConstante(int param) {
        /**
         * Independente do parametro, o tempo de execução será sempre o mesmo.
         *
         * Gráfico: é um reta paralela com o eixo X
         */
        return 10;
    }

    private static double funcaoLinear(int param) {
        /**
         * Função que cresce de acordo com o parametro
         *
         * Gráfico: É um reta subindo
         */
        return 10 + param;
    }

    private static double funcaoLogN(int param) {
        /**
         * Função que inicia com um número de elements N, mas acada iteração, este número dimunie.
         * Assim a quando de execução começa N, mas quantidade de iteração vai dimunindo.
         *
         * Gráfico: é um curva que começa subindo rápido, mas que fica paralela
         */
        return 0.0;
    }

    private static double funcaoNlogN(int param) {
        /**
         * Combina o tempos de execução do linear mais log N. porém o tempo de exeução
         * e maior que o linear.
         *
         * Gráfico: é uma curva levemente subindo
         */
        return 0.0;
    }

    private static double funcaoQuadratica(int param) {
        /**
         * Função que para cada parametro será executando o número de elementros elevado a 2
         * Gráfico: curvado para cima de forma acentuada
         */

        var array1 = new int[2];
        var array2 = new int[2];

        Arrays.stream(array1).forEach((el1) -> {
            Arrays.stream(array2).forEach((el2) -> {
                System.out.println(el1 + el2);
            });
        });

        return param ^ 2;
    }

    private static double funcaoCubica(int param) {
        /**
         * Função que para cada parametro será executando o número de elementros elevado a 3
         * Deve ser evitado soluções cúbicas.
         *
         * Gráfico: curvado para cima de forma acentuada.
         */
        var array1 = new int[2];
        var array2 = new int[2];
        var array3 = new int[2];

        Arrays.stream(array1).forEach((el1) -> {
            Arrays.stream(array2).forEach((el2) -> {
                Arrays.stream(array3).forEach((el3) -> {
                    System.out.println(el1 + el2 + el3);
                });
            });
        });

        return param ^ 3;
    }

    private static double funcaoExponencial(int param) {
        /**
         * Função com tempo de execução com o número de valores elevado ao número de elementos
         * Só é adimito para baixos número de eleementos, mas deve ser evitado a todo custo.
         *
         * Gráfico: curvado extremamente acentuado
         */

        // Exemplo de código seria a chamada recursiva para a solução do fibonacci.
        // que baseado em um entrada constante, precisa fazer um chamada exponencialmente para
        // obter a solução
        return 0.0;
    }
}
