/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parser;

import static org.hamcrest.CoreMatchers.instanceOf;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import parser.Node;
import parser.Parser;
import parser.Sum;
import parser.Number;

/**
 *
 * @author kipsu
 */
public class ParserTest {
    
    public ParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void sum() {
        String input = "2+2";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        double result = 2;
        Number left = (Number)node.getLeft();
        Number right = (Number)node.getRight();
        
        assertThat(node, instanceOf(Sum.class));
        assertEquals(result, left.getValue(), 0.01);
        assertEquals(result, right.getValue(), 0.01);
    }
    
    @Test
    public void sumSeveralNumbers() {
        String input = "1+22+333+4444";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Number num1 = (Number)node.getLeft();
        Number num2 = (Number)node.getRight().getLeft();
        Number num3 = (Number)node.getRight().getRight().getLeft();
        Number num4 = (Number)node.getRight().getRight().getRight();
        double expected1 = 1;
        double expected2 = 22;
        double expected3 = 333;
        double expected4 = 4444;
        
        assertEquals(expected1, num1.getValue(), 0.01);
        assertEquals(expected2, num2.getValue(), 0.01);
        assertEquals(expected3, num3.getValue(), 0.01);
        assertEquals(expected4, num4.getValue(), 0.01);
    }
    
    @Test
    public void sumDoubleNumbers() {
        String input = "5.4+1.0544";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Number num1 = (Number)node.getLeft();
        Number num2 = (Number)node.getRight();
        double expected1 = 5.4;
        double expected2 = 1.0544;
        
        assertEquals(expected1, num1.getValue(), 0.01);
        assertEquals(expected2, num2.getValue(), 0.01);
    }
    
    @Test
    public void sumCommedNumbers() {
        String input = "5,4+1,0544";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Number num1 = (Number)node.getLeft();
        Number num2 = (Number)node.getRight();
        double expected1 = 5.4;
        double expected2 = 1.0544;
        
        assertEquals(expected1, num1.getValue(), 0.01);
        assertEquals(expected2, num2.getValue(), 0.01);
    }
    
    @Test
    public void sumNumbersWithSpaces() {
        String input = "5,4 + 1,0544";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Number num1 = (Number)node.getLeft();
        Number num2 = (Number)node.getRight();
        double expected1 = 5.4;
        double expected2 = 1.0544;
        
        assertEquals(expected1, num1.getValue(), 0.01);
        assertEquals(expected2, num2.getValue(), 0.01);
    }
    
    @Test
    public void getValue() {
        String input = "1+22+333+4444";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue();
        Double expected = 4800.0;
        
        assertEquals(expected, value, 0.01);
    }
}
