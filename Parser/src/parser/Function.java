/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import java.util.List;
import java.util.Map;

/**
 *
 * @author kipsu
 */
public class Function extends Node {
    
    private final String name;
    private final List children;
    
    public Function(String name, List children) {
        this.name = name;
        this.children = children;
    }
    
    public Double getValue(Map<String, Double> variables, Map<String, FunctionInterface> functions) {
        return functions.get(this.name).execute(this.children, variables, functions);
    }
    
}
