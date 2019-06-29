package typeCasting_Laila_Abbas;

public class TypeCasting {
	
	public String intToString (int numChanged)
	{
		if(numChanged == 0)
			return "0";
		int newNum = numChanged;
		int countDigits = 0;
		while(newNum != 0)
		{
			newNum = newNum /10;
			countDigits++;
		}
		char [] charArr = new char [countDigits];
		newNum = numChanged;
		int digit = 0;
		for(int i= countDigits - 1;i>-1;i--)
		{
			digit = newNum %10;
			charArr[i]= (char)('0'+digit);
			newNum /=10;
		}
		String str = String.valueOf(charArr);
		return (str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1245 ;
		TypeCasting firstTime = new TypeCasting();
		String s= firstTime.intToString(num);
		System.out.println(s);
	}

}
