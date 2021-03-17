import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task3
{

    public static void main(String[] args)
    {

        System.out.println("Chessboard pattern synthesis");

        BufferedImage image;

        final int x_res = Integer.parseInt(args[0].trim());
        final int y_res = Integer.parseInt(args[1].trim());
        final int w = Integer.parseInt(args[2].trim());

        final Color c1 = new Color(Integer.parseInt(args[3]),Integer.parseInt(args[3]),Integer.parseInt(args[3]));
        final Color c2 = new Color(Integer.parseInt(args[4]),Integer.parseInt(args[4]),Integer.parseInt(args[4]));

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                if (j % (2*w) < w) {
                    if (i % (2*w) < w) {
                        image.setRGB(j,i,c1.getRGB());
                    }
                    else {
                        image.setRGB(j,i,c2.getRGB());
                    }
                }
                else {
                    if (i % (2*w) >= w) {
                        image.setRGB(j,i,c1.getRGB());
                    }
                    else {
                        image.setRGB(j,i,c2.getRGB());
                    }
                }
            }
        }

        try
        {
            ImageIO.write(image, "BMP", new File(args[5]));
            System.out.println( "Chessboard image created successfully");

        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }
}