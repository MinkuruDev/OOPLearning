package SV24.NguyenTrungVinh.BTH5;

public class Manager2 extends Employee {
    private int[] team;
    private int count;
    private static final int MAX_NV = 5;
    private static int managerID = 0;

    public Manager2(String firstName, String lastName, int salary, int yearExp, Employee... employees){
        super(firstName, lastName, salary, yearExp);
        employeeID--;
        managerID++;
        this.id = managerID;
        team = new int[MAX_NV];
        count = 0;

        for(Employee e : employees){
            if(! this.addEE(e.getId()))
                break;
        }
    }

    public boolean containsEE(int id){
        for(int i = 0; i<count; i++){
            if(team[i] == id)
                return true;
        }

        return false;
    }

    public boolean addEE(int id){
        if(count == MAX_NV) return false;
        team[count] = id;
        count++;
        return true;
    }

    public boolean removeEE(int id){
        if(count == 0) return false;
        int i = 0;
        for(i = 0; i<count; i++){
            if(team[i] == id)
                break;
        }
        if(i == count) return false;

        count--;
        team[i] = team[count];
        team[count] = 0;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Manager2[id=%d, name=%s, salary=%d, yearExp=%d]",
                                    id, getName(), salary, yearExp);
    }
    
}
