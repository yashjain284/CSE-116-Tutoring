package Lab08;

public class BigInteger {

	public String add(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		char[] num1Array = num1.toCharArray();
		char[] num2Array = num2.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		while (i >= 0 || j >= 0 || carry == 1) 
		{
			int a = 0;
			if(i>=0){
				a = num1Array[i]-'0';
				i--;
			}
			int b = 0;
			if(j>= 0){
				b= num2Array[j]-'0';
				j--;
			}
			int sum = a + b + carry;
			sb.insert(0, sum % 10);
			carry = sum / 10;
			
		}
		return sb.toString();
	}

	// Draw the diagram and explain
	// We know that multiplication of i and j should be at an array position of
	// i+j, i+j+1.
	// if it single digit number it is preceded by 0.

	public String multiply(String num1, String num2) {
		// Store the length of both the number arrays.
		int m = num1.length(), n = num2.length();

		// We create a new array to store the intermediate results.
		int[] pos = new int[m + n];

		// Traverse the results from the back of the array.
		for (int i = m - 1; i >= 0; i--) {

			for (int j = n - 1; j >= 0; j--) {

				// Multiply the integer at i and j th position
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				// We note down two positions of the product.

				// Position 1 : i+j
				// Position 2 : i+j+1
				int p1 = i + j, p2 = i + j + 1;

				// Adding the current product to the existing product stores at
				// position p2.
				int sum = mul + pos[p2];

				// We update the position as POS1 : Store the 10s digit and POS2
				// : Units digit.

				pos[p1] += sum / 10;
				pos[p2] = (sum) % 10;

				// Note that in the next iteration the current pos[p1] will be
				// pos[p2]
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int p : pos)
			if (!(sb.length() == 0 && p == 0))
				sb.append(p);
		return sb.length() == 0 ? "0" : sb.toString();
	}
	
	public static void main(String[] args){
		String num1 = "4534";
		String num2 = "6739384";
		BigInteger ob = new BigInteger();
		System.out.println("Sum = "+ob.add(num1, num2));
		System.out.println("Product = "+ob.multiply(num1, num2));
	}
}