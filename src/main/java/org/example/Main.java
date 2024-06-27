package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Wall wall1= new Wall();
        Wall wall2 = new Wall();

        Partition floor = new Partition();
        Partition ceiling = new Partition();

        wall1.setThickness(1.0);
        floor.setThickness(4.0);

        floor.setOrientation(Partition.Orientation.HORIZONTAL);
        System.out.println(wall1.getResistance());

        System.out.println(floor.getResistance());
        System.out.println();
    }
}