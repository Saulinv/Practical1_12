
package com.mycompany.practical1_12;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


public class Plant implements Externalizable {
    
    private String name;
    private String species;
    private String color;
    private int height;
    private boolean isIndoor;

    public Plant() {}

    private static final long serialVersionUID = -7334973160000689866L;
    
    public Plant(String name, String species, String color, int height, boolean isIndoor) {
        this.name = name;
        this.species = species;
        this.color = color;
        this.height = height;
        this.isIndoor = isIndoor;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(species);
        out.writeObject(color);
        out.writeInt(height);
        out.writeBoolean(isIndoor);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        species = (String) in.readObject();
        color = (String) in.readObject();
        height = in.readInt();
        isIndoor = in.readBoolean();
    }

    @Override
    public String toString() {
        return "Plant{name = " + name + 
                ", species = " + species + 
                ", color = " + color + 
                ", height = " + height + 
                ", isIndoor = " + isIndoor + '}';
    }

    
}
