/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

import controller.Manager;
import ui.Menu;
import util.Util;

/**
 *
 * @author DELL
 */
public class J1SP0057 {

    
    public static void main(String[] args) {
        // TODO code application logic here
        String[] menu = {
            "1. Create a new account",
            "2. Login system",
            "3. Exit"
        };

        Menu mn = new Menu("USER MANAGER");
        for (String x : menu) {
            mn.addOp(x);
        }
        int choice;
        do {
            mn.printMenu();
            choice = mn.getChoice();

            switch (choice) {
                case 1:
                    Manager.createAccount();
                    break;
                case 2:
                    Manager.LoginAcc(
                            Util.checkUserName(
                                    "Enter the valid username (Username must be at least 5 characters and no spaces): ", "Try again"));
                    break;
                case 3:
                    System.out.println("Exit");
                    break;

            }

        } while (choice != menu.length);
    }

}
