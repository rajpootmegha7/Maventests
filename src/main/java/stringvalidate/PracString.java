package stringvalidate;

public class PracString {

	public static void main(String[] args) {
		PracString ps = new PracString();
		String sh = "javas";
		ps.reverseString(sh);
		ps.reverse2("Megha");
		ps.reverse3("Megha");
	}

	private void reverseString(String sh) {
		char[] car = sh.toCharArray();
		char[] car1 = new char[car.length];
		int count = 0;
		for(int i =car.length-1; i>=0; i--) {
			car1[count] = car[i];
			count++;
		}
		String str = String.valueOf(car1);
		System.out.println(str);
		System.out.println(str.length());
	}
	
	private void reverse2(String str) {  //Megha
		char[] ch = str.toCharArray();
		char temp = 'a';
		int l = ch.length-1; //5
		for(int i=0;i<(l)/2;i++) {
	
			temp = ch[i];   //M
			ch[i] = ch[l-i];
			ch[l-i] = temp;
			
		}
		System.out.println(ch);
	}
	
	private void reverse3(String str) {  //Megha
		char[] ch = str.toCharArray();
		char temp = 'a';
		int l = ch.length-1; //5
		for(int i=0,j=l;j>l/2&&i<(l)/2;j--,i++) {
	
			temp = ch[i];   //M
			ch[i] = ch[j];
			ch[j] = temp;
			
		}
		System.out.println(ch);
	}
	
	private void palendromeString(String str) {
		char[] ch = str.toCharArray();
		char temp = 'a';
		int l = ch.length-1; //5
		for(int i=0,j=l;j>l/2&&i<(l)/2;j--,i++) {
	
			temp = ch[i];   //M
			ch[i] = ch[j];
			ch[j] = temp;
			
		}
		
		System.out.println(ch);
	}

}
