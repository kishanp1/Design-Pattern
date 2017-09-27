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
import java.util.logging.Level;
import java.util.logging.Logger;
import myTree.Node;
import myTree.ObserverI;
import myTree.SubjectI;
import util.FileProcessor;
import util.TreeBuilder;
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
	Driver driver=new Driver();
	TreeBuilder tb=new TreeBuilder();
	String operation=null;
	 /**A bufferedReader to be used to read the input file
        */
        BufferedReader br = null;
        if(args==null || args.length<=1)
        {
            System.out.println("please insert valid number of filename"+args.length+" "+args[0]);
        }
        try
        {
	    operation="input";
            System.out.println("path="+args[0]);
            br = new BufferedReader(new FileReader(args[0]));
            String line=null;
            line=d.readLine(br);
            if(line!=null)
              {
                driver.processLine(line,tb,operation);
              }
	    while(line!=null)
            {
                
                line=d.readLine(br);
		if(line!=null)
              	{
                    driver.processLine(line,tb,operation);
              	}
            }
	    br.close();
            /*
            * delete operation
            */
            operation="delete";
	    String path2="C:\\Users\\Kishan\\Documents\\NetBeansProjects\\studentCoursesBackup\\src\\"+args[1];
            System.out.println("path="+args[1]);
            operation="delete";
            br = new BufferedReader(new FileReader(args[1]));
            line=null;
            line=d.readLine(br);
            if(line!=null)
              {
                driver.processLine(line,tb,operation);
              }
            while(line!=null)
            {
              line=d.readLine(br);
              if(line!=null)
              {
                driver.processLine(line,tb,operation);
              }
            }
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
	catch(IOException ie)
	{
		System.out.println("can not close file");
	}
        finally{
            try{
                br.close();
            }
            catch(IOException ie)
            {
                System.out.println("Can not close file");
            }
	    catch(NullPointerException ne)
            {
                
            }
            
        }

    }

	 /**A to String function to be used if it's needed to print Driver
         * class's object
        */
	public String toString()
	{
		String str="this is a driver's object";
		return str;
	}
	
	 private void processLine(String line,TreeBuilder tb,String operation) {
      //  System.out.println("line="+line);
       
      String[] full_line=line.split(":");
       int value=-1,Bnumber=-1;
       char course = 'z';
       if(full_line.length==2)
       {
           
        try {
            value=Integer.parseInt(full_line[0]);
            Bnumber=value;
            if (full_line[1].matches(".*[A,B,C,D,E,F,G,H,I].*")) 
            { 
                 course=full_line[1].charAt(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("invalid line");
            //write system.err, not to sout
        }
        finally{
            
        }
        if(Bnumber>0 && course!='z') 
        {
            System.out.println("bnumber="+Bnumber+" subject="+course);
            try 
            {
                if(operation.equals("input"))
                {
                  tb.createNodes(Bnumber,course);
                }
                else if(operation.equals("delete"))
                {
                  tb.deleteCourse(Bnumber,Character.toString(course));
                }
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       }
       
    }	
}
