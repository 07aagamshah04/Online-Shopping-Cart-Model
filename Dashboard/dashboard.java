package Dashboard;

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

public class dashboard {
    public static void main(String args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            System.out.println(ANSI_BLUE + "\u001B[35m"
                    + "                                                                ***************                                                       "
                    + "\u001B[0m" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "\u001B[35m"
                    + "                                                                *  Dashboard  *                                     "
                    + "\u001B[0m" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "\u001B[35m"
                    + "                                                                ***************                                                      "
                    + "\u001B[0m" + ANSI_RESET);
            System.out.println();
            System.out.println("1).View Products");
            System.out.println("2).View Cart");
            System.out.println("3).View Orders");
            System.out.println("4).Logout");
            System.out.println();
            System.out.print("enter your choice : ");
            int n = sc.nextInt();

            if (n == 1) {
                System.out.println();
                Product.main(args);
                i--;
            } else if (n == 2) {
                System.out.println();
                cart.main(args);
                i--;
            } else if (n == 3) {
                System.out.println();
                System.out.println("---------------------------------------------------");
                System.out.println(ANSI_YELLOW + "                 Your Orders              " + ANSI_RESET);
                System.out.println("---------------------------------------------------");
                System.out.println("ID " + "Name          " + " Price   " + "Quantity  " + "Total Price");
                String file1 = "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//"
                        + args + "_order_file" + ".csv";
                try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
                    int j = 1;
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] elec = line.split(",");
                        System.out.print(j + "  ");
                        j++;
                        System.out.print(elec[0]);
                        for (int k = 0; k < 15 - elec[0].length(); k++) {
                            System.out.print(" ");
                        }
                        System.out.print(elec[1]);
                        for (int k = 0; k < 10 - elec[1].length(); k++) {
                            System.out.print(" ");
                        }
                        System.out.print(elec[2]);
                        for (int k = 0; k < 9 - elec[2].length(); k++) {
                            System.out.print(" ");
                        }
                        Float total1 = Float.parseFloat(elec[1]);
                        Float total2 = Float.parseFloat(elec[2]);
                        Float final1 = total1 * total2;
                        System.out.print(final1);
                        System.out.println();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                i--;
            } else {
                System.out.print("\033[H\033[2J");
                break;
            }
        }
    }
}