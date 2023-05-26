/**
 *  Title      : skilltest.java
 *  Description: A TDD to test the skill function of our engineering
 *
 *  @author  Yuanchi Zhou
 *  @version 1.0
 */

package test;

import control.SkillsControl;
import org.junit.Test;

import static org.junit.Assert.*;

public class skilltest {

    @Test
    public void testskillrequired(){
        // Test if the IsAccquired method correctly reads the general information of the student's skill
        SkillsControl sijin = new SkillsControl("jp2020213326");
        sijin.isAccquired();
        assertEquals(5,sijin.skillslist.size());// There should be 6 skills in the skilllist
        System.out.println("the skill's information of sijin is correct");
        SkillsControl zhaotinghan = new SkillsControl("jp2020213333");
        zhaotinghan.isAccquired();
        assertEquals(4,zhaotinghan.skillslist.size());// There should be 4 skills in the skilllist
        System.out.println("the skill's information of zhaotinghan is correct");
    }
}
