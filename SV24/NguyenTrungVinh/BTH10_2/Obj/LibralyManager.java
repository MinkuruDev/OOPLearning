package SV24.NguyenTrungVinh.BTH10_2.Obj;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import SV24.NguyenTrungVinh.BTH10_2.Builder.*;

public class LibralyManager {
    private final Libraly libraly;
    private final Scanner scanner;

    public LibralyManager(Libraly libraly){
        this.libraly = libraly;
        scanner = new Scanner(System.in);
    }

    private void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Book inputBook(){
        System.out.println("===Input book===");
        BookBuilder builder = new BookBuilder();
        System.out.print("Input title: ");
        builder.title(scanner.nextLine());
        System.out.print("Input author: ");
        builder.author(scanner.nextLine());
        System.out.print("Input publish year: ");
        builder.publishYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Input eposide: ");
        builder.eposide(Integer.parseInt(scanner.nextLine()));
        System.out.print("Input price: ");
        builder.price(Integer.parseInt(scanner.nextLine()));
        return builder.toBook();
    }

    private Magazine inputMagazine(){
        System.out.println("===Input magazine===");
        MagazineBuilder builder = new MagazineBuilder();
        System.out.print("Input title: ");
        builder.title(scanner.nextLine());
        System.out.print("Input publish date (yyyy-mm-dd example 2023-04-01): ");
        builder.publishDate(scanner.nextLine());
        System.out.print("Input no: ");
        builder.no(Integer.parseInt(scanner.nextLine()));
        System.out.print("Input price: ");
        builder.price(Integer.parseInt(scanner.nextLine()));
        return builder.toMagazine();
    }

    public void start(){
        int option = 0;
        while(true){
            printOption();
            option = Integer.parseInt(scanner.nextLine());
            switch(option){
                case 0:
                    break;
                
                case 1:
                    printAll();
                    break;

                case 2:
                    findBook();
                    break;

                case 3:
                    register();
                    break;

                case 4:
                    borrowReadable();
                    break;

                case 5:
                    returnReadable();
                    break;

                case 6:
                    payMonetaryFine();
                    break;

                case 7:
                    addNewReadable();
                    break;

                case 8:
                    restockReadable();
                    break;

                case 9:
                    printAllMember();
                    break;

                case 10:
                    printAllBorrowing();
                    break;

                default:
                    System.out.println("Invalid option !!!");
            }

            if(option != 0) sleep(1696);
            else break;
        };

        scanner.close();
    }

    public void printOption(){
        System.out.println("\n=====Libraly Manager v1.0=====");
        System.out.println("1. Print all books/magazines");
        System.out.println("2. Find books/magazine");
        System.out.println("3. Register new Reader");
        System.out.println("4. Borrow a book/magazine");
        System.out.println("5. Return a book/magazine");
        System.out.println("6. Pay monetary fine");
        System.out.println("7. Add new books/magazines");
        System.out.println("8. Restock exist book/magazine");
        System.out.println("9. Print all members");
        System.out.println("10. Print all borrowing card");
        System.out.println("0. Exit");
        System.out.print("Your option: ");
    }

    public void printAll(){
        libraly.showAllReadable();
    }

    public void printAllMember(){
        libraly.showAllMembers();
    }

    public void printAllBorrowing(){
        libraly.showAllBorrowing();
    }

    public void findBook(){
        System.out.print("Enter keyword: ");
        String condtion = scanner.nextLine();
        TreeMap<String, ArrayList<ReadableAndAmount>> res = libraly.find(condtion);
        if(res.size() == 0){
            System.out.println("Can not find anything match condition");
            return;
        }

        System.out.println("Search result:");
        res.forEach((shelf, found) -> {
            System.out.println("Shelf: " + shelf);
            for(ReadableAndAmount rna : found){
                System.out.println(rna + " in stock");
            }
        });
    }

    public void register(){
        System.out.println("===== Register new members =====");
        ReaderBuilder builder = new ReaderBuilder();
        System.out.print("Input name: ");
        builder.name(scanner.nextLine());
        System.out.print("Input phone number: ");
        builder.phoneNumber(scanner.nextLine());
        System.out.print("Input birthday (yyyy-mm-dd example: 2004-03-22): ");
        builder.birthday(scanner.nextLine());
        System.out.print("Input adress: ");
        builder.address(scanner.nextLine());
        Reader reader = builder.toReader();
        libraly.addMember(reader);
        System.out.println("New member added: \n" + reader);
    }

    public void borrowReadable(){
        System.out.println("=====Borrow books/magazines=====");
        System.out.print("Input reader ID: ");
        int readerID = Integer.parseInt(scanner.nextLine());
        System.out.print("Input book/magazine ID: ");
        int readableID = Integer.parseInt(scanner.nextLine());

        try {
            libraly.borrowReadable(readerID, readableID);
        } catch (Exception e) {
            System.out.println("Cannot borrow readable ID: " + readableID);
            System.out.println(e.getMessage());
        }
    }

    public void returnReadable(){
        System.out.println("=====Return books/magazines=====");
        System.out.print("Input reader ID: ");
        int readerID = Integer.parseInt(scanner.nextLine());
        System.out.print("Input book/magazine ID: ");
        int readableID = Integer.parseInt(scanner.nextLine());

        int money = libraly.returnReadable(readerID, readableID);
        if(money < 0)
            System.out.println("Cannot return readable, some error occur");
        else if(money > 0)
            System.out.println("This readable is returned late, reader have to pay " 
            + money + "vnd Monetary fine");
    }

    public void payMonetaryFine(){
        System.out.println("=====Pay monetary fine=====");
        System.out.print("Input reader ID: ");
        int readerID = Integer.parseInt(scanner.nextLine());
        int money = libraly.getMonetaryFine(readerID);

        if(money == 0){
            System.out.println("Great member! this member don't have any monetary fine");
            return;
        }

        System.out.println("This member have to pay " + money + "vnd");
        System.out.print("Is this member paid enough (y/n)? ");
        if(scanner.nextLine().equals("y")){
            System.out.println("Confirmed");
            libraly.removeMonetaryFine(readerID);
        }
    }

    public void addNewReadable(){
        System.out.println("===Add new book/maganzine===");
        System.out.print("What type of readable (book-b/magazine-m)?");
        Readable readable = null;
        if(scanner.nextLine().equals("b"))
            readable = inputBook();
        else
            readable = inputMagazine();
        
        System.out.print("What shelf this readable should be put in: ");
        String type = scanner.nextLine();
        System.out.print("How many copies of this readable: ");
        int amount = Integer.parseInt(scanner.nextLine());

        libraly.addNewReadable(type, readable, amount);
        System.out.println("Added " + readable +
                            " with " + amount + 
                            " copies to the shelf " + type);
    }

    public void restockReadable(){
        System.out.println("===Restock book/maganzine===");
        System.out.print("Input readable ID: ");
        int readableID = Integer.parseInt(scanner.nextLine());
        System.out.print("Input new stock to add: ");
        int amount = Integer.parseInt(scanner.nextLine());
        libraly.restockReadable(readableID, amount);
    }
}
