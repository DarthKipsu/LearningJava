/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import parser.FunctionInterface;
import parser.Node;
import parser.Number;
import parser.Parser;
import parser.Sum;
import parser.Var;

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
        assertEquals(result, left.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(result, right.getValue(new HashMap(), new HashMap()), 0.01);
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
        
        assertEquals(expected1, num1.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected2, num2.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected3, num3.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected4, num4.getValue(new HashMap(), new HashMap()), 0.01);
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
        
        assertEquals(expected1, num1.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected2, num2.getValue(new HashMap(), new HashMap()), 0.01);
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
        
        assertEquals(expected1, num1.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected2, num2.getValue(new HashMap(), new HashMap()), 0.01);
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
        
        assertEquals(expected1, num1.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected2, num2.getValue(new HashMap(), new HashMap()), 0.01);
    }
    
    @Test
    public void getValue() {
        String input = "1+22+333+4444";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue(new HashMap(), new HashMap());
        Double expected = 4800.0;
        
        assertEquals(expected, value, 0.01);
    }
    
    @Test
    public void substract() {
        String input = "1-2";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue(new HashMap(), new HashMap());
        Double expected = -1.0;
        
        assertEquals(expected, value, 0.01);
    }
    
    @Test
    public void negativeFirstValue() {
        String input = "-1-2";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue(new HashMap(), new HashMap());
        Double expected = -3.0;
        
        assertEquals(expected, value, 0.01);
    }
    
    @Test
    public void parentheses() {
        String input = "1+(2-1)+5";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue(new HashMap(), new HashMap());
        Number num1 = (Number)node.getLeft();
        Number num2 = (Number)node.getRight().getLeft().getLeft();
        Number num3 = (Number)node.getRight().getLeft().getRight();
        Number num4 = (Number)node.getRight().getRight();
        double expected1 = 1.0;
        double expected2 = 2.0;
        double expected3 = 5.0;
        
        assertEquals(expected1, num1.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected2, num2.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected1, num3.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected3, num4.getValue(new HashMap(), new HashMap()), 0.01);
    }
    
    @Test
    public void secondLevelParentheses() {
        String input = "5-(4+(2-1)-1)";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue(new HashMap(), new HashMap());
        Number num1 = (Number)node.getLeft();
        Number num2 = (Number)node.getRight().getLeft();
        Number num3 = (Number)node.getRight().getRight().getRight();
        Number num4 = (Number)node.getRight().getRight().getLeft().getLeft();
        Number num5 = (Number)node.getRight().getRight().getLeft().getRight();
        double expected1 = 1.0;
        double expected2 = 2.0;
        double expected4 = 4.0;
        double expected5 = 5.0;
        
        assertEquals(expected5, num1.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected4, num2.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected1, num3.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected2, num4.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected1, num5.getValue(new HashMap(), new HashMap()), 0.01);
    }
    
    @Test
    public void multiplication() {
        String input = "5 * 2";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue(new HashMap(), new HashMap());
        Number num1 = (Number)node.getLeft();
        Number num2 = (Number)node.getRight();
        double expected1 = 5.0;
        double expected2 = 2.0;
        double expected3 = 10.0;
        
        assertEquals(expected1, num1.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected2, num2.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected3, value, 0.01);
    }
    
    @Test
    public void multiplicatingParentheses() {
        String input = "(1+2) * (4-1)";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue(new HashMap(), new HashMap());
        Number num1 = (Number)node.getLeft().getLeft();
        Number num2 = (Number)node.getLeft().getRight();
        Number num3 = (Number)node.getRight().getLeft();
        Number num4 = (Number)node.getRight().getRight();
        double expected1 = 1.0;
        double expected2 = 2.0;
        double expected4 = 4.0;
        
        assertEquals(expected1, num1.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected2, num2.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected4, num3.getValue(new HashMap(), new HashMap()), 0.01);
        assertEquals(expected1, num4.getValue(new HashMap(), new HashMap()), 0.01);
    }
    
    @Test
    public void severalMultiplicatingWithParentheses() {
        String input = "2+3*(3*4.5*1-5)*(4-2)*3";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue(new HashMap(), new HashMap());
        double expected1 = 155.0;
        
        assertEquals(expected1, value, 0.01);
    }
    
    @Test
    public void division() {
        String input = "1 - 2 * 3 / ( 4.5 + 6 / 2 )";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Double value = node.getValue(new HashMap(), new HashMap());
        double expected1 = 0.2;
        
        assertEquals(expected1, value, 0.01);
    }
    
    @Test
    public void variable() {
        String input = "x + 1";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Map map = new HashMap();
        map.put("x", 5.0);
        Double value = node.getValue(map, new HashMap());
        double expected1 = 6.0;
        
        assertEquals(expected1, value, 0.01);
    }
    
    @Test
    public void multipleVariables() {
        String input = "x * (y + z)";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Map map = new HashMap();
        map.put("x", 5.0);
        map.put("y", 1.5);
        map.put("z", -2.0);
        Double value = node.getValue(map, new HashMap());
        double expected1 = -2.5;
        
        assertEquals(expected1, value, 0.01);
    }
    
    @Test
    public void vairableWithCoefficient() {
        String input = "2x + 1,5y";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Map map = new HashMap();
        map.put("x", -2.5);
        map.put("y", 8.0);
        Number num1 = (Number)node.getLeft().getLeft();
        Var num2 = (Var)node.getLeft().getRight();
        Number num3 = (Number)node.getRight().getLeft();
        Var num4 = (Var)node.getRight().getRight();
        double expected1 = 2.0;
        double expected2 = -2.5;
        double expected3 = 1.5;
        double expected4 = 8.0;
        
        assertEquals(expected1, num1.getValue(map, new HashMap()), 0.01);
        assertEquals(expected2, num2.getValue(map, new HashMap()), 0.01);
        assertEquals(expected3, num3.getValue(map, new HashMap()), 0.01);
        assertEquals(expected4, num4.getValue(map, new HashMap()), 0.01);
    }
    
    @Test
    public void StringVariable() {
        String input = "this + 1";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Map map = new HashMap();
        map.put("this", 5.0);
        Double value = node.getValue(map, new HashMap());
        double expected1 = 6.0;
        
        assertEquals(expected1, value, 0.01);
    }
    
    @Test
    public void square() {
        String input = "pow(3 ; 2)";
        Parser parser = new Parser();
        
        Node node = parser.parse(input);
        Map<String, FunctionInterface> func = new HashMap();
        
        FunctionInterface pow = (children, variables, function) ->
            (Double)Math.pow(
                children.get(0).getValue(variables, function), 
                children.get(1).getValue(variables, function)
            );
 
        
        func.put("pow", pow);
        Double value = node.getValue(new HashMap(), func);
        double expected1 = 9.0;
        
        assertEquals(expected1, value, 0.01);
    }
}