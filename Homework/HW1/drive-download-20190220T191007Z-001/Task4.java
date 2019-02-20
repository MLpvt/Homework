package core;

public class Task4 {
public static void main(String[] args) {
	int a=100;
	short b=5;
	long c=134320;
	double d=12.2343;
	float e=32.4f;
	char f='#';
	boolean g=true;
	
	//сумма int и short
	int result1=a+(int)b;
	
	//разность long и double
	double result2=(double)c-d;
	
	//произведение float и double
	double result3=(double)e*d;
	
	//результат сравнения long > double
	String result4;
	if ((double)c>d)
	{
		result4="c больше d";
	}
	else {
		result4= "d больше c";
	}
	
	//результат сравнения float < int
	
	String result5;
	if (e<(float)a)
	{
		result5="e меньше a";
	}
	else {
		result5= "a меньше e";
	}
	
	//результат сравнения на равенство
	String result6;
	if ((float)c==e) {
		result6="c равно e";
	}
	else {
		result6="c не равно e";
	}
	
	//результат сравнения на неравенство
	String result7;	
	if ((float)a!=e) {
			result7="a не равно e";
			
		}
		else {
			result7="a равно e";
		}
		
		System.out.print(result1+", "+result2+", "+result3+"\n");
		System.out.println (result4+", " +result5+", "+result6+", "+result7+"\n");
		System.out.printf("%d больше %d", a,b);
		
}
}


