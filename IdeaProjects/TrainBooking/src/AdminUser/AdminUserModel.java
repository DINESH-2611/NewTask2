package AdminUser;

import datalayer.TrainBookingDatabse;
import model.Passenger;
import model.Ticket;
import model.TrainRoutes;

import java.util.List;

public class AdminUserModel {
    private AdminUserView adminUserView;
    private String[] status = {"CNF", "WL", "Cancel"};

    public AdminUserModel(AdminUserView adminUserView) {
        this.adminUserView = adminUserView;
    }

    public void addTrainRoutes(String name, String departure, String arrival, int seats, int fare, List<String> routes) {
        TrainRoutes trainRoutes = new TrainRoutes();
        trainRoutes.setTrainNo(generatePnr());
        trainRoutes.setTrainName(name);
        trainRoutes.setDepartureTime(departure);
        trainRoutes.setArrivalTime(arrival);
        trainRoutes.setSeats(seats);
        trainRoutes.setFare(fare);
        trainRoutes.setRoutes(routes);
        TrainBookingDatabse.getInstance().addTrainroutes(trainRoutes);
    }

    public void getAvailabletrains(String from, String to, String userName, int i) {
        List<TrainRoutes> availabletrains = TrainBookingDatabse.getInstance().getAvailabletrains(from, to);
        if (availabletrains.isEmpty()) {
            adminUserView.showAlert("No trains found");
        } else {
            if (i == 1) {
                adminUserView.showAlert("\t\t\tAvailable trains");
                adminUserView.showTrains(availabletrains);
                adminUserView.getTrainNo(availabletrains, from, to, userName);
            } else {
                adminUserView.showAlert("Train List");
                adminUserView.showTrains(availabletrains);
            }
        }
    }

    public void isvalidTrain(List<TrainRoutes> availabletrains, int trainNo, String from, String to, String userName) {
        for (TrainRoutes trainRoutes : availabletrains) {
            if (trainRoutes.getTrainNo() == trainNo) {
                adminUserView.getpassengersCount(trainRoutes, from, to, userName, availabletrains);
                return;
            }
        }
        adminUserView.showAlert("Train  no is wrong");
    }

    public void showTrains() {
        adminUserView.showTrains(TrainBookingDatabse.getInstance().getAllTrains());
    }

    public void isvalidPnr(int pnr) {
        if (TrainBookingDatabse.getInstance().getPnr(pnr) != null) {
            adminUserView.getTicketStatus(pnr);
        } else {
            adminUserView.showAlert("PNR number not match");
        }
    }

    public void updateStatus(int pnr, String status) {
        List<Passenger> passengers = TrainBookingDatabse.getInstance().getPassengersByPnr(pnr);
        for (Passenger passenger : passengers) {
            passenger.setStatus(status);
        }
        adminUserView.showAlert("Ticket status updated as '" + status + "'\nTicket Details\nTrain Details\n_____________");
        adminUserView.showTickets(TrainBookingDatabse.getInstance().getTicketsByPnr(pnr));
        adminUserView.showAlert("Passengers Details\n_____________");
        adminUserView.showPassengers(TrainBookingDatabse.getInstance().getPassengersByPnr(pnr));
    }

    public void showTicketsByPnr() {
        adminUserView.showTickets(TrainBookingDatabse.getInstance().getTickets());
    }

    public void showPassengersPnr() {
        adminUserView.showPassengers(TrainBookingDatabse.getInstance().getpassengers());
    }

    void bookTicket(TrainRoutes trainRoutes, Passenger[] passengers1, String from, String to, int totalfare, String userName) {
        int pnr = generatePnr();
        for (Passenger passenger : passengers1) {
            int index = (int) (Math.random() * 3 + 0.5);
            if (index < 0 || index > 2)
                index = 1;
            passenger.setStatus(status[index]);
        }
        TrainBookingDatabse.getInstance().addPassengers(passengers1, pnr);
        TrainBookingDatabse.getInstance().addTicket(trainRoutes, pnr, from, to, totalfare);
        TrainBookingDatabse.getInstance().getPnrToUser(userName, pnr);
        adminUserView.showAlert("Ticket Details\nTrain Details\n_____________");
        adminUserView.showTickets(TrainBookingDatabse.getInstance().getTicketsByPnr(pnr));
        adminUserView.showAlert("Passengers Details\n_____________");
        adminUserView.showPassengers(TrainBookingDatabse.getInstance().getPassengersByPnr(pnr));
    }

    private int generatePnr() {
        return (int) (Math.random() * 10000000 + (int) (Math.random() * 100000));
    }

    public void validatePnr(int pnr) {
        List<Ticket> tickets = TrainBookingDatabse.getInstance().getTicketsByPnr(pnr);
        if (tickets.isEmpty()) {
            adminUserView.showAlert("Invalid PNR number");
            return;
        }
        adminUserView.showAlert("Ticket Details\nTrain Details\n_____________");
        adminUserView.showTickets(TrainBookingDatabse.getInstance().getTicketsByPnr(pnr));
        adminUserView.showAlert("Passengers Details\n_____________");
        adminUserView.showPassengers(TrainBookingDatabse.getInstance().getPassengersByPnr(pnr));
    }

    public void isPnrExist(int pnr) {
        Ticket ticket = TrainBookingDatabse.getInstance().getPnr(pnr);
        if (ticket != null) {
            adminUserView.checkForcancel(pnr, ticket);
        } else {
            adminUserView.showAlert("Invalid PNR number");
        }
    }

    public void cancelTicket(int pnr, Ticket ticket) {
        adminUserView.showAlert("Ticket cancelled successfully,Your refund " + ticket.getTotalfare() + " will be processed soon");
        TrainBookingDatabse.getInstance().removeTicket(ticket);
    }

    public void isPassengerExist(int id) {
        Passenger passenger = TrainBookingDatabse.getInstance().getPassenger(id);
        if (passenger != null) {
            adminUserView.showAlert(passenger + "");
        } else {
            adminUserView.showAlert("Passenger not found");
        }
    }

    public void getAllTickets() {
        adminUserView.showTicketsWithPassengers(TrainBookingDatabse.getInstance().getAllTickets());
    }

    public void getPassenger(int pnr) {
        adminUserView.showPassengers(TrainBookingDatabse.getInstance().getPassengersByPnr(pnr));
    }
}
