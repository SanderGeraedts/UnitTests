/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;

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
    public Appointment(String subj, TimeSpan timeSp)
    {
        this.subject = subj;
        this.timeSpan = timeSp;
        invitees = new ArrayList<Contact>();
    }
    
}
