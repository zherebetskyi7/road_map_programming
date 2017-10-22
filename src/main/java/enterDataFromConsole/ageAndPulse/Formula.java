package enterDataFromConsole.ageAndPulse;

import java.util.LinkedList;
import java.util.Scanner;

public class Formula
{
    public static void formula()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your age (integer): ");
        int age = scan.nextInt();
        System.out.println("Please enter your pulse (integer): ");
        int pulse = scan.nextInt();
        System.out.println(age_and_pulse_formula(age, pulse));
    }

    public static LinkedList<String> age_and_pulse_formula(int age, int pulse)
    {

        int max_pulse = 220 - age;
        double maximum_load = (int)pulse_formula(90, pulse, age, max_pulse);
        double anaerobic_zone = (int)pulse_formula(80, pulse, age, max_pulse);
        double aerobic_zone = (int)pulse_formula(70, pulse, age, max_pulse);
        double spirometric_zone = (int)pulse_formula(60, pulse, age, max_pulse);
        double light_activity_zone = (int)pulse_formula(50, pulse, age, max_pulse);

        LinkedList<String> all_values = new LinkedList<>();

        String max_pulse_string = "Your max pulse = " + max_pulse;
        String maximum_load_string = "Your maximum load = " + maximum_load + " - " + max_pulse;
        String anaerobic_zone_string = "Your anaerobic zone = " + anaerobic_zone + " - " + maximum_load;
        String aerobic_zone_string = "Your aerobic zone = " + aerobic_zone + " - " + anaerobic_zone;
        String spirometric_zone_string = "Your spirometric zone = " + spirometric_zone + " - " + aerobic_zone;
        String light_activity_zone_string = "Your light activity zone = " + light_activity_zone + " - " + spirometric_zone;
        String pulse_string = "Your rest pulse = " + pulse;

        all_values.add(max_pulse_string);
        all_values.add(maximum_load_string);
        all_values.add(anaerobic_zone_string);
        all_values.add(aerobic_zone_string);
        all_values.add(spirometric_zone_string);
        all_values.add(light_activity_zone_string);
        all_values.add(pulse_string);

        return all_values;
    }

    private static double pulse_formula(int percent, int pulse, int age, int max_pulse)
    {
        double chss = ((max_pulse - pulse)*(percent*0.01)) + pulse;
        return chss;
    }
}
