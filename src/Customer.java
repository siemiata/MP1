import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Customer {
    private String name;
    private String secondName; //moze byc null - atrybut opcjonalny
    private LocalDate dateOfCreate; //atrybut zlozony
    private ArrayList<String> fereignLanguages; //atrybut powtarzalny
    private int salary;
    private static int minSalary = 2000; // atrybut klasowy
    public Customer(String name, String secondName, LocalDate dateOfCreate, ArrayList<String> fereignLanguages, int salary) {
        this.name = name;
        this.secondName = secondName;
        this.dateOfCreate = dateOfCreate;
        this.fereignLanguages = fereignLanguages;
        this.salary = salary;
    }

    public int setSalary(){ //atrybut wyliczalny
        return minSalary + 2*minSalary;
    }

    public int setSalaryPlus(int bonus){ //przeciązenie
        return minSalary + 2*minSalary + bonus;
    }

}
