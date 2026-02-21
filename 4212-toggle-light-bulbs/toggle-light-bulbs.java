class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] isOn = new boolean[101];
        for (int b : bulbs) {
            isOn[b] = !isOn[b];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (isOn[i]) {
                result.add(i);
            }
        }
        return result;
    }
}