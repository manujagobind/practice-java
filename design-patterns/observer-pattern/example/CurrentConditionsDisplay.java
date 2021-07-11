public class CurrentConditionsDisplay implements IObserver, IDisplay {

    // This display only needs a subset of weather data
    private double temprature;
    private double humidity;

    // Maintains a reference to the subject
    WeatherData weatherData;
    
    // The subject is provided at runtime
    CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;

        // Register with the subject
        this.weatherData.registerObserver(this);
    }

    // Implementing IObserver
    // The ISubject will invoke this function
    public void update() {
        // Get the required data from the ISubject
        this.temprature = this.weatherData.getTemprature();
        this.humidity = this.weatherData.getHumidity();

        // Perform required operation
        this.display();
    }

    // Implementing IDisplay
    public void display() {
        System.out.println(String.format("The current wather conditions are: temprature %,.2f degrees C and humidity %,.2f %%.",
            this.weatherData.getTemprature(), this.weatherData.getHumidity()));
    }

}