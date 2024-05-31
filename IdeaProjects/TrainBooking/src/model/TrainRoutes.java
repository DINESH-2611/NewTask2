package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainRoutes {
    private int trainNo;
    private String trainName;
    private String departureTime;
    private String arrivalTime;
    private List<String> routes = new ArrayList<>();
    private int seats;
    private int fare;

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<String> getRoutes() {
        return routes;
    }

    public void setRoutes(List<String> routes) {
        this.routes = routes;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "TrainRoutes{" +
                "trainNo=" + trainNo +
                "|| trainName='" + trainName + '\'' +
                "|| departureTime='" + departureTime + '\'' +
                "|| arrivalTime='" + arrivalTime + '\'' +
                "|| routes=" + routes +
                "|| seats=" + seats +
                "|| fare=" + fare +
                '}';
    }
}
