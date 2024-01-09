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

class electronic extends Cart_adding {
    @Override
    public void add_cart(int id, String q, String name) {
        int ct = 1;
        String naam = "", pr = "";
        String cartFile = "D:\\Java programs\\my first project\\src\\Dashboard\\Electronic_item.csv";
        // boolean flag = false;
        // int count = 0;
        // float qn = 0;
        // try {
        // BufferedReader reader = new BufferedReader(new FileReader(cartFile));
        // StringBuilder updatedCartData = new StringBuilder();

        // int a = 1;
        // String line;
        // while ((line = reader.readLine()) != null) {
        // String[] parts = line.split(",");
        // if (a == id) {
        // qn = Float.parseFloat(parts[2]);
        // }
        // a++;
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // float q1 = Float.parseFloat(q);
        // if (q1 > qn) {
        // System.out.println("We have Limited quantity then you want!");
        // System.out.println("We have add "+q1+" in our stock. Now you can order!");
        // try {
        // BufferedReader reader = new BufferedReader(new FileReader(cartFile));
        // StringBuilder updatedCartData = new StringBuilder();

        // int a = 1;
        // String line;
        // while ((line = reader.readLine()) != null) {
        // String[] parts = line.split(",");
        // if (a != id) {
        // updatedCartData.append(line).append("\n");
        // } else {
        // // parts[2] = Object.toString(q1+qn);
        // line = parts[0] + ',' + parts[1] + ',' + parts[2];
        // updatedCartData.append(line).append("\n");
        // }
        // a++;
        // }

        // reader.close();

        // FileWriter writer = new FileWriter(cartFile);
        // writer.write(updatedCartData.toString());
        // writer.close();

        // // System.out.println(ANSI_GREEN + "Changes to item removed successfully." +
        // ANSI_RESET);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // return;
        // }
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "D:\\Java programs\\my first project\\src\\Dashboard\\Electronic_item.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cloth = line.split(",");
                if (ct == id) {
                    naam = cloth[0];
                    pr = cloth[1];
                    break;
                } else {
                    ct++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String file1 = "D:\\Java programs\\my first project\\src\\Dashboard\\" + name + "_cart_file" + ".csv";
        // String
        // file1="C:\\Users\\aagam\\OneDrive\\Desktop\\Javaproject\\myfirstproject\\src\\Dashboard\\"+name+"_cart_file"+".csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1, true))) {
            writer.write(naam + "," + pr + "," + q + "\n");
            System.out.println("Added to your cart successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println("                 Electronic Products               ");
        System.out.println("---------------------------------------------------");
        System.out.println("ID " + "Name          " + " Price   " + "Quantity  ");
        int j = 1;
        try (BufferedReader reader = new BufferedReader(
                new FileReader("D:\\Java programs\\my first project\\src\\Dashboard\\Electronic_item.csv"))) {
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
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println();
            System.out.println("To Make Purchase press 1");
            System.out.println("Go Back to Categories Press 2");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter the Id of the Product: ");
                int id = sc.nextInt();
                System.out.print("Enter the Quantity: ");
                String q = sc.next();
                electronic obj = new electronic();
                obj.add_cart(id, q, args);
            } else {
                break;
            }
        }
    }
}