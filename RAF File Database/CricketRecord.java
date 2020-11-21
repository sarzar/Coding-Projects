package edu.hdsb.gwss.ics4u.u6;

//CRICKETRECORD CLASS
public class CricketRecord {

    //CLASS VARIABLES
    public static final int SIZE = 65;
    public static final int LENGTH_PLAYER = 15;
    public static final int LENGTH_TEAM = 12;

    //INSTANCE VARIABLES
    private String playerName;
    private String teamName;
    private char position;
    private int runsScored;
    private int gamesPlayed;
    private long idNumber;
    private boolean isRetired;

    //EMPTY CONSTRUCT TO CREATE DEFAULT CONTAINER
    public CricketRecord() {

    }

    //CONSTRUCTOR THAT TAKES IN PLAYERNAME, TEAMNAME, AND RUNS SCORED
    public CricketRecord(String theplayerName, String teamName, int runsScored) {

        this.setTeamName(teamName);
        this.setGamesPlayed(gamesPlayed);
        this.setPosition(position);
        this.setPlayerName(theplayerName);
        this.runsScored = runsScored;
        this.gamesPlayed = gamesPlayed;
        this.idNumber = -1;
        this.isRetired = isRetired;
    }

    //GETTERS
    //GETS PLAYER NAME
    public String getPlayerName() {
        return playerName;
    }

    //GETS TEAM NAME
    public String getTeamName() {
        return teamName;
    }

    //GETS POSITION
    public char getPosition() {
        return position;
    }

    //GETS GAMES PLAYED
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    //GETS ID NUMBER
    public long getidNumber() {
        return idNumber;
    }

    //GETS RUNS SCORED
    public int getRunsScored() {
        return runsScored;
    }

    //GETS ISRETIRED BOOLEAN
    public boolean isRetired() {
        return isRetired;
    }

    //GETS AVERAGE RUNS PER GAME
    public float getAverageRunsPerGame() {

        //RUNS ONLY IF GAMES PLAYED IS NOT EQUAL TO 0
        if (this.gamesPlayed != 0) {

            //CALCULATES AVERAGE RUNS PER GAME
            return this.runsScored / this.gamesPlayed;

        }
        //DEFAULT RETURN TYPE
        return 0;
    }

    //SETTERS
    //SETS PLAYER NAME
    public void setPlayerName(String playerName) {
        StringBuilder temp = new StringBuilder();

        if (playerName != null) {
            temp.append(playerName.trim());
        } else {
            temp.append("");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_PLAYER);
        this.playerName = temp.toString();
    }

    //SETS TEAM NAME
    public void setTeamName(String teamName) {
        StringBuilder temp = new StringBuilder();

        if (teamName != null) {
            temp.append(teamName.trim());
        } else {
            temp.append("");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_TEAM);
        this.teamName = temp.toString();

    }

    //SETS POSITION [B FOR BOWLER OR BATSMEN, K FOR KEEPER, A FOR ALLROUNDER]
    public void setPosition(char position) {
        if (position == 'b' || position == 'k') {
            this.position = position;
        } else {
            this.position = 'a';
        }
    }

    //SETS RUNS SCORED
    public void setRunsScored(int runsScored) {
        if (runsScored > 0) {
            this.runsScored = runsScored;
        }
    }

    //SETS ISRETIRED VARIABLE
    public void setIsRetired(boolean isRetired) {
        this.isRetired = isRetired;
    }

    //SETS GAMES PLAYED
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    //SETS ID NUMBER
    protected void setIDNumber(long i) {
        this.idNumber = i;
    }

    //CONVERTS OBJECT TO STRING
    public String toString() {

        return "CricketRecord{" + "playerName=" + playerName + ", teamName=" + teamName + ", position=" + position + ", runsScored=" + runsScored + ", gamesPlayed=" + gamesPlayed + ", averageRunsPerGame=" + getAverageRunsPerGame() + ", isRetired=" + isRetired + '}';
    }

}
