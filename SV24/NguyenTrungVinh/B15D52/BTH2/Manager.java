package SV24.NguyenTrungVinh.B15D52.BTH2;

import java.util.ArrayList;

public class Manager extends Employee{
    private ArrayList<Employee> team;
    public Manager(int id, String firstName, String lastName, int salary){
        super(id, firstName, lastName, salary);
        team = new ArrayList<>(10);
    }

    public void setYearExpNotSetSalary(int yearExp) {
        this.yearExp = yearExp;
    }

    public boolean addNewEmployee(Employee employee){
        if(team.size() == 10) return false;
        return team.add(employee);
    }

    public boolean removeEmployee(Employee employee){
        return team.remove(employee);
    }

    public void setTeam(ArrayList<Employee> team) {
        // deep copy
        this.team = new ArrayList<>(team.size());
        for(Employee employee : team){
            this.team.add(employee);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Manager[id=%d, name=%s, salary=%d]\n",
                                    id, getName(), salary));
        if(team.size() == 0)
            builder.append("Hien tai nguoi quan ly nay khong co ai trong team\n");
        else{
            builder.append("Nguoi quan ly nay co ")
            .append(team.size())
            .append(" nhan vien trong team\n");
            int i = 1;

            for(Employee employee : team){
                builder.append(i)
                .append(". ")
                .append(employee.toString())
                .append("\n");
                i++;
            }
        }

        return builder.toString();
    }
}
