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
import java.io.File;
import java.io.IOException;
import java.util.*;
import Dashboard.*;

class cart {
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
        float cost = 0;
        for (int k = 0; k < 1; k++) {

            System.out.println("---------------------------------------------------");
            System.out.println("                 Your Cart              ");
            System.out.println("---------------------------------------------------");
            System.out.println("ID " + "Name          " + " Price   " + "Quantity  " + "Total Price");
            int j = 1;

            String file1 = "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//"
                    + args + "_cart_file" + ".csv";
            try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] elec = line.split(",");
                    System.out.print(j + "  ");
                    j++;
                    System.out.print(elec[0]);
                    for (int i = 0; i < 15 - elec[0].length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.print(elec[1]);
                    for (int i = 0; i < 10 - elec[1].length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.print(elec[2]);
                    for (int i = 0; i < 9 - elec[2].length(); i++) {
                        System.out.print(" ");
                    }
                    Float total1 = Float.parseFloat(elec[1]);
                    Float total2 = Float.parseFloat(elec[2]);
                    Float final1 = total1 * total2;
                    cost += final1;
                    System.out.print(final1);
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("Total cost: " + cost);
            System.out.println();
            System.out.println("1).To Order.");
            System.out.println("2).To remove item.");
            System.out.println("3).Back to Dashboard.");
            System.out.println();
            System.out.println("Enter your choice : ");
            int n = sc.nextInt();
            System.out.println();
            if (n == 1) {
                System.out.println();
                random.main(args);
            } else if (n == 2) {
                File cartFile = new File(file1);

                int id;
                String q;
                System.out.println("Enter id of the product which you want to remove : ");
                id = sc.nextInt();
                System.out.println("Enter how many quantity you want to have in your cart : ");
                q = sc.next();

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(cartFile));
                    StringBuilder updatedCartData = new StringBuilder();

                    int a = 1;
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (a != id) {
                            updatedCartData.append(line).append("\n");
                        } else {
                            if (q == "0") {
                                continue;
                            }

                            parts[2] = q;
                            line = parts[0] + ',' + parts[1] + ',' + parts[2];
                            updatedCartData.append(line).append("\n");
                        }
                        a++;
                    }

                    reader.close();

                    FileWriter writer = new FileWriter(cartFile);
                    writer.write(updatedCartData.toString());
                    writer.close();

                    System.out.println(ANSI_GREEN + "Changes to item removed successfully." + ANSI_RESET);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                k--;
            } else {
                break;
            }
        }
    }
}