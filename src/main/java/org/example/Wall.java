package org.example;

public class Wall extends Partition {
    public Wall(){
        super();
        this.orientation = Orientation.VERTICAL;
    }

    public Double getResistance(){
        if(resistance == null) {
            if(getConductivity() == 0.0) {
               return 0.0;
            }
            else{
                return 1/getConductivity();
            }
        }
        return resistance;
    }

}
