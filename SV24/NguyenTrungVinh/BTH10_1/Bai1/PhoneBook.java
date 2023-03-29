package SV24.NguyenTrungVinh.BTH10_1.Bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook extends Phone{
    private List<Pair<String, String>> phoneList;
    private boolean sorted;

    public PhoneBook(){
        phoneList = new ArrayList<>();
        sorted = true;
    }

    @Override
    public String toString() {
        if(phoneList.size() == 0)
            return "No one in the phone book";
        
        StringBuilder builder = new StringBuilder();
        builder.append("Phone List:\n");
        int i = 0;
        for(Pair<String, String> p : phoneList){
            i++;
            String s = String.format("%d. %s - %s\n", i, p.first(), p.second());
            builder.append(s);
        }
        return builder.toString();
    }

    @Override
    public void insertPhone(String name, String phone) {
        Pair<String, String> p = searchPhone(name);
        if(p != null){
            p.second(p.second() + ":" + phone);
            System.out.println("Inserted " + p);
            return;
        }

        phoneList.add(new Pair<String,String>(name, phone));
        int size = phoneList.size();
        if(size > 1 && phoneList.get(size-1).compareTo(phoneList.get(size-2)) < 0)
            sorted = false;
        System.out.println("Inserted " + phoneList.get(size-1));
    }

    @Override
    public void removePhone(String name) {
        Pair<String,String> p = searchPhone(name);
        if(p == null){
            System.out.println(name + "Not Exists");
        }else{
            System.out.println("Removed " + p);
            phoneList.remove(p);
        }
    }

    @Override
    public void updatePhone(String name, String newphone) {
        Pair<String, String> p = searchPhone(name);
        if(p == null){
            insertPhone(name, newphone);
            System.out.println(name + "Not Exists, insert new " + name + " - " + newphone);
        }else{
            p.second(newphone);
            System.out.println("Updated " + p);
        }
    }

    @Override
    public Pair<String, String> searchPhone(String name) {
        if(sorted && phoneList.size() > 16){
            // binary search
            int l = 0, r = phoneList.size() - 1;
            while(l <= r){
                int mid = (l + r) / 2;
                Pair<String, String> p = phoneList.get(mid);
                int comp = p.first().compareTo(name);

                if(comp == 0)
                    return p;
                else if(comp > 0)
                    r = mid - 1;
                else 
                    l = mid + 1;
            }

            return null;
        }

        for(Pair<String, String> p : phoneList){
            if(p.first().equals(name))
                return p;
        }

        return null;
    }

    @Override
    public void sort() {
        if(sorted) return;
        Collections.sort(phoneList);
        sorted = true;
    }
    
}
