package Signuporlogin;

import datalayer.TrainBookingDatabse;

class SignUporLoginModel {
    private SignUpOrLoginView signUpOrLoginView;

    public SignUporLoginModel(SignUpOrLoginView signUpOrLoginView) {
        this.signUpOrLoginView = signUpOrLoginView;
    }

    public void isUserExist(String userName, String password) {
        if (!alreadyuser(userName, password)) {
            signUpOrLoginView.showAlert("User already exist");
            signUpOrLoginView.onLoginfailed();
        } else {
            TrainBookingDatabse.getInstance().adduser(userName, password);
            signUpOrLoginView.showAlert("User account created Succesfully");
        }
    }

    private boolean alreadyuser(String userName, String password) {
        return TrainBookingDatabse.getInstance().isUserExist(userName, password);
    }

    public void validUser(String userName, String password) {
        if (TrainBookingDatabse.getInstance().validuser(userName, password)) {
            if (userName.equals("zsgs")) {
                signUpOrLoginView.onAdminLoginuccess();
            } else {
                signUpOrLoginView.onUserLoginSuccess(userName);
            }
        } else {
            signUpOrLoginView.showAlert("Invalid username or password");
            signUpOrLoginView.onLoginfailed();
        }
    }
}
