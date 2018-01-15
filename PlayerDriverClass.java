package NFL_PlayerClass;

//This is my own work. Chad Galloway
/**  Program: NFL_Player class testing driver
*    File: PlayerDriverClass.java
*    Summary: Implementation and testing of the NFL:_Player class.
*               For simplicity the Human and NFL_Player classes are include in this .java file
*    Author: Chad Galloway
*    Date: Jan. 13, 2018
**/

import java.time.LocalDate;

public class PlayerDriverClass {

    public static void main(String[] args) {
        
        // Constructor tests with toString tests
        NFL_Player player = new NFL_Player("Travis Kelce", LocalDate.of(1989, 10, 5), 79f, 260f, "Westlake, OH", 87, "TE", "Cincinnati", 5, 15, 1038, 0, 83, 8, 0, 0);
        System.out.println("// Constructor tests with toString() tests");
        System.out.println(player.toString());
        System.out.println("");
        
        // Default constructor testing
        NFL_Player player2 = new NFL_Player();
        System.out.println("// Default constructor tests with toString() tests");
        System.out.println(player2.toString());
        System.out.println("");
        
        // set accessor tests on blank default constructor player
        player2.setDOB(LocalDate.of(1972, 6, 27));
        player2.setBirthPlace("Aurora, IL");
        player2.setPlayersNumber(99);
        player2.setHeight(71f);
        player2.setWeight(190f);
        player2.setName("Chad Galloway");
        player2.setCollegeAttended("Grand Canyon University");
        System.out.println("// Set accessor tests using default constructor object");
        System.out.println(player2.toString());
        System.out.println("");
        
        //test get accessors
        System.out.println("// Get accessor tests");
        System.out.print(player.getName());
        System.out.print(", yards: " + player.getYards());
        System.out.print(", completions: " + player.getCompletions());
        System.out.print(", yards/completion: " + String.format("%.1f", player.getYardsPerCompletion()));
        System.out.print(", games: " + player.getGamesPlayed());
        System.out.print(", yards/game: " + String.format("%.1f", player.getYardsPerGame()));
        System.out.print(", completions/game: " + String.format("%.1f", player.getCompletionsPerGame()));
        System.out.println(", TOUCHDOWNS!!!: " + player.getTouchdowns());
        System.out.println("");
        
        
        // test age calculations
        System.out.println("// Test age calculations");
        System.out.print("Today is: " + LocalDate.now());
        player2.setDOB(LocalDate.of(2000, 1, 14));
        System.out.print(", if I was born on this day in the year 2000 I would be: " + player2.getAge());
        player2.setDOB(LocalDate.of(2000, 1, 15));        
        System.out.println(" today, but it I was born a day later I would only be: " + player2.getAge() + " right now.");
        

    }

}
abstract class Human {
    
    // Private properties.
    private String name;
    private LocalDate dob;
    private float height;
    private float weight;
    private String birthPlace;

    // Constructors.
    public Human(String name, LocalDate dob, float height, float weight, String birthPlace) {
        
        this.name = name;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
        this.birthPlace = birthPlace;
    }
    public Human() {
        
        this.name = "";
        this.dob = LocalDate.now();
        this.height = 0f;
        this.weight = 0f;
        this.birthPlace = "";
    }

    // Get accessors.
    public String getName() {
        
        return this.name;
    }
    public LocalDate getDOB() {
        
        return this.dob;
    }
    public float getHeight() {
        
        return this.height;
    }
    public float getWeight() {
        
        return this.weight;
    }
    public String getBirthPlace() {
        
        return this.birthPlace;
    }
    
    // Set accessors.
    public void setName(String newValue) {
        
        this.name = newValue;
    }
    public void setDOB(LocalDate newValue) {
        
        this.dob = newValue;
    }
    public void setHeight(float newValue) {
        
        this.height = newValue;
    }
    public void setWeight(float newValue) {
        
        this.weight = newValue;
    }
    public void setBirthPlace(String newValue) {
        
        this.birthPlace = newValue;
    }

    // Additional get methods
    public int getAge() {
        
        // Get current date for use in calculations.
        LocalDate now = LocalDate.now();
        
        
        // Calculate the base year considered age.
        int age = now.getYear() - dob.getYear();
        
        // Adjust age for month and day born.
        if ( now.getMonthValue() - (dob.getMonthValue()) <= 0 && now.getDayOfMonth() - dob.getDayOfMonth() < 0 ) {
            age--; // Decrease age by one year because they haven't quite reached their birthday yet this year.
        }
        return age;
    }
}

class NFL_Player extends Human {

    private int playersNumber;
    private String positionAbbreviation;
    private String collegeAttended;
    private int yearsExperienceInNFL;
    private int gamesPlayed;
    private int yards;
    private int attempts;
    private int completions;
    private int touchdowns;
    private int fumbles;
    private int interceptions;

    // Constructors
    public NFL_Player(String name, LocalDate dob, float height, float weight, String birthPlace, int playersNumber, String positionAbbreviation, String collegeAttended, 
                        int yearsExperienceInNFL, int gamesPlayed, int yards, int attempts, int completions, int touchdowns, int fumbles, int interceptions) {
        
        super(name, dob, height, weight, birthPlace);
        this.playersNumber = playersNumber;
        this.positionAbbreviation = positionAbbreviation;
        this.collegeAttended = collegeAttended;
        this.yearsExperienceInNFL = yearsExperienceInNFL;
        this.gamesPlayed = gamesPlayed;
        this.yards = yards;
        this.attempts = attempts;
        this.completions = completions;
        this.touchdowns = touchdowns;
        this.fumbles = fumbles;
        this.interceptions = interceptions;
    }
    public NFL_Player() {
        super();
        this.playersNumber = 0;
        this.positionAbbreviation = "";
        this.collegeAttended = "";
        this.yearsExperienceInNFL = 0;
        this.gamesPlayed = 0;
        this.yards = 0;
        this.attempts = 0;
        this.completions = 0;
        this.touchdowns = 0;
        this.fumbles = 0;
        this.interceptions = 0;
    }

    // Get accessors
    public int getPlayersNumber() {

        return this.playersNumber;
    }
    public String getPlayersPosition() {
        
        return this.positionAbbreviation;
    }
    public String getCollegeAttended() {
        
        return this.collegeAttended;
    }
    public int getPlayersExperience() {
        
        return this.yearsExperienceInNFL;
    }
    public int getGamesPlayed() {
        
        return this.gamesPlayed;
    }
    public int getYards() {
        
        return this.yards;
    }
    public int getAttempts() {
        
        return this.attempts;
    }
    public int getCompletions() {
        
        return this.completions;
    }
    public int getTouchdowns() {
        
        return this.touchdowns;
    }
    public int getFumbles() {
        
        return this.fumbles;
    }
    public int getInterceptions() {
        
        return this.interceptions;
    }

    // Set accessors
    public void setPlayersNumber(int newValue) {
        
        this.playersNumber = newValue;
    }
    public void setPlayersPosition(String newValue) {
        
        this.positionAbbreviation = newValue;
    }
    public void setCollegeAttended(String newValue) {
        
        this.collegeAttended = newValue;
    }
    public void setPlayersExperience(int newValue) {
        
        this.yearsExperienceInNFL = newValue;
    }
    public void setGamesPlayed(int newValue) {
        
        this.gamesPlayed = newValue;
    }
    public void setYards(int newValue) {
        
        this.yards = newValue;
    }
    public void setAttempts(int newValue) {
        
        this.attempts = newValue;
    }
    public void setCompletions (int newValue) {
        
        this.completions = newValue;
    }
    public void setTouchdowns(int newValue) {
        
        this.touchdowns = newValue;
    }
    public void setFumbles(int newValue) {
        
        this.fumbles = newValue;
    }
    public void setInterceptions(int newValue) {
        
        this.interceptions = newValue;
    }

    // Aditional get methods.
    public float getYardsPerCompletion() {
         
        return (float)this.yards / (float)this.completions;
    }
    public float getCompletionsPerGame() {
        
        return (float)this.completions / (float)this.gamesPlayed;
    }
    public float getYardsPerGame() {
        
        return (float)this.yards / (float)this.gamesPlayed;
    }
    public float getCompletionPercentage() {
        
        // Divide by zero check
        if ( this.attempts > 0 ) {
            return (float)this.completions / (float)this.attempts;
        }
        
        return 0f;
    }
        
    @Override
    public String toString() {
        
        String s = "";
        s = getName() + "\n#" + getPlayersNumber() + " " + getPlayersPosition() + "\nHeight: " + getHeight() + "in.  Weight: " + getWeight() + "lb.  Age: " + getAge() + 
                "\nBorn: " + getDOB().getMonthValue() + "/" + getDOB().getDayOfMonth() + "/" + getDOB().getYear() + " " + getBirthPlace() + "\nCollege: " + getCollegeAttended() + "\n" + getPlayersExperience() + " Seasons in the NFL.";
        
        return s;
    }
}
