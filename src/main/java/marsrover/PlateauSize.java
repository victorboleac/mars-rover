package marsrover;
// singleton design pattern
public class PlateauSize {


    private int height;
    private int width;
    private static PlateauSize instance;

    private PlateauSize(int width, int height) {
        if(height<=0||width<=0)  throw new IllegalArgumentException("Height and Width must be positive");

        this.height = height;
        this.width = width;
    }
    public static PlateauSize getInstance( int width, int height){
        if (instance==null){
            instance = new PlateauSize(width,height);
        }
        return instance;
    }
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
