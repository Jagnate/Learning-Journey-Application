package test;

        import control.AchControl;

        import control.CourseControl;

        import control.SkillsControl;

        import org.junit.Test;

        import static org.junit.Assert.*;

public class controltest {

    @Test
    public void testReadCourses() {
        // Test if the readCourses method correctly reads the courses for a given student ID
        CourseControl sijin = new CourseControl("jp2020213326", 2018);
        sijin.readCourses("jp2020213326");
        assertEquals(19, sijin.courselist.size()); // sijin should have 19 courses
        assertTrue(sijin.courseIndex.contains(1)); // sijin should take course with index 1
        assertTrue(sijin.courseIndex.contains(21)); // sijin should take course with index 21
        System.out.println("has read sijin's course");
        CourseControl zhaotinghan = new CourseControl("jp2020213333", 2020);
        zhaotinghan.readCourses("jp2020213333");
        assertEquals(17, zhaotinghan.courselist.size()); // zhaotinghan should have 19 courses
        assertTrue(zhaotinghan.courseIndex.contains(1)); // zhaotinghan should take course with index 1
        assertTrue(zhaotinghan.courseIndex.contains(17)); // zhaotinghan should take course with index 17
        System.out.println("has read zhaotinghan's course");
    }
    @Test
    public void testReadGeneralInfo() {
        // Test if the readGeneralInfo method correctly reads the general information of the courses
        CourseControl sijin = new CourseControl("jp2020213326", 2018);
        sijin.readCourses("jp2020213326");
        assertEquals(19, sijin.courselist.size()); // There should be 19 courses in the course list
        assertEquals("Advanced_Mathematics", sijin.courselist.get(0).getCourseName()); //Advanced_Mathematics should be the first course in the list
        assertEquals(4, sijin.courselist.get(0).getCredit()); // Advanced_Mathematics should have 4 credits
        assertTrue(sijin.courselist.get(0).getCourseType()); // Advanced_Mathematics should be compulsory
        System.out.println("the course's information of sijin is correct");
        CourseControl zhaotinghan = new CourseControl("jp2020213333", 2020);
        zhaotinghan.readCourses("jp2020213333");
        assertEquals(17, zhaotinghan.courselist.size()); // There should be 17 courses in the course list
        assertEquals("Product_Development_and_Marketing", zhaotinghan.courselist.get(15).getCourseName()); //Product_Development_and_Marketing should be the last but not least course in the list
        assertEquals(2, zhaotinghan.courselist.get(15).getCredit()); // Product_Development_and_Marketing should have 2 credits
        assertFalse(zhaotinghan.courselist.get(15).getCourseType()); // Product_Development_and_Marketing should be optional
        System.out.println("the course's information of zhaotinghan is correct");
    }
    @Test
    public void testsuggestedAchs(){
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

    @Test
    public void testIsAccquired() {
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
