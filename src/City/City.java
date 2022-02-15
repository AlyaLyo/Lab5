package City;

import City.Fields.Climate;
import City.Fields.Coordinates;
import City.Fields.Human;

public class City implements Comparable<City> {

    private int id;
    private String name;
    private Coordinates coordinates;
    private java.time.ZonedDateTime creationDate;
    private int area;
    private long population;
    private Integer metersAboveSeaLevel;
    private long telephoneCode;
    private long agglomeration;
    private Climate climate;
    private Human governor;

    public City (int id,String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, int area, long population, Integer metersAboveSeaLevel, long telephoneCode, long agglomeration, Climate climate, Human governor) {
        this.setId(id);
        this.setName(name);
        this.setCoordinates(coordinates);
        this.setCreationDate(creationDate);
        this.setArea(area);
        this.setPopulation(population);
        this.setMetersAboveSeaLevel(metersAboveSeaLevel);
        this.setTelephoneCode(telephoneCode);
        this.setAgglomeration(agglomeration);
        this.setClimate(climate);
        this.setGovernor(governor);
    }

    @Override
    public int compareTo(City city) {
        if (city == null) {
            return 1;
        }
        if (this.getId() == city.getId()) {
            return 0;
        }
        if (this.getId() < city.getId()) {
            return -1;
        }
        return 1;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    private void setId(int id) {
        if (id <= 0) {
            throw new FieldException("Exception: Field 'name' can not be less or equal zero");
        }
        this.id = id;
    }

    private void setName(String name) {
        if (name == null) {
            throw new FieldException("Exception: Field 'name' can not be null");
        }
        if (name.isEmpty()) {
            throw new FieldException("Exception: Field 'name' can not be empty");
        }
        this.name = name;
    }

    private void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new FieldException("Exception: Field 'coordinates' can not be null");
        }
        this.coordinates = coordinates;
    }

    private void setCreationDate(java.time.ZonedDateTime creationDate) {
        if (creationDate == null) {
            throw new FieldException("Exception: Field 'creation date' can not be null");
        }
        this.creationDate = creationDate;
    }

    private void setArea(int area) {
        if (area <= 0) {
            throw new FieldException("Exception: Field 'area' can not be less or equal zero");
        }
        this.area = area;
    }

    private void setPopulation(long population) {
        if (area <= 0) {
            throw new FieldException("Exception: Field 'population' can not be less or equal zero");
        }
        this.population = population;
    }

    private void setMetersAboveSeaLevel(Integer metersAboveSeaLevel) {
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    private void setTelephoneCode(long telephoneCode) {
        if (telephoneCode <= 0) {
            throw new FieldException("Exception: Field 'telephone code' can not be less o equal zero");
        }
        if (telephoneCode > 100000) {
            throw new FieldException("Exception: Field 'telephone code' can not be more 100 000");
        }
        this.telephoneCode = telephoneCode;
    }

    private void setAgglomeration(long agglomeration) {
        this.agglomeration = agglomeration;
    }

    private void setClimate(Climate climate) {
        if (climate == null) {
            throw new FieldException("Exception: Field 'climate' can not be null");
        }
        this.agglomeration = agglomeration;
    }

    private void setGovernor(Human governor) {
        if (governor == null) {
            throw new FieldException("Exception: Field 'governor' can not be null");
        }
        this.climate = climate;
    }

}
