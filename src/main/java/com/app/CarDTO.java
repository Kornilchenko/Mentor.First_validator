package com.app;


import jakarta.validation.constraints.*;

public class CarDTO {
    @NotNull(message = "may not be null")
    private String manufacturer;
    @NotBlank(message = "cannot be an empty field")
    @NotNull(message = "may not be null")
    private String model;
    @Min(value = 1990, message = "cars not older than 1990")
    @Max(value = 2022, message = "year of manufacture of the car no more than 2022")
    private int year;
    @NotNull(message = "may not be null")
    @Size(min = 6, max = 8, message = "size must be between 6 and 8")
    @CheckCase(value = CaseMode.UPPER)
    private String licensePlate;

    public CarDTO(String manufacturer, String model, int year, String licensePlate) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString (){
        return "\nmanufacturer = " + manufacturer +
                "\nmodel = " + model +
                "\nyear of issue = " + year +
                "\nlicense plate = " +licensePlate +"\n";
    }
}