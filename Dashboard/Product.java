package Dashboard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileWriter;
import java.io.FileReader;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Product {
    public static void main(String args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[34m";
        Scanner sc = new Scanner(System.in);
        String s=args;
        for (int i = 0; i < 1; i++) {

            System.out.println(ANSI_BLUE+"\u001B[35m"+"                                                                ***************                                                       "+"\u001B[0m"+ANSI_RESET);
            System.out.println(ANSI_BLUE+"\u001B[35m"+"                                                                * Categories  *                                     "+"\u001B[0m"+ANSI_RESET);
            System.out.println(ANSI_BLUE+"\u001B[35m"+"                                                                ***************                                                      "+"\u001B[0m"+ANSI_RESET);
            System.out.println();
            System.out.println("1).Electronics");
            System.out.println("2).Foot Wears");
            System.out.println("3).Clothes");
            System.out.println("4).Watches");
            System.out.println("5).Exit");
            System.out.println();
            System.out.println("Enter your choice : ");
            int n = sc.nextInt();

            if (n == 1) {
                System.out.println();
                electronic.main(args);
                i--;
            }
            else if(n==2){
                System.out.println();
                footwear.main(args);i--;
            }
            else if(n==3){
                System.out.println();
                clothing.main(args);i--;
            }
            else if(n==4){
                System.out.println();
                watch.main(args);i--;
            }
            else {
                break;
            }
        }
    }


}