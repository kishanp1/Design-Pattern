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
        FileProcessor d = new FileProcessor();
        Driver driver=new Driver();
        TreeBuilder tb_original=new TreeBuilder();
        TreeBuilder tb_backup1=new TreeBuilder();
        TreeBuilder tb_backup2=new TreeBuilder();
        BufferedReader br = null;
        String operation=null;
        Results rs=new Results();
        if(args==null || args.length<=1)
        {
            System.out.println("please insert valid number of filename"+args.length+" "+args[0]);
        }
        int flag=0;
        try
        {
            String path="C:\\Users\\Kishan\\Documents\\NetBeansProjects\\studentCoursesBackup\\src\\"+args[0];
            System.out.println("path="+args[0]);
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
            String path2="C:\\Users\\Kishan\\Documents\\NetBeansProjects\\studentCoursesBackup\\src\\"+args[1];
            System.out.println("path="+args[1]);
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
            System.out.println("check=="+rs.getResult());
            rs.setResult(null);
            System.out.println("===");
            tb_backup1.writeResults(rs,"backup 1",args[3]);
            rs.setResult(null);
            tb_backup2.writeResults(rs,"backup 2",args[4]);
            
        }
        
       
    }

    private void processLine(String line,TreeBuilder tb_original,TreeBuilder tb_backup1,TreeBuilder tb_backup2,String operation) {
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
}
