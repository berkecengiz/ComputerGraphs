import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task6
{

    public static void main(String[] args)
    {

        System.out.println("Mixing two images");

        final int w = 10;

        String filename1 = args[0];
        String filename2 = args[1];
        BufferedImage file1 = null;
        BufferedImage file2 = null;

        try
        {
            file1 = ImageIO.read(new File(filename1));
            file2 = ImageIO.read(new File(filename2));
        } catch(IOException e) {
            System.out.println("Error: Images could not be opened.");
            System.exit(1);
        }

        int x_res = file1.getWidth();
        int y_res = file1.getHeight();
        int x_c = x_res/2;
        int y_c = y_res/2;

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                double d = Math.sqrt((i - y_c)*(i - y_c) + (j - x_c)*(j - x_c));
                int r = (int)d / w;
                if (r % 2  == 0) {
                    file1.setRGB(j, i, file2.getRGB(j, i));
                }
            }
        }

        try
        {
            ImageIO.write(file1, "BMP", new File(args[2]));
            System.out.println( "Two image mixed successfully");

        } catch (IOException e) {
            System.out.println("This image couldn't be mixed.");
        }
    }
}