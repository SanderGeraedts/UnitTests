/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Roy
 */
public class Appointment {
    
    
    private String subject;
    private ITimeSpan timeSpan;
    private ArrayList<Contact> invitees;
    
    /**
     * Constructor for Appointment
     *
     * @param subj String for a subject name.
     * @param timeSp TimeSpan for when Appointment is planned
     */
    public Appointment(String subj, ITimeSpan timeSp)
    {
    }
    
    public String getSubject()
    {
        return null;
    }

    public ITimeSpan getPeriod()
    {
        return null;
    }

    public Iterator<Contact> invitees()
    {
        return null;
    }
    
    /**
     * Adds a contact to the appointment
     * Appointment may not be in conflict with other apointments
     * @param c Contact to be added to the appointment
     * @return true if succeeded.
     */
    public boolean addContact(Contact c)
    {
        return false;
    }

    /**
     * Removes a contact from the appointment
     * @param c 
     */
    public void removeContact(Contact c)
    {
        
    }
}