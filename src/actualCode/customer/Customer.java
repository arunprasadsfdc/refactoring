package actualCode.customer;

import actualCode.movie.Movie;
import actualCode.rental.Rental;

import java.util.Enumeration;
import java.util.Vector;

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
            double thisAmount = 0;

            Rental each = (Rental) rentalsEnum.nextElement();

            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
                default:
                    System.out.println("Invalid Data.");
            }

            //add freaquest renter points
            frequentRentalPoints++;

            //add bouns for a two day new release
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRentalPoints++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";

            //add footer line
            result += "Amount owned is " + String.valueOf(totalAmount);

            result += "You earned " + String.valueOf(frequentRentalPoints) + " frequesnt renter ponit";
        }
        return result;
    }
}
