package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job firstJob;
    Job secondJob;
    Job thirdJob;
    Job fourthJob;
    Job jobWithNullValue;


    Employer jobEmployer;
    Location jobLocation;
    PositionType jobPosition;
    CoreCompetency jobCoreCompetency;

    Employer jobEmployerWithEmptyValue;


    @Before
    public void setUpJobTests() {
        firstJob = new Job();
        secondJob = new Job();

        jobEmployer = new Employer("ACME");
        jobLocation = new Location("Desert");
        jobPosition = new PositionType("Quality control");
        jobCoreCompetency = new CoreCompetency("Persistence");

        thirdJob = new Job("Product tester", jobEmployer, jobLocation, jobPosition, jobCoreCompetency);
        fourthJob = new Job("Product tester", jobEmployer, jobLocation, jobPosition, jobCoreCompetency);

        jobEmployerWithEmptyValue = new Employer("");
        jobWithNullValue = new Job("Product tester", jobEmployerWithEmptyValue, jobLocation, jobPosition, jobCoreCompetency);
    }

    //checks for sequential ID numbers
    @Test
    public void testSettingJobId() {
        assertEquals(firstJob.getId(), secondJob.getId() - 1);
    }

    //tests for correct constructor class and value assignments
    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(thirdJob instanceof Job);
        assertTrue(jobEmployer instanceof Employer);
        assertTrue(jobLocation instanceof Location);
        assertTrue(jobPosition instanceof PositionType);
        assertTrue(jobCoreCompetency instanceof CoreCompetency);

        assertEquals("Product tester", thirdJob.getName());
        assertEquals(jobEmployer, thirdJob.getEmployer());
        assertEquals(jobLocation, thirdJob.getLocation());
        assertEquals(jobPosition, thirdJob.getPositionType());
        assertEquals(jobCoreCompetency, thirdJob.getCoreCompetency());

    /* I didn't use .getValue bc the class fields could change in the future.
    assertEquals("Persistence", jobCoreCompetency.getValue(), thirdJob.getCoreCompetency().getValue());*/
    }

    //tests
    @Test
    public void testJobsForEquality() {
        assertFalse(thirdJob.getId() == fourthJob.getId());

        assertEquals(thirdJob.getName(), fourthJob.getName());
        assertEquals(thirdJob.getEmployer(), fourthJob.getEmployer());
        assertEquals(thirdJob.getLocation(), fourthJob.getLocation());
        assertEquals(thirdJob.getPositionType(), fourthJob.getPositionType());
        assertEquals(thirdJob.getCoreCompetency(), fourthJob.getCoreCompetency());
    }

    //checks for empty lines on either end of printed job string
    @Test
    public void testJobsToStringBlankLines() {
        assertTrue(firstJob.toString().endsWith("\n"));
        assertTrue(firstJob.toString().startsWith("\n"));
    }

    //checks for null and class values with empty strings
    @Test
    public void testJobsToStringContainsLabel() {
        assertTrue(firstJob.toString().contains("Employer: Data not available"));
        assertTrue(jobWithNullValue.toString().contains("Employer: Data not available"));
    }

}
