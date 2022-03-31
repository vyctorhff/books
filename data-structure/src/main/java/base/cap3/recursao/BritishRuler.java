/*
 * Created on 16/02/2011, 23:49:01
 * Locate at Parnamirim, Rio Grande do Norte.
 *
 * CasosGerais.java
 *
 * @autor torugo
 */
package base.cap3.recursao;

public class BritishRuler {

    public static final int TICK_WITHOUT_LABEL = -1;

    public void draw(int mainSize) {
        drawOneTick(mainSize, 0);

        for (int count = 1; count <= 3; count++) {
            drawTicks(mainSize - 1);
            drawOneTick(mainSize, count);
        }
    }

    private void drawTicks(int tickLength) {
        if (tickLength > 0) {
            drawTicks(tickLength - 1);
            drawOneTick(tickLength);
            drawTicks(tickLength - 1);
        }
    }

    private void drawOneTick(int tickLength, int tickLabel) {
        System.out.print("-".repeat(tickLength));

        if (tickLabel >= 0) {
            System.out.print(" " + tickLabel);
        }
        System.out.println();
    }

    private void drawOneTick(int tickLength) {
        drawOneTick(tickLength, TICK_WITHOUT_LABEL);
    }
}
