import Signuporlogin.SignUpOrLoginView;
import datalayer.TrainBookingDatabse;

public class TrainBookingMain {
    public static void main(String[] args) {
        createCredential();
        new SignUpOrLoginView().init();
    }

    private static void createCredential() {
        TrainBookingDatabse.getInstance().createCredentails();
    }
}
