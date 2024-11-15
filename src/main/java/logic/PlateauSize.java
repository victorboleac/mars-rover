package logic;
// singleton design pattern
public class PlateauSize {


    private static int x;
    private static int y;
    private static PlateauSize instance;

    private PlateauSize(int x, int y) {
        if(x<=0||y<=0)  throw new IllegalArgumentException("Height and Width must be positive");

        PlateauSize.y = y;
        PlateauSize.x = x;
    }
    public static PlateauSize getInstance( int x, int y){
        if (instance==null){
            instance = new PlateauSize(x,y);
        }
        return instance;
    }

    public static boolean isInsideTheGrid(int x, int y){
        return x >= 0 && x <= PlateauSize.x && y >= 0 && y <= PlateauSize.y;
    }
    public static int getHeight() {
        return y;
    }

    public static int getWidth() {
        return x;
    }

}
