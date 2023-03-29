package SV24.NguyenTrungVinh.BTH10_1.Bai1;

import java.util.Scanner;

public class ManagePhoneBook {
    private static Scanner scanner;
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        scanner = new Scanner(System.in);
    
        int option = 0;
        String name, phone;

        do{
            printOption();
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    System.out.println("Insert Phone");
                    name = inputSingle("Input name: ");
                    phone = inputSingle("Input phone pumber: ");
                    phoneBook.insertPhone(name, phone);
                    break;

                case 2:
                    System.out.println("Remove Phone");
                    name = inputSingle("Input name: ");
                    phoneBook.removePhone(name);
                    break;

                case 3:
                    System.out.println("Update Phone");
                    name = inputSingle("Input name: ");
                    phone = inputSingle("Input new phone number: ");
                    phoneBook.updatePhone(name, phone);
                    break;

                case 4:
                    System.out.println("Search Phone");
                    name = inputSingle("Input name: ");
                    Pair<String, String> p = phoneBook.searchPhone(name);
                    if(p == null)
                        System.out.println("Cannot find anyone have name: ");
                    else
                        System.out.println("Found: " + p);
                    break;

                case 5:
                    System.out.println("Sort");
                    phoneBook.sort();
                    break;

                case 6:
                    System.out.println(phoneBook);
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Invalid Option!!!");
                
            }

            if(option != 7)
                sleep(1000);

        }while(option != 7);

        scanner.close();
    }

    public static void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String inputSingle(String msg){
        System.out.print(msg);
        return scanner.nextLine();
    }

    public static void printOption(){
        System.out.println("==================================================");
        System.out.println("QUAN LY DANH BA DIEN THOAI - PHONEBOOK MANAGERMENT");
        System.out.println("==================================================");
        System.out.println("1. Insert Phone");
        System.out.println("2. Remove Phone");
        System.out.println("3. Update Phone");
        System.out.println("4. Search Phone");
        System.out.println("5. Sort");
        System.out.println("6. Print Phonebook");
        System.out.println("7. Quit");
        System.out.print("Select: ");
    }
}
