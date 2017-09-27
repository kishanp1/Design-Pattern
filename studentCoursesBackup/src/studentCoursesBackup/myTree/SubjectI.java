/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTree;



/**
 *
 * @author Kishan
 */
public interface SubjectI {
    public void registerObserver(Node o);
    public void removeObserver(Node o);
    public void removeObserverCourse(String course);
    public void addObserverCourse(String course);
    public void notifyObserver(); 

}
