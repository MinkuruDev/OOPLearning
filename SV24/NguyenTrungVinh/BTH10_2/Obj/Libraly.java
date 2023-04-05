package SV24.NguyenTrungVinh.BTH10_2.Obj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import SV24.NguyenTrungVinh.BTH10_2.Data.DataWriter;

public class Libraly {
    private TreeMap<String, Shelf> allReadables;
    private ArrayList<Reader> members;
    private TreeSet<BorrowCard> borrowing;
    private HashMap<Integer, Integer> monetaryFine;

    public Libraly(){
        allReadables = new TreeMap<>();
        members = new ArrayList<>();
        borrowing = new TreeSet<>();
        monetaryFine = new HashMap<>();
    }

    public TreeMap<String, ArrayList<ReadableAndAmount>> find(String condtion){
        TreeMap<String, ArrayList<ReadableAndAmount>> res = new TreeMap<>();
        allReadables.forEach((readableType, shelf) -> {
            ArrayList<ReadableAndAmount> readables = shelf.select(
                rna -> rna.toString().toLowerCase()
                        .contains(condtion.toLowerCase())
            );
            
            if(readables.size() > 0)
                res.put(readableType, readables);
        });
        return res;
    }

    public TreeMap<String, ArrayList<ReadableAndAmount>> advancedFind(Shelf.Filterable filter){
        TreeMap<String, ArrayList<ReadableAndAmount>> res = new TreeMap<>();
        allReadables.forEach((readableType, shelf) -> {
            ArrayList<ReadableAndAmount> readables = shelf.select(filter);
            if(readables.size() > 0)
                res.put(readableType, readables);
        });
        return res;
    }

    public ReadableAndAmount getReadableAndAmount(int id){
        for(Shelf shelf : allReadables.values()){
            ArrayList<ReadableAndAmount> readables = shelf.select(r -> r.readable().getId() == id);
            if(readables.size() > 0)
                return readables.get(0);
        }

        return null;
    }

    public void addNewReadable(String type, Readable readable, int amount){
        Shelf shelf = allReadables.get(type);
        if(shelf == null){
            shelf = new Shelf();
            allReadables.put(type, shelf);
        }
        shelf.addReadable(readable, amount);
        DataWriter.appendReadable(getReadableAndAmount(readable.getId()), type);
    }

    public void addBorrowCard_init(TreeSet<BorrowCard> bc){
        borrowing.addAll(bc);
        DataWriter.writeAllBorrowCard(borrowing);
    }

    public void restockReadable(int readableID, int addAmount){
        ReadableAndAmount r = getReadableAndAmount(readableID);
        if(r == null){
            System.out.println("Cannot find readable ID:" + readableID);
            return;
        }
        r.addAmount(addAmount);
        System.out.println("Restock complete. " + r + " in stock");
        DataWriter.refresh(true, true);
    }

    public void addMember(ArrayList<Reader> readers){
        members.addAll(readers);
        DataWriter.writeAllReader(members);
    }

    public void addMember(Reader reader){
        members.add(reader);
        DataWriter.writeAllReader(members);
    }

    public Reader getMember(int index){
        if(index > members.size()) return null;
        return members.get(index);
    }

    public BorrowCard borrowReadable(int readerID, int readableID) throws Exception{
        ReadableAndAmount rna = getReadableAndAmount(readableID);
        if(rna == null)
            throw new Exception("There are no readable have ID: " + readableID);
        if(rna.amount() == 0)
            throw new Exception(rna.readable() + " is out of stock");
        if(monetaryFine.containsKey(readerID))
            throw new Exception(String.format("%s have to pay %dvnd monetary fine in order to borrow a new book",
                                                            getMember(readerID-1), monetaryFine.get(readerID)));
        int count = 0;
        for(BorrowCard b : borrowing)
            if(b.getReader().getId() == readerID){
                if(b.getReadable().getId() == readableID)
                    throw new Exception("This user already borrow this readable");
                count++;
            }
        if(count == 3)
            throw new Exception("Reader arleady borrow 3 books/maganizes");
        
        BorrowCard borrowCard = new BorrowCard(getMember(readerID-1), rna.readable());
        borrowing.add(borrowCard);
        DataWriter.writeAllBorrowCard(borrowing);
        System.out.println("Borrow success");
        System.out.println(borrowCard);
        rna.addAmount(-1);
        return borrowCard;
    }

    public int returnReadable(int readerID, int readableID){
        int days = 0;
        BorrowCard card = null;
        for(BorrowCard b : borrowing){
            if(b.getReader().getId() == readerID && b.getReadable().getId() == readableID){
                days = b.returnReadable();
                card = b;
                break;
            }
        }

        if(card == null) return -1;
        
        ReadableAndAmount rna = getReadableAndAmount(readableID);
        rna.addAmount(1);
        System.out.println("Return success");
        System.out.println(card);
        borrowing.remove(card);
        DataWriter.writeAllBorrowCard(borrowing);
        DataWriter.refresh(true, true);
        if(days > 45)
            monetaryFine.put(readerID, (int)(card.getReadable().getPrice() * 1.1));
        else if(days > 15) 
            monetaryFine.put(readerID, (days - 15) * 1_000);
        else
            return 0;
        return monetaryFine.get(readerID);
    }

    public void addMonetaryFine(int readerID, int money){
        monetaryFine.put(readerID, money);
        DataWriter.writeAllMF(monetaryFine);
    }

    public void init_monetaryFine(HashMap<Integer, Integer> mf){
        monetaryFine.putAll(mf);
        DataWriter.writeAllMF(monetaryFine);
    }

    public int getMonetaryFine(int readerID){
        if(! monetaryFine.containsKey(readerID)) return 0;
        return monetaryFine.get(readerID);
    }

    public void removeMonetaryFine(int readerID){
        monetaryFine.remove(readerID);
        DataWriter.writeAllMF(monetaryFine);
    }

    public void showAllMembers(){
        if(members.size() == 0){
            System.out.println("Libraly has 0 member :(");
            return;
        }

        System.out.println("===Members List===");
        for(Reader reader : members)
            System.out.println(reader);
    }

    public void showAllBorrowing(){
        if(borrowing.size() == 0){
            System.out.println("No one borrowin anything in the present");
            return;
        }

        System.out.println("===Borrowing List===");
        for(BorrowCard card : borrowing)
            System.out.println(card);
    }

    public void showAllReadable(){
        if(allReadables.size() == 0){
            System.out.println("Libraly too poor, donate to build better one");
            System.out.println("22210004236664 BIDV");
            return;
        }

        System.out.println("===Current Books in the libraly===");

        allReadables.forEach((type, shelf) -> {
            System.out.println("Shelf: " + type);
            shelf.select(readableAndAmount -> {
                System.out.println(readableAndAmount + " in stock");
                return false; // print readable without select
            });
        });

    }

}
