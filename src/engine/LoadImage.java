package engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadImage {

    private BufferedImage img = null;

    // https://alvinalexander.com/blog/post/java/getting-rgb-values-for-each-pixel-in-image-using-java-bufferedi
    public void printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }

    public void marchThroughImage() {
        int w = img.getWidth();
        int h = img.getHeight();
        System.out.println("width, height: " + w + ", " + h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.println("x,y: " + j + ", " + i);
                int pixel = img.getRGB(j, i);
                printPixelARGB(pixel);
                System.out.println("");
            }
        }
    }
    // *****************************************************************

    public void load(String fName){
        try {
            img = ImageIO.read(new File(fName));
            marchThroughImage();
        } catch (IOException e) {
            System.out.println("LoadImage.load: " + e);
        }
    }

    public BufferedImage getBufferedImage(){
        return img;
    }
}
