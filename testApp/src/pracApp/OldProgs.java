package pracApp;

public class OldProgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int counter = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<=i; j++){
				System.out.print(++counter);
			}
			System.out.print("\n");
		}
		++counter;
		//System.out.print(counter-n);
		for(int i=0; i<n; i++){
			int count=0;
			for (int j= 0 ; j< n-i; j++){
				count = counter--;
				
				System.out.print(count +".");
				System.out.print(count + j);
			}
			count = count - (n-i);
			System.out.print("\n");
		}
	}

}
