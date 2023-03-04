package SV24.NguyenTrungVinh.B15D52.BTH2;

public class Employee {
    protected int id, salary, yearExp;
    protected String firstName, lastName;

    public Employee(int id, String firstName, String lastName, int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.yearExp = 0;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public int getYearExp() {
        return yearExp;
    }

    public String toString(){
        return String.format("Employee[id=%d, name=%s, salary=%d]",
                            id, getName(), salary);
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary(){
        return salary * 12;
    }

    public int raiseSalary(int percent){
        float fSalary = salary;
        fSalary *= 1 + ((float)percent) / 100;
        salary = Math.round(fSalary);
        return salary;
    }

    public void setYearExp(int yearExp) {
        if(yearExp >= 10)
            raiseSalary(20);
        else if(yearExp >= 7)
            raiseSalary(15);
        else if(yearExp >= 5)
            raiseSalary(10);
        else if(yearExp >= 2)
            raiseSalary(5);

        this.yearExp = yearExp;
    }
}
