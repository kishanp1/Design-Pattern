/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kishan
 */
public class Node implements SubjectI, ObserverI,Cloneable{
    private List<Node> observers = new ArrayList<Node>();
    public Node leftChild=null;
    public Node rightChild=null;    
    private List<String> courseName=new ArrayList<String>();
    private int Bnumber;

    public Node(int Bnumber,String courseName) {
        
         if(!courseName.contains(courseName))
         {
             this.courseName.add(courseName);
         }
        this.Bnumber = Bnumber;
    }
    public Node(int Bnumber,List<String> courseName) {
        
            this.courseName=courseName;
            this.Bnumber = Bnumber;
    }
    public List<String> getCourseName() {
        return courseName;
    }

    public int getBnumber() {
        return Bnumber;
    }

    public void setCourseName(String courseName) {
         if(!courseName.contains(courseName))
         {
             this.courseName.add(courseName);
         }
    }

    public void setBnumber(int Bnumber) {
        this.Bnumber = Bnumber;
    }
    
    public String toString()
    {
        return this.Bnumber+":"+this.courseName;
    }
    
    public Node clone() throws CloneNotSupportedException
    {
        List<String> courseClone=new ArrayList<String>(this.courseName);
        Node cloned = new Node(this.Bnumber,courseClone);
        return cloned;
    }
    
    public void removeCourse(String course)
    {
        System.out.print(this+" "+this.Bnumber+this.courseName);
         if(this.courseName.contains(course))
         {
             this.courseName.remove(course);
         }
        System.out.println(" now course="+this.courseName);
        removeObserverCourse(course);
    }
    public void addCourse(String course)
    {
        System.out.print(this+" "+this.Bnumber+this.courseName);
         if(!courseName.contains(course))
         {
             this.courseName.add(course);
         }
        System.out.println(" now course="+this.courseName);
        addObserverCourse(course);
    }
    @Override
    public void removeObserverCourse(String course) 
    {
        if(!observers.isEmpty())
        {
            System.out.println("inside"+this+" "+this.observers);
     
            for (Node observer : observers) 
         {
            observer.removeCourse(course);
         } 
        }    
    }

    @Override
    public void addObserverCourse(String course) {
        
        if(!observers.isEmpty())
        {
            System.out.println("inside"+this+" "+this.observers);
        for (Node observer : observers) 
         {
            observer.addCourse(course);
         }
        }
    }

    @Override
    public void notifyObserver() {
       for (Node observer : observers) {
         observer.update();
      }
    }

    @Override
    public void update() {
       System.out.println("changes made"+this+"node="); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerObserver(Node o) {
       if(!observers.contains(o))
        {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Node o) {
      if(observers.contains(o))
        {
            observers.remove(o);
        } 
    }

    
    
}
