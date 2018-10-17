public class Variables {
    public static void main(String[] args) {

        //FavoriteNumber
        int favoriteNumber = 20;
        System.out.println("My favorite number is: " + favoriteNumber);

        //Swap
        int a = 123;
        int b = 526;
        int c = b;
        b = a;
        a = c;

        System.out.println(a);
        System.out.println(b);

        //BMI
        double massInKg = 81.2;
        double heightInM = 1.78;
        double bmi = massInKg/heightInM/heightInM;

        System.out.println("BMI: " + bmi);

        //DefineBasicInfo
        String name = "Viola Pfening";
        int age = 32;
        double height = 1.74;
        boolean married = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Married: " + married);

        //Cuboid
        double x = 12.3;
        double y = 8.6;
        double z = 4.7;

        double surface = 2*((x*y)+(x*z)+(y*z));
        double volume = x*y*z;
        System.out.println("Surface Area: " + surface);
        System.out.println("Volume: " + volume);

        //SecondsInADay

        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        int remainingSeconds = (24*60*60) - ((currentHours*60*60) + (currentMinutes*60) + currentSeconds);
        System.out.println("Remaining seconds from the day: " + remainingSeconds);


    }
}