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

    public String htmlStatement() {
        int frequentRentalPoints = 0;

        Enumeration rentalsEnum = rentals.elements();

        String result = "Rental Records from ".concat(getName()).concat("\n");

        while (rentalsEnum.hasMoreElements()) {

            Rental aRental = (Rental) rentalsEnum.nextElement();

            result += "\t" + aRental.getMovie().getTitle() + "\t" + String.valueOf(aRental.getCharges()) + "\n";

            result += "Amount owned is " + String.valueOf(getTotalCharge());

            result += "You earned " + String.valueOf(getTotalFrequentRentalPoints()) + " frequest renter point";
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentalsEnum = rentals.elements();
        while(rentalsEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalsEnum.nextElement();
            result += rental.getCharges();
        }
        return result;
    }

    private int getTotalFrequentRentalPoints() {
        int result = 0;
        Enumeration rentalsEnum = rentals.elements();
        while(rentalsEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalsEnum.nextElement();
            result += rental.getFrequentRentalPoints();
        }
        return result;
    }
}
