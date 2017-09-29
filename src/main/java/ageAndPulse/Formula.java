package ageAndPulse;

import java.util.Scanner;

public class Formula
{
    public static void age_and_pulse_formula()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your age (integer): ");
        int age = scan.nextInt();
        System.out.println("Please enter your pulse (integer): ");
        int pulse = scan.nextInt();
        // чсс=(макс - в спокої) * % + в спокої

        int max_pulse = 220 - age;
        double maximum_load = (int)pulse_formula(90, pulse, age, max_pulse);
        double anaerobic_zone = (int)pulse_formula(80, pulse, age, max_pulse);
        double aerobic_zone = (int)pulse_formula(70, pulse, age, max_pulse);
        double spirometric_zone = (int)pulse_formula(60, pulse, age, max_pulse);
        double light_activity_zone = (int)pulse_formula(50, pulse, age, max_pulse);

        System.out.println("Your max pulse = " + max_pulse);
        System.out.println("Your maximum load = " + maximum_load + " - " + max_pulse);
        System.out.println("Your anaerobic zone = " + anaerobic_zone + " - " + maximum_load);
        System.out.println("Your aerobic zone = " + aerobic_zone + " - " + anaerobic_zone);
        System.out.println("Your spirometric zone = " + spirometric_zone + " - " + aerobic_zone);
        System.out.println("Your light activity zone = " + light_activity_zone + " - " + spirometric_zone);
        System.out.println("Your rest pulse = " + pulse);
    }

    private static double pulse_formula(int percent, int pulse, int age, int max_pulse)
    {
        double chss = ((max_pulse - pulse)*(percent*0.01)) + pulse;
        return chss;
    }
}
