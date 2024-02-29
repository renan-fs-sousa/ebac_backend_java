package br.com.rsousa;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Car> listCar = new ArrayList<>();

        listCar.add(new Jaguar());
        listCar.add(new Maverick());
        listCar.add(new Shelby());

        for (Car car : listCar) {
            car.showCar();
        }
    }
}