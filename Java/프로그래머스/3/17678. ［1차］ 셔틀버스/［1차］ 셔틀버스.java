import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int aHour = 9;
        int aMin = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (String time : timetable) {
            StringTokenizer st = new StringTokenizer(time);
            int hour = Integer.parseInt(st.nextToken(":"));
            int min = Integer.parseInt(st.nextToken(":"));
            pq.offer(new int[] {hour, min});
        }

        int nowHour = 9;
        int nowMin = 0;

        for (int i = 0; i < n; i++) { // 하루 운행 횟수
            int mCnt = 0;
            int[] lastPerson = null;

            while (!pq.isEmpty()
                   && mCnt < m
                   && (nowHour * 60 + nowMin >= pq.peek()[0] * 60 + pq.peek()[1])) {
                lastPerson = pq.poll();
                mCnt++;
            }

            if (i == n - 1) { // 마지막 버스
                if (mCnt < m) {
                    aHour = nowHour;
                    aMin = nowMin;
                } else {
                    int timesum = lastPerson[0] * 60 + lastPerson[1] - 1;
                    aHour = timesum / 60;
                    aMin = timesum % 60;
                }
            }

            // 시간 증가
            nowMin += t;
            nowHour += nowMin / 60;
            nowMin %= 60;
        }

        answer = String.format("%02d:%02d", aHour, aMin);
        return answer;
    }
}
