package com.parkit.parkingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.constants.ParkingType;

public class parkingSpotTest {
    @Test
    public void setIdTest() {
        ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
        parkingSpot.setId(2);
        assertThat(parkingSpot.getId()).isEqualTo(2);
    }

    @Test
    public void setParkingTypeTest() {
        ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
        parkingSpot.setParkingType(ParkingType.BIKE);
        assertThat(parkingSpot.getParkingType()).isEqualTo(ParkingType.BIKE);
    }

    @Test
    public void equalsWithSameInstance() {
        ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
        parkingSpot.setParkingType(ParkingType.BIKE);
        assertThat(parkingSpot.equals(parkingSpot)).isTrue();
    }

    @Test
    public void equalsWithSameNumber() {
        ParkingSpot parkingSpot1 = new ParkingSpot(1, ParkingType.CAR, false);
        ParkingSpot parkingSpot2 = new ParkingSpot(1, ParkingType.CAR, false);
        assertThat(parkingSpot1.equals(parkingSpot2)).isTrue();
    }

    @Test
    public void equalsWithDifferentNumber() {
        ParkingSpot parkingSpot1 = new ParkingSpot(1, ParkingType.CAR, false);
        ParkingSpot parkingSpot2 = new ParkingSpot(2, ParkingType.CAR, false);
        assertThat(parkingSpot1.equals(parkingSpot2)).isFalse();
    }

    @Test
    public void equalsWithNullParameter() {
        ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
        assertThat(parkingSpot.equals(null)).isFalse();
    }
}
