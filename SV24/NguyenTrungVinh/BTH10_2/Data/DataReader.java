package SV24.NguyenTrungVinh.BTH10_2.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collections;
import java.util.HashMap;

import SV24.NguyenTrungVinh.BTH10_2.Builder.*;
import SV24.NguyenTrungVinh.BTH10_2.Obj.*;
import SV24.NguyenTrungVinh.BTH10_2.Obj.Readable;

public class DataReader {
    static String dir = System.getProperty("user.dir");
    static ArrayList<ReadableBuilderHelper> helpers = new ArrayList<>();
    
    public static void readAll(Libraly lib){
        try {
            getBooks();
            getMaganizes();
            toReadables(lib);

            getReaders(lib);
            getBorrowCard(lib);
            getMonetaryFine(lib);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void toReadables(Libraly lib){
        Collections.sort(helpers);
        for(ReadableBuilderHelper helper : helpers){
            Object builder = helper.getBuilder();
            if(builder instanceof BookBuilder)
                lib.addNewReadable(helper.getShelfType(), ((BookBuilder)builder).toBook(), helper.getAmount());
            else if (builder instanceof MagazineBuilder)
                lib.addNewReadable(helper.getShelfType(), ((MagazineBuilder)builder).toMagazine(), helper.getAmount());
            else
                System.out.println("ffffffff");
        }
    }

    static void getBooks() throws FileNotFoundException{
        File bookData = new File(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/books.txt");
        if(! bookData.exists())
            return;
        
        Scanner scanner = new Scanner(bookData);
        int nums = Integer.parseInt(scanner.nextLine());

        while(nums > 0){
            String readableType = scanner.nextLine();
            int amount = Integer.parseInt(scanner.nextLine());
            int id = Integer.parseInt(scanner.nextLine());
            BookBuilder builder = new BookBuilder()
                                            .title(scanner.nextLine())
                                            .author(scanner.nextLine())
                                            .publishYear(Integer.parseInt(scanner.nextLine()))
                                            .eposide(Integer.parseInt(scanner.nextLine()))
                                            .price(Integer.parseInt(scanner.nextLine()));

            helpers.add(new ReadableBuilderHelper(readableType, amount, id, builder));
            nums--;
        }

        scanner.close();
    }

    static void getMaganizes() throws FileNotFoundException{
        File maganizeData = new File(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/maganizes.txt");
        if(! maganizeData.exists())
            return;
        
        Scanner scanner = new Scanner(maganizeData);
        int nums = Integer.parseInt(scanner.nextLine());

        while(nums > 0){
            String readableType = scanner.nextLine();
            int amount = Integer.parseInt(scanner.nextLine());
            int id = Integer.parseInt(scanner.nextLine());

            MagazineBuilder builder = new MagazineBuilder()
                                                .title(scanner.nextLine())
                                                .no(Integer.parseInt(scanner.nextLine()))
                                                .publishDate(scanner.nextLine())
                                                .price(Integer.parseInt(scanner.nextLine()));

            helpers.add(new ReadableBuilderHelper(readableType, amount, id, builder));
            // lib.addNewReadable(readableType, builder.toMagazine(), amount);
            nums--;
        }

        scanner.close();
    }

    static void getReaders(Libraly lib) throws FileNotFoundException{
        File readerData = new File(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/readers.txt");
        if(! readerData.exists())
            return;
        
        Scanner scanner = new Scanner(readerData);
        int nums = Integer.parseInt(scanner.nextLine());
        ArrayList<Reader> readers = new ArrayList<>();
        for(int i = 0; i<nums; i++){
            ReaderBuilder builder = new ReaderBuilder()
                                            .name(scanner.nextLine())
                                            .phoneNumber(scanner.nextLine())
                                            .address(scanner.nextLine())
                                            .birthday(scanner.nextLine());

            readers.add(builder.toReader());
        }

        lib.addMember(readers);
        scanner.close();
    }

    static void getBorrowCard(Libraly lib) throws FileNotFoundException{
        File borrowData = new File(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/borrows.txt");
        if(! borrowData.exists())
            return;
        Scanner scanner = new Scanner(borrowData);
        int nums = Integer.parseInt(scanner.nextLine());
        TreeSet<BorrowCard> cards = new TreeSet<>();
        while (nums > 0){
            int readerID = Integer.parseInt(scanner.nextLine());
            int readableID = Integer.parseInt(scanner.nextLine());
            String time = scanner.nextLine();
            Reader reader = lib.getMember(readerID - 1);
            Readable readable = lib.getReadableAndAmount(readableID).readable();
            cards.add(new BorrowCard(reader, readable, time));
            nums--;
        }
        lib.addBorrowCard_init(cards);

        scanner.close();
    }

    static void getMonetaryFine(Libraly lib) throws FileNotFoundException{
        File moneyData = new File(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/monetaryFine.txt");
        if(! moneyData.exists())
            return;
        Scanner scanner = new Scanner(moneyData);
        int nums = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, Integer> mf = new HashMap<>();
        while (nums > 0){
            int id = Integer.parseInt(scanner.nextLine());
            int money = Integer.parseInt(scanner.nextLine());

            mf.put(id, money);
            nums--;
        }

        lib.init_monetaryFine(mf);

        scanner.close();
    }
}
