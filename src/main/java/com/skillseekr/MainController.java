package com.skillseekr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import com.skillseekr.Models.User.User;
import com.skillseekr.User.SessionManager;



public class MainController {
    @FXML
    private Button btnUsers;

    @FXML
    private Button btnOffers;

    @FXML
    private Button btnCalendar;

    @FXML
    private Button btnClaims;

    @FXML
    private Button btnProjects;

    @FXML
    private Button btnHire;

/*
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnOffers) {
            // Load Offers page
            loadPage("/com/Skillseekr/Offer/Offer.fxml");
        } else if ((mouseEvent.getSource() == btnHire)) {
            loadPage("/com/Skillseekr/Hire/Recrutement.fxml");
        }
        else if ((mouseEvent.getSource() == btnCalendar)) {
            loadPage("/com/Skillseekr/Calendar.fxml");
        }
        else if ((mouseEvent.getSource() == btnClaims)) {
            loadPage("/com/Skillseekr/Claims/Claims.fxml");
        }
        else if ((mouseEvent.getSource() == btnProjects)) {
            loadPage("/com/Skillseekr/Projects/Projects.fxml");
        }
        else if ((mouseEvent.getSource() == btnUsers)) {
            loadPage("/com/Skillseekr/User/Back.fxml");
        }
    }
*/

    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        User currentUser = SessionManager.getCurrentUser();
        if (currentUser != null) {
            if (currentUser.getRoles().contains("[\"ROLE_ADMIN\"]")) {
                handleAdminClicks(mouseEvent);
            } else if (currentUser.getRoles().contains("[\"ROLE_RECRUTEUR\"]")) {
                handleRecruiterClicks(mouseEvent);
            } else if (currentUser.getRoles().contains("[\"ROLE_FREELANCER\"]")) {
                handleFreelancerClicks(mouseEvent);
            } else {
                // Handle other roles or no role scenario
            }
        } else {
            // Handle the case where the current user is not authenticated
        }
    }

    private void handleAdminClicks(javafx.event.ActionEvent mouseEvent) {
        // Admin can access all interfaces
        if (mouseEvent.getSource() == btnOffers) {
            // Load Offers page
            loadPage("/com/Skillseekr/Offer/Offer.fxml");
        } else if ((mouseEvent.getSource() == btnHire)) {
            loadPage("/com/Skillseekr/Hire/Recrutement.fxml");
        } else if ((mouseEvent.getSource() == btnCalendar)) {
            loadPage("/com/Skillseekr/Calendar.fxml");
        } else if ((mouseEvent.getSource() == btnClaims)) {
            loadPage("/com/Skillseekr/Claims/Claims.fxml");
        } else if ((mouseEvent.getSource() == btnProjects)) {
            loadPage("/com/Skillseekr/Projects/Projects.fxml");
        } else if ((mouseEvent.getSource() == btnUsers)) {
            loadPage("/com/Skillseekr/User/Back.fxml");
        }
    }

    private void handleRecruiterClicks(javafx.event.ActionEvent mouseEvent) {
        // Recruiters can access specific interfaces
        if (mouseEvent.getSource() == btnOffers) {
            // Load Offers page
            loadPage("/com/Skillseekr/Offer/Offer.fxml");
        } else if (mouseEvent.getSource() == btnCalendar) {
            // Load Calendar page
            loadPage("/com/Skillseekr/Calendar.fxml");
        } else if (mouseEvent.getSource() == btnClaims) {
            // Load Claims page
            loadPage("/com/Skillseekr/Claims/Claims.fxml");
        } else if (mouseEvent.getSource() == btnProjects) {
            // Load Projects page
            loadPage("/com/Skillseekr/Projects/Projects.fxml");
        } else if ((mouseEvent.getSource() == btnHire)) {
            loadPage("/com/Skillseekr/Hire/Recrutement.fxml");
        }
        // Add other button handling cases for recruiters if needed
    }

    private void handleFreelancerClicks(javafx.event.ActionEvent mouseEvent) {
        // Freelancers can access specific interfaces
        if (mouseEvent.getSource() == btnOffers) {
            // Load Offers page
            loadPage("/com/Skillseekr/Offer/Offer.fxml");
        } else if (mouseEvent.getSource() == btnCalendar) {
            // Load Calendar page
            loadPage("/com/Skillseekr/Calendar.fxml");
        } else if (mouseEvent.getSource() == btnProjects) {
            // Load Projects page
            loadPage("/com/Skillseekr/Projects/Projects.fxml");
        } else if ((mouseEvent.getSource() == btnClaims)) {
            loadPage("/com/Skillseekr/Claims/Claims.fxml");
        }
        // Add other button handling cases for freelancers if needed
    }

    private void loadPage(String fxml) {
        try {
            URL resourceUrl = getClass().getResource(fxml);
            if (resourceUrl == null) {
                throw new IllegalArgumentException("FXML file not found: " + fxml);
            }
            Parent root = FXMLLoader.load(resourceUrl);
            Scene scene = btnOffers.getScene(); // Get the scene from any UI element, assuming all UI elements are in the same scene
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

