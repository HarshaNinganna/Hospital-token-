package com.stockanalyzer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private StockDataService stockDataService; // Service for fetching stock data

    @Override
    public void start(Stage primaryStage) {
        stockDataService = new StockDataService();

        Label stockLabel = new Label("Stock Price: ");
        Button refreshButton = new Button("Refresh");

        refreshButton.setOnAction(e -> {
            String stockPrice = stockDataService.fetchCurrentStockPrice("AAPL"); // Fetch stock price for Apple
            stockLabel.setText("Stock Price: " + stockPrice);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(stockLabel, refreshButton);
        Scene scene = new Scene(layout, 300, 200);

        primaryStage.setTitle("Real-time Stock Market Analyzer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
