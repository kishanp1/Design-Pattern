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

	/**A private member to store all the tree
	*/   
 private String result;

/**getter method for result
	 *@param no paramters
	 *@return returns a String, which is the result member
	*/
    public String getResult() {
        return result;
    }


	/**Setter method for result
	 *@param A string that will be the value for result
	 *@return returns void
	*/
    public void setResult(String result) {
        this.result = result;
    }

/**An implementation of writeToFile method that will write 
	 * the result to the given file
	 * @param A string that will hold the path for the output file
	 * 	  or the file to be written
	 * @return void return
	*/
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

/**Implementation of writeToStdOut, not used in this specific
	 * project
	 * @param A string to be written to standard output
	 * @return void return
	*/
    public void writeToStdout(String s){
        System.out.println(s);
    }
    
/**With each test, it's result will be added to result member
	 * using the function storeNewResult
	 *@param A string, which will be a node, that
	* 	will be added into the result member of class
	* @retunr returns void
	*/
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
/**Overriding toString method, if its needed to print object
	 * of Results in different manner
	*/
     public String toString(){
         return null;
        }
}

