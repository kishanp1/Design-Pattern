/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import myTree.Node;
import myTree.ObserverI;
import myTree.SubjectI;
import util.FileProcessor;

/**
 *
 * @author Kishan
 */
public class Driver {
      public static void main(String[] args) {
         /**Object of file processor that will be used to read input
         * file line by line
        */
        FileProcessor d = new FileProcessor();

	 /**A bufferedReader to be used to read the input file
        */
        BufferedReader br = null;
        if(args==null || args.length<=1)
        {
            System.out.println("please insert valid number of filename"+args.length+" "+args[0]);
        }
        try
        {
            System.out.println("path="+args[0]);
            br = new BufferedReader(new FileReader(args[0]));
            String line=null;
            line=d.readLine(br);
            while(line!=null)
            {
                
                line=d.readLine(br);
            }
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        finally{
            try{
                br.close();
            }
            catch(IOException ie)
            {
                System.out.println("Can not close file");
            }
            
        }

	 /**Object of Node class that will hold the node in
        */
        Node n=new Node("c",1234);
	
	 /**Object of SubjectI class that will act as subject 
	  * for all observers
        */
        SubjectI node_origin=new SubjectI(n);

	 /**Object of ObserverI class that will be a observer
         * of subject named node_origin
        */
        ObserverI backup_Node_1=new ObserverI(node_origin);

	 /**Object of ObserverI class that will be a observer
         * of subject named node_origin
        */
        ObserverI backup_Node_2=new ObserverI(node_origin);
        node_origin.setState(n);
    }

	 /**A to String function to be used if it's needed to print Driver
         * class's object
        */
	public String toString()
	{
		String str="this is a driver's object";
		return str;
	}
}
