package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

import static java.nio.file.Paths.get;


public final class Main {
    @Test
    public static void main(String... args) throws IOException {
        Main parser = new Main("CustomerList.txt");
        parser.parseLineByLine();

    }

    /**
     Constructor
     */
    public Main(String fileName){
        filePath = get(fileName);
    }

    public final void parseLineByLine() throws IOException {
        try (Scanner scanner =  new Scanner(filePath, ENCODING.name())){
            while (scanner.hasNextLine()){
                parseEachLine(scanner.nextLine());
            }
        }
    }


    protected void parseEachLine(String line){
        //second Scanner to parse the content of each line

        try(Scanner scanner = new Scanner(line)){
            scanner.useDelimiter(",");
            if (scanner.hasNext()) {
                    //assumes the line has a certain structure
                    String latitude = scanner.next ();
                    String user_id = scanner.next ();
                    String name = scanner.next ();
                    String longitude = scanner.next ();
                    latitude = latitude.replaceAll ( "[a-zA-Z:\"\\s]", "" ).replaceAll ( "\\p{Ps}", "" );
                    longitude = longitude.replaceAll ( "[a-zA-Z:\"\\s]", "" ).replaceAll("}$", "");
//                FileWriter fw = new FileWriter ( "Output.txt" );
//                fw.write ( name.trim () + " ; " + user_id.trim ());
//
//
               if(getDistance(latitude,longitude, 53.339428, -6.257664)){
//           System.out.println(latitude.trim() + " "+  "; " + " "+longitude.trim());
//
            System.out.println(name.trim() + " "+  "; " + " "+user_id.trim());
                }

            }
            else {
                log("Empty or invalid line. Unable to process.");
            }

        }
    }
    // get distance of each cordinate from the office location 53.339428, -6.257664
    public static boolean getDistance(String latitude, String longitude, double lat2, double long2) {
        double lat1 = Double.parseDouble(latitude);
        double long1 = Double.parseDouble(longitude);
        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLong = Math.toRadians(long2 - long1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
       // double a = Math.pow(Math.sin(deltaLat / 2),2) + Math.pow(Math.sin(deltaLong / 2),2) * Math.cos(lat1) * Math.cos(lat2);
       // double c = 2 * Math.asin(Math.sqrt(a));
        double a =((Math.sin(lat1))*(Math.sin(lat2)))+((Math.cos(lat1))*(Math.cos ( lat2 ))*(Math.cos(deltaLong)));
        double c =Math.acos ( a );
        double distance =  6371 * c;
       if(distance<=100)
       {System.out.println ("Distance " + distance + " km");}
        return distance<=100;
    }
    // PRIVATE
    private final Path filePath;
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    private static void log(Object object){
        System.out.println(Objects.toString(object));
    }

}