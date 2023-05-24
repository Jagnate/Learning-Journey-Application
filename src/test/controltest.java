


package test;
import control.CourseControl;
import control.SkillsControl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class controltest {

    @Test
    public void testReadCourses() {
        // Test if the readCourses method correctly reads the courses for a given student ID
        CourseControl sijin = new CourseControl("jp2020213326", 2018);
        sijin.readCourses("jp2020213326");
        assertEquals(6, sijin.courselist.size()); // jp2020213326 should have 3 courses
        assertTrue(sijin.courseIndex.contains(1)); // jp2020213326 should take course with index 1
        assertTrue(sijin.courseIndex.contains(2)); // jp2020213326 should take course with index 2
        assertTrue(sijin.courseIndex.contains(3)); // jp2020213326 should take course with index 3
        assertTrue(sijin.courseIndex.contains(6)); // jp2020213326 should take course with index 6
        assertTrue(sijin.courseIndex.contains(7)); // jp2020213326 should take course with index 7
        assertTrue(sijin.courseIndex.contains(11)); // jp2020213326 should take course with index 11

//        CourseControl jiasijin = new CourseControl("sijin666", 2018);
//        jiasijin.readCourses("sijin666");
//        assertEquals(6, jiasijin.courselist.size()); // jp2020213326 should have 3 courses
//        assertTrue(jiasijin.courseIndex.contains(1)); // jp2020213326 should take course with index 1
//        assertTrue(jiasijin.courseIndex.contains(2)); // jp2020213326 should take course with index 2
//        assertTrue(jiasijin.courseIndex.contains(3)); // jp2020213326 should take course with index 3
//        assertTrue(jiasijin.courseIndex.contains(6)); // jp2020213326 should take course with index 6
//        assertTrue(jiasijin.courseIndex.contains(7)); // jp2020213326 should take course with index 7
//        assertTrue(jiasijin.courseIndex.contains(11)); // jp2020213326 should take course with index 11
    }

    @Test
    public void testReadGeneralInfo() {
        // Test if the readGeneralInfo method correctly reads the general information of the courses
        CourseControl courseControl = new CourseControl("jp2020213326", 2018);
        courseControl.readCourses("jp2020213326");
        assertEquals(6, courseControl.courselist.size()); // There should be 6 courses in the course list
        assertEquals("Advanced_Mathematics", courseControl.courselist.get(0).getCourseName()); //Advanced_Mathematics should be the first course in the list
        assertEquals(4, courseControl.courselist.get(0).getCredit()); // Advanced_Mathematics should have 4 credits
        assertTrue(courseControl.courselist.get(0).getCourseType()); // Advanced_Mathematics should be compulsory

        assertEquals("Electric_and_Magnetic_Fields", courseControl.courselist.get(5).getCourseName()); //Electric_and_Magnetic_Fields should be the last course in the list
        assertEquals(4, courseControl.courselist.get(5).getCredit()); // Electric_and_Magnetic_Fields should have 4 credits
        assertTrue(courseControl.courselist.get(5).getCourseType()); // Electric_and_Magnetic_Fields should be compulsory
    }

    @Test
    public void testskill() {
        // Test if the readPersonInfo method correctly reads the personal information of the courses for a given student ID and year
        CourseControl courseControl = new CourseControl("123", 2022);
        courseControl.readCourses("jp2020213326");
        courseControl.readPersonInfo("jp2020213326", 2022);
    }

//    @Test
//    public void testReadtoLearnSkills() {
//        //Test if the toLearnskill correctly reads the skill to learn
//        SkillsControl sijin = new SkillsControl("2020213326");
//        assertEquals(0, sijin.toLearnSkillList.size()); // only have 0 skills to learn
//    }

    @Test
    public void testIsAccquired() {
        SkillsControl sijin = new SkillsControl("jp2020213326");
        sijin.isAccquired();
        assertTrue(sijin.skillslist.get(0).accquired);   // MathSkill需要学习3门课程，学生都已学习过
        assertTrue(sijin.skillslist.get(1).accquired);   // PhysicsSkill需要学习2门课程，学生都已学习过
        assertTrue(sijin.skillslist.get(2).accquired);   // PlanningSkill需要学习1门课程，学生都已学习过
    }



}
