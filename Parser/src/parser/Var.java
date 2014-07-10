/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import java.util.Map;

/**
 *
 * @author kipsu
 */
public class Var extends Node {
    
    private final String name;
    
    public Var(String name) {
        this.name = name;
    }

    public Double getValue(Map variables, Map functions) {
        return (Double)variables.get(name);
    }
}
