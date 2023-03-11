package SV24.NguyenTrungVinh.BTH5;

import java.util.Arrays;

public class Manager extends Employee{
    private Employee[] team;
    private int count;
    private static final int MAX_NV = 5;
    private static int managerID = 0;

    public Manager(String firstName, String lastName, int salary, int yearExp, Employee... employees){
        super(firstName, lastName, salary, yearExp);
        employeeID--;
        managerID++;
        this.id = managerID;
        team = new Employee[MAX_NV];
        count = 0;
        for(Employee e: employees){
            if(! this.addEE(e))
                break;
        }
    }

    public int coutNumNV() {
        return count;
    }

    public Employee[] getTeams(){
        if(count == MAX_NV)
            return team;
        return Arrays.copyOf(team, count);
    }

    public boolean search(Employee ee){
        for(Employee e : getTeams()){
            if(e.equals(ee)) return true;
        }
        return false;
    }

    public void printEE(){
        System.out.println(eeToString());
    }

    /**
     * Thêm Employee vào cho đến khi số lượng đạt {@code newNum}
     * @param newNum - {@code newNum <= 5}
     * @param employees - những Employee muốn thêm vào. Những Employee ở sau có thể không được thêm
     * @return số lượng Employee đã thêm
     */
    public int setNumNV(int newNum, Employee... employees){
        if(newNum == count) return 0;
        if(newNum > MAX_NV || newNum < count) return 0;
        int added = 0;
        for(Employee employee : employees){
            if(count < newNum){
                addEE(employee);
                added++;
            }
        }
        return added;
    }

    public boolean addEE(Employee e){
        if(count == MAX_NV) return false;
        team[count] = e;
        count++;
        return true;
    }

    public boolean removeEE(Employee ee){
        if(count == 0) return false;
        int index = -1;
        for(int i = 0; i<count; i++){
            if(ee.equals(team[i])){
                index = i;
                break;
            }
        }

        if(index < 0) return false;
        count--;
        team[index] = team[count];
        team[count] = null;

        return true;
    }

    public String eeToString(){
        StringBuilder builder = new StringBuilder();
        if(count == 0)
            builder.append("Hien tai nguoi quan ly nay khong co ai trong team\n");
        else{
            builder.append("Nguoi quan ly nay co ")
            .append(count)
            .append(" nhan vien trong team\n");
            
            for(int i = 0; i<count; i++){
                builder.append(i+1)
                .append(". ")
                .append(team[i])
                .append("\n");
            }
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return String.format("Manager[id=%d, name=%s, salary=%d, yearExp=%d]",
                                    id, getName(), salary, yearExp);
    }
}
