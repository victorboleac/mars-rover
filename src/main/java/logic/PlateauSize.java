package logic;
// singleton design pattern
public class PlateauSize {


    private static int height;
    private static int width;
    private static PlateauSize instance;

    private PlateauSize(int width, int height) {
        if(height<=0||width<=0)  throw new IllegalArgumentException("Height and Width must be positive");

        PlateauSize.height = height;
        PlateauSize.width = width;
    }
    public static PlateauSize getInstance( int width, int height){
        if (instance==null){
            instance = new PlateauSize(width,height);
        }
        return instance;
    }
    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

}
