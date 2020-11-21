package edu.hdsb.gwss.ics4u.u6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//DATABASE CLASS
public class CricketRecordDB {

    //CLASS VARIABLES
    //VARIABLE USED TO CHECK IF FILE IS OPEN
    static private boolean isOpen;

    //RANDOM ACCESS FILE OBJECT THAT WILL BE USED TO OPEN NEW FILE AND WORK WITH DATA
    static private RandomAccessFile raf;

    //OPENS DATABASE FOR USE
    public static void open() {

        //CREATED NEW FILE BASE ON USER PASSED FILE
        try {
            raf = new RandomAccessFile("cricket_database.dat", "rw");
            
           //UPDATES ISOPEN VARIABLE TO TRUE
           isOpen = true;

        } //CATCHES ALL FILE NOT FOUND EXCEPTIONS
        catch (FileNotFoundException ae) {
            System.out.println("Unable to create file!");
            isOpen = false;
         
        }

    }

    //CLOSES DATABASE
    public static void close() {

        //CLOSES FILE
        try {
            raf.close();

            //UPDATES ISOPEN VARIABLE TO FALSE 
            isOpen = false;
        } //CATCHES IOEXCEPTION IF RAF.CLOSE THROW EXCEPTION
        catch (IOException ae) {
            System.out.println("Error can't close file because file was never created!");
        }

    }

    //SAVES AND UPDATES PREVIOUS FILES DEPENDING ON THE ID NUMBER OF THE RECORD PASSED
    public static CricketRecord save(CricketRecord c) {

        try {

            //DATABASE MUST BE OPEN TO SAVE OR UPDATE RECORD
            if (isOpen && c.getPlayerName() != null) {

                //IF RECORD ID NUMBER IS LESS THAN 1, THEN THAT RECORD IS NOT IN FILE SO IT MOVES THE POINTER TO THE BOTTOM OF THE FILE
                if (c.getidNumber() < 1) {

                    //SETS ID NUMBER OF NEW RECORD ADDED
                    c.setIDNumber(raf.length() / CricketRecord.SIZE + 1);

                    //MOVES POINTER TO END OF FILE
                    raf.seek(raf.length());

                } else {
                    //IF ID NUMBER OF RECORD PASSED IS BIGGER THAN -1 THEN IT MOVES THE POINTER TO THE RECORD THAT NEEDS TO BE UPDATED
                    raf.seek((c.getidNumber() - 1) * CricketRecord.SIZE);

                }

                //WRITES TO THE FILE
                raf.writeChars(c.getPlayerName());
                raf.writeChars(c.getTeamName());
                raf.writeChar(c.getPosition());
                raf.writeInt(c.getRunsScored());
                raf.writeInt(c.getGamesPlayed());
                raf.writeBoolean(c.isRetired());

                //RETURNS RECORD WRITTEN
                return c;
            }

        } //CATCHES IOEXCEPTION IF ERROR WHILE WRITING TO FILE
        catch (IOException ae) {

            System.out.println("Error! Unable to write to file!");
        }

        //DEFAULT RETURN TYPE IS NULL IF NOT RETURNED EARLIER
        return null;
    }

    //RETURNS RECORD TO USER BASED ON THE ID NUMBER PASSED
    public static CricketRecord get(long dbid) {

        try {
            //DATABASE MUST BE OPEN TO GET RECORD
            if (isOpen) {

                //ID NUMBER MUST BE VALID, AND ALREADY WRITTEN IN FILE WHICH IS WHY IT MUST BE ATLEAST 1
                if (dbid >= 1) {

                    //SEEKS TO THE LOCATION OF THE RECORD BASED ON THE ID NUMBER
                    raf.seek((dbid - 1) * CricketRecord.SIZE);

                    CricketRecord c = new CricketRecord();

                    //READS RECORD
                    //LOOP GOING THROUGH ALL CHARACTERS OF STRING THAT STOPS WHEN IT REACHES THE MAXIMUM VALUE OF THE PLAYER NAME LENGTH CONSTANT
                    char str[] = new char[CricketRecord.LENGTH_PLAYER];
                    for (int i = 0; i < CricketRecord.LENGTH_PLAYER; i++) {

                        str[i] = raf.readChar();

                    }

                    c.setPlayerName(new String(str));

                    //LOOP GOING THROUGH ALL CHARACTERS OF STRING THAT STOPS WHEN IT REACHES THE MAXIMUM VALUE OF THE TEAM NAME LENGTH CONSTANT
                    str = new char[CricketRecord.LENGTH_TEAM];
                    for (int i = 0; i < CricketRecord.LENGTH_TEAM; i++) {

                        str[i] = raf.readChar();

                    }

                    c.setTeamName(new String(str));

                    c.setPosition(raf.readChar());
                    c.setRunsScored(raf.readInt());
                    c.setGamesPlayed(raf.readInt());
                    c.setIsRetired(raf.readBoolean());

                    //RETURNS RECORD
                    return c;

                }
            }
        } //CATCHES ALL EXCEPTIONS WHILE TRYING TO READ, INCLUDING INVALID DATA PASSED, AND IOEXCEPTION
        catch (Exception ae) {

            System.out.println("Error! Unable to read from file!");

        }

        //DEAFAULT RETURN VALUE IF NOT RETURNED EARLIER
        return null;
    }

    //RETURNS RECORD BASED ON SECONDARY KEY PASSED BY USER
    public static CricketRecord get(String theplayerName, String teamName, int runsScored) {

        try {
            //DATABASE MUST BE OPEN TO GET RECORD
            if (isOpen) {

                //LOOPS THROUGH ID NUMBERS
                for (int c = 1; c < raf.length(); c++) {

                    //CALLS THE OTHER GETTER THAT TAKES IN ID NUMBER AND STORES WRITTEN RECORD IN A NEW RECORD
                    CricketRecord g = get(c);

                    //COMPARES SECONDARY VALUES PASSED BY USER TO VALUES OF EACH RECORD
                    if (g.getPlayerName().trim().equals(theplayerName) && g.getTeamName().trim().equals(teamName) && g.getRunsScored() == runsScored) {

                        //RETURNS RECORD IF MATCH FOUND
                        return g;
                    }

                }
            }
        } //CATCHES ALL EXCEPTIONS WHILE TRYING TO READ, INCLUDING INVALID DATA PASSED, AND IOEXCEPTION
        catch (Exception ae) {
            System.out.println("Error! Unable to read from file!");
        }

        //DEAFAULT RETURN VALUE IF NOT RETURNED EARLIER
        return null;
    }

}
