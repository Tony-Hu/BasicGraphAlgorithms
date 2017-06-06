package GraphSearch;

import java.util.ArrayList;
import java.util.List;

public class GraphSearch {
	private List<List<Integer>> dfsList;
	private int[] dfsParent;
	private int[] dfsCC;
	private boolean[] dfsMark;
	
	public GraphSearch(){
		dfsList = new ArrayList<List<Integer>>();
		//TODO more information of dfsList to be initialized
		initialHW10();
		int size = dfsList.size();
		dfsMark = new boolean[size];
		dfsParent = new int[size];
		dfsCC = new int[size];//connected component
	}
	public void dfsList(){
		for (int i = 0; i < dfsList.size();i++){
			if (!dfsMark[i])
			{
				dfsParent[i] = -1;
				ccdfs(i, i);
			}
		}
		int x = 0;
	}
	
	/**
	 * 
	 * @param vertex node number
	 * @param ccnum current connected component name
	 */
	private void ccdfs(int vertex, int ccnum){
		dfsMark[vertex] = true;
		dfsCC[vertex] = ccnum;
		for (int w : dfsList.get(vertex))
		{
			if (!dfsMark[w]){
				dfsParent[w] = vertex;
				ccdfs(w,ccnum);
			}
		}
	}
	
	private void initialHW10()
	{
		List<Integer> l0 = new ArrayList<Integer>();
		l0.add(2);
		l0.add(7);
		dfsList.add(l0);
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		l1.add(6);
		dfsList.add(l1);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(0);
		l2.add(3);
		l2.add(4);
		l2.add(9);
		dfsList.add(l2);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(0);
		l3.add(7);
		l3.add(9);
		dfsList.add(l3);
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(9);
		dfsList.add(l4);
		List<Integer> l5 = new ArrayList<Integer>();
		l5.add(2);
		dfsList.add(l5);
		List<Integer> l6 = new ArrayList<Integer>();
		l6.add(7);
		l6.add(8);
		dfsList.add(l6);
		List<Integer> l7 = new ArrayList<Integer>();
		dfsList.add(l7);
		List<Integer> l8 = new ArrayList<Integer>();
		l8.add(9);
		dfsList.add(l8);
		List<Integer> l9 = new ArrayList<Integer>();
		l9.add(5);
		dfsList.add(l9);
	}
}
