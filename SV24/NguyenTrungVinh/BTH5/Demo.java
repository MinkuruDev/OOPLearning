package SV24.NguyenTrungVinh.BTH5;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    private static Employee[] employees;
    private static int employeeCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        employeeCount = sc.nextInt();
        employees = new Employee[employeeCount];

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
        
        Manager managerA = new Manager(null, null, 0, 0);
        System.out.println("Nhap thong tin quan ly A");
        nhap(sc, managerA);
        int j = 0;
        while(j < employeeCount && j<5){
            managerA.addEE(employees[j]);
            j++;
        }
        System.out.println(managerA);
        managerA.printEE();

        Manager managerB;
        if(employeeCount >= 10){
            managerB = new Manager(
                randomEmployee.firstNameVN(),
                randomEmployee.lastNameVN(),
                randomEmployee.range(1000, 2000),
                randomEmployee.range(10, 50),
                employees[5], employees[6], employees[7], employees[8], employees[9]
            );
        }else{
            managerB = new Manager(
                randomEmployee.firstNameVN(),
                randomEmployee.lastNameVN(),
                randomEmployee.range(1000, 2000),
                randomEmployee.range(10, 50)
            );
        }
        
        System.out.println(managerB);
        managerB.printEE();
        
        printEmployees(employees, employeeCount, "Danh sach tat ca cac nhan vien: ", "Hien tai khong co nhan vien");

        Employee[] huu = searchEmployees(e -> e.getYearExp() >= 30);
        printEmployees(huu, huu.length, "Nhung nhan vien da co the nghi huu", "Khong co nhan vien nao co the nghi huu");
        for(Employee e: huu){
            removeEE(e);
            managerA.removeEE(e);
            managerB.removeEE(e);
        }
        printEmployees(employees, employeeCount, "Danh sach tat ca cac nhan vien: ", "Hien tai khong co nhan vien");
        System.out.println(managerA);
        managerA.printEE();
        System.out.println(managerB);
        managerB.printEE();
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

interface Filterable{
    public boolean filter(Employee e);
}
