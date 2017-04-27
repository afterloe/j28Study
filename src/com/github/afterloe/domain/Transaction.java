package com.github.afterloe.domain;

/**
 * Created by afterloe on 4/27/2017.
 */
public class Transaction {
    private Traders traders;
    private int year;
    private float value;

    @Override
    public String toString() {
        return "Transaction{" +
                "traders=" + traders +
                ", year=" + year +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (year != that.year) return false;
        if (Float.compare(that.value, value) != 0) return false;
        return traders != null ? traders.equals(that.traders) : that.traders == null;
    }

    @Override
    public int hashCode() {
        int result = traders != null ? traders.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + (value != +0.0f ? Float.floatToIntBits(value) : 0);
        return result;
    }

    public Traders getTraders() {

        return traders;
    }

    public void setTraders(Traders traders) {
        this.traders = traders;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Transaction(Traders traders, int year, float value) {

        this.traders = traders;
        this.year = year;
        this.value = value;
    }
}
