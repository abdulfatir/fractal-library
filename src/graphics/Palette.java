package fractals.graphics;
import java.awt.Color;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList; 
public class Palette
{
	private Color[] colors;
	private int steps;
	private int[] color_array;
	public Palette(Color ... colors)
	{
		this.colors = colors;
		this.steps = 256;
		color_array = toArray(this.steps,this.colors);
	}
	public Palette(int steps,Color ... colors)
	{
		this.colors = colors;
		this.steps = steps;
		color_array = toArray(this.steps,this.colors);
	}
	public int getColorAtIndex(int index)
	{
		return color_array[index];
	}
	public int[] toArray()
	{
		return color_array;
	}
	public int getPaletteLength()
	{
		return this.steps;
	}
	public static Palette paletteFromFile(String path,int steps)
	{
		Palette out = null;
		try
		{
			File file=new File(path);
			FileReader freader = new FileReader(file);
			BufferedReader breader = new BufferedReader(freader);
			String line = "";
			ArrayList<Color> _colorlist_ = new ArrayList<Color>();
			while((line = breader.readLine())!=null)
			{
				line = line.trim();
				if(line.length()>0)
				{
					String[] c = line.split(",");
					_colorlist_.add(new Color(Integer.parseInt(c[0]),Integer.parseInt(c[1]),Integer.parseInt(c[2])));
				}
			}
			Color[] _colors_ = null;
			_colors_=(Color[])_colorlist_.toArray(new Color[_colorlist_.size()]);
			breader.close();
			freader.close();
			out= new Palette(steps,_colors_);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return out;
	}
	public boolean writePaletteToFile(String path)
	{
		boolean done = true;
		if(path.length() == 0)
			path = "palette.palette";
		if(!path.endsWith(".palette"))
			path += ".palette";
		try
		{
			File file = new File(path);
			FileWriter fwriter = new FileWriter(file);
			PrintWriter pwriter = new PrintWriter(fwriter);
			for(Color color : colors)
			{
				pwriter.println(color.getRed()+","+color.getGreen()+","+color.getBlue());
			}
			pwriter.flush();
			pwriter.close();
			fwriter.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			done = false;
		}
		return done;
	}
	public static int[] toArray(int steps, Color ... colors)
    {
        int palette[] = new int[steps];
        if (colors.length == 1)
        {
            Arrays.fill(palette, colors[0].getRGB());
            return palette;
        }
        double colorDelta = 1.0 / (colors.length - 1);
        for (int i=0; i<steps; i++)
        {
            double globalRel = (double)i / (steps - 1);
            int index0 = (int)(globalRel / colorDelta);
            int index1 = Math.min(colors.length-1, index0 + 1);
            double localRel = (globalRel - index0 * colorDelta) / colorDelta;

            Color c0 = colors[index0];
            int r0 = c0.getRed();
            int g0 = c0.getGreen();
            int b0 = c0.getBlue();
            int a0 = c0.getAlpha();

            Color c1 = colors[index1];
            int r1 = c1.getRed();
            int g1 = c1.getGreen();
            int b1 = c1.getBlue();
            int a1 = c1.getAlpha();

            int dr = r1-r0;
            int dg = g1-g0;
            int db = b1-b0;
            int da = a1-a0;

            int r = (int)(r0 + localRel * dr);
            int g = (int)(g0 + localRel * dg);
            int b = (int)(b0 + localRel * db);
            int a = (int)(a0 + localRel * da);
            int rgb = 
                (a << 24) |
                (r << 16) |
                (g <<  8) |
                (b <<  0);
            palette[i] = rgb;
        }
        return palette;
	}    
}