import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Demo0 {

    public static void main(String[] args) {

        System.out.println("Ring pattern synthesis");

        BufferedImage image;

        int x_res, y_res; // Image resolution
        int x_c, y_c;   // Ring center coordinate
        int black, white;
        int i, j;
        final int w = 10;

        x_res = Integer.parseInt(args[0].trim());
        y_res = Integer.parseInt(args[1].trim());

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        white = int2RGB(255, 255, 255);
        black = int2RGB(0, 0, 0);
        x_c = x_res / 2;
        y_c = y_res / 2;

        // Process the image, pixel by pixel
        for (i = 0; i < y_res; i++) {
            for (j = 0; j < x_res; j++) {
                double d;
                int r;
                // Calculate distance to the image center
                d = Math.sqrt((i - y_c)*(i - y_c) + (j - x_c)*(j - x_c));
                // Find the ring index
                r = (int)d / w;
                if (r % 2  == 0) { // decision
                    image.setRGB(j, i, black);
                }
                else {
                    image.setRGB(j, i, white);
                }
            }
        }

        try
        {
            ImageIO.write(image, "BMP", new File(args[2]));
            System.out.println( "Ring image created successfully");
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }

    static int int2RGB(int red, int green, int blue)
    {
        red = red & 0x000000FF;
        green = green & 0x000000FF;
        blue = blue & 0x000000FF;

        return (red << 16) + (green << 8) + blue;
    }
}