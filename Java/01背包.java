经典01背包问题

public class Demo {
		public static void main(String[] args){
			int[] arr = {5,4,4,7,6};
			int[] weight = {5,4,4,7,6};
			int m = 13;
			int n = arr.length;		
			int[][] state =new int[n+1][m+1];
			int[][] path = new int[n+1][m+1];
			for(int i = 1 ;i <state.length; i++){
				for(int j =1 ; j < state[0].length ; j++){
					if(weight[i-1] >j){
						state[i][j] =state[i-1][j];
					}else{
						if(state[i-1][j-weight[i-1]]+arr[i-1] < state[i-1][j]){
						state[i][j] = state[i-1][j];
						}else{
							state[i][j] = state[i-1][j-weight[i-1]]+arr[i-1];
							path[i][j] = 1;
						}
					}
				}
			}
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[0].length; j++) {
				System.out.print(state[i][j]+"    ");
			}
			System.out.println();
		}
		int i = state.length-1;
		int j = state[0].length-1;
		while(i >0 && j > 0){
			if (path[i][j] ==1){
				System.out.print(i+"进包");
				j -= weight[i-1];
			}
			i--;
		}
	}
}


