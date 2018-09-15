package refactoredCode.rental;

import actualCode.movie.Movie;

import static actualCode.movie.Movie.*;
import static refactoredCode.movie.Movie.NEW_RELEASE;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    public double getCharges() {
        double thisAmount = 0;
        int daysRented = getDaysRented();
        switch (getMovie().getPriceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2) {
                    thisAmount += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDREN:
                thisAmount += 1.5;
                if (daysRented > 3) {
                    thisAmount += (daysRented - 3) * 1.5;
                }
                break;
            default:
                System.out.println("Invalid Data.");
        }
        return thisAmount;
    }

    public int getFrequentRentalPoints() {
        int frequentRentalPoints = 1;

        if (getMovie().getPriceCode() == NEW_RELEASE && getDaysRented() > 1) {
            frequentRentalPoints++;
        }

        return frequentRentalPoints;
    }
}
