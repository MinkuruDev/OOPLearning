package SV24.NguyenTrungVinh.BTH5;

import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {
    private static Employee[] employees;
    private static int employeeCount;
    private static final int MAX_EMPLOYEE = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap so luong nhan vien (<=%d): ", MAX_EMPLOYEE);
        employeeCount = sc.nextInt();
        employees = new Employee[MAX_EMPLOYEE];

        System.out.println("1. Khoi tao ngau nhien nhan vien");
        System.out.println("2. Nhap thu cong nhan vien");
        boolean mannual = sc.nextInt() == 2;
        
        RandomPeople randomEmployee = new RandomPeople();
        for(int i = 0; i<employeeCount; i++){
            employees[i] = new Employee(
                randomEmployee.firstNameVN(),
                randomEmployee.lastNameVN(),
                randomEmployee.range(100, 1000),
                randomEmployee.range(0, 40)
            );

            if(mannual) nhap(sc, employees[i]);
        }

        printEmployees(employees, employeeCount, "Danh sach cac nhan vien: ", "Hien tai khong co nhan vien");

        Manager2 manager;
        if(employeeCount >= 5){
            manager = new Manager2(
                randomEmployee.firstNameVN(),
                randomEmployee.lastNameVN(),
                randomEmployee.range(1000, 2000),
                randomEmployee.range(10, 40),
                employees[0], employees[1], employees[2], employees[3], employees[4]
            );
        }else{
            manager = new Manager2(
                randomEmployee.firstNameVN(),
                randomEmployee.lastNameVN(),
                randomEmployee.range(1000, 2000),
                randomEmployee.range(10, 40)
            );
        }

        System.out.println("Thong tin quan ly: "+ manager);
        Employee[] team = searchEmployees(e -> manager.containsEE(e.getId()));
        printEmployees(team, team.length, "Danh sach nhan vien trong team: ", "Khong co nhan vien trong team");

        Employee[] huu = searchEmployees(e -> e.getYearExp() >= 30);
        printEmployees(huu, huu.length, "Nhung nhan vien da co the nghi huu", "Khong co nhan vien nao co the nghi huu");
        
        sc.close();
    }

    public static Employee[] searchEmployees(Filterable filterable){
        Employee[] res = new Employee[employeeCount];
        int count = 0;
        for(Employee e : employees){
            if(e == null) continue;
            if(filterable.filter(e)){
                res[count] = e;
                count++;
            }
        }

        return Arrays.copyOf(res, count);
    }

    public static boolean addEE(Scanner sc){
        if(employeeCount == MAX_EMPLOYEE) {
            System.out.println("Khong the them nhan vien");
            return false;
        }

        Employee employee = new Employee(null, null, 0, 0);
        System.out.println("Nhap nhan vien moi: ");
        nhap(sc, employee);
        employees[employeeCount] = employee;
        employeeCount++;

        return true;
    }

    public static boolean removeEE(Employee e){
        int i = 0;
        for(i = 0; i<employeeCount; i++){
            if(employees[i].equals(e))
                break;
        }
        if(i == employeeCount) return false;

        employeeCount--;
        employees[i] = employees[employeeCount];
        employees[employeeCount] = null;
        return true;
    }

    public static void suathongTin(Scanner sc, Employee e){
        System.out.println("Sua thong tin nhan vien: " + e);
        nhap(sc, e);
    }

    public static void nhap(Scanner sc, Employee e){
        System.out.println("Nhap thong tin: ");
        System.out.print("Nhap ho: ");
        e.setFirstName(sc.next());
        System.out.print("Nhap ten: ");
        e.setLastName(sc.next());
        System.out.print("Nhap so nam kinh nghiem: ");
        e.setYearExp(sc.nextInt());
        System.out.print("Nhap luong thang: ");
        e.setSalary(sc.nextInt());
    }

    public static void printEmployees(Employee[] employees, int num, String have, String havent){
        if(employees == null || employees.length == 0){
            System.out.println(havent);
        }else{
            System.out.println(have);
            for(int i = 0; i< num; i++){
                System.out.println((i+1) + ". " + employees[i]);
            }
            System.out.println();
        }
    }
}
