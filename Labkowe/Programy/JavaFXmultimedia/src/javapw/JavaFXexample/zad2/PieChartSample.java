package javapw.JavaFXexample.zad2;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

import java.util.Random;

public class PieChartSample extends Application {

    ObservableList<PieChart.Data> pieChartData;

    Random rand;
    int apples = 1;
	
    public void start(Stage stage) {
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(600);

        pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", apples));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        Button randButton = new Button("Randomize number of apples");
        randButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                rand = new Random();
                apples = rand.nextInt(200);
                System.out.println("Apples: " + apples);
                chart.getData().remove(4);
                chart.getData().add(new PieChart.Data("Apples", apples));
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(chart);
        borderPane.setBottom(randButton);

        Scene scene = new Scene(borderPane,500,600);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}