package com.thoughtworks.movierental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    public void shouldReturnCustomerNameWhenGetNameFunctionIsCalled(){
        Customer customer = new Customer("Mukilan");
        Assertions.assertEquals("Mukilan", customer.getName());
    }

    @Test
    public void shouldAddRentalToCustomerWhenAddRentalFunctionIsCalled(){
        //TODO: Add test implementation
    }

    @Test
    public void shouldReturnProperStatementWhenStatementFunctionIsCalled() {
        Customer customer = new Customer("Mukilan");
        customer.addRental(new Rental(new Movie("Shawshank's Redemption", 0), 30));
        Assertions.assertEquals("Rental Record for Mukilan\n" +
                "\tShawshank's Redemption\t44.0\n" +
                "Amount owed is 44.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void shouldGenerateStatement() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("movie-1", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("movie-2", Movie.CHILDRENS), 6));
        customer.addRental(new Rental(new Movie("movie-3", Movie.NEW_RELEASE), 5));
        Assertions.assertEquals("Rental Record for Bob\n" +
                "\tmovie-1\t2.0\n" +
                "\tmovie-2\t6.0\n" +
                "\tmovie-3\t15.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points", customer.statement());
    }
}