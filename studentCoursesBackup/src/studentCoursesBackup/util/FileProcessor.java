/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Kishan
 */
public class FileProcessor {

 /**A function named readLine that will read a file
     * line by line and return it
     * @param a bufferedReader for the file to be read
     * @return return a single line if there is line to be
     *         read, otherwise returns null
     */

   public String readLine(BufferedReader br)
    {
        String line=null;
        try
        {
            if ((line = br.readLine()) != null) 
            {
                return line;
            }
            else
            {
                line=null;
                return line;
            }
        }
        catch (IOException ex) 
        {
            System.out.println("IOException occured");
            line=null;
        }
        return line;
    }
}
