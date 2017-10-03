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
import util.Results;
import util.TreeBuilder;

/**
 *
 * @author Kishan
 */
public class Driver {
      public static void main(String[] args) {
        // TODO code application logic here
	/** An object of file processor to read file line by line
	*/
        FileProcessor d = new FileProcessor();

	 /** An object of Driver itself to call other functions
        */
        Driver driver=new Driver();

	 /** An object of tree builder for original tree
        */
        TreeBuilder tb_original=new TreeBuilder();

	 /** An object of tree builder for backup tree1
        */
	TreeBuilder tb_backup1=new TreeBuilder();

         /** An object of tree builder for backup tree2
        */
	TreeBuilder tb_backup2=new TreeBuilder();

	 /** A Buffer reader to read file
        */
	BufferedReader br = null;

	 /** A string to specify input or delete
        */
        String operation=null;

 	/** An object of result to write in output file
        */
	Results rs=new Results();
  
        if(args==null || args.length!=5 || args[0].equals("${arg0}") || args[4].equals("${arg4}"))
        {
            System.out.println("please insert valid number of filename");
        }
	else{
        int flag=0;
        try
        {
            operation="input";
            br = new BufferedReader(new FileReader(args[0]));
            String line=null;
            line=d.readLine(br);
            if(line!=null)
              {
                driver.processLine(line,tb_original,tb_backup1,tb_backup2,operation);
              }
            while(line!=null)
            {
              line=d.readLine(br);
              if(line!=null)
              {
                driver.processLine(line,tb_original,tb_backup1,tb_backup2,operation);
              }
            }
            br.close();
            /*
            * delete operation
            */
            operation="delete";
            br = new BufferedReader(new FileReader(args[1]));
            line=null;
            
            line=d.readLine(br);
            if(line!=null)
              {
                driver.processLine(line,tb_original,tb_backup1,tb_backup2,operation);
              }
            while(line!=null)
            {
              line=d.readLine(br);
              if(line!=null)
              {
                driver.processLine(line,tb_original,tb_backup1,tb_backup2,operation);
              }
            }
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            flag=1;
        }
        catch(IOException ie)
        {
            System.out.println("Can not close file");
            flag=1;
        }
        finally
        {
            try{
                br.close();
            }
            catch(IOException ie)
            {
                flag=1;
                System.out.println("Can not close file");
            }
            catch(NullPointerException ne)
            {
                flag=1;
                 System.out.println("Can not close file");
            }
            
        }
        if(flag!=1)
        {
            tb_original.writeResults(rs,"original",args[2]);
            rs.setResult(null);
            tb_backup1.writeResults(rs,"backup 1",args[3]);
            rs.setResult(null);
            tb_backup2.writeResults(rs,"backup 2",args[4]);
            
        }
        
       }
    }

	/**
         * This function will process the line first before giving
         * it to tree Builder and discards the line if the courses
	 * are invalid
         * @param line received from the input or delete file
	 * @param tb_original a treebuilder object tobuild original tree
	 * @param tb_backup1 a treebuilder object tobuild backup tree 1
	 * @param tb_backup2 a treebuilder object tobuild backup tree 2
         * @return Void return
        */
    private void processLine(String line,TreeBuilder tb_original,TreeBuilder tb_backup1,TreeBuilder tb_backup2,String operation) {
       
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
        }
        finally{
            
        }
        if(Bnumber>0 && course!='z') 
        {
            try 
            {
                if(operation.equals("input"))
                {
                  tb_original.createNodes(Bnumber,course,tb_backup1,tb_backup2);
                }
                else if(operation.equals("delete"))
                {
                  tb_original.deleteCourse(Bnumber,Character.toString(course));
                }
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       }
       
    }
	/**A to String function to be used if it's needed to print Driver 
	 * class's object
	*/
	public String toString()
	{
	 String str="this is a driver class's object";
         return str;
        }

}
