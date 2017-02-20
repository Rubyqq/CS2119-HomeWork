package Mengyi_HW3;

public class Test {
	public static void main(String [] args){
		int a = 5;
		for(int i=0; i<10; i++){
			if(a == i){
				return;
			}
			/*else{
				System.out.print(i);
			}*/
			a++;
		}
		System.out.print(a);
	}

}
