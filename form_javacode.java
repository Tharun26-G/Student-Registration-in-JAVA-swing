package com.example.registrationform;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.time.LocalDate;


public class form extends Application {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BlackRock R&D Mock Examination 2022");
        GridPane grid = createGrid();
        addUIControls(grid);
        Scene scene = new Scene(grid, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void addUIControls(GridPane grid) {
        Label headerLabel = new Label("\t\t\t\t\t\t\t\tREGISTRATION FORM");
        headerLabel.setTextFill(Color.ORANGERED);
        headerLabel.setFont(Font.font("TIMESNEWROMAN", FontWeight.BOLD, 24));
        grid.add(headerLabel, 0,0,2,1);

        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // NAME FIELD
        Label nameLabel = new Label("Name : ");
        grid.add(nameLabel, 0,1);
        //TEXT FIELD FOR NAME
        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        grid.add(nameField, 1,1);

        // regno FIELD
        Label regnoLabel = new Label("Reg No : ");
        grid.add(regnoLabel, 0,2);

        //TEXT FIELD FOR regno
        TextField regnoField = new TextField();
        regnoField.setPrefHeight(40);
        grid.add(regnoField, 1,2);

        // email FIELD
        Label emailLabel = new Label("Email : ");
        grid.add(emailLabel, 0,3);
        //TEXT FIELD FOR email
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        grid.add(emailField, 1,3);

        // phone FIELD
        Label phoneLabel = new Label("Phone : ");
        grid.add(phoneLabel, 0,4);
        //TEXT FIELD FOR phone
        TextField phoneField = new TextField();
        phoneField.setPrefHeight(40);
        grid.add(phoneField, 1,4);

        // Date of Birth FIELD
        Label dobLabel = new Label("Date of Birth : ");
        grid.add(dobLabel, 0,5);
        Label selectedDateLabel = new Label("Not Selected");
        //Select date of birth from calendar
        DatePicker dobField = new DatePicker();
        dobField.setOnAction(e -> {
            LocalDate date = dobField.getValue();
            String dateString = date.toString();
            selectedDateLabel.setText(dateString);

        });
        grid.add(selectedDateLabel, 1,5);
        grid.add(dobField, 1,6);

        // Branch Radio button
        Label branchLabel = new Label("Branch : ");
        grid.add(branchLabel, 0,8);
        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("CSE");
        RadioButton button2 = new RadioButton("ECE");
        RadioButton button3 = new RadioButton("EEE");
        RadioButton button4 = new RadioButton("IT");
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);
        button3.setToggleGroup(group);
        button4.setToggleGroup(group);
        grid.add(button1, 1,8);
        grid.add(button2, 2,8);
        grid.add(button3, 1,9);
        grid.add(button4, 2,9);

        // Current semester Radio button
        Label semesterLabel = new Label("Current Semester : ");
        grid.add(semesterLabel, 0,11);
        ToggleGroup group1 = new ToggleGroup();
        RadioButton button5 = new RadioButton("Semester 7");
        RadioButton button6 = new RadioButton("Semester 8");
        button5.setToggleGroup(group1);
        button6.setToggleGroup(group1);
        grid.add(button5, 1,11);
        grid.add(button6, 2,11);

        // CGPA field
        Label cgpaLabel = new Label("CGPA : ");
        grid.add(cgpaLabel, 0,13);
        TextField cgpaField = new TextField();
        cgpaField.setPrefHeight(40);
        grid.add(cgpaField, 1,13);

        // Internship field

        Label internshipLabel = new Label(" Have you taken Internship in any company ? : ");
        grid.add(internshipLabel, 0,15);
        ToggleGroup group2 = new ToggleGroup();
        RadioButton button7 = new RadioButton("Yes");
        RadioButton button8 = new RadioButton("No");
        button7.setToggleGroup(group2);
        button8.setToggleGroup(group2);
        grid.add(button7, 1,15);
        grid.add(button8, 2,15);
        TextArea internshipField = new TextArea();
        group2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {


                if(button7.isSelected()){

                    internshipField.setPromptText("Enter your internship details here");
                    internshipField.setPrefHeight(100);
                    internshipField.setPrefWidth(400);
                    grid.add(internshipField, 1,16);


                }

            }
        });

        // Programming languages known field
        Label languagesLabel = new Label("Programming Languages Known : ");
        grid.add(languagesLabel, 0,18);
        CheckBox checkBox1 = new CheckBox("C");
        CheckBox checkBox2 = new CheckBox("C++");
        CheckBox checkBox3 = new CheckBox("Java");
        CheckBox checkBox4 = new CheckBox("Python");

        grid.add(checkBox1, 1,18);
        grid.add(checkBox2, 2,18);
        grid.add(checkBox3, 1,19);
        grid.add(checkBox4, 2,19);

        // Submit button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setPrefWidth(100);
        submitButton.setAlignment(Pos.CENTER);
        grid.add(submitButton, 1,20);


        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // get the data from the fields
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                if(name.isEmpty()){
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please enter your name");
                    nameField.setPromptText("Please enter your name");
                    nameField.requestFocus();

                }
                else if(email.isEmpty() ){
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please enter your email id");
                    emailField.setPromptText("Please enter your email id");
                    emailField.requestFocus();
                }
                else if (!email.contains("@") || !email.contains(".") || email.length()<5)
                {
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please enter a valid email id");
                    emailField.setPromptText("Please enter a valid email id");
                    emailField.requestFocus();
                }

                else if(phone.isEmpty() ){
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please enter your phone number");
                    phoneField.setPromptText("Please enter your phone number");
                    phoneField.requestFocus();
                }
                else if ( phone.length()!=10 || !phone.matches("[0-9]+"))
                {
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please enter a valid phone number");
                    phoneField.requestFocus();
                }
                // if Regno field is empty
                else if(regnoField.getText().isEmpty() ){
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please enter your registration number");
                    regnoField.setPromptText("Please enter your registration number");
                    regnoField.requestFocus();
                }
                else if (  regnoField.getText().length()!=9 || !regnoField.getText().matches("[0-9]{2}[A-Z]{3}[0-9]{4}"))
                {
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please enter a valid registration number");
                    regnoField.requestFocus();
                }
                // if Date of birth field is empty or age less than 19
                else if(dobField.getValue()==null ){
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please Enter valid date of birth");

                }
                else if ( LocalDate.now().getYear()-dobField.getValue().getYear()<19)
                {
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Application can be applied only for students above 19 years");
                }
                // if branch is not selected
                else if(!button1.isSelected() && !button2.isSelected() && !button3.isSelected() && !button4.isSelected()){
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please select your Branch");

                }
                // if semester is not selected
                else if(!button5.isSelected() && !button6.isSelected() ){
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please select your semester");
                }
                // if  cgpa field is empty
                else if(cgpaField.getText().isEmpty()){
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please enter your CGPA");
                    cgpaField.setPromptText("Please enter your CGPA");
                    cgpaField.requestFocus();
                }
                // if internship field is empty
                else if(button7.isSelected() && internshipField.getText().isEmpty())
                {
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Please enter your internship Details");
                }
                // if no programming languages are selected
                else if(!checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected() && !checkBox4.isSelected()){
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!", "Applicant is expected to be proficient in atleast one  of the programming language");
                }
                else {
                    showAlert(Alert.AlertType.CONFIRMATION, grid.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());
                }

            }
        });
    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20,40,80,40));
        grid.setHgap(10);
        grid.setVgap(10);
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        columnOneConstraints.setHgrow(Priority.ALWAYS);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        ColumnConstraints columnThreeConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnThreeConstrains.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll( columnOneConstraints, columnTwoConstrains,columnThreeConstrains);

        return grid;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
