public class Main {    

    public static void main (String[] args) {

        // The subject
        WeatherData weatherData = new WeatherData();

        // The observers
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        
        // Changes in the subject
        weatherData.setMeasurements(32.12, 40.15);
        weatherData.setMeasurements(40.00, 38.12);
        weatherData.setMeasurements(34.20, 33.44);
    }
}