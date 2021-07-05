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
public class Challenge {
    
    private int ChallengeNo;
    private ChallengeType Type;
    private String Enemy;
    private int SkillRequired;
    private int Reward;
    
    /** Constructor for objects of class Challenge
     *
     * @param cNo - challenge number of this challenge
     * @param typ - challenge type of this challenge: magic, fight, mystery
     * @param enmy - enemy name of this challenge
     * @param SklReq - skill required by champion to fight this challenge 
     * @param rew - reward money in gulden for this challenge
     */
    public Challenge(int cNo, ChallengeType typ, String enmy, int SklReq, int rew){
        
        ChallengeNo = cNo;
        Type = typ;
        Enemy = enmy;
        SkillRequired = SklReq;
        Reward = rew;
    }
    
    /** Retrieves challenge number
     *
     * @return an int - Challenge Number
     */
    public int getChallengeNo(){
        return ChallengeNo;
    }
    
    /** Retrieves Skill Required 
     *
     * @return an int - Skill Required
     */
    public int getSkillReq(){
        return SkillRequired;
    }
    
    /**Retrieves Reward
     *
     * @return an int - Reward
     */
    public int getReward(){
        return Reward;
    }
    
    /**Retrieves challenge type
     *
     * @return a Challenge Type - Type
     */
    public ChallengeType getType(){
        return Type;
    }
    
    /**Returns all details of this challenge
     *
     * @return String - details about this challenge
     */
    @Override
    public String toString(){
        return "\nChallenge Number: " + ChallengeNo + "\nChallenge Type: " + Type + "\nEnemy: " + Enemy + "\nSkill Required: " + SkillRequired + "\nReward: " + Reward;
    }
}
