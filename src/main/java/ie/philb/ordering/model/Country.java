package ie.philb.ordering.model;

import java.io.Serializable;

public class Country implements Serializable {

    private Long id;
    private int version;
    private String isoCode;
    private String name;
    private String printableName;
    private String iso3;
    private String numcode;

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
        if (!(obj instanceof Country)) {
            return false;
        }
        Country other = (Country) obj;
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

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrintableName() {
        return printableName;
    }

    public void setPrintableName(String printableName) {
        this.printableName = printableName;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getNumcode() {
        return numcode;
    }

    public void setNumcode(String numcode) {
        this.numcode = numcode;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (isoCode != null && !isoCode.trim().isEmpty()) {
            result += "isoCode: " + isoCode;
        }
        if (name != null && !name.trim().isEmpty()) {
            result += ", name: " + name;
        }
        if (printableName != null && !printableName.trim().isEmpty()) {
            result += ", printableName: " + printableName;
        }
        if (iso3 != null && !iso3.trim().isEmpty()) {
            result += ", iso3: " + iso3;
        }
        if (numcode != null && !numcode.trim().isEmpty()) {
            result += ", numcode: " + numcode;
        }
        return result;
    }
}
