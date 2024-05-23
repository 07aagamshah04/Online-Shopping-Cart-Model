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

class footwear extends Cart_adding {
    @Override
    public void add_cart(int id, String q, String name) {
        int ct = 1;
        String naam = "", pr = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//Footwear_item.csv"))) {
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
        String file1 = "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//" + name
                + "_cart_file" + ".csv";
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
        System.out.println("                 Footwear Products               ");
        System.out.println("---------------------------------------------------");
        System.out.println("ID " + "Name          " + " Price   " + "Quantity  ");
        int j = 1;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//Footwear_item.csv"))) {
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
                footwear obj = new footwear();
                obj.add_cart(id, q, args);
            } else {
                break;
            }
        }
    }
}