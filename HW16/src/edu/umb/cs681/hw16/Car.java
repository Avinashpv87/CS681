package edu.umb.cs681.HW16;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make;
    private String model;
    private int mileage;
    private int year;
    private int price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, int price, int dominationCount) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.dominationCount = dominationCount;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }
    public static void main(String[] args) {

        List<Car> cars = new ArrayList();

        cars.add(new Car("Audi", "A6", 2021, 3, 200000, 1));
        cars.add(new Car("Ferrari", "488 Pista", 2022, 12, 400000, 4));
        cars.add(new Car("Tesla", "3", 2019, 4, 50000, 3));
        cars.add(new Car("Bentley", "Ghost", 2021, 2, 150000, 2));

        int highestprice = cars.stream().parallel().map((Car car) ->car.getPrice() ).reduce(0, (ans,price)->ans > price ? ans : price);
        System.out.println("Costliest Price of a car is :"+highestprice);

        int lowestprice = cars.stream().parallel().map((Car car) ->car.getPrice() ).reduce(1000000000, (ans, price)->price>ans ? ans : price);
        System.out.println("Cheapest Car Price is :"+lowestprice);

        int averageprice = cars.stream().parallel().map((Car car) ->car.getPrice() ).reduce(0, (ans,price) -> ans+price, (ans1, intemans) -> ans1)/cars.size();
        System.out.println("Mean Price of the car is :" + averageprice);
    }
}