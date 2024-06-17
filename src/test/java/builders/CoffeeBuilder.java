package builders;

import dto.Coffee;

// create different Coffee instances
public class CoffeeBuilder {

    public static Coffee createCoffeeObj(int id, String name, String description){
        Coffee coffee = new Coffee();
        coffee.setName(name);
        coffee.setId(id);
        coffee.setDescription(description);
        return coffee;
    }
}
