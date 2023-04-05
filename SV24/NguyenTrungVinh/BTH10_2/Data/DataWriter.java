package SV24.NguyenTrungVinh.BTH10_2.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import SV24.NguyenTrungVinh.BTH10_2.Obj.Book;
import SV24.NguyenTrungVinh.BTH10_2.Obj.BorrowCard;
import SV24.NguyenTrungVinh.BTH10_2.Obj.Magazine;
import SV24.NguyenTrungVinh.BTH10_2.Obj.ReadableAndAmount;
import SV24.NguyenTrungVinh.BTH10_2.Obj.Reader;

public class DataWriter {
    static TreeMap<ReadableAndAmount, String> books = new TreeMap<>();
    static TreeMap<ReadableAndAmount, String> magazines = new TreeMap<>();
    static String dir = System.getProperty("user.dir");

    public static void refresh(boolean book, boolean magazine){
        try{
            if(book)
                writeAllBooks();
            if(magazine)
                writeAllMagazine();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void appendReadable(ReadableAndAmount rna, String shelfType){
        try{
            if(rna.readable() instanceof Book){
                books.put(rna, shelfType);
                writeAllBooks();
            }else {
                magazines.put(rna, shelfType);
                writeAllMagazine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeAllBooks() throws IOException{
        FileWriter writer = new FileWriter(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/books.txt");
        writer.write(books.size() + "\n");
        books.forEach((bna, type) -> {
            Book book = (Book) bna.readable();
            writeABook(writer, book, bna.amount(), type);
        });
        writer.close();
    }

    public static void writeABook(FileWriter writer, Book book, int amount, String type){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type);
        stringBuilder.append('\n');
        stringBuilder.append(amount);
        stringBuilder.append('\n');
        stringBuilder.append(book.getId());
        stringBuilder.append('\n');
        stringBuilder.append(book.getTitle());
        stringBuilder.append('\n');
        stringBuilder.append(book.getAuthor());
        stringBuilder.append('\n');
        stringBuilder.append(book.getPublishYear());
        stringBuilder.append('\n');
        stringBuilder.append(book.getEposide());
        stringBuilder.append('\n');
        stringBuilder.append(book.getPrice());
        stringBuilder.append('\n');
        try {
            writer.append(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllMagazine() throws IOException{
        FileWriter writer = new FileWriter(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/maganizes.txt");
        writer.write(magazines.size() + "\n");
        magazines.forEach((mna, type) -> {
            Magazine magazine = (Magazine) mna.readable();
            writeAMagazine(writer, magazine, mna.amount(), type);
        });
        writer.close();
    }

    public static void writeAMagazine(FileWriter writer, Magazine magazine, int amount, String type){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type);
        stringBuilder.append('\n');
        stringBuilder.append(amount);
        stringBuilder.append('\n');
        stringBuilder.append(magazine.getId());
        stringBuilder.append('\n');
        stringBuilder.append(magazine.getTitle());
        stringBuilder.append('\n');
        stringBuilder.append(magazine.getNo());
        stringBuilder.append('\n');
        stringBuilder.append(magazine.getPublishDate().toString());
        stringBuilder.append('\n');
        stringBuilder.append(magazine.getPrice());
        stringBuilder.append('\n');
        try {
            writer.append(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllReader(ArrayList<Reader> readers){
        try {
            FileWriter writer = new FileWriter(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/readers.txt");
            writer.write(readers.size() + "\n");
            for(Reader reader : readers){
                StringBuilder builder = new StringBuilder();
                builder.append(reader.getName());
                builder.append("\n");
                builder.append(reader.getPhoneNumber());
                builder.append("\n");
                builder.append(reader.getAdress());
                builder.append("\n");
                builder.append(reader.getBirthday().toString());
                builder.append("\n");
                writer.append(builder.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllBorrowCard(TreeSet<BorrowCard> cards){
        try {
            FileWriter writer = new FileWriter(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/borrows.txt");
            writer.write(cards.size() + "\n");
            for(BorrowCard card: cards){
                StringBuilder builder = new StringBuilder();
                builder.append(card.getReader().getId());
                builder.append("\n");
                builder.append(card.getReadable().getId());
                builder.append("\n");
                builder.append(card.getBorrowDate().toString());
                builder.append("\n");
                writer.append(builder.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllMF(HashMap<Integer, Integer> mf){
        try {
            FileWriter writer = new FileWriter(dir + "/SV24/NguyenTrungVinh/BTH10_2/Data/monetaryFine.txt");
            writer.write(mf.size() + "\n");
            for(int key: mf.keySet()){
                StringBuilder builder = new StringBuilder();
                builder.append(key);
                builder.append("\n");
                builder.append(mf.get(key));
                builder.append("\n");
                writer.append(builder.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
