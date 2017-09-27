/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import myTree.Node;

/**
 *
 * @author Kishan
 */
public class TreeBuilder {
        
    Node node_origin;
    Node backup_Node_1;
    Node backup_Node_2;
    
    public void createNodes(int Bnumber, char courseName) throws CloneNotSupportedException
    {
        
          node_origin=new Node(Bnumber,Character.toString(courseName) );
          
          backup_Node_1=(Node)node_origin.clone();
          backup_Node_2=(Node)node_origin.clone();
          System.out.println("node="+node_origin);
          System.out.println("bk node="+backup_Node_1);
          System.out.println("bk2 node="+backup_Node_2);
          node_origin.registerObserver(backup_Node_1);
          node_origin.registerObserver(backup_Node_2);
          node_origin.addCourse(Character.toString('F'));
          node_origin.addCourse(Character.toString('K'));
          node_origin.removeCourse(Character.toString('F'));
          node_origin.addCourse(Character.toString('K'));
    }
    
}
