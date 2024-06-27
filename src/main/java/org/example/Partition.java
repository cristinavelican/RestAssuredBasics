package org.example;

import static java.lang.Double.POSITIVE_INFINITY;
import static javax.swing.SwingConstants.*;

public class Partition {
    protected Double resistance;
    protected Double thickness;
    protected Double conductivity;
    public enum Orientation
    {
        HORIZONTAL,
        VERTICAL,
        INCLINED
    }
    protected Orientation orientation;

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Partition(){
        this.thickness = 0.0;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }



    public Double getConductivity() {
        if(resistance == null) {
            if(getThickness() != 0.0) {
                conductivity = getLambda()/getThickness();
            }
        }
        else{
            conductivity = 0.0;
        }
        return conductivity;
    }

    public Double getThickness() {
        return thickness;
    }

    public Double getResistance() {
        if(resistance == null) {
            if(getConductivity() == 0.0){
                return POSITIVE_INFINITY;
            }
            else{
                return 1/getConductivity();
            }
        }
        return resistance;
    }



    protected Double getLambda(){
        double lambda = 1.0;
        switch(orientation){
            case HORIZONTAL, INCLINED:
                lambda = 2.0;
                break;
            case VERTICAL:
                lambda = 3.0;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + orientation);
        }
        return lambda;
    }
}
