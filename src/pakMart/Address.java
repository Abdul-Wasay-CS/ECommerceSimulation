package pakMart;

import java.util.Objects;

public class Address {
    private String country;
    private String city;
    private String society;
    private int streetNo;
    private int houseNo;

    Address(){

    }

    Address(String country, String city, String society, int streetNo, int houseNo){
        this.country = country;
        this.city = city;
        this.society = society;
        this.streetNo = streetNo;
        this.houseNo = houseNo;
    }

    Address(Address copiedAddress){
        this.country = copiedAddress.getCountry();
        this.city = copiedAddress.getCity();
        this.society = copiedAddress.getSociety();
        this.streetNo = copiedAddress.getStreetNo();
        this.houseNo = copiedAddress.getHouseNo();
    }


    // Getters

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getSociety() {
        return society;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public int getHouseNo() {
        return houseNo;
    }

    // setters

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    @Override
    public String toString() {
        return "pakMart.Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", society='" + society + '\'' +
                ", streetNo=" + streetNo +
                ", houseNo=" + houseNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;

        return houseNo == address.getHouseNo() && streetNo == address.streetNo
                && country.equals(address.getCountry()) && city.equals(address.getCity())
                && society.equals(address.getSociety());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getCity(), getSociety(), getStreetNo(), getHouseNo());
    }
}
