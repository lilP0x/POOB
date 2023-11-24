package domain;

import java.awt.Color;


public abstract class Agent{
    
    public final static char UNKNOWN='u', ALIVE='a', DEAD='d';
    protected char state;
    private int age;

    /**Create a new agent
     * 
     */
    public Agent(){
        state=UNKNOWN;
        age=0;
    }


    /**The agent turns one life span old
     * 
     */
    protected void turn(){
        age++;
    }    
    
    
    /** The agent moves
     */
    public abstract void move();
    
    
    /**Returns the age
    @return 
     */   
    public final int getAge(){
        return age;
    }    

    public boolean dead(){
        if (age >= 50){
            state = DEAD;
        }
        return (state==Agent.DEAD);
    }
    
    /**Returns if alive
    @return true, if ALIVE; false, otherwise
     */
    public final boolean isAlive(){
        return (state == Agent.ALIVE) ;
    }
    
}
