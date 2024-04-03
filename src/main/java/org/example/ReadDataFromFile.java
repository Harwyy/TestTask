package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadDataFromFile {

    public static Tickets readDataFromFile(){
        ObjectMapper objectMapper = new ObjectMapper();
        Tickets tickets = new Tickets();
        try {
            tickets = objectMapper.readValue(new File("ticket.json"), Tickets.class);
        } catch (IOException e){
            System.out.println("Ошибка при считывание файла! Файл не найден.");
        }
        return tickets;
    }
}
