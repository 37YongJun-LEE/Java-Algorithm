import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N은 문자 종류 개수 제한.
        String str = br.readLine();

        // 슬라이딩 윈도우를 이용한 조건을 기반한 최대 문자 길이 구하기

        int start = 0;
        int end; // 시작 문자열.

        int wordCount = 0;
        int maxAnswer = 0;

        int[] alphaArr = new int[26];

        for (end = 0 ; end < str.length(); end++) {
            if (alphaArr[str.charAt(end) - 'a'] == 0) { // 처음 사용하는 문자종류라면
                wordCount++;  // 사용한 문자 종류 증가.
            }
            alphaArr[str.charAt(end) - 'a']++;

            while ( N < wordCount && start < end) { // 이때, wordCount가 N보다 크면, 이제는 늘리기 그만하고 앞에서 줄여줘야해.
                alphaArr[str.charAt(start) - 'a']--; // 개수 줄이기.
                if (alphaArr[str.charAt(start) - 'a'] == 0) { // 이때 start 위치의 사용 개수가 0이라면, 문자 종류가 줄어든것.
                    wordCount--;
                }
                start++; //  start를 뒤로 당기기 시작.
            }
            maxAnswer = Math.max(maxAnswer, end - start + 1);
        }
        System.out.println(maxAnswer);

    }
}
