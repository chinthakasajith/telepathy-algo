package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    public void testDoMathPlus() {
        assertEquals(3.0,new App().doMath(1,2,'+'));
    }

    public void testDoMathMinus() {
        assertEquals(1.0,new App().doMath(2,1,'-'));

        assertEquals(2.0,new App().doMath(1,2,'*'));
        assertEquals(2.0,new App().doMath(4,2,'/'));
    }

    public void testDoMathMultiply() {
        assertEquals(2.0,new App().doMath(1,2,'*'));
    }

    public void testDoMathDevide() {
        assertEquals(2.0,new App().doMath(4,2,'/'));
    }

    public void testCompareBracket() {
        assertFalse(new App().compare('(','+'));
    }

    public void testCompareNotBracket() {
        assertTrue(new App().compare('+','-'));
    }

    public void testEvaluate() {
        Node root = new App().expTree("((15÷(7−(1+1)))×-3)−(2+(1+1))");
        Double v = (Double.parseDouble("0.0"));

        assertEquals(v,new App().evaluate(root));

    }
}
