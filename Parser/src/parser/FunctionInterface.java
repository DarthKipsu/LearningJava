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

@FunctionalInterface
public interface FunctionInterface {
    
    public Double execute(List<Node> children, Map<String, Double> variables, Map<String, FunctionInterface> functions);
    
}
