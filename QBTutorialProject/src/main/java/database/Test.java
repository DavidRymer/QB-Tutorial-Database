package database;

public class Test {
	
	public static int firstInt(String string) { 
		
		int i = 0;
		while (i < string.length() && !Character.isDigit(string.charAt(i))) i++;
		int j = i;
		while (j < string.length() && Character.isDigit(string.charAt(j))) j++;
		return Integer.parseInt(string.substring(i, j));
		
		
		
	}

}
