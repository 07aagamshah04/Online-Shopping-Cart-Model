import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

import Dashboard.Product;
//directly imported package from javaproject floder
import Dashboard.dashboard;

public class Assignment {
    public static void main(String[] args) {
        // Example of clearing the screen
        System.out.print("\033[H\033[2J");

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        while (true) {

            System.out.println();
            System.out.println(ANSI_CYAN + "\u001B[35m"
                    + "                                                         ****************************************                                                       "
                    + "\u001B[0m" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\u001B[35m"
                    + "                                                           Welcome to Online Shopping cart model                                        "
                    + "\u001B[0m" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\u001B[35m"
                    + "                                                         ****************************************                                                      "
                    + "\u001B[0m" + ANSI_RESET);
            System.out.println();
            System.out.println("1). Login IN");
            System.out.println("2). Register");
            System.out.println("3). Exit");
            System.out.println();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice : ");
            int n = sc.nextInt();

            if (n >= 3) {
                System.out.println(
                        "--------------------------------------THANK YOU-----------------------------------------");
                break;
            } else if (n == 1) {
                String name = "", password;
                for (int i = 0; i < 1; i++) {
                    System.out.print("Email Id : ");
                    name = sc.next();

                    System.out.print("Password : ");
                    password = sc.next();

                    // For checking whether user-name and password exist or not
                    boolean flag = false;

                    try (BufferedReader reader = new BufferedReader(
                            new FileReader(
                                    "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//user_data.csv"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] userData = line.split(",");

                            if ((userData[1].equals(name)) && userData[2].equals(password)) {
                                System.out.println();
                                System.out.println(ANSI_GREEN + "Logged In Successfully" + ANSI_RESET);
                                System.out.println();
                                flag = true;
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        i--;
                        continue;
                    }
                    try {
                        if (flag == false) {
                            throw new Assignment_Exception(ANSI_RED + "Please enter valid input" + ANSI_RESET);
                        }
                    } catch (Assignment_Exception e) {
                        System.out.println("Exception : " + e);
                        i--;
                        continue;
                    }
                }
                String s1 = "";
                for (int i = 0; i < name.length(); i++) {
                    if (name.charAt(i) == '@') {
                        break;
                    } else {
                        s1 += name.charAt(i);
                    }
                }
                System.out.println();

                dashboard.main(s1);
            } else {
                String name = "", email = "", password = "", c_password;
                for (int i = 0; i < 1; i++) {
                    System.out.print("Username : ");
                    name = sc.next();

                    try {

                        System.out.print("Email-Id : ");
                        email = sc.next();

                        boolean flag = false;

                        try (BufferedReader reader = new BufferedReader(
                                new FileReader(
                                        "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//user_data.csv"))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                String[] userData = line.split(",");

                                if (userData[1].equals(email)) {
                                    throw new Email_Exception(ANSI_RED + "This email-id already exist." + ANSI_RESET);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            i--;
                            continue;
                        }
                    } catch (Email_Exception e) {
                        System.out.println("Exception : " + e);
                        i--;
                        continue;
                    }

                    try {
                        System.out.print("Password : ");
                        password = sc.next();

                        if (password.length() < 8) {
                            throw new Letter_exception(
                                    ANSI_RED + "Your password should contain atleast 8 characters " + ANSI_RESET);
                        }

                    } catch (Letter_exception e) {
                        System.out.println("Exception : " + e);
                        i--;
                        continue;
                    }

                    try {

                        System.out.print("Confirm Password : ");
                        c_password = sc.next();

                        if (!(c_password.equals(password))) {
                            throw new Password_checker(
                                    ANSI_RED + "Your password is not matching with previous password " + ANSI_RESET);
                        }
                    } catch (Password_checker e) {
                        System.out.println("Exception : " + e);
                        i--;
                        continue;
                    }
                }
                String s1 = "";
                for (int i = 0; i < email.length(); i++) {
                    if (email.charAt(i) == '@') {
                        break;
                    } else {
                        s1 += email.charAt(i);
                    }
                }

                String file1 = "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//"
                        + s1 + "_cart_file" + ".csv";

                String file2 = "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//"
                        + s1 + "_order_file" + ".csv";
                try (BufferedWriter writer = new BufferedWriter(
                        new FileWriter(
                                "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//user_data.csv",
                                true))) {
                    writer.write("\n" + name + "," + email + "," + password);
                    System.out.println();
                    System.out.println(ANSI_GREEN + "User data saved successfully." + ANSI_RESET);
                    System.out.println();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // System.out.print("\033[H\033[2J");
            }
        }
    }
}