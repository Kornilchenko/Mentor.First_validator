package com.app;

import java.util.ArrayList;
import java.util.List;

public class CarShop
{
    public static void main( String[] args )
    {
        List<CarDTO> carDTOList = new ArrayList<>();
        carDTOList.add(new CarDTO("Tavria", "Nona", 1991, "KA3456CC"));
        carDTOList.add(new CarDTO("Opel", "Vectra", 1999, "BI5467CA"));
        carDTOList.add(new CarDTO("Nissan", "Micro", 2012, "AH6577ET"));
        carDTOList.add(new CarDTO("Nissan", "Pixo", 2015, "AX4567AB"));
        carDTOList.add(new CarDTO("ZAZ", "968M", 1981, "torpeda"));
        System.out.println(carDTOList);
    }
}