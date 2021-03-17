import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task4
{

    public static void main(String[] args)
    {

        System.out.println("Mixing image with grid");

        BufferedImage image;

        final int x_res = Integer.parseInt(args[0].trim());
        final int y_res = Integer.parseInt(args[1].trim());
        final int w = Integer.parseInt(args[2].trim());
        final int x_c = Integer.parseInt(args[3].trim());
        final int y_c = Integer.parseInt(args[4].trim());

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        BufferedImage img=null;
        File f=null;
        try{
            f = new File("krakow.jpg");
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                Color c = new Color(0,0,0);
                if (j % x_c < (x_c - w)/2 || j % x_c > (x_c - w)/2 + w) {
                    if (i % y_c < (y_c - w)/2 || i % y_c > (y_c - w)/2 + w) {
                        image.setRGB(j,i, img.getRGB(j,i));
                    }
                }
                image.getRGB(j, i);
            }
        }

        try
        {
            ImageIO.write(image, "BMP", new File(args[5]));
            System.out.println( "Image and grid mixed successfully");
        } catch (IOException e) {
            System.out.println("This image couldn't be grid.");
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