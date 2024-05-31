package datalayer;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class TrainBookingDatabse {
    private String appName;
    private static TrainBookingDatabse trainBookingDatabse;
    private List<TrainRoutes> trainRoutesList = new ArrayList<>();
    private List<Passenger> passengerList = new ArrayList<>();
    private List<Credential> credentialList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();

    public static TrainBookingDatabse getInstance() {
        if (trainBookingDatabse == null) {
            trainBookingDatabse = new TrainBookingDatabse();
        }
        return trainBookingDatabse;
    }

    public String getAppName() {
        return appName;
    }

    public void createCredentails() {
        if (credentialList.isEmpty()) {
            Credential credential = new Credential();
            credential.setUserName("zsgs");
            credential.setPassword("admin");
            credential.setRole(1);
            credentialList.add(credential);
        }
        appName = "IRCTC";
    }

    public boolean isUserExist(String userName, String password) {
        for (Credential credential : credentialList) {
            if (credential.getUserName().equals(userName))
                return false;
        }
        return true;
    }

    public void adduser(String userName, String password) {
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        userList.add(user);
        Credential credential = new Credential();
        credential.setUserName(userName);
        credential.setPassword(password);
        credentialList.add(credential);
    }

    public void addTrainroutes(TrainRoutes trainRoutes) {
        trainRoutesList.add(trainRoutes);
    }

    public List<TrainRoutes> getAvailabletrains(String from, String to) {
        List<TrainRoutes> availabletrains = new ArrayList<>();
        for (TrainRoutes trainRoutes : trainRoutesList) {
            List<String> routes = trainRoutes.getRoutes();
            if (routes.get(0).equalsIgnoreCase(from) && routes.get(routes.size() - 1).equalsIgnoreCase(to))
                availabletrains.add(trainRoutes);
        }
        return availabletrains;
    }

    public boolean validuser(String userName, String password) {
        for (Credential credential : credentialList) {
            if (credential.getUserName().equals(userName) && credential.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public List<TrainRoutes> getAllTrains() {
        return trainRoutesList;
    }

    public Ticket getPnr(int pnr) {
        for (Ticket ticket : ticketList) {
            if (ticket.getPnrNo() == pnr)
                return ticket;
        }
        return null;
    }

    public List<Passenger> getPassengersByPnr(int pnr) {
        List<Passenger> passengers = new ArrayList<>();
        for (Passenger passenger : passengerList) {
            if (passenger.getPnr() == pnr)
                passengers.add(passenger);
        }
        return passengers;
    }

    public List<Ticket> getTickets() {
        return ticketList;
    }

    public List<Passenger> getpassengers() {
        return passengerList;
    }

    public List<Ticket> getTicketsByPnr(int pnr) {
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            if (ticket.getPnrNo() == pnr)
                tickets.add(ticket);
        }
        return tickets;
    }

    public void addPassengers(Passenger[] passengers1, int pnr) {
        for (Passenger passenger : passengers1) {
            passenger.setPnr(pnr);
            passengerList.add(passenger);
        }
    }

    public void addTicket(TrainRoutes trainRoutes, int pnr, String from, String to, int totalfare) {
        Ticket ticket = new Ticket();
        ticket.setTrainNo(trainRoutes.getTrainNo());
        ticket.setTrainName(trainRoutes.getTrainName());
        ticket.setDepartureTime(trainRoutes.getDepartureTime());
        ticket.setArrivalTime(trainRoutes.getArrivalTime());
        ticket.setFrom(from);
        ticket.setTo(to);
        ticket.setPnrNo(pnr);
        ticket.setTotalfare(totalfare);
        ticketList.add(ticket);
    }

    public void getPnrToUser(String userName, int pnr) {
        for (User user : userList) {
            if (user.getName().equals(userName))
                user.setPnr(pnr);
        }
    }

    public int getPnrNo(String userName) {
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                return user.getPnr();
            }
        }
        return -1;
    }

    public void removeTicket(Ticket ticket) {
        Ticket ticket2 = null;
        for (Ticket ticket1 : ticketList) {
            if (ticket.getPnrNo() == ticket1.getPnrNo())
                ticket2 = ticket1;
        }
        ticketList.remove(ticket2);
    }

    public Passenger getPassenger(int id) {
        for (Passenger passenger : passengerList) {
            if (passenger.getId() == id)
                return passenger;
        }
        return null;
    }

    public List<Ticket> getAllTickets() {
        return ticketList;
    }
}
