import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task1
{

    public static void main(String[] args)
    {

        System.out.println("Grayscale fuzzy ring pattern synthesis");

        BufferedImage image;

        int x_res, y_res;
        int x_c, y_c;
        int i, j;
        final int w = 10;

        x_res = Integer.parseInt(args[0].trim());
        y_res = Integer.parseInt(args[1].trim());

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        x_c = x_res / 2;
        y_c = y_res / 2;

        for (i = 0; i < y_res; i++) {
            for (j = 0; j < x_res; j++) {
                double d;
                int r;
                d = Math.sqrt((i - y_c)*(i - y_c) + (j - x_c)*(j - x_c));
                r =(int) (128*(Math.sin((Math.PI*d)/w)+1)); //solution
                if(r>255){
                    r=255;
                }
                Color c = new Color(r,r,r);
                image.setRGB( j, i, c.getRGB() );
            }
        }

        try
        {
            ImageIO.write(image, "BMP", new File(args[2]));
            System.out.println( "Grayscale Fuzzy Ring image created successfully");
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }
}