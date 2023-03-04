package SV24.NguyenTrungVinh.B15D52.BTH2;

import java.util.ArrayList;
import java.util.Scanner;

public class TestEmployee {
    static ArrayList<Employee> employees;
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        employees = new ArrayList<>();

        // employees.add(new Employee(10, "Nguyen", "Van A", 10_000_000));
        // employees.add(new Employee(12, "Nguyen", "Van B", 11_000_000));
        // employees.add(new Employee(15, "Nguyen", "Van C", 12_000_000));
        // employees.add(new Employee(19, "Nguyen", "Van D", 13_000_000));
        // employees.add(new Employee(24, "Nguyen", "Van E", 14_000_000));
        // employees.add(new Employee(30, "Nguyen", "Van F", 15_000_000));
        // employees.add(new Employee(37, "Nguyen", "Van G", 16_000_000));

        System.out.print("Nhap so luong nhan vien: ");
        int n = scanner.nextInt();
        for(int i = 0; i<n; i++){
            employees.add(nhapNhanVien("Nhap nhan vien thu " + i));
        }

        printEmployees(employees, "Danh sach nhan vien", "Hien khong co nhan vien");

        Employee e = nhapNhanVien("nhap quan ly:");
        Manager manager = new Manager(e.id, e.getFirstName(), e.getLastName(), e.getSalary());
        manager.setYearExpNotSetSalary(e.getYearExp());
        manager.setTeam(employees);
        System.out.println(manager);

        findEmployee();
        nghiHuu();
        
        scanner.close();
    }

    public static Employee nhapNhanVien(String msg){
        System.out.println(msg);
        System.out.print("Nhap ID: ");
        int id = scanner.nextInt();
        System.out.print("Nhap Ho: ");
        scanner.nextLine();
        String firstName = scanner.nextLine();
        System.out.print("Nhap Ten: ");
        String lastName = scanner.nextLine();
        System.out.print("Nhap Luong: ");
        int salary = scanner.nextInt();

        Employee employee = new Employee(id, firstName, lastName, salary);
        System.out.print("Nhap so nam kinh nghiem: ");
        int year = scanner.nextInt();
        employee.setYearExp(year);
        return employee;
    }

    public static void nghiHuu(){
        ArrayList<Employee> huu = getEmployees((need, has) -> has.getYearExp() >= 30, null);
        printEmployees(huu, "Nhung nhan vien da den tuoi nghi huu", "Tat ca cac nhan vien deu chua nghi huu");
    }

    public static void findEmployee(){
        int select = 1;
        ArrayList<Employee> res = null;
        do{
            System.out.println("Tim kiem nhan vien");
            System.out.println("1 - Tim kiem theo id");
            System.out.println("2 - Tim kiem theo ten");
            System.out.println("3 - Tim kiem theo luong");
            System.out.print("Lua chon cua ban: ");
            select = scanner.nextInt();
            scanner.nextLine(); // flush

            switch(select){
                case 1:
                    System.out.print("Nhap ID can tim kiem: ");
                    int id = scanner.nextInt();
                    res = getEmployees((need, has) -> need.id == has.id, 
                                        new Employee(id, null, null, 0));
                break;
                
                case 2:
                    System.out.print("Nhap Ten can tim kiem: ");
                    String name = scanner.nextLine();
                    res = getEmployees((need, has) -> name.equals(has.getName()),
                                        null);
                break;

                case 3:
                    System.out.print("Nhap Luong can tim kiem: ");
                    int salary = scanner.nextInt();
                    res = getEmployees((need, has) -> need.salary == has.salary, 
                                        new Employee(0, null, null, salary));
                break;
            }

        }while(select < 1 || select > 3);

        printEmployees(res, "Nhung nhan vien tim thay", "Khong tim thay nhan vien dap uong yeu cau");
    }

    public static void printEmployees(ArrayList<Employee> employees, String have, String havent){
        if(employees.size() == 0){
            System.out.println(havent);
        }else{
            System.out.println(have);
            int i = 1;
            for(Employee employee : employees){
                System.out.println(i + ". " + employee);
                i++;
            }
        }
    }

    public static ArrayList<Employee> getEmployees(Filterable filter, Employee need){
        ArrayList<Employee> res = new ArrayList<>();
        for(Employee employee : employees){
            if(filter.filter(need, employee))
                res.add(employee);
        }
        return res;
    }
}

@FunctionalInterface
interface Filterable{
    public boolean filter(Employee need, Employee has);
}
