package base.cap4;

/**
 * Função constante
 * Função linear
 * Função logarítmica
 * Função n-log n
 * Função quadrática
 * Função cúbica
 * Função exponencial
 * <p>
 * Todas elas são funções polinomiais
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
         * Gráfico: é um curva que começa subindo rápido, mas que fica paralela
         */
        return 0.0;
    }

    private static double funcaoNlogN(int param) {
        /**
         * Gráfico: é uma curva levemente subindo
         */
        return 0.0;
    }

    private static double funcaoQuadratica(int param) {
        /**
         * Função que para cada parametro será executando o número de elementros elevado a 2
         * Gráfico: curvado para cima de forma acentuada
         */
        return param ^ 2;
    }

    private static double funcaoCubica(int param) {
        /**
         * Função que para cada parametro será executando o número de elementros elevado a 3
         * Deve ser evitado soluções cúbicas.
         *
         * Gráfico: curvado para cima de forma acentuada.
         */
        return 0.0;
    }

    private static double funcaoExponencial(int param) {
        /**
         * Função com tempo de execução com o número de valores elevado ao número de elementos
         * Só é adimito para baixos número de eleementos, mas deve ser evitado a todo custo.
         *
         * Gráfico: curvado extremamente acentuado
         */
        return 0.0;
    }
}
