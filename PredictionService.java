package com.stockanalyzer;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class PredictionService {

    private Classifier model;

    /**
     * Loads the machine learning model from the specified file.
     * 
     * @param modelFilePath the path to the model file
     * @throws Exception if there is an error loading the model
     */
    public void loadModel(String modelFilePath) throws Exception {
        DataSource source = new DataSource(modelFilePath);
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);
        model = Classifier.forName("weka.classifiers.trees.J48", null); // Example with J48 decision tree
        model.buildClassifier(data);
    }

    /**
     * Makes a prediction for the given stock data instance.
     * 
     * @param stockData the stock data instance to predict
     * @return the predicted price as a String
     * @throws Exception if there is an error during prediction
     */
    public String predictPrice(Instance stockData) throws Exception {
        double prediction = model.classifyInstance(stockData);
        return String.valueOf(prediction);
    }
}
