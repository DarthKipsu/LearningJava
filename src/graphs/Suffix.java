/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphs;

/**
 *
 * @author kipsu
 */
public class Suffix {
    
    private String suffix;
    private int i;   // alphabetical index
    private int Si;  // suffix index
    
    public Suffix(String suffixData, int SiData) {
        suffix = suffixData;
        Si = SiData;
    }
    
    public void setIndex(int iData) {
        i = iData;
    }
    
    public String get() {
        return suffix;
    }
    
    public int index() {
        return i;
    }
    
    public int sIndex() {
        return Si;
    }
}
