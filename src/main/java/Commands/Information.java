package Commands;

import City.CityConstructor;

import java.util.List;

/**
 * Класс, отвечающий за хранение информации о команде.
 */

public class Information {

    private int simpleArguments;
    private int complexArguments;
    private boolean isCity;
    private boolean isPrintable;
    private List<String> description;
    private List<Class<CityConstructor>> constructors;

    public Information (int simpleArguments, int complexArguments, boolean isCity, boolean isPrintable, List<String> description, List<Class<CityConstructor>> constructors) {
        this.simpleArguments = simpleArguments;
        this.complexArguments = complexArguments;
        this.isCity = isCity;
        this.isPrintable = isPrintable;
        this.description = description;
        this.constructors = constructors;
    }

    public int getSimpleArguments(){
        return simpleArguments;
    }

    public int getComplexArguments(){
        return complexArguments;
    }

    public boolean getIsCity(){
        return isCity;
    }

    public boolean getIsPrintable(){
        return isPrintable;
    }

    public List<String> getDescription() {
        return description;
    }

    public List<Class<CityConstructor>> getConstructors() { return constructors; }

}
