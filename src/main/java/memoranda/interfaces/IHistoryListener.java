/**
 * HistoryListener.java
 * Created on 23.02.2003, 1:56:52 Alex
 * Package: net.sf.memoranda
 * 
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package main.java.memoranda.interfaces;

import main.java.memoranda.HistoryItem;

/**
 * 
 */
/*$Id: HistoryListener.java,v 1.2 2004/01/30 12:17:41 alexeya Exp $*/
public interface IHistoryListener { //Task 2, Step5 Steven Bennett

    /*void historyWasRolledBack();
    
    void historyWasRolledForward();*/
    
    void historyWasRolledTo(HistoryItem item);

}