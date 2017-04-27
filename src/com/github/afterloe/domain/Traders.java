package com.github.afterloe.domain;

/**
 * Created by afterloe on 4/27/2017.
 */
public class Traders {
    private String name;
    private String city;

    @Override
    public String toString() {
        return "Traders{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Traders traders = (Traders) o;

        if (name != null ? !name.equals(traders.name) : traders.name != null) return false;
        return city != null ? city.equals(traders.city) : traders.city == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Traders(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
