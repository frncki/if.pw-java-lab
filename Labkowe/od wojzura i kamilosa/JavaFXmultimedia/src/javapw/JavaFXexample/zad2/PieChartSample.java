package javapw.JavaFXexample.zad2;


import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
 
public class PieChartSample extends Application {
	
	 ObservableList<PieChart.Data> pieChartData;
	 Random rand;
	 int apples = 1;
	 PieChart chart;
	
    public void start(Stage stage) {
 
        pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", apples));
        chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");
        
        Button btn = new Button("draw apples");
        btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Random rand = new Random();
				apples = rand.nextInt(200);
				System.out.println(apples);
				chart.getData().remove(4);
				chart.getData().add(new PieChart.Data("Apples", apples));
			}
        });
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(btn);
        borderPane.setCenter(chart);

 
        Scene scene = new Scene(borderPane,500,600);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}