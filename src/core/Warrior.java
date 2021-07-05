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
public class Warrior extends Champion{
    
    private String PrefWeapon;
        
    /**Constructor for objects of class Warrior which is a subclass of Champion
     *
     * @param nme - name of this Warrior (inherited from Champion)
     * @param skill - skill level of this Warrior (inherited from Champion)
     * @param fee - entry fee of this Warrior (Inherited from Champion)
     * @param cState - state of this Warrior (Inherited from Champion)
     * @param mag - magic availability of this Warrior. (Inherited from Champion)
     * @param fig - fight availability of this Warrior (Inherited from Champion)
     * @param mys - mystery availability of this Warrior (Inherited from Champion)
     * @param pWeap - the preferred weapon of this Warrior
     */
    public Warrior(String nme, int skill, int fee, ChampionState cState, boolean mag, boolean fig, boolean mys, String pWeap){
        super(nme, skill, fee, cState, mag, fig, mys); // Inherited from Champion class
        PrefWeapon = pWeap;
    }
    
    /** Returns all details of this Warrior
     *
     * @return String - details about this Warrior
     */
    @Override
    public String toString(){
    String s = super.toString() + "\nType: Warrior \nPreferred Weapon: " + PrefWeapon;
    return s;
    }
    
}
