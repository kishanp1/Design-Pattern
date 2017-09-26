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
public class ObserverI implements observerInterface{

    SubjectI subject;
    
    public ObserverI(SubjectI subject) 
    {
        this.subject=subject;
        this.subject.registerObserver(this);
    }
    
    @Override
    public void update() {
        System.out.println("changes made"+this+"node="+subject.node_origin);
    }
    
}
