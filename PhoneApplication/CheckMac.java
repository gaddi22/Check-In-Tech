import java.util.Array;
public class CheckMac {
	public static void main(String[]args)
	{
		int MacId = InetAdress.getLocalHost();
		boolean usedTwice;
		NetworkInterface.getByInetAdress(MacID);
		Array MacRoster[];//to be connected with the current MacId querrying the pc application
		for (int a=0; a<MacRoster[];a++)
		{
			if MacId!=MacRoster[a];
			{
				usedTwice=false;
			}
			else
			{
				usedTwice=true;
			}
		}
		
	}
}