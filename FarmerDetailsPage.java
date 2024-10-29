package com.example.oop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FarmerDetailsPage extends Application {
    private String username; 

    public FarmerDetailsPage(String username) {
        this.username = username; 
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Farmer Details Page");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Labels and fields for farmer details
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        grid.add(ageLabel, 0, 1);
        grid.add(ageField, 1, 1);

        Label cropLabel = new Label("Types of Crops Grown:");
        TextField crop1Field = new TextField();
        TextField crop2Field = new TextField();
        TextField crop3Field = new TextField();
        TextField cropOtherField = new TextField();
        crop1Field.setPromptText("Crop 1");
        crop2Field.setPromptText("Crop 2");
        crop3Field.setPromptText("Crop 3");
        cropOtherField.setPromptText("Other");
        grid.add(cropLabel, 0, 2);
        grid.add(crop1Field, 1, 2);
        grid.add(crop2Field, 1, 3);
        grid.add(crop3Field, 1, 4);
        grid.add(cropOtherField, 1, 5);

        Label fundingLabel = new Label("Any Funding:");
        TextArea fundingField = new TextArea();
        fundingField.setPromptText("Specify funding from government or any other body...");
        fundingField.setPrefRowCount(3);
        grid.add(fundingLabel, 0, 6);
        grid.add(fundingField, 1, 6);

        Button updateButton = new Button("Update Details");
        grid.add(updateButton, 1, 7);

        
        updateButton.setOnAction(e -> {
           
            String name = nameField.getText();
            String age = ageField.getText();
            String crop1 = crop1Field.getText();
            String crop2 = crop2Field.getText();
            String crop3 = crop3Field.getText();
            String otherCrops = cropOtherField.getText();
            String funding = fundingField.getText();

            
            showAlert(Alert.AlertType.INFORMATION, "Update Successful", "Details updated for " + username + "!");
        });

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
