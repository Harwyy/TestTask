package org.example;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tasks {

    // difference between the average price and the median
    public static double secondTask(List<Ticket> tickets){
        double avg = avg(tickets);
        double median = median(tickets);
        return Math.abs(avg - median);
    }

    private static double avg(List<Ticket> tickets){
        double sum = 0;
        int count = 0;
        for (Ticket ticket : tickets){
            if (ticket.getOrigin_name().equals("Владивосток") && ticket.getDestination_name().equals("Тель-Авив")) {
                sum += ticket.getPrice();
                count += 1;
            }
        }
        return sum / count;
    }

    private static double median(List<Ticket> tickets){
        tickets.sort((o1, o2) -> Integer.compare(o1.getPrice(), o2.getPrice()));
        ArrayList<Ticket> newTickets = new ArrayList<>();
        for (Ticket ticket : tickets){
            if (ticket.getOrigin_name().equals("Владивосток") && ticket.getDestination_name().equals("Тель-Авив")) {
                newTickets.add(ticket);
            }
        }
        double median = 0;
        if (newTickets.size() % 2 == 0){
            median += newTickets.get(newTickets.size() / 2).getPrice();
            median += newTickets.get(newTickets.size() / 2 - 1).getPrice();
            median = median / 2;
        } else {
            median = newTickets.get(newTickets.size() / 2).getPrice();
        }
        return median;
    }

    // minimum flight time
    public static HashMap<String, LocalTime> firstTask(List<Ticket> tickets){
        HashMap<String, LocalTime> map = new HashMap<>();
        for (Ticket ticket : tickets) {
            if (ticket.getOrigin_name().equals("Владивосток") && ticket.getDestination_name().equals("Тель-Авив")) {
                String dt = ticket.getDeparture_time();
                if (ticket.getDeparture_time().length() == 4){
                    dt = "0" + dt;
                }
                String at = ticket.getArrival_time();
                if (ticket.getArrival_time().length() == 4){
                    at = "0" + at;
                }
                LocalTime departureTime = LocalTime.parse(dt);
                LocalTime arrivalTime = LocalTime.parse(at);
                int diffHours = (int) departureTime.until(arrivalTime, ChronoUnit.HOURS);
                int diffMinutes = (int) (departureTime.until(arrivalTime, ChronoUnit.MINUTES) % 60);
                LocalTime diffTime = LocalTime.of(diffHours, diffMinutes);
                if (map.containsKey(ticket.getCarrier())){
                    if (diffTime.compareTo(map.get(ticket.getCarrier())) == -1){
                        map.replace(ticket.getCarrier(), diffTime);
                    }
                } else {
                    map.put(ticket.getCarrier(), diffTime);
                }
            }
        }
        return map;
    }
}
