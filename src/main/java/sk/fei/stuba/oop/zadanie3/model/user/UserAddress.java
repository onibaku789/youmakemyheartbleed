package sk.fei.stuba.oop.zadanie3.model.user;


public class UserAddress  {
    private int postalCode;
    private String town;
    private String street;
    private int houseNumber;

    public UserAddress(int postalCode, String town, String street, int houseNumber) {
        setPostalCode(postalCode);
        setTown(town);
        setStreet(street);
        setHouseNumber(houseNumber);
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        if (postalCode <= 0)
            throw new IllegalArgumentException("You have to specify postal code.");
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if (town.trim().isEmpty())
            throw new IllegalArgumentException("You have to specify town.");
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street.trim().isEmpty())
            throw new IllegalArgumentException("You have to specify users ID.");
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        if (houseNumber <= 0)
            throw new IllegalArgumentException("You have to specify users house number.");
        this.houseNumber = houseNumber;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (UserAddress) super.clone();
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "postalCode=" + postalCode +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
