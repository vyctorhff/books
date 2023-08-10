package br.study.base.cap3.recursao;

import br.study.base.cap3.recursao.BritishRuler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BritishRulerTest {

    private BritishRuler ruler;

    @BeforeEach
    void setup() {
        this.ruler = new BritishRuler();
    }

    @Test
    void testDraw() {
        this.ruler.draw(4);
    }
}