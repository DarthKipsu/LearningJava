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
public class Number extends Node {
    
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    public Double getValue(Map variables, Map functions) {
        return value;
    }
    
}