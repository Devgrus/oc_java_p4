package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {

    public void calculateFare(Ticket ticket, boolean isRecurringUser){
        if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }

        long inTime = ticket.getInTime().getTime();
        long outTime = ticket.getOutTime().getTime();

        long timeDiff = outTime - inTime;
        int millisecondToHour = 60 * 60 * 1000;

        double duration = Math.round(((float)timeDiff / millisecondToHour) * 100) / 100f;

        if(timeDiff > millisecondToHour / 2) {
            switch (ticket.getParkingSpot().getParkingType()){
                case CAR: {
                    if (isRecurringUser) ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR_RECURRING_USER);
                    else ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR);
                    break;
                }
                case BIKE: {
                    if (isRecurringUser) ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR_RECURRING_USER);
                    else ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR);
                    break;
                }
                default: throw new IllegalArgumentException("Unkown Parking Type");
            }
        } else {
            switch (ticket.getParkingSpot().getParkingType()){
                case CAR:
                case BIKE: {
                    ticket.setPrice(0);
                    break;
                }
                default: throw new IllegalArgumentException("Unkown Parking Type");
            }
        }
    }
}