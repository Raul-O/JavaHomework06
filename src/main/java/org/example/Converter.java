package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Converter
{
    public static String lengthConverter( String string )
    {

        double total = 0;
        double convertedValue = 0;
        int lowestUnit;
        String[] unit = string.replaceAll(" ", "")
                .replaceAll("\\d","")
                .replace("+", "-")
                .replace("km","5")
                .replace("dm","3")
                .replace("cm","2")
                .replace("mm","1")
                .replace("m","4")
                .split("-");
        List<Integer> ints = Arrays.stream(unit)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.sort(ints);
        lowestUnit = ints.get(0);
        String[] str2 = string.replaceAll(" ", "")
                .replaceAll("\\+", ",+,")
                .replaceAll("-", ",-,")
                .split(",");


        for (int i = 0; i<str2.length;i++){
            if(str2[i].contains("+") && i==1){
                total = convertToMeter(str2[0]) + convertToMeter(str2[2]);
            }
            if(str2[i].contains("-") && i==1){
                total = convertToMeter(str2[0]) - convertToMeter(str2[2]);
            }
            if(str2[i].contains("+") && i>1){
                total += convertToMeter(str2[i+1]);
            }
            if(str2[i].contains("-") && i>1){
                total -= convertToMeter(str2[i+1]);
            }
        }

        return convertTo(lowestUnit, total);
        //System.out.println(convertTo(lowestUnit, total));


    }

    public static double convertToMeter(String element){
        double value = 0;
        switch(element.replaceAll("\\d","")){
            case "m":
                value = Double.parseDouble(element.replaceAll("[\\D.]",""));
                break;
            case "mm":
                value = Double.parseDouble(element.replaceAll("[\\D.]",""))*0.001;
                break;
            case "cm":
                value = Double.parseDouble(element.replaceAll("[\\D.]",""))*0.01;
                break;
            case "dm":
                value = Double.parseDouble(element.replaceAll("[\\D.]",""))*0.1;
                break;
            case "km":
                value = Double.parseDouble(element.replaceAll("[\\D.]",""))*1000;
                break;

        }
        return value;
    }


    public static String convertTo(int um, Double value){
        String converted ="";
        switch(um){
            case 4:
                converted = value.toString() + " m";
                break;
            case 1:
                converted = value * 1000 + " mm";
                break;
            case 2:
                converted = value * 100 + " cm";
                break;
            case 3:
                converted = value * 10 + " dm";
                break;
            case 5:
                converted = value * 0.001 + " Km";
                break;

        }
        return converted;
    }
}
