/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kishan
 */public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public void writeToFile(String s){ 
        
        if(s==null || s.length()==0)
        {
            System.out.println("please insert valid string file name");
        }
        else
        {
            BufferedWriter writer = null;
            try
            {
                writer = new BufferedWriter(new FileWriter(s));
                System.out.println("");
                writer.write(this.result);
                
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found");
            }
            catch (IOException ex) 
            {
                Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                   try {
                    writer.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
                    }

            }
        }
    }
    public void writeToStdout(String s){
        System.out.println(s);
    }
    
    public void storeNewResult(String s)
    {
        String temp;
        if(this.result!=null)
        {   
            temp=this.result+"\r\n"+s;
            this.result=temp;
        }
        else{
            this.result=s;
        }
        
    }
     public String toString(){//implement  
         return null;
        }
}

