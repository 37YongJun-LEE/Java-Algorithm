class Solution {
    public long solution(int w, int h) {
        long totalArea = (long) w * h;
        long gcd = gcd(w, h);
        return totalArea - (w + h - gcd);
    }

    private long gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
