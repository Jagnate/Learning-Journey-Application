/**
 *  Title      : coursetest.java
 *  Description: A TDD to test the coursecontrol function of our engineering
 *
 *  @author  Yuanchi Zhou
 *  @version 1.0
 */

package test;

import control.CourseControl;
import org.junit.Test;

import static org.junit.Assert.*;

public class coursetest {

    @Test
    public void courserequired(){
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
    public void checkgetinfo(){
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
}
