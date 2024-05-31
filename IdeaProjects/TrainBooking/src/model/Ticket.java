package model;

public class Ticket {
    private int trainNo;
    private String trainName;
    private String departureTime;
    private String arrivalTime;
    private String from;
    private String to;
    private int pnrNo;
    private int totalfare;

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(int pnrNo) {
        this.pnrNo = pnrNo;
    }

    public int getTotalfare() {
        return totalfare;
    }

    public void setTotalfare(int totalfare) {
        this.totalfare = totalfare;
    }

    @Override
    public String toString() {
        return
                "trainNo=" + trainNo +
                        "|| trainName='" + trainName + '\'' +
                        "|| departureTime='" + departureTime + '\'' +
                        "|| arrivalTime='" + arrivalTime + '\'' +
                        "|| from='" + from + '\'' +
                        "|| to='" + to + '\'' +
                        "|| pnrNo=" + pnrNo +
                        "|| totalfare=" + totalfare;
    }
}
