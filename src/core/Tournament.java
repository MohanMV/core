package core;
import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from the CORE
* as required for 6COM1037 Cwk Assignment - Nov 2020
 * 
 * @author Adil and Mohan
 * @version 05/10/20
 */

public class Tournament implements CORE
{
    // Fields
    private String playerName;
    private int Treasury;
    private ArrayList<Champion> championList;
    private ArrayList<Challenge> challengeList;
    
    
    //**************** CORE ************************** 
    /** Constructor requires the name of the player
     * @param pl the name of the player
     */  
    public Tournament(String pl)
    {
       playerName = pl; //Store pl in playerName
       Treasury = 1000; //Set Treasury to 10000
       championList = new ArrayList<Champion>(); //Set an ArrayList for champions
       challengeList = new ArrayList<Challenge>(); //Set an ArrayList for challenges
       
       setUpChampions(); // initialize champions
       setUpChallenges(); // initialize challenges 
       
    }
    
    
    //******* Implements interface CORE *******************
    /**Returns a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * 
     * @return a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     */
    public String toString() {
        String output = "";
        String champList = "";
        output += "\nPlayer Name: " + playerName + "\nGulden: " + Treasury + "\n"; //store game details in output
        if(isDefeated() == false){
            output += "\nIs OK"; // If player is not defeated then add "Is OK" to output
        }
        else{
            output += "\nIs Defeated"; // If player is defeated then add "is defeated" to output
        }
        for(int i=0; i<championList.size(); i++){ //For loop on the ChampionList
             if(championList.get(i).getChampionState() == ChampionState.ACTIVE){ //if champion's state is Active 
                champList += championList.get(i).toString() + "\n"; // add that champions details to ChampList
             }
         }
         if(champList.equals("")){ // if champList is empty 
             champList = "No champions"; // add "No Champions" to champList
         }
        return output + "\n" + champList; // return output and ChampList
     }
  
    /** returns true if Treasury <=0 and the player's team has no 
     * champions which can be withdrawn. 
     * @returns False if Treasury >=0 and the player's team has 
     * champions which can be decommissioned. 
     */
    public boolean isDefeated(){
        if(Treasury <= 0){ // If we have 0 or less Gulden
         for(int i=0; i<championList.size(); i++){ // For loop on the ChampionList
             if(championList.get(i).getChampionState() == ChampionState.ACTIVE){ // If the Champion in this posiiton of the array has their State set as Active
                 return false; // Player is not defeated
             }
         }
         return true; //Player is defeated
        }
       return false; //Player is not defeated
    }
    
    /** returns the amount of money in the Treasury
     * @returns the amount of money in the Treasury
     */
    public int getMoney(){
       return Treasury;
    }    
    
    /**Returns a String representation of all champions in reserve
     * @return a String representation of all champions in reserve
     **/
    public String getReserve(){
        String output = "";
        for(int i=0; i<championList.size(); i++){ //Loop through the list of Champions
            if(championList.get(i).getChampionState() == ChampionState.WAITING){ //If the Champion state is Waiting
                output += championList.get(i).toString() + "\n"; // Store the toString of the Champion object in output
            }
        }
       return output; // return output
    }
       
    /** Returns details of any champion with the given name
     * @return details of any champion with the given name
     **/
    public String getChampionDetails(String nme){
        for(int i=0; i<championList.size(); i++){ //Loop through the list of Champions
            if(nme.equals(championList.get(i).getChampionName())){ //If the Champion name matches the parameter
                return championList.get(i).toString(); //Return the toString of the Champion object
            }
        }
       return ""; //Else return nothing
    }
    
    /** returns whether champion is in reserve
    * @param champion's name
    * @return true if champion in reserve, false otherwise
    */
    public boolean isInReserve(String nme) {
        for(int i=0; i<championList.size(); i++){ //Loop through the list of Champions
            if(nme.equals(championList.get(i).getChampionName())){ //If the Champion name matches the parameter
                if(championList.get(i).getChampionState() == ChampionState.WAITING) // if Champion state is Waiting return true else return false
                return true;
            }
        }
        return false;
    }
    
 // ***************** Players Team************************   
    /** Allows a champion to be entered for the player's team, if there 
     * is enough money in the Treasury for the entry fee.The champion's 
     * state is set to "active"
     * 0 if champion is entered in the player's team, 
     * 1 if champion is not in reserve, 
     * 2 if not enough money in the treasury, 
     * -1 if there is no such champion 
     * @param nme represents the name of the champion
     * @return as shown above
     **/        
    public int enterChampion(String nme){
        for(int i=0; i<championList.size(); i++){ //Loop through the list of Champions
            if(nme.equals(championList.get(i).getChampionName())){//If the Champion name matches the parameter
                if(championList.get(i).getChampionState() == ChampionState.WAITING){ // if that champion's state is waiting
                    if(Treasury >= championList.get(i).getChampionFee()){// if the player's treasury is more that that champion's fee
                        championList.get(i).setChampionState(ChampionState.ACTIVE);// change the champions state to Active
                        Treasury -= championList.get(i).getChampionFee(); // deduct the player's treasury according to the champion's fee
                        return 0; // return 0
                    }
                    else{
                        return 2; // return 2
                    }
                }
                if(championList.get(i).getChampionState() == ChampionState.DEAD || championList.get(i).getChampionState() == ChampionState.ACTIVE){ // if champion's state is DEAD or if champion's state is Active 
                    return 1; // return 1
                }
            }
        }
       return -1; // return -1
    }
    
        
    /** Returns true if the champion with the name is in 
     * the player's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the player's team, false otherwise.
     **/
    public boolean isInPlayersTeam(String nme){
        for(int i=0; i<championList.size(); i++){ //Loop through the list of Champions
            if(nme.equals(championList.get(i).getChampionName())){ //If the Champion name matches the parameter
                if(championList.get(i).getChampionState() == ChampionState.ACTIVE) //if that champion's state is Active 
                return true; // return true
            }
        }
       return false; // return false
    }
    
    
    /** Removes a champion from the team to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is retired to reserves
     * 1 - if champion not retired because dead
     * 2 - if champion not retired because not in team
     * -1 - if no such champion
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int retireChampion(String nme){
        for(int i=0; i<championList.size(); i++){ //Loop through the list of Champions
            if(nme.equals(championList.get(i).getChampionName())){ //If the Champion name matches the parameter
                if(championList.get(i).getChampionState() == ChampionState.ACTIVE){ //if that champion's state is Active 
                championList.get(i).setChampionState(ChampionState.WAITING); //set that champion's state to Waiting
                Treasury += (championList.get(i).getChampionFee() / 2); // add half of that champion's fee to the treasury
                return 0; // return 0
                }
                if(championList.get(i).getChampionState() == ChampionState.DEAD){ // if that champion's state is dead return 1
                    return 1;
                }
                if(championList.get(i).getChampionState() == ChampionState.WAITING){ // if that champion's state is Waiting return 2
                    return 2;
                }
            }
        }
       return -1; // return -1 if champion name doesn't match parameter
    }
        
        
    /**Returns a String representation of the champions in the player's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the player's team
     **/
    public String getTeam(){
        String output = ""; //declare string variable and set it to an empty string
        for(int i=0; i<championList.size(); i++){ //Loop through the list of Champions
            if(championList.get(i).getChampionState() == ChampionState.ACTIVE){ //if that champion's state is Active
                output += championList.get(i).toString(); // add that champion's details to output
            }
        }
        if(output.equals("")){ // if output is empty 
            return "No champions entered."; //return "No champions entered
        }
       return output; //return output
    }
    
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the number of the challenge
     * @returns true if the number represents a challenge
     **/
     public boolean isChallenge(int num){
        for(int i=0; i<challengeList.size(); i++){ //For loop on the ChallengeList
            if(challengeList.get(i).getChallengeNo() == num){ // if challenge number matches the parameter
                return true; //return true
            }
        }  
       return false; // return false
    }
     
    /** Provides a String representation of an challenge given by 
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num){
        for(int i=0; i<challengeList.size(); i++){ //For loop on the ChallengeList
            if(challengeList.get(i).getChallengeNo() == num){ // if challenge number matches the parameter
                return challengeList.get(i).toString(); // return all details of that challenge
            }
        }  
       return "\nChallenge Not Found."; // if challenge number does not match parameter return "Challenge not found".
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges(){
        String output = "";//declare a string variable and set it to an empty string
        for(int i=0; i<challengeList.size(); i++){ //For loop on the ChallengeList
                output += challengeList.get(i).toString();// add challenge details to output    
        }
       return output;// return output
    }
    
    /** Retrieves the challenge represented by the challenge 
     * number.Finds a champion from the team which can challenge the 
     * challenge. The results of fighting an challenge will be 
     * one of the following:  
     * 0 - challenge won, add reward to the treasury, 
     * 1 - challenge lost on battle skills  - deduct reward from
     * treasury and record champion as "dead"
     * 2 - challenge lost as no suitable champion is  available, deduct
     * the reward from treasury 
     * 3 - If a challenge is lost and player completely defeated (no money and 
     * no champions to withdraw) 
     * -1 - no such challenge 
     * @param chalNo is the number of the challenge
     * @return an int showing the result(as above) of fighting the challenge
     */ 
    public int fightChallenge(int chalNo){
        for(int i=0; i<challengeList.size(); i++){ //For loop on the ChallengeList
            if(challengeList.get(i).getChallengeNo() == chalNo){ // if challenge number matches parameter
                ChallengeType type = challengeList.get(i).getType(); //store challenge type in variable 
                for(int j=0; j<championList.size(); j++){ // for loop through ChampionList
                    if(championList.get(j).getChampionState() == ChampionState.ACTIVE){ // if state of champion is Active
                        if(type == ChallengeType.MAGIC){ // if challenge type stored is magic
                            if(championList.get(j).getMagic() == true){ // if champion is has magic 
                                if(championList.get(j).getSkillLevel() >= challengeList.get(i).getSkillReq()){ // if champion's skill level is more than the skill required of the challenge
                                    Treasury += challengeList.get(i).getReward(); //add money to treasury
                                    if(isDefeated() == true){ // if player is defeated 
                                        return 3; // return 3
                                    }
                                    return 0;// if player is not defeated return 0
                                }
                                else{ // if champions skill level is <= challenges skill required than deduct money from treasury according to the reward
                                    Treasury -= challengeList.get(i).getReward(); //remove money from treasury
                                    championList.get(j).setChampionState(ChampionState.DEAD);//kill champion
                                    return 1;
                                }
                            }
                        }
                        if(type == ChallengeType.FIGHT){// if challenge type stored is fight
                            if(championList.get(j).getFight() == true){ // if champion is has fight
                                if(championList.get(j).getSkillLevel() >= challengeList.get(i).getSkillReq()){// if champion's skill level is more than the skill required of the challenge
                                    Treasury += challengeList.get(i).getReward(); //add money to treasury
                                    if(isDefeated() == true){// if player is defeated return 3
                                        return 3;
                                    }
                                    return 0;// if player is not defeated return 0
                                }
                                else{ // if champions skill level is <= challenges skill required than deduct money from treasury according to the reward
                                    Treasury -= challengeList.get(i).getReward(); //remove money from treasury
                                    championList.get(j).setChampionState(ChampionState.DEAD);//kill champion
                                    return 1;
                                }
                            }
                        }
                        if(type == ChallengeType.MYSTERY){// if challenge type stored is Mystery
                            if(championList.get(j).getMystery() == true){ // if champion is has Mystery
                                if(championList.get(j).getSkillLevel() >= challengeList.get(i).getSkillReq()){// if champion's skill level is more than the skill required of the challenge
                                    Treasury += challengeList.get(i).getReward(); //add money to treasury
                                    if(isDefeated() == true){// if player is defeated return 3
                                        return 3;
                                    }
                                    return 0;
                                }
                                else{// if champions skill level is <= challenges skill required than deduct money from treasury according to the reward
                                    Treasury -= challengeList.get(i).getReward(); //remove money from treasury
                                    championList.get(j).setChampionState(ChampionState.DEAD);//kill champion
                                    return 1;
                                }
                            }
                        }     
                    }
                }
                Treasury -= challengeList.get(i).getReward(); //deduct money
                return 2;
            }
         }
       return -1;
    }
  
// These methods are not needed until Task 4.4
    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    public void saveGame(String fname){
        
       
    }
    
    /** reads all information about the game from the specified file 
     * and returns a CORE reference to a Tournament object
     * @param fname name of file storing the game
     * @return the game (as a Tournament object)
     */
    public CORE loadGame(String fname){
        
       return null;
    }
    
    /**
     * reads challenges from a comma-separated textfile and stores
     * @param filename of the comma-separated textfile storing information about challenges
     */
    public void readChallenges(String filename){
        
    }
    
    private void setUpChampions() {
        
        //create objects of Champions according to the Assignment Case Study and add them to ChampionList
        Champion champ1 = new Wizard("Ganfrank", 7, 400, ChampionState.WAITING, true, true, true, true, "Transmutation");
        Champion champ2 = new Wizard("Rudolf", 6, 400, ChampionState.WAITING, true, true, true, true, "Invisibility");
        Champion champ3 = new Warrior("Elblond", 1, 150, ChampionState.WAITING, false, true, false, "Sword");
        Champion champ4 = new Warrior("Flimsi", 2, 200, ChampionState.WAITING, false, true, false, "Bow");
        Champion champ5 = new Dragon("Drabina", 7, 500, ChampionState.WAITING, false, true, false,  false);
        Champion champ6 = new Dragon("Golum", 7, 500, ChampionState.WAITING, false, true, false, true);
        Champion champ7 = new Warrior("Argon", 9, 900, ChampionState.WAITING, false, true, false, "Mace");
        Champion champ8 = new Wizard("Neon", 2, 300, ChampionState.WAITING, true, true, true, false, "Translocation");
        Champion champ9 = new Dragon("Xenon", 7, 500, ChampionState.WAITING, false, true, false ,true);
        Champion champ10 = new Warrior("Atlanta", 5, 500, ChampionState.WAITING, false, true, false, "Bow");
        Champion champ11 = new Wizard("Krypton", 8, 300, ChampionState.WAITING, true, true, true, false, "Fireballs");
        Champion champ12 = new Wizard("Hedwig", 1, 400, ChampionState.WAITING, true, true, true, true, "Flying");

        championList.add(champ1);
        championList.add(champ2);
        championList.add(champ3);
        championList.add(champ4);
        championList.add(champ5);
        championList.add(champ6);
        championList.add(champ7);
        championList.add(champ8);
        championList.add(champ9);
        championList.add(champ10);
        championList.add(champ11);
        championList.add(champ12);
    }
    
    private void setUpChallenges(){
        
        //create objects of Challenges according to the Assignment Case Study and add them to ChallengeList
        Challenge challenge1 = new Challenge(1, ChallengeType.MAGIC, "Borg", 3, 100);
        Challenge challenge2 = new Challenge(2, ChallengeType.FIGHT, "Huns", 3, 120);
        Challenge challenge3 = new Challenge(3, ChallengeType.MYSTERY, "Ferengi", 3, 150);
        Challenge challenge4 = new Challenge(4, ChallengeType.MAGIC, "Vandal", 9, 200);
        Challenge challenge5 = new Challenge(5, ChallengeType.MYSTERY, "Borg", 7, 90);
        Challenge challenge6 = new Challenge(6, ChallengeType.FIGHT, "Goth", 8, 45);
        Challenge challenge7 = new Challenge(7, ChallengeType.MAGIC, "Frank", 10, 200);
        Challenge challenge8 = new Challenge(8, ChallengeType.FIGHT, "Sith", 10, 170);
        Challenge challenge9 = new Challenge(9, ChallengeType.MYSTERY, "Cardashian", 9, 300);
        Challenge challenge10 = new Challenge(10, ChallengeType.FIGHT, "Jute", 2, 300);
        Challenge challenge11 = new Challenge(11, ChallengeType.MAGIC, "Celt", 2, 250);
        Challenge challenge12 = new Challenge(12, ChallengeType.MYSTERY, "Celt", 1, 250);

        challengeList.add(challenge1);
        challengeList.add(challenge2);
        challengeList.add(challenge3);
        challengeList.add(challenge4);
        challengeList.add(challenge5);
        challengeList.add(challenge6);
        challengeList.add(challenge7);
        challengeList.add(challenge8);
        challengeList.add(challenge9);
        challengeList.add(challenge10);
        challengeList.add(challenge11);
        challengeList.add(challenge12);
    }
}



