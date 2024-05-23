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
import Dashboard.Upi_Exception;
import Dashboard.pin_Exception;

class GPay extends payment {
    @Override
    public String number() {
        String up;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your UPI-ID : ");
        up = sc.next();
        return up;
    }

    @Override
    public String pin() {
        String up;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your UPI-PIN : ");
        up = sc.next();
        return up;
    }

    @Override
    public float get_total(String args) {
        // int j = 1;

        String file1 = "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//" + args
                + "_cart_file" + ".csv";
        float final1 = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elec = line.split(",");
                Float total1 = Float.parseFloat(elec[1]);
                Float total2 = Float.parseFloat(elec[2]);
                final1 += total1 * total2;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (final1);
    }
}

class Credit_card extends payment {
    @Override
    public String number() {
        String up;
        System.out.print("Enter your 16 digit credit card number : ");
        Scanner sc = new Scanner(System.in);
        up = sc.next();
        return up;
    }

    @Override
    public String pin() {
        String up;
        System.out.print("Enter your 4-digit pin : ");
        Scanner sc = new Scanner(System.in);
        up = sc.next();
        return up;
    }

    @Override
    public float get_total(String args) {
        // int j = 1;

        String file1 = "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//" + args
                + "_cart_file" + ".csv";
        float final1 = 0f;
        try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elec = line.split(",");
                Float total1 = Float.parseFloat(elec[1]);
                Float total2 = Float.parseFloat(elec[2]);
                final1 = total1 * total2;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (final1);
    }
}

public class random {
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

        System.out.println("1).For Gpay");
        System.out.println("2).Credit Card");
        System.out.println();
        System.out.print("Enter your choice : ");
        int n = sc.nextInt();
        System.out.println();
        String num = "";
        String pin = "";
        float total = 0;
        for (int i = 0; i < 1; i++) {
            if (n == 1) {
                GPay obj = new GPay();
                try {
                    String up = obj.number();
                    num = up;
                    if (up.length() != 12) {
                        throw new Upi_Exception(ANSI_RED + "Your UPI-ID must contain 12 characters." + ANSI_RESET);
                    }
                } catch (Upi_Exception e) {
                    System.out.println("Exception : " + e);
                    i--;
                    continue;
                }
                try {
                    String up = obj.pin();
                    pin = up;
                    if (up.length() != 6) {
                        throw new pin_Exception(ANSI_RED + "Your pin must contain six digits." + ANSI_RESET);
                    }
                } catch (pin_Exception e) {
                    System.out.println("Exception : " + e);
                    i--;
                }
                float cost = obj.get_total(args);
                total = cost;
            } else {
                Credit_card obj = new Credit_card();
                try {
                    String up = obj.number();
                    num = up;
                    if (up.length() != 16) {
                        throw new Upi_Exception(ANSI_RED + "Your UPI-ID must contain 16 characters." + ANSI_RESET);
                    }
                } catch (Upi_Exception e) {
                    System.out.println("Exception : " + e);
                    i--;
                    continue;
                }
                try {
                    String up = obj.pin();
                    pin = up;
                    if (up.length() != 4) {
                        throw new pin_Exception(ANSI_RED + "Your pin must contain four digit." + ANSI_RESET);
                    }
                } catch (pin_Exception e) {
                    System.out.println("Exception : " + e);
                    i--;
                }
                float cost = obj.get_total(args);
                total = cost;
            }
        }
        String add = "";
        System.out.print("Enter your shipping address : ");
        sc.nextLine();
        add = sc.nextLine();
        String name = "";
        System.out.print("Enter your Name : ");
        name = sc.nextLine();
        String phone = "";
        for (int i = 0; i < 1; i++) {
            try {
                System.out.print("Enter your mobile no : ");
                phone = sc.next();
                if (phone.length() == 10) {
                    for (int j = 0; j < 10; j++) {
                        if (phone.charAt(j) >= '0' && phone.charAt(j) <= '9') {
                            continue;
                        } else {
                            throw new Phone_Exception(ANSI_RED + "Your phone number must contain digits." + ANSI_RESET);
                        }
                    }
                } else {
                    throw new Phone_Exception(ANSI_RED + "Your phone number must be of 10-digits." + ANSI_RESET);
                }
            } catch (Phone_Exception e) {
                System.out.println("Exception : " + e);
                i--;
            }
        }
        float cost = 0;
        String file1 = "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//" + args
                + "_order_file" + ".csv";
        String file2 = "C://Users//aagam//OneDrive//Desktop//MyProject//Online-Shopping-Cart-Model//Dashboard//" + args
                + "_cart_file" + ".csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1, true))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] elec = line.split(",");
                    float total1 = Float.parseFloat(elec[1]);
                    float total2 = Float.parseFloat(elec[2]);
                    cost += total1 * total2;
                    float f = total1 * total2;
                    writer.write(elec[0] + "," + elec[1] + "," + elec[2] + "," + f + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Your BiLL : ");
        float final1 = 0;
        System.out.println("+--------------------+----------+------+------------+");
        System.out.printf("| %-18s | %-8s | %-4s | %-10s |\n", "Name", "Price", "Qty", "Total");
        System.out.println("+--------------------+----------+------+------------+");
        try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elec = line.split(",");
                float total1 = Float.parseFloat(elec[1]);
                float total2 = Float.parseFloat(elec[2]);
                final1 = total1 * total2;
                System.out.printf("| %-18s | %-8s | %-4s |", elec[0], elec[1], elec[2]);
                System.out.printf(" %-10.2f |%n", final1);

            }
            System.out.println("+--------------------+----------+------+------------+");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // String s1="";
        System.out.printf("| %-37s|", "Total Cost:");
        System.out.printf(" %-10.2f |%n", cost);
        System.out.println("+--------------------+----------+------+------------+");
        System.out.println();
        System.out.println("Shipping Address : " + add);
        System.out.println();
        System.out.println("Name : " + name);
        System.out.println();
        System.out.println("Contact no : " + phone);
        System.out.println();
        System.out.println();
        System.out.println(
                ANSI_GREEN + "                             =======================================" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "                                      Thank You for Shopping!" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "                                     We hope to see you again!" + ANSI_RESET);
        System.out.println(
                ANSI_GREEN + "                             =======================================" + ANSI_RESET);
        System.out.println();
        System.out.println();
        System.out.println();
    }

}