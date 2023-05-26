package test;

import control.AchControl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class achtest {

    @Test
    public void suggestedinfo(){
        // Test if the suggestedAch method correctly reads the general information of the Ach
        AchControl sijin = new AchControl("jp2020213326");
        sijin.suggestedAchs();
        assertEquals(4,sijin.suggestedList.size());//sijin should have 4 suggested achievement
        assertEquals("MathematicalContestInModeling",sijin.suggestedList.get(0));//sijin should have the "NationalEnglishContestforCollegeStudents" achievement
        System.out.println("all of sijin's achievement has read and correct");
        AchControl zhaotinghan = new AchControl("jp2020213333");
        zhaotinghan.suggestedAchs();
        assertEquals(7,zhaotinghan.suggestedList.size());//zhaotinghan should have 7 suggested achievement
        assertEquals("CommunicationNetworkDeploymentDesignCompetition",zhaotinghan.suggestedList.get(6));//zhaotinghan should have the "CommunicationNetworkDeploymentDesignCompetition" achievement
        System.out.println("all of zhaotinghan's achievement has read and correct");
    }
}
