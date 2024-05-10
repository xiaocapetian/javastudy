package day31thread.a13waitandnotify;

public class tt {
    public static void main(String[] args) {
        Cooktt cook = new Cooktt();
        Foodiett foodie = new Foodiett();
        cook.start();
        foodie.start();
    }
}
