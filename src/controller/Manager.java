/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import util.Util;

/**
 *
 * @author DELL
 */
public class Manager {

    public static final String path = "D:\\Spring24\\LAB211\\J1.S.P0057-UserManagement\\src\\model\\user.txt";

    public static void createAccount() {
        while (true) {
            String username = Util.checkUserName("Enter the valid username (Username must be at least 5 characters and no spaces): ", "Try again");
            if (!Util.checkUserNameExist(username, path)) {
                Account acc = new Account();
                acc.setUserName(username);
                acc.setPassword(Util.checkPassword("Enter the valid password (Username must be at least 6 characters and no spaces): ", "Try again"));
                addAccount(acc);
                return;
            } else {
                System.out.println("Username existed");
            }
        }

    }

    public static void addAccount(Account acc) {
        File file = new File(path);
        if (!Util.checkFileExist(file)) {
            Util.createFile(file);
        }

//        try {
//            FileOutputStream fo = new FileOutputStream(file, true);
////            OutputStreamWriter osw = new OutputStreamWriter(fo, "UTF-8");
//            ObjectOutputStream oos = new ObjectOutputStream(fo);
//            oos.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try (
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw)) {
            String accountData = acc.toString();
            bw.write(accountData);
            bw.newLine();
            System.out.println("Account added successfully.");

        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void clearFile(String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath, false)) {
            fileOutputStream.write(0);
            System.out.println("File cleared successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LoginAcc(String username) {
        if (Util.checkUserNameExist(username, path)) {
            int count = 0;
            while (count < 3) {
                String pass = Util.checkPassword("Enter the valid password (Username must be at least 6 characters and no spaces): ", "Try again");

                if (!Util.checkPasswordExist(pass, path)) {
                    count++;
                    if ((3 - count) != 0) {
                        System.out.println("Inconsistent passwords" + "(You have " + (3 - count) + " inputs remaining)");
                    } else {
                        System.out.println("Inconsistent passwords");
                    }
                } else {
                    System.out.println("Login successful");
                    break;
                }
            }
        } else {
            System.out.println("Username not exist");
        }
    }

    public static void main(String[] args) {
//        clearFile(path);
//        addAccount(new Account("nhatthang", "thang123"));
        LoginAcc("catlinh");
    }
}
