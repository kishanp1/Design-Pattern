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
    /**An Arraylist to store node's observers
    */
    private List<Node> observers = new ArrayList<Node>();

     /**An object of node to store left child
    */
    public Node leftChild=null;

    /**An object of node to store right child
    */
    public Node rightChild=null;

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

     /**An Arraylist to store node's courses
    */
    private List<String> courseName=new ArrayList<String>();

     /**An int to store Bnumber of node
    */
    private int Bnumber;

    /**Node's constructor with bnumber and single course
    */
    public Node(int Bnumber,String courseName) {
        
         if(!courseName.contains(courseName))
         {
             this.courseName.add(courseName);
         }
        this.Bnumber = Bnumber;
    } 
    
     /**Node's constructor with bnumber and courseList
    */
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
    
  /**A to String function to be used if it's needed to print Node 
   * class's object
   */
   public String toString()
    {
        String result=Integer.toString(this.Bnumber);
        return this.Bnumber+":"+this.courseName;
    }
   /**To clone the node's object
    */ 
    
    public Node clone()
    {
	try{
        List<String> courseClone=new ArrayList<String>(this.courseName);
        Node cloned = new Node(this.Bnumber,courseClone);
        return cloned;
       }catch(Exception ce)
       {
        System.out.println("problem with cloning");
       }
	return null;
    }
   
    /** This function will remove the course if found
     * and notifys observers
     * @param A string named course, the course needs to
     * to be removed
     * @return Void return
     */
    public void removeCourse(String course)
    {
         if(this.courseName.contains(course))
         {
             this.courseName.remove(course);
         }
        notifyall(course);
    }

     /** This function will add the course in the node
     * @param A string named course, the course needs to
     * to be added
     * @return Void return
     */
    public void addCourse(String course)
    {
         if(!courseName.contains(course))
         {
             this.courseName.add(course);
         }
    }

   /** This function will notifys observers
     * @param A string named course, the course needs to
     * be removed
     * @return Void return
     */
    @Override
    public void notifyall(String course) {
       for (Node observer : observers) {
         observer.update(course);
      }
    }
    
    /** This function will call remove method 
     * to update the course names of observer
     * @param A string named course, the course needs to
     * to be removed
     * @return Void return
     */
    @Override
    public void update(String course) {
        this.removeCourse(course);
    }

    /**This function will register observers
     * @param Node's object that will be observer
    */
    @Override
    public void registerObserver(Node o) {
       if(!observers.contains(o))
        {
            observers.add(o);
        }
    }

   /**This function will remove observers
     * @param Node's object that will be removed from
     * observers list
    */
    @Override
    public void removeObserver(Node o) {
      if(observers.contains(o))
        {
            observers.remove(o);
        } 
    }

    
    
}
