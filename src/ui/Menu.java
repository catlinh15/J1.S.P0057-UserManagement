/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import util.Util;
/**
 *
 * @author DELL
 */
public class Menu {
    private String titleMenu;
    private ArrayList<String> optionM = new ArrayList<>();

    public Menu(String titleMenu) {
        this.titleMenu = titleMenu;
    }
    
    public void addOp(String op){
        this.optionM.add(op);
    }
    
    public void printMenu(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------" + titleMenu +"------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        for (String x : optionM) {
            System.out.println(x);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
    
    public int getChoice(){
        int max = optionM.size();
        return Util.isAnInteger("Enter your option: ", "Try again", 1, max);
    }
}
