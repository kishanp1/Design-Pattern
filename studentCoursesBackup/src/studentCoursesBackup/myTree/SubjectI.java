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
/**A Subject interface
*/
public interface SubjectI {
   /**Declaration of registerObservers
    *@param A Node's Object
    *@return void return
    */
    public void registerObserver(Node o);

 /**Declaration of removeObserver
    *@param A Node's Object
    *@return void return
    */
    public void removeObserver(Node o);

 /**Declaration of Notifyall
    *@param A String named course
    *@return void return
    */

    public void notifyall(String course); 

}
