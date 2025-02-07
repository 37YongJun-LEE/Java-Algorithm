import java.io.*;
import java.util.*;

public class Main {

    static int Hour, Minute;
    static int[] HourArr, MinuteArr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Hour = Integer.parseInt(st.nextToken());
        Minute = Integer.parseInt(st.nextToken());

        HourArr = new int[24];
        for (int i = 0; i < 24; i++) {
            HourArr[i] = i;
        }
        MinuteArr = new int[60];
        for (int i = 0; i < 60; i++) {
            MinuteArr[i] = i;
        }

        int ago = Integer.parseInt(br.readLine());

        Hour += ago / 60;
        Minute += ago % 60;

        Hour = (Hour + (Minute / 60) ) % 24;
        Minute = Minute % 60;


        System.out.print(Hour + " " + Minute);


    }
}
