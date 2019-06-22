package chk;

import java.util.HashMap;

public class FruitBasket {

    public static void main(String[] args) {

        System.out.println(new FruitBasket().totalFruit(new int[]{1,2,3,2,2}));

    }

    public int totalFruit(int[] tree) {

        int maxDistinctFruitsPerBasket = 0;
        int numberOfBaskets = 2;

        int windowStart = 0;
        int windowSum = 0;
        HashMap<Integer, Integer> fruitsByCount = new HashMap<>();

        for (int i = 0; i < tree.length; i++) {

            int typeOfFruit = tree[i];
            fruitsByCount.put(typeOfFruit, fruitsByCount.getOrDefault(typeOfFruit, 0) + 1);

            if (fruitsByCount.size() > numberOfBaskets || (maxDistinctFruitsPerBasket == 0 && i == tree.length - 1)) {
                // breach
                windowSum = fruitsByCount.values().stream().mapToInt(num -> num).sum();
                maxDistinctFruitsPerBasket = Math.max(windowSum, maxDistinctFruitsPerBasket);

                int typeOfFruitAtWindowStart = tree[windowStart];
                if (fruitsByCount.get(typeOfFruit) > 1) {
                    // decrease by one
                    fruitsByCount.put(typeOfFruit, fruitsByCount.get(typeOfFruit) - 1);
                } else {
                    // remove entry
                    fruitsByCount.remove(typeOfFruitAtWindowStart);
                }

                windowStart++;
            }

        }

        System.out.println("windowStart "+windowStart);

        return maxDistinctFruitsPerBasket;
    }

}
