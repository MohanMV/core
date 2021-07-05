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
public class Wizard extends Champion {
    
    private boolean Necromancer;
    private String Spell;
    
    /**Constructor for objects of class Wizard which is a subclass of Champion
     *
     * @param nme - name of this Wizard (inherited from Champion)
     * @param skill - skill level of this Wizard (inherited from Champion)
     * @param fee - entry fee of this Wizard (Inherited from Champion)
     * @param cState - state of this Wizard (Inherited from Champion)
     * @param mag - magic availability of this Wizard. (Inherited from Champion)
     * @param fig - fight availability of this Wizard. (Inherited from Champion)
     * @param mys - mystery availability of this Wizard. (Inherited from Champion)
     * @param nec - Necromancer presence of this Wizard. 
     * @param spl - spell speciality of this Wizard.
    */
    public Wizard(String nme, int skill, int fee, ChampionState cState, boolean mag, boolean fig, boolean mys, boolean nec, String spl){
        super(nme, skill, fee, cState, mag, fig, mys); // Inherited from parent class Champion
        Necromancer = nec;
        Spell = spl;
    }
    
    /** Returns all details of this Wizard
     *
     * @return String - details about this Wizard
    */
    @Override
    public String toString(){
        String s = super.toString() + "\nType: Wizard \nNecromancer: " + Necromancer + "\nSpell: " + Spell;
        return s;
    }
}
