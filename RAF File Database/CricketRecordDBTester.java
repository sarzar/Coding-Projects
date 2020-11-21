package edu.hdsb.gwss.ics4u.u6;

//TESTER FOR DATABASE
public class CricketRecordDBTester {

    public static void main(String[] args) {

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
        System.out.println("***************************************************");
        
        //TESTING GET ON EMPTY FILE
        System.out.println("Testing get on an empty file....");

        CricketRecordDB.open();

        assert (CricketRecordDB.get(3) == null);
        assert (CricketRecordDB.get("Logan", "White Oaks", 298) == null);

        System.out.println("Case passed!");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        System.out.println("***************************************************");
        
        //TESTING READING WHEN ONLY ONE RECORD
        System.out.println("Testing reading when only one record.....");

        CricketRecord a = new CricketRecord("Joe", "Garth Webb", 228);

        assert (CricketRecordDB.save(a).toString().equals(a.toString()));
        assert (CricketRecordDB.get(1).toString().equals(a.toString()));
        assert (CricketRecordDB.get("Joe", "Garth Webb", 228).toString().equals(a.toString()));

        System.out.println("Case passed!");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        System.out.println("***************************************************");
        
        //TESTING READING FROM MULTIPLE RECORDS
        System.out.println("Testing reading from multiple records.....");

        CricketRecord b = new CricketRecord("Alex", "Garth Webb", 67);

        assert (CricketRecordDB.save(b).toString().equals(b.toString()));
        assert (CricketRecordDB.get(2).toString().equals(b.toString()));
        assert (CricketRecordDB.get("Alex", "Garth Webb", 67).toString().equals(b.toString()));

        System.out.println("Case passed!");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        System.out.println("***************************************************");
        
        //TESTING UPDATING RECORD
        System.out.println("Testing updating record.....");

        b.setPlayerName("Bilal");
        b.setRunsScored(75);

        assert (CricketRecordDB.save(b).toString().equals(b.toString()));
        assert (CricketRecordDB.get(2).toString().equals(b.toString()));
        assert (CricketRecordDB.get("Bilal", "Garth Webb", 75).toString().equals(b.toString()));

        System.out.println("Case passed!");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        System.out.println("***************************************************");
        
        //TESTING SAVING EMPTY RECORD
       
        System.out.println("Testing saving empty record....");

        CricketRecord c = new CricketRecord();

        assert (CricketRecordDB.save(c) == null);
        assert (CricketRecordDB.get(3) == null);
        assert (CricketRecordDB.get(null, null, 0) == null);

        System.out.println("Case Passed!");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
        System.out.println("***************************************************");
        
        //TESTING READING ON CLOSE FILE
        System.out.println("Testing reading on a closed file....");

        CricketRecordDB.close();

        assert (CricketRecordDB.get(1) == null);
        assert (CricketRecordDB.get("Joe", "Garth Webb", 228) == null);

        System.out.println("Case passed!");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("***************************************************");
        
        //TESTING SAVING ON CLOSED FILE
        System.out.println("Testing saving on a close file....");

        assert (CricketRecordDB.save(b) == null);
        assert (CricketRecordDB.get("Alex", "Garth Webb", 67) == null);

        System.out.println("Case Passed!");
        
        System.out.println("***************************************************");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    }

}
