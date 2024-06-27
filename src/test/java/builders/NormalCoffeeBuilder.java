package builders;
import dto.Coffee;
public class NormalCoffeeBuilder {

    private String description;
    private int id;
    private String name;

    public NormalCoffeeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public NormalCoffeeBuilder setId(int id) {
        this.id = id;
        return this;
    }
    public NormalCoffeeBuilder setName(String name){
        this.name = name;
        return this;
    }

    public Coffee build(){
        return new Coffee(id,name,description);
    }
    
}
