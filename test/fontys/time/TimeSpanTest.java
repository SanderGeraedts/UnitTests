/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roy
 */
public class TimeSpanTest {

    private Time t1;
    private Time t2;
    private Time t3;
    private Time t4;
    private Time t5;
    private Time t6;

    private TimeSpan ts1;
    private TimeSpan ts2;
    private TimeSpan ts3;

    public TimeSpanTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
        t1 = new Time(2016, 3, 12, 12, 21);
        t2 = new Time(2016, 3, 12, 12, 40);
        t3 = new Time(2016, 3, 13, 10, 40);
        t4 = new Time(2016, 3, 13, 10, 59);
        t5 = new Time(2016, 3, 14, 10, 40);
        t6 = new Time(2016, 3, 14, 10, 59);

        ts1 = new TimeSpan(t1, t2);
        ts2 = new TimeSpan(t3, t4);
        ts3 = new TimeSpan(t5, t6);
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Constructor Test T1 should be earlier than T2
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTimeSpan()
    {
        ts1 = new TimeSpan(t2, t1);
    }

    /**
     * Test of getBeginTime method, of class TimeSpan.
     */
    @Test
    public void testGetBeginTime()
    {
        System.out.println("getBeginTime");
        TimeSpan instance = ts1;
        ITime expResult = t1;
        ITime result = instance.getBeginTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndTime method, of class TimeSpan.
     */
    @Test
    public void testGetEndTime()
    {
        System.out.println("getEndTime");
        TimeSpan instance = ts1;
        ITime expResult = t2;
        ITime result = instance.getEndTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength()
    {
        System.out.println("length");
        TimeSpan instance = ts1;
        int expResult = t1.difference(t2);
        int result = instance.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBeginTime method, of class TimeSpan.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetBeginTime()
    {
        System.out.println("setBeginTime");
        ITime beginTime = new Time(2016, 3, 12, 12, 21);
        TimeSpan instance = ts2;
        instance.setBeginTime(beginTime);      
        ts1.setBeginTime(t5);
        
        
        
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetEndTime()
    {
        System.out.println("setEndTime");
        ITime endTime = t6;
        TimeSpan instance = ts2;
        instance.setEndTime(endTime);
        ts2.setEndTime(t3);
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove()
    {
        System.out.println("move");
        int t1 = ts1.getBeginTime().getMinutes();
        int t2 = ts1.getEndTime().getMinutes();
        int minutes = 10;
        TimeSpan instance = ts1;
        instance.move(minutes);
        assertEquals(t1+minutes, ts1.getBeginTime().getMinutes());
        assertEquals(t2+minutes, ts1.getEndTime().getMinutes());
        
        System.out.println("move");
        t1 = ts1.getBeginTime().getMinutes();
        t2 = ts1.getEndTime().getMinutes();
        minutes = -10;
        instance = ts1;
        instance.move(minutes);
        assertEquals(t1+minutes, ts1.getBeginTime().getMinutes());
        assertEquals(t2+minutes, ts1.getEndTime().getMinutes());
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testChangeLengthWith()
    {
        System.out.println("changeLengthWith");
        int t1 = ts1.getBeginTime().getMinutes();
        int minutes = 10;
        TimeSpan instance = ts1;
        instance.changeLengthWith(minutes);
        assertEquals(t1+minutes, instance.getBeginTime().getMinutes());
        instance.changeLengthWith(-10);
        
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf()
    {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = ts1;
        TimeSpan instance = ts1;
        boolean expResult = true;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        
        assertFalse(ts2.isPartOf(ts1));
        assertFalse(ts1.isPartOf(ts2));
        assertFalse(ts3.isPartOf(ts2));
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith()
    {
        System.out.println("unionWith");
        ts3 = (TimeSpan)ts1.unionWith(ts2);
        assertEquals(null, ts3);
       
        t1 = new Time(2016, 3, 12, 12, 21);
        t2 = new Time(2016, 3, 12, 12, 40);
        t3 = new Time(2016, 3, 12, 10, 40);
        t4 = new Time(2016, 3, 13, 10, 59);
        
        ts1 = new TimeSpan(t1,t2);
        ts2 = new TimeSpan(t3,t4);
        
        ts3 = (TimeSpan)ts1.unionWith(ts2);
        assertNotNull(ts3);
        assertEquals(t3.getMinutes(), ts3.getBeginTime().getMinutes());
        assertEquals(t4.getMinutes(), ts3.getEndTime().getMinutes());
        
        t1 = new Time(2016, 3, 12, 12, 21);
        t2 = new Time(2016, 3, 13, 12, 40);
        t3 = new Time(2016, 3, 12, 12, 30);
        t4 = new Time(2016, 3, 13, 10, 59);
        
        ts1 = new TimeSpan(t1,t2);
        ts2 = new TimeSpan(t3,t4);
        
        ts3 = (TimeSpan)ts1.unionWith(ts2);
        assertNotNull(ts3);
        assertEquals(t1.getMinutes(), ts3.getBeginTime().getMinutes());
        assertEquals(t2.getMinutes(), ts3.getEndTime().getMinutes());
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith()
    {        
        System.out.println("intersectionWith");
        TimeSpan ts3 = new TimeSpan(t1, t2);
        t1= new Time(2012,2,10,12,20); t2= new Time(2012,2,10,12,21); t3= new Time(2012,2,10,12,22); t4= new Time(2012,2,10,12,23);
        ts1 = new TimeSpan(t1,t2);
        ts2 = new TimeSpan(t3,t4);
        ts3 = (TimeSpan)ts1.intersectionWith(ts2);
        assertEquals(null, ts3);
        ts3 = (TimeSpan)ts2.intersectionWith(ts1);
        assertEquals(null, ts3);
        
        ts1 = new TimeSpan(t1,t4);
        ts2 = new TimeSpan(t2,t3);
        ts3 = (TimeSpan)ts1.intersectionWith(ts2); 
        assertEquals(21, ts3.getBeginTime().getMinutes());
        assertEquals(22, ts3.getEndTime().getMinutes());        
        
        ts1 = new TimeSpan(t2,t4);
        ts2 = new TimeSpan(t1,t3);
        ts3 = (TimeSpan)ts1.intersectionWith(ts2); 
        assertEquals(21, ts3.getBeginTime().getMinutes());
        assertEquals(22, ts3.getEndTime().getMinutes());
        
        ts1 = new TimeSpan(t1,t4);
        ts2 = new TimeSpan(t1,t3);
        ts3 = (TimeSpan)ts1.intersectionWith(ts2); 
        assertEquals(20, ts3.getBeginTime().getMinutes());
        assertEquals(22, ts3.getEndTime().getMinutes());
        
        ts1 = new TimeSpan(t1,t4);
        ts2 = new TimeSpan(t2,t4);
        ts3 = (TimeSpan)ts1.intersectionWith(ts2); 
        assertEquals(21, ts3.getBeginTime().getMinutes());
        assertEquals(23, ts3.getEndTime().getMinutes());    
    }

}
