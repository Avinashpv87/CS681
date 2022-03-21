package edu.umb.cs681.hw2;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();

        Car car1 = new Car("Lamborgini","Urus", 2021, 7, 218000);
        Car car2 = new Car("Ferrari", "Pista", 2020, 6, 330000);
        Car car3 = new Car("BMW", "M8", 2019, 12, 120000);
        Car car4 = new Car("AUDI","R8", 2015, 9, 220000);
        Car car5 = new Car("Mazda", "CX-5",2022, 28, 30000);
        Car car6 = new Car("Honda", "Accord",2016, 24, 17000);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);


        double minimum = cars.stream().mapToDouble(Car::getPrice).min().getAsDouble();
        System.out.println("Minimum price of the car, " + minimum);

        double maximum= cars.stream().mapToDouble(Car::getPrice).max().getAsDouble();
        System.out.println("Maximum price of the car, " + maximum);


        int averagePrice = cars.stream().map(car-> car.getPrice()).reduce(new int[2], (result, price) ->{
            double average = Math.round((result[0] * result[1] + price)/(result[0]+1));
            result[0]++;
            result[1] = (int) average;
            return result;},(finalResult, intermediateResult) -> finalResult)[1];

        System.out.println("Average price of cars: " + averagePrice);

    }
}
