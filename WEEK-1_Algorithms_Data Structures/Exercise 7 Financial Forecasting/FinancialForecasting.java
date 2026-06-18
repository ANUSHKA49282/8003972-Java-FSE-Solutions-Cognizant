public class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; 
        double pastDataGrowthRate = 0.05; 
        int periodsToForecast = 10;   

        System.out.println("--- Financial Forecasting ---");
        System.out.println("Present Value: $" + presentValue);
        System.out.println("Growth Rate: " + (pastDataGrowthRate * 100) + "%");
        System.out.println("Periods to Forecast: " + periodsToForecast + " years");

        double futureValue = calculateFutureValue(presentValue, pastDataGrowthRate, periodsToForecast);
        
        System.out.printf("\nPredicted Future Value: $%.2f\n", futureValue);
    }
}