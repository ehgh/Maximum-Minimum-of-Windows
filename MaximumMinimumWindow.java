import java.util.*;

public class MaximumMinimumWindow{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i = 0 ; i < T ; i++){
			int N = scanner.nextInt();
			int[] num = new int[N];
			for (int j = 0; j < N ; j++){
				num[j] =  scanner.nextInt();
			}
			num = maxMin(num , N);
			for (int j = 0; j < N ; j++)
				System.out.print(num[j]+ " ");
			System.out.println();
		}
		scanner.close();
	}

	private static int[] maxMin(int[] num, int N){
		int[] maxWin = new int[N];
		Stack<Integer> maxMinNum = new Stack<>();
		Stack<Integer> Temp = new Stack<>();
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < N ; i++)
			maxMinNum.push(max);
		for (int i = 0; i < N ; i++){
			int s;
			for(int j = i ; j < N; j++){
				s = maxMinNum.pop();
				Temp.push(Math.min(num[j], s));
			}
			max = Integer.MIN_VALUE;
			for(int j = i ; j < N; j++){
				s = Temp.pop();
				max = Math.max(max, s);
				maxMinNum.push(s);
			}
			maxWin[i] = max;
		}
		return maxWin;
	}

}