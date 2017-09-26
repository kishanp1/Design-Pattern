/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTree;

/**
 *
 * @author Kishan
 */
public class Node {
    private String courseName;
    private int Bnumber;

    public Node(String courseName, int Bnumber) {
        this.courseName = courseName;
        this.Bnumber = Bnumber;
    }
    
    public String getCourseName() {
        return courseName;
    }

    public int getBnumber() {
        return Bnumber;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setBnumber(int Bnumber) {
        this.Bnumber = Bnumber;
    }
    
    public String toString()
    {
        return this.Bnumber+" "+this.courseName;
    }
    
}
