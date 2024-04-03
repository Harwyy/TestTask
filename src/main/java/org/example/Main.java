package org.example;

import java.time.LocalTime;
import java.util.HashMap;

import static org.example.ReadDataFromFile.readDataFromFile;

public class Main {
    public static void main(String[] args) {
        Tickets tickets = readDataFromFile();
        double secondAnswer = Tasks.secondTask(tickets.getTickets());
        HashMap<String, LocalTime> map = Tasks.firstTask(tickets.getTickets());
        System.out.println("Задание 1");
        for (String string : map.keySet()){
            System.out.println(string + " - " + map.get(string));
        }
        System.out.println("Задание 2");
        System.out.println(secondAnswer);
    }
}