public class Location {
    String key;
    String name;
    Location location;
    LocationType type;
    String number;
    String website;

    public Location(String key, String name, Location location, LocationType type,
                    String number, String website) {
        this.key = key;
        this.name = name;
        this.location = location;
        this.type = type;
        this.number = number;
        this.website = website;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public LocationType getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public String getNumber() {
        return number;
    }

    public String getWebsite() {
        return website;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
