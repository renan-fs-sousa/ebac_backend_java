package br.com.rsousa;

public class ContractFactory extends Factory {
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Toyota(100, "full", "black");
        } else {
            return new Honda(110, "full", "white");
        }
    }
}