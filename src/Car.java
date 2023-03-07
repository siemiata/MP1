import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Car {
    private String brand; //atrybut prosty
    private String color;
    int wheelsSize;
    private static int minPrice = 20000; //atrybut klasowy
    private int price;
    private String seatsNumber; // atrybut opcjonalny - może być null
    private LocalDate dateOfCreate; //atrybut zlozony
    private ArrayList<String> externalAccesories; //atrybut powtarzalny

    public Car(String brand, String color, int wheelsSize) {
        this.brand = brand;
        this.color = color;
        this.wheelsSize = wheelsSize;
        addCar(this);
    }
    public int setPrice(){ //atrybut wyliczalny
        return minPrice + 1000;
    }

    public int setPricePlus(int customerPrice){ //przeciązenie
        return minPrice + 1000 + customerPrice;
    }

    @Override
    public String toString() {
        return "Car: " + brand + ", id: " + super.toString();
    }

    private static List<Car> extent = new ArrayList<>();

    private static void addCar(Car car){
        extent.add(car);
    }

    private static void removeCar(Car car){
        extent.remove(car);
    }

    public static void showExtent(){ //metoda klasowa
        System.out.println("Extent of the class: " + Car.class.getName());

        for(Car car : extent){
            System.out.println(car);
        }
    }
    public static void writer() {
        try {
            FileWriter fw = new FileWriter("cars.txt");
            for(Car car : extent){
                fw.write(car.brand + " " + car.color + " " + car.wheelsSize + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void reader() {
        try {
            Scanner s = new Scanner(new File("cars.txt"));
            while (s.hasNext()){
                String d1 = s.next();
                String d2 = s.next();
                String d3 = s.next();
                Car c = new Car(d1,d2,Integer.parseInt(d3));
            }
            s.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
