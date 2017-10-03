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
    /**A node objet to create original node
    */        
    Node node_origin;
 
/**A node objet to create backup node1
    */
    Node backup_Node_1;

/**A node objet to create backup node2
    */
    Node backup_Node_2;

/**A node objet to use as root for this treebuilder
    */
    Node tree_root=null;
    Node root_original=null,root_backup_1=null,root_backup_2=null;

     /** This function will create a node if doesn't exist 
	*and create its observers, if node exists only add courses
        * @param An int Bnumber for the node
	* @param An char course for the node
	* @param tb_backup1 treebuilder's object to create backup1 tree
	* @param tb_backup2 treebuilder's object to create backup2 tree
        * @return Void return
        */
    public void createNodes(int Bnumber, char courseName, TreeBuilder tb_backup1, TreeBuilder tb_backup2) throws CloneNotSupportedException
    {
        
          Node test=findNode(Bnumber);
          if(test==null)
          {
          node_origin=new Node(Bnumber,Character.toString(courseName));
          node_origin.addCourse(Character.toString(courseName));
          backup_Node_1=(Node)node_origin.clone();
          backup_Node_2=(Node)node_origin.clone();
          this.add(node_origin);
          tb_backup1.add(backup_Node_1);
          tb_backup2.add(backup_Node_2);
          
          
          node_origin.registerObserver(backup_Node_1);
          node_origin.registerObserver(backup_Node_2);
          
          }
          else
          {
              node_origin=test;
              node_origin.addCourse(Character.toString(courseName));
              Node backup1=tb_backup1.findNode(Bnumber);
              Node backup2=tb_backup2.findNode(Bnumber);
              backup1.addCourse(Character.toString(courseName));
              backup2.addCourse(Character.toString(courseName));
          }
    }

    /**This function will find the node and delete the course
	* @param An int Bnumber for the node
        * @param An char course for the node
        * @return Void return
        */
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
/**This function will add a node to tree
* @param An object of Node to be added
* @param An char course for the node
*/    
/*
    *reference: https://www.youtube.com/watch?v=M6lYob8STMI
    */
    private void add(Node n) {
        Node root=null;
        root=this.tree_root;
        if(root==null)
        {
            this.tree_root=n;
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
               
            }
        }
    }
    
/**This function will traverse the tree in order
* @param An object of Node 
* @param An object of results to save tree
*/
    private void inOrderTraverse(Node n,Results rs)
    {
        if(n!=null)
        {
            inOrderTraverse(n.leftChild,rs);
            rs.storeNewResult(n.toString());
            inOrderTraverse(n.rightChild,rs);
        }
    }

/**This function will find node from tree
* @param An int Bnumber to find the node
*/

    private Node findNode(int Bnumber) {
        Node focus=this.tree_root;
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

/**This function will write the results to
*results object
* @param An object of result to write result
* @param An String fileName to write file
*/

    public void writeResults(Results rs, String type, String fileName) {
        inOrderTraverse(this.tree_root,rs);
        rs.writeToFile(fileName);
    }

   /**A to String function to be used if it's needed to print TreeBuilder 
	 * class's object
	*@param NA
	*@return returns a String
	*/
	public String toString(){
	String str="this is a treebuilder's object";
         return str;
        }
    
}
