package ie.philb.ordering.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address implements Serializable {

    private Long id;
    private int version;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipcode;
    private Long countryId;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address other = (Address) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (street1 != null && !street1.trim().isEmpty()) {
            result += "street1: " + street1;
        }
        if (street2 != null && !street2.trim().isEmpty()) {
            result += ", street2: " + street2;
        }
        if (city != null && !city.trim().isEmpty()) {
            result += ", city: " + city;
        }
        if (state != null && !state.trim().isEmpty()) {
            result += ", state: " + state;
        }
        if (zipcode != null && !zipcode.trim().isEmpty()) {
            result += ", zipcode: " + zipcode;
        }
        return result;
    }

}
