package pl.edu.wszib.costume;


public class Costume {
        private String name;
        private String size;
        private int costumeId;
        private boolean rent;


    public Costume(String name, String size, int costumeId, boolean isRent) {
        this.name = name;
        this.size = size;
        this.costumeId = costumeId;
        this.rent = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCostumeId() {
        return costumeId;
    }

    public void setCostumeId(int costumeId) {
        this.costumeId = costumeId;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public Costume() {
    }

    @Override
    public String toString() {
        return "Costume{" +
                "costumeId=" + costumeId +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", rent='" + rent + '\'' +
                '}';

    }
}
