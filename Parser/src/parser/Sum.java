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
public class Sum extends Node {

    public Double getValue(Map variables, Map functions) {
        Double value = this.getLeft().getValue(variables, functions) + this.getRight().getValue(variables, functions);
        return value;
    }
    
}