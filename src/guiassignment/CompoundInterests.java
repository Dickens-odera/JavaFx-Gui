/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates                       
 * and open the template in the editor.
 */
package guiassignment;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *r
 * @author Dickens
 */
public class CompoundInterests extends Application {
    private double principle;
    private double rate;
    private int time;
    private double simpleInterest;
    private double compoundInterest;
    private double difference;
    @Override
    public void start(Stage primaryStage) {
       GridPane gridPane = new GridPane();
       gridPane.setAlignment(Pos.CENTER);
       gridPane.setPadding(new Insets(10,10,10,10));
       gridPane.setHgap(10);
       gridPane.setVgap(10);
       //flowpane
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(10);
        pane.setVgap(10);
       pane.setBorder(Border.EMPTY);
       //Instantiate the widgets
       Label lblP = new Label("Principle");
       TextField tftPrinciple = new TextField();
       TextField tftRate = new TextField();
       TextField tftTime = new TextField();
       TextField tftCompoundInterest = new TextField();
       TextField tftSimpleInterest = new TextField();
       TextField tftDiffrence = new TextField();
       Button btnCompute = new Button("Compute");
       Button btnExit = new Button("Exit");
       Label lblRate = new Label("Rate");
       Label lblTime = new Label("Time (Years)");
       Label lblCompound = new Label("Compound Interest");
       Label lblSimpleInterest = new Label("Simple Interest");
       Label lblDiffrence = new Label("Difference");
              // add buttons to flowpane

       Button btnClear = new Button("Clear");
       btnClear.setPrefWidth(100);
       btnExit.setPrefWidth(150);
       btnCompute.setPrefWidth(100);
       btnExit.applyCss();
       pane.getChildren().addAll(btnCompute, btnExit);
       //tft modifications
       tftCompoundInterest.setEditable(false);
       tftSimpleInterest.setEditable(false);
       tftDiffrence.setEditable(false);
       //add pane to grid
       //gridPane.add(pane, 0,7);
       //place nodes on the pane
       btnCompute.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 18));
       btnExit.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 18));
       btnClear.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 18));

       //action listeners
       btnClear.setOnAction((event)->{
           tftCompoundInterest.setText("");
           tftSimpleInterest.setText("");
           tftTime.setText("");
           tftRate.setText("");
           tftDiffrence.setText("");
           tftPrinciple.setText("");


       });
       btnCompute.setOnAction((ActionEvent event) -> {
           /*
           String amount = JOptionPane.showInputDialog(null,"Enter The Principle","Principle",JOptionPane.QUESTION_MESSAGE);
           principle = Double.parseDouble(amount);
           String rateToCompute = JOptionPane.showInputDialog(null,"Enter the rate", "Rate", JOptionPane.QUESTION_MESSAGE);
           rate = Double.parseDouble(rateToCompute);
           String timeToCompute = JOptionPane.showInputDialog(null,"Enter the duration","Time", JOptionPane.QUESTION_MESSAGE);
           time = Integer.parseInt(timeToCompute);
           
           */
           
          String p = tftPrinciple.getText();
          String r = tftRate.getText();
          String t = tftTime.getText();
          principle = Double.parseDouble(p);
          rate = Double.parseDouble(r);
          time = Integer.parseInt(t);
          if(tftTime.getText().equals("")||
                  principle == 0.00 || 
                  rate == 0.00 ||
                  time == 0 ||
                  tftPrinciple.getText().equals("")||
                  tftRate.getText().equals("") ||
                  tftTime.getText().equals("")
                   ){
              JOptionPane.showMessageDialog(null,"Invalid Entry","ERROR", JOptionPane.INFORMATION_MESSAGE);
          }else{
                try{
              simpleInterest = ((principle * ( rate/100) * (time/12)));
           //System.out.println("The value is "+ simpleInterest);
           DecimalFormat df = new DecimalFormat("0.00");
        tftSimpleInterest.setText(String.valueOf(String.format("Kshs %.2f",simpleInterest)));  
        double amount =  principle * Math.pow(1 + (rate/100), (time/12));
        compoundInterest = amount - principle;
        tftCompoundInterest.setText(String.valueOf(String.format("Kshs %.2f",compoundInterest)));
        difference = compoundInterest - simpleInterest;
        tftDiffrence.setText(String.valueOf(String.format("Kshs %.2f",difference)));
          }catch(NumberFormatException e){
             //JOptionPane.showMessageDialog(null,"Error",e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
             System.out.println("Empty fields");
          }
          catch(InputMismatchException ex){
              System.out.println("You must enter numeric values "+ex);
          }
              
          }
       });
       //exit button
       btnExit.setOnAction((ActionEvent event) ->{
           System.exit(0);
       });
       gridPane.add(lblP, 0, 0);
       gridPane.add(tftPrinciple, 1,0);
       gridPane.add(lblRate, 0, 1);
       gridPane.add(tftRate, 1,1);
       gridPane.add(lblTime, 0,2);
       gridPane.add(tftTime, 1,2);
       gridPane.add(lblSimpleInterest, 0,3);
       gridPane.add(tftSimpleInterest, 1,3);
       gridPane.add(lblCompound, 0, 4);
       gridPane.add(tftCompoundInterest, 1, 4);
       gridPane.add(lblDiffrence, 0, 5);
       gridPane.add(tftDiffrence, 1, 5);
       gridPane.add(btnCompute, 0, 6);
       gridPane.add(btnExit, 1, 6);
       gridPane.add(btnClear,2, 6);
       gridPane.setPrefSize(500, 300);
       //set the scene
       Scene scene = new Scene(gridPane);
       primaryStage.setScene(scene);
       primaryStage.setTitle("Simple and Compound Interest");
       primaryStage.setResizable(false);
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
