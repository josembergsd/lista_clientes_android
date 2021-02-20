package app.modelo.meusclientes.model;

public class Cliente {

    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private int zipCode;
    private String publicPlace;
    private String addrNumber;
    private String district;
    private String city;
    private String state;
    private boolean useTerms;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getAddrNumber() {
        return addrNumber;
    }

    public void setAddrNumber(String addrNumber) {
        this.addrNumber = addrNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isUseTerms() {
        return useTerms;
    }

    public void setUseTerms(boolean useTerms) {
        this.useTerms = useTerms;
    }
}
