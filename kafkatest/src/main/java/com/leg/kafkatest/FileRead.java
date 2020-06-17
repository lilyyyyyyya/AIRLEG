package com.leg.kafkatest;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRead {
    public static List<Flight> flight() {
        File file=new File("D:\\XstudySources\\Workspace\\爬虫数据\\flight_query.csv");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader reader=null;
        List<Flight> flights = new ArrayList<>();
        try {
            fis=new FileInputStream(file);
            isr= new InputStreamReader(fis, "GBK");
            reader=new BufferedReader(isr);
            String line=null;
//            line = reader.readLine();
            line = reader.readLine();

            while((line=reader.readLine())!=null) {
                String[] strings=line.split(",");
                String FLIGHT_NO=strings[0];
                String DEP_CT=strings[1];
                String ARR_CT = strings[2];
                String DEP_SCHEDULED = strings[3];
                String ARR_SCHEDULED = strings[4];
                String FLIGHT_STATE = strings[5];
                String PRICE = strings[6];
                String DATE = strings[7];
                Flight f = new Flight(FLIGHT_NO, DEP_CT, ARR_CT, DEP_SCHEDULED, ARR_SCHEDULED, FLIGHT_STATE, PRICE, DATE);
                flights.add(f);
            }
            System.out.println(flights);
            return flights;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader!=null) {
                    reader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return flights;
        }
    }

}
