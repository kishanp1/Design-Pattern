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
    Node root_original=null,root_backup_1=null,root_backup_2=null;
//    TreeBuilder tb_original=new TreeBuilder();
//    TreeBuilder tb_backup_1=new TreeBuilder();
//    TreeBuilder tb_backup_2=new TreeBuilder();
    public void createNodes(int Bnumber, char courseName) throws CloneNotSupportedException
    {
        
          Node test=findNode(Bnumber);
          if(test==null)
          {
            node_origin=new Node(Bnumber,Character.toString(courseName));
          backup_Node_1=(Node)node_origin.clone();
          backup_Node_2=(Node)node_origin.clone();
          System.out.println("original="+node_origin);
          System.out.println("bk node="+backup_Node_1);
          System.out.println("bk2 node="+backup_Node_2);
          add(node_origin,"original");
          add(backup_Node_1,"backup 1");
          add(backup_Node_2,"backup 2");
          
          System.out.println("traversal original=");
          inOrderTraverse(root_original);
          System.out.println("end of traversal");
          
          System.out.println(" ");
          System.out.println("traversal backup 1=");
          inOrderTraverse(root_backup_1);
          System.out.println("end of traversal");
          
          System.out.println(" ");
          System.out.println("traversal backup 2=");
          inOrderTraverse(root_backup_2);
          System.out.println("end of traversal");
          node_origin.registerObserver(backup_Node_1);
          node_origin.registerObserver(backup_Node_2);
          node_origin.addCourse(Character.toString(courseName));
          /*
          node_origin.addCourse(Character.toString('F'));
          node_origin.addCourse(Character.toString('K'));
          node_origin.removeCourse(Character.toString('F'));
          node_origin.addCourse(Character.toString('K'));
          */
          }
          else
          {
              node_origin=test;
              node_origin.addCourse(Character.toString(courseName));
          }
    }
    /*
    *reference: https://www.youtube.com/watch?v=M6lYob8STMI
    */
    public void deleteCourse(int Bnumber, String course) 
    {
          Node test=findNode(Bnumber);
          if(test!=null)
          {
              test.removeCourse(course);
          }
    }
    /*
    *reference: https://www.youtube.com/watch?v=M6lYob8STMI
    */
    private void add(Node n,String s) {
        Node root=null;
        if(s.equals("original"))
        {
            root = root_original;
        }
        else if(s.equals("backup 1"))
        {
            root = root_backup_1;
        }
        else if(s.equals("backup 2"))
        {
            root = root_backup_2;
        }
        if(root==null && s.equals("original"))
        {
            System.out.println("root_original changed");
            root_original=n;
        }
        else if(root==null && s.equals("backup 1"))
        {
            root_backup_1=n;
        }
        else if(root==null && s.equals("backup 2"))
        {
            root_backup_2=n;
        }
        else
        {
            Node focus=root;
            Node parent;
            while(true)
            {
                parent=focus;
                if(n.getBnumber()<focus.getBnumber())
                {
                    focus=focus.leftChild;
                    if(focus==null)
                    {
                        parent.leftChild=n;
                        return;
                    }
                }
                else if(n.getBnumber()>focus.getBnumber())
                {
                    focus=focus.rightChild;
                    if(focus==null)
                    {
                        parent.rightChild=n;
                        return;
                    }
                }
                else
                {
                    focus.addCourse(s);
                }
            }
        }
    }
    
    private void inOrderTraverse(Node n)
    {
        if(n!=null)
        {
            inOrderTraverse(n.leftChild);
            System.out.println(n);
            inOrderTraverse(n.rightChild);
        }
    }

    private Node findNode(int Bnumber) {
        Node focus=root_original;
        if(focus==null)
        {
            return null;
        }
        while(focus.getBnumber()!=Bnumber)
        {
            if(Bnumber==focus.getBnumber())
            {
                return focus;
            }
            if(Bnumber<focus.getBnumber())
            {
                focus=focus.leftChild;
            }
            else if(Bnumber>focus.getBnumber())
            {
                focus=focus.rightChild;
            }
            if(focus==null)
            {
                return null;
            }
        }
        return focus;
    }

   
    
}

