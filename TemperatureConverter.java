import java.util.Scanner;

public class TemperatureConverter {
    public static boolean isValidScale(String scale) {
        return scale.equals("C") || scale.equals("F") || scale.equals("K");
     }
    public static double convertTemp(double temperature, String sourcescale, String targetscale){
        switch (sourcescale) {
            case "C":
                if (targetscale.equals("F")) {
                    return (temperature*9/5)+32;
                }else if(targetscale.equals("K")){
                    return temperature+273.15;
                }
                break;
            
            case "F":
            if (targetscale.equals("C")) {
                return (temperature-32)*5/9;
            }else if(targetscale.equals("K")){
                return (temperature+459.67)*5/9;
            }

            case "K":
            if (targetscale.equals("C")) {
                return temperature-273.15;
            }else if(targetscale.equals("F")){
                return (temperature*9/5)-459.67;
            }
                break;
        }
        return temperature;
     }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get user input
        double temperature = sc.nextDouble();

        // Get user input for source scale
        System.out.println("Enter source scale (C, K or F): ");
        String sourcescale = sc.next().toUpperCase();

        // Get user input for target scale
        System.out.println("Enter target scale (C, K or F): ");
        String targetscale = sc.next().toUpperCase();

        if (!isValidScale(sourcescale) || !isValidScale(targetscale)) {
            System.out.println("Invalid scale entered. Use C, F, or K.");
            sc.close();
            return;
        }

        double convertedTemp = convertTemp(temperature,sourcescale,targetscale);
        
        // Display result
        System.out.println(temperature +sourcescale+ " is converted into "+convertedTemp+targetscale);
        
    }
}
