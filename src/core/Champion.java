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
public class Champion {
    
    //Fields
    private String Name;
    private int skillLevel;
    private int entryFee;
    private ChampionState State;
    private boolean Magic;
    private boolean Fight;
    private boolean Mystery;
    
    /** Constructor for objects of class Champion
     *
     * @param nme - name of this champion
     * @param skill - skill level of this champion
     * @param fee - fee of this champion
     * @param cState - state of this champion: Active, Dead, or Waiting
     * @param mag - true of this champion has magic and false if otherwise
     * @param fig - true of this champion has fight and false if otherwise
     * @param mys - true of this champion has magic and false if otherwise
     */
    public Champion(String nme, int skill, int fee, ChampionState cState, boolean mag, boolean fig, boolean mys){
        Name = nme;
        skillLevel = skill;
        entryFee = fee;
        State = cState;
        Magic = mag;
        Fight = fig;
        Mystery = mys;
    }
    
    /** Gets the name of champion
     *
     * @return String - name of champion
     */
    public String getChampionName(){
        return Name;
    }
    
    /** Gets the entry fee of champion
     *
     * @return an int - entry fee for a champion
     */
    public int getChampionFee(){
        return entryFee;
    }
    
    /** Gets the skill level of champion
     *
     * @return an int - skill level of a champion
     */
    public int getSkillLevel(){
        return skillLevel;
    }
    
    /** Gets the magic value of champion
     *
     * @return a boolean - true if has magic and false if otherwise
     */
    public boolean getMagic(){
        return Magic;
    }
    
    /**Gets the fight value of this champion
     *
     * @return a boolean - true if has fight and false if otherwise
     */
    public boolean getFight(){
        return Fight;
    }
    
    /** Gets the Mystery value of this champion
     *
     * @return a boolean - true if has magic and false if otherwise
     */
    public boolean getMystery(){
        return Mystery;
    }
    
    /**Gets the Champion State of this champion
     *
     * @return a ChampionState - Dead, Alive or Waiting
     */
    public ChampionState getChampionState(){
        return State;
    }
    
    /** Sets the state of this champion 
     *
     * @param state - either Dead, Alive or Waiting
     */
    public void setChampionState(ChampionState state){
        State = state;
    }
    
    /** Returns all details of this champion
     *
     * @return String - details about this Champion
     */
    @Override
    public String toString(){
        return "\nChampion Name: " + Name + "\nSkill Level: " + skillLevel + "\nEntry Fee: " + entryFee + "\nState:" + State + "\nMagic: " + Magic + "\nFight: " + Fight + "\nMystery: " + Mystery;
    }

}