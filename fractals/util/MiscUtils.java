package fractals.util;
public class MiscUtils
{
	public static String formatTime(int millis)
	{
		StringBuffer buffer=new StringBuffer();
		int milisecs = millis%1000;
		millis/=1000;
		int secs = millis%60;
		millis/=60;
		int mins = millis%60;
		millis/=60;
		int hours = millis;
		if(hours > 0)
			buffer.append(hours+" hours ");
		if(mins > 0)
			buffer.append(mins+" minutes ");
		if(secs > 0)
			buffer.append(secs+" seconds ");
		if(milisecs > 0)
			buffer.append(milisecs+" milliseconds");
		String formattedTime = buffer.toString().trim();
		formattedTime+=".";
		return formattedTime;
	}
}