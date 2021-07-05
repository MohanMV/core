/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Adil and Mohan 
 */
public class Dragon extends Champion {
    
    //Fields
    private boolean Talks;
    
    /**Constructor for objects of class Dragon which is a subclass of Champion
     *
     * @param nme - name of this Dragon (inherited from Champion)
     * @param skill - skill level of this Dragon (inherited from Champion)
     * @param fee - entry fee of this Dragon (Inherited from Champion)
     * @param cState - state of this Dragon (Inherited from Champion)
     * @param mag - magic availability of this Dragon. (Inherited from Champion)
     * @param fig - fight availability of this Dragon (Inherited from Champion)
     * @param mys - mystery availability of this Dragon (Inherited from Champion)
     * @param talk - talking ability of this Dragon.
     */
    public Dragon(String nme, int skill, int fee, ChampionState cState, boolean mag, boolean fig, boolean mys, boolean talk){
        super(nme, skill, fee, cState, mag, fig, mys); // will be inherited from parent class Champion
        Talks = talk;
    }
    
    /** Returns all details of this Dragon
     *
     * @return String - details about this Dragon
     */
    @Override
    public String toString(){
    String s = super.toString() + "\nType: Dragon \nTalks: " + Talks;
    return s;
    }
}
