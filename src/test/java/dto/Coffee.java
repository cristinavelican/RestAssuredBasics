package dto;
//data models for the Coffee
public class Coffee {
    private int id;
    private String name;
    private String description;

    public Coffee(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    //setters and getters

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public String getDescription() {
        return description;
    }


}
