class FoodRatings {
    static class F {
        String name, cuisine;
        int rating;
        F(String n, String c, int r) { name = n; cuisine = c; rating = r; }
    }
    final java.util.Comparator<F> cmp = (a, b) -> {
        int t = Integer.compare(b.rating, a.rating);
        return t != 0 ? t : a.name.compareTo(b.name);
    };
    java.util.HashMap<String, F> foodMap;
    java.util.HashMap<String, java.util.TreeSet<F>> byCuisine;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length, cap = (int)(n / 0.75f) + 1;
        foodMap = new java.util.HashMap<>(cap);
        byCuisine = new java.util.HashMap<>(cap);
        for (int i = 0; i < n; i++) {
            F f = new F(foods[i], cuisines[i], ratings[i]);
            foodMap.put(f.name, f);
            byCuisine.computeIfAbsent(f.cuisine, k -> new java.util.TreeSet<>(cmp)).add(f);
        }
    }
    public void changeRating(String food, int newRating) {
        F f = foodMap.get(food);
        java.util.TreeSet<F> set = byCuisine.get(f.cuisine);
        set.remove(f);
        f.rating = newRating;
        set.add(f);
    }
    public String highestRated(String cuisine) {
        return byCuisine.get(cuisine).first().name;
    }
}
