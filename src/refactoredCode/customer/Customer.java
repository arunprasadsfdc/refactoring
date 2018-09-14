package refactoredCode.customer;

import refactoredCode.movie.Movie;
import refactoredCode.rental.Rental;

import java.util.Enumeration;
import java.util.Vector;

import static refactoredCode.movie.Movie.*;

public class Customer {

    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRentalPoints = 0;

        Enumeration rentalsEnum = rentals.elements();

        String result = "Rental Records from ".concat(getName()).concat("\n");

        while (rentalsEnum.hasMoreElements()) {

            Rental aRental = (Rental) rentalsEnum.nextElement();

            //add freaquest renter points
            frequentRentalPoints++;

            //add bouns for a two day new release
            if (aRental.getMovie().getPriceCode() == NEW_RELEASE && aRental.getDaysRented() > 1) {
                frequentRentalPoints++;
            }

            result += "\t" + aRental.getMovie().getTitle() + "\t" + String.valueOf(aRental.getCharges()) + "\n";

            //add footer line
            result += "Amount owned is " + String.valueOf(totalAmount);

            result += "You earned " + String.valueOf(frequentRentalPoints) + " frequest renter point";
        }
        return result;
    }
}
