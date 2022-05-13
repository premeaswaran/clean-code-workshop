package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
    private int frequentRenterPoints = 0;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            updateFrequentRenterPoints(rental);

            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
            totalAmount += rental.amount();
        }

        //add footer lines result
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }

    private void updateFrequentRenterPoints(Rental rental) {
        frequentRenterPoints++;
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                &&
                rental.getDaysRented() > 1) frequentRenterPoints++;
    }
}
