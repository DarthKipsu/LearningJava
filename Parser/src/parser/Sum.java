/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

/**
 *
 * @author kipsu
 */
public class Sum extends Node {

    public Double getValue() {
        Double value = this.getLeft().getValue() + this.getRight().getValue();
        return value;
    }
    
}