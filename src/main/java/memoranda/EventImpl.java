/**
 * EventImpl.java
 * Created on 08.03.2003, 13:20:13 Alex
 * Package: net.sf.memoranda
 * 
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package main.java.memoranda;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.interfaces.IEvent;
import main.java.memoranda.util.Local;
import nu.xom.Attribute;
import nu.xom.Element;

/**
 * 
 */
/*$Id: EventImpl.java,v 1.9 2004/10/06 16:00:11 ivanrise Exp $*/
public class EventImpl implements IEvent, Comparable {
    
    private Element _element = null; //Task 2, Step4 Steven Bennett

    /**
     * Constructor for EventImpl.
     */
    public EventImpl(Element elem) {
        _element = elem; //Task 2, Step4 Steven Bennett
    }

   
    /**
     * @see main.java.memoranda.interfaces.IEvent#getHour()
     */
    public int getHour() {
        //Task 2, Step4 Steven Bennett
        return new Integer(_element.getAttribute("hour").getValue()).intValue();
    }

    /**
     * @see main.java.memoranda.interfaces.IEvent#getMinute()
     */
    public int getMinute() {
        //Task 2, Step4 Steven Bennett
        return new Integer(_element.getAttribute("min").getValue()).intValue();
    }
    
    public String getTimeString() {
        return Local.getTimeString(getHour(), getMinute());
    }
        
  
    /**
     * @see main.java.memoranda.interfaces.IEvent#getText()
     */
    public String getText() {
        return _element.getValue(); //Task 2, Step4 Steven Bennett
    }

    /**
     * @see main.java.memoranda.interfaces.IEvent#getContent()
     */
    public Element getContent() {
        return _element; //Task 2, Step4 Steven Bennett
    }
    /**
     * @see main.java.memoranda.interfaces.IEvent#isRepeatable()
     */
    public boolean isRepeatable() {
        return getStartDate() != null;
    }
    /**
     * @see main.java.memoranda.interfaces.IEvent#getStartDate()
     */
    public CalendarDate getStartDate() {
        Attribute a = _element.getAttribute("startDate"); //Task 2, Step4 Steven Bennett
        if (a != null) return new CalendarDate(a.getValue());
        return null;
    }
    /**
     * @see main.java.memoranda.interfaces.IEvent#getEndDate()
     */
    public CalendarDate getEndDate() {
        Attribute a = _element.getAttribute("endDate"); //Task 2, Step4 Steven Bennett
        if (a != null) return new CalendarDate(a.getValue());
        return null;
    }
    /**
     * @see main.java.memoranda.interfaces.IEvent#getPeriod()
     */
    public int getPeriod() {
        Attribute a = _element.getAttribute("period"); //Task 2, Step4 Steven Bennett
        if (a != null) return new Integer(a.getValue()).intValue();
        return 0;
    }
    /**
     * @see main.java.memoranda.interfaces.IEvent#getId()
     */
    public String getId() {
        Attribute a = _element.getAttribute("id"); //Task 2, Step4 Steven Bennett
        if (a != null) return a.getValue();
        return null;
    }
    /**
     * @see main.java.memoranda.interfaces.IEvent#getRepeat()
     */
    public int getRepeat() {
      //Task 2, Step4 Steven Bennett
        Attribute a = _element.getAttribute("repeat-type");
        if (a != null) return new Integer(a.getValue()).intValue();
        return 0;
    }
    /**
     * @see main.java.memoranda.interfaces.IEvent#getTime()
     */
    public Date getTime() {
    	//Deprecated methods
		//Date d = new Date();
		//d.setHours(getHour());
		//d.setMinutes(getMinute());
		//d.setSeconds(0);
		//End deprecated methods

		Date d = new Date(); //Revision to fix deprecated methods (jcscoobyrs) 12-NOV-2003 14:26:00
		Calendar calendar = new GregorianCalendar(Local.getCurrentLocale()); //Revision to fix deprecated methods (jcscoobyrs) 12-NOV-2003 14:26:00
		calendar.setTime(d); //Revision to fix deprecated methods (jcscoobyrs) 12-NOV-2003 14:26:00
		calendar.set(Calendar.HOUR_OF_DAY, getHour()); //Revision to fix deprecated methods (jcscoobyrs) 12-NOV-2003 14:26:00
		calendar.set(Calendar.MINUTE, getMinute()); //Revision to fix deprecated methods (jcscoobyrs) 12-NOV-2003 14:26:00
		calendar.set(Calendar.SECOND, 0); //Revision to fix deprecated methods (jcscoobyrs) 12-NOV-2003 14:26:00
		d = calendar.getTime(); //Revision to fix deprecated methods (jcscoobyrs) 12-NOV-2003 14:26:00
        return d;
    }
	
	/**
     * @see main.java.memoranda.interfaces.IEvent#getWorkinDays()
     */
	public boolean getWorkingDays() {
	  //Task 2, Step4 Steven Bennett
        Attribute a = _element.getAttribute("workingDays");
        if (a != null && a.getValue().equals("true")) return true;
        return false;
	}
	
	public int compareTo(Object o) {
		IEvent event = (IEvent) o;
		return (getHour() * 60 + getMinute()) - (event.getHour() * 60 + event.getMinute());
	}

}
