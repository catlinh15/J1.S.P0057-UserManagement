/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Util {

    public static Scanner sc = new Scanner(System.in);
    public static final String userName = "^[^\\s]{5,}$";
    public static final String password = "^[^\\s]{6,}$";

    public static String isAString(String mess, String error) {
        String result = "";
        while (true) {
            try {
                System.out.print(mess);
                result = sc.nextLine();
                return result;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static int isAnInteger(String mess, String error, int max, int min) {
        int result = 0;
        while (true) {
            try {
                result = Integer.parseInt(isAString(mess, error));
                if (result <= min && result >= max) {
                    return result;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static String checkUserName(String mess, String error) {
        while (true) {
            String result = isAString(mess, error);
            if (result.matches(userName)) {
                return result;
            } else {
                System.out.println(error);
            }
        }
    }

    public static String checkPassword(String mess, String error) {
        while (true) {
            String result = isAString(mess, error);
            if (result.matches(password)) {
                return result;
            } else {
                System.out.println(error);
            }
        }
    }

    public static boolean checkFileExist(File f) {
        if (!f.exists()) {
            System.out.println("File not exist");
            return false;
        }
        return true;
    }

    public static void createFile(File f) {
        try {
            f.createNewFile();
            System.out.println("File created successful");
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    public static boolean checkUserNameExist(String username, String f) {
//        File file = new File("D:\\Spring24\\LAB211\\J1.S.P0057-UserManagement\\src\\model\\user.dat");
        boolean flag = false;
//        try {
//            FileInputStream fi = new FileInputStream(f);
//            ObjectInputStream ob = new ObjectInputStream(fi);
//
//            try {
//                while (true) {
//                    Account tmp = (Account) ob.readObject();
//                    if (tmp.getUserName().equals(username)) {
//                        flag = true;
//                        break;
//                    }
//                }
//            } catch (ClassNotFoundException ex) {
//                ex.printStackTrace();
//            }
//            ob.close();
//            fi.close();
//        } catch (FileNotFoundException ex) {
//            //  Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            // Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)) {

            String line;

            while ((line = br.readLine()) != null) {
                String arr[] = line.split(";");
                if (arr[0].equals(username)) {
                    flag = true;
                    break;
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public static boolean checkPasswordExist(String password, String f) {
        boolean flag = false;
        try (FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)) {

            String line;

            while ((line = br.readLine()) != null) {
                String arr[] = line.split(";");
                if (arr[1].equals(password)) {
                    flag = true;
                    break;
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args) {
//        File file = new File("D:\\Spring24\\LAB211\\J1.S.P0057\\src\\model\\user.txt");
        String f = "D:\\Spring24\\LAB211\\J1.S.P0057-UserManagement\\src\\model\\user.txt";
//        createFile(file);
//        checkFileExist(file);
        if (!checkUserNameExist("catlinh", f)) {
            System.out.println("kh ton tai");
        } else {
            System.out.println("ton tai");
        };

        if (!checkUserNameExist("nhatthang", f)) {
            System.out.println("kh ton tai");
        } else {
            System.out.println("ton tai");
        };

        if (!checkUserNameExist("trinhtrinh", f)) {
            System.out.println("kh ton tai");
        } else {
            System.out.println("ton tai");
        };
//            
//            if(!checkUserNameExist("nhatthang", f)){
//                System.out.println("kh ton tai");
//            }else{
//                System.out.println("ton tai");
//            };

    }
}
