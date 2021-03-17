import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task2
{

    public static void main(String[] args)
    {

        System.out.println("Grid pattern synthesis");

        BufferedImage image;

        final int x_res = Integer.parseInt(args[0].trim());
        final int y_res = Integer.parseInt(args[1].trim());
        final int w = Integer.parseInt(args[2].trim());
        final int x_c = Integer.parseInt(args[3].trim());
        final int y_c = Integer.parseInt(args[4].trim());


        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                Color c = new Color(0,0,0);
                if (j % x_c < (x_c - w)/2 || j % x_c > (x_c - w)/2 + w) {
                    if (i % y_c < (y_c - w)/2 || i % y_c > (y_c - w)/2 + w) {
                        c = new Color(255,255,255);
                    }
                }
                image.setRGB(j, i, c.getRGB());
            }
        }

        try
        {
            ImageIO.write(image, "BMP", new File(args[5]));
            System.out.println( "Grid image created successfully");
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }
}