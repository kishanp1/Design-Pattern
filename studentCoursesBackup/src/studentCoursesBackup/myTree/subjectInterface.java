/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTree;

import java.util.Observer;

/**
 *
 * @author Kishan
 */
public interface subjectInterface {
    public void registerObserver(ObserverI o);
    public void removeObserver(ObserverI o);
    public void notifyObserver();
}
