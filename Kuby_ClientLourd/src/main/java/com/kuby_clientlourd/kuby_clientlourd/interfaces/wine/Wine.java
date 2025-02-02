package com.kuby_clientlourd.kuby_clientlourd.interfaces.wine;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Wine {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty stock = new SimpleIntegerProperty();
    private final IntegerProperty year = new SimpleIntegerProperty();
    private final IntegerProperty supplier_id = new SimpleIntegerProperty();
    private final IntegerProperty terroir_id = new SimpleIntegerProperty();
    private final IntegerProperty variety_id = new SimpleIntegerProperty();
    private final IntegerProperty wine_family_id = new SimpleIntegerProperty();

    public int getId() { return id.get(); }
    public void setId(int value) { id.set(value); }
    public IntegerProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public void setName(String value) { name.set(value); }
    public StringProperty nameProperty() { return name; }

    public String getDescription() { return description.get(); }
    public void setDescription(String value) { description.set(value); }
    public StringProperty descriptionProperty() { return description; }

    public int getStock() {return stock.get();}
    public void setStock(int value) { stock.set(value);}
    public IntegerProperty stockProperty() { return stock; }

    public int getYear() { return year.get(); }
    public void setYear(int value) { year.set(value); }
    public IntegerProperty yearProperty() { return year; }

    public int getSupplier_id() { return supplier_id.get(); }
    public void setSupplier_id(int value) { supplier_id.set(value); }
    public IntegerProperty supplier_idProperty() { return supplier_id; }

    public int getTerroir_id() { return terroir_id.get(); }
    public void setTerroir_id(int value) { terroir_id.set(value);}
    public IntegerProperty terroir_idProperty() { return terroir_id; }

    public int getVariety_id() { return variety_id.get(); }
    public void setVariety_id(int value) { variety_id.set(value); }
    public IntegerProperty variety_idProperty() { return variety_id; }

    public int getWine_family_id() { return wine_family_id.get(); }
    public void setWine_family_id(int value) { wine_family_id.set(value);}
    public IntegerProperty Wine_family_idProperty() { return wine_family_id; }
}
