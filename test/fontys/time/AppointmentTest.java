/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
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
public class AppointmentTest {

    private Time t1;
    private Time t2;
    private Time t3;
    private Time t4;
    private ITimeSpan ts1;
    private ITimeSpan ts2;
    private String subject1 = "subject1";
    private String subject2 = "subject2";
    private Contact c1;
    private Contact c2;
    ArrayList<Contact> a;
    Iterator<Contact> c;

    public AppointmentTest()
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
        t1 = new Time(2000, 10, 3, 12, 00);
        t2 = new Time(2000, 10, 3, 12, 15);
        t3 = new Time(2000, 10, 3, 12, 10);
        t4 = new Time(2000, 10, 3, 12, 45);
        ts1 = new TimeSpan(t1, t2);
        ts2 = new TimeSpan(t3, t4);
        c1 = new Contact("Piet");
        c2 = new Contact("Henk");
    }

    @After
    public void tearDown()
    {
    }
    

    /**
     * Test of getSubject method, of class Appointment.
     */
    @Test
    public void testGetSubject()
    {
        System.out.println("getSubject");
        Appointment instance = new Appointment(subject1, ts1);
        String expResult = "subject 1";
        String result = instance.getSubject();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPeriod method, of class Appointment.
     */
    @Test
    public void testGetPeriod()
    {
        System.out.println("getPeriod");
        Appointment instance = new Appointment(subject1, ts1);
        t1 = new Time(2000, 10, 3, 12, 00);
        t2 = new Time(2000, 10, 3, 12, 15);
        ts1 = new TimeSpan(t1, t2);
        ITimeSpan expResult = ts1;
        ITimeSpan result = instance.getPeriod();
        assertEquals(expResult, result);
    }

    /**
     * Test of invitees method, of class Appointment.
     */
    @Test
    public void testInvitees()
    {
        System.out.println("invitees");
        Appointment instance = new Appointment(subject1, ts1);
        instance.addContact(c1);
        instance.addContact(c2);
        ArrayList<Contact> listContact = new ArrayList<Contact>();
        listContact.add(c1);
        listContact.add(c2);
        Iterator<Contact> expResult = listContact.iterator();
        Iterator<Contact> result = instance.invitees();
        assertEquals(expResult, result);
    }

    /**
     * Test of addContact method, of class Appointment.
     */
    @Test
    public void testAddContact()
    {
        System.out.println("addContact");
        
        Appointment instance = new Appointment(subject1, ts1);
        boolean expResult = true;
        boolean result = instance.addContact(c1);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.addContact(c1);
        assertEquals(expResult, result);
        expResult = true;
        result = instance.addContact(c2);
        assertEquals(expResult, result);
        
        instance = new Appointment(subject2, ts2);
        expResult = true;
        instance.addContact(c1);
        assertEquals(expResult, result);
        
        t3 = new Time(2000, 10, 3, 12, 00);
        t4 = new Time(2000, 10, 3, 12, 15);
        ts2 = new TimeSpan(t3, t4);
        instance = new Appointment(subject2, ts2);
        expResult = false;
        result = instance.addContact(c1);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of removeContact method, of class Appointment.
     */
    @Test
    public void testRemoveContact()
    {
        System.out.println("removeContact");
        Appointment instance = new Appointment(subject1, ts1);
        instance.addContact(c1);
        instance.removeContact(c1); 
        boolean expResult = false;
        boolean result = instance.invitees().hasNext();
        assertEquals(expResult, result);
    }
    
}
