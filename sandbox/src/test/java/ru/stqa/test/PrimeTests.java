package ru.stqa.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Primes;


public class PrimeTests {
    @Test
    public void testPrimes() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimeLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }

    @Test
    public void testPrimeFast() {
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }



    @Test(enabled = false)
    public void testNonPrimes() {
        Assert.assertTrue(Primes.isPrime((Integer.MAX_VALUE) - 2));
    }




}
