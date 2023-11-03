package entity;

public class Ecole {

    private String citySchool1;
    private String citySchool2;
    private String citySchool3;
    private String citySchool4;
    private String citySchool5;

    public Ecole() {
        this.citySchool1 = "Paris";
        this.citySchool2 = "Rennes";
        this.citySchool3 = "Orléans";
        this.citySchool4 = "Strasbourg";
        this.citySchool5 = "Cagnes-sur-Mer";
    }


    public String[] villesEcoles() {
        String[] cities = new String[5];
        cities[0] = this.citySchool1;
        cities[1] = this.citySchool2;
        cities[2] = this.citySchool3;
        cities[3] = this.citySchool4;
        cities[4] = this.citySchool5;
        return cities;
    }

}
