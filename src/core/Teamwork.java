package core;


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[7];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        details[0] = "Ouroboros";
        details[1] = "Akbarali";
        details[2] = "Adil";
        details[3] = "17073408";
        details[4] = "Maha Veerachakkravarthi";
        details[5] = "Mohankumaar"; 
        details[6] = "17048038";
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
