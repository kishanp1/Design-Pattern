/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 *
 * @author Kishan
 */
public class SubjectI implements subjectInterface{
    private List<ObserverI> observers = new ArrayList<ObserverI>();
    Node node_origin;

    public SubjectI(Node node_origin) {
        this.node_origin = node_origin;
    }
    
    public void setState(Node n) {
      this.node_origin.setBnumber(n.getBnumber());
      this.node_origin.setCourseName(n.getCourseName());
      notifyObserver();
   }
    
    public void registerObserver(ObserverI o) 
    {
        if(!observers.contains(o))
        {
            observers.add(o);
        }
    }
    public void removeObserver(ObserverI o) 
    {
        if(observers.contains(o))
        {
            observers.remove(o);
        }
    }

    public void notifyObserver() 
    {
        for (ObserverI observer : observers) {
         observer.update();
      }
    }

    

}
