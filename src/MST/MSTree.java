package MST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Implements of Prim's minimum spanning tree algorithm.
 * @author warha
 *
 */
public class MSTree {
	
	private enum Status{UNSEEN, FRINGE, TREE};
	
	private List<List<PriorityInfo>> mstList;
	private Status[] status;
	private int[] parent;
	private int[] fringe_wt;
	public int compCounter;
	
	private PriorityQueue<PriorityInfo> pq;//TODO use Queue<PriorityInfo> instead?
	public MSTree() throws FileNotFoundException {
		mstList = new ArrayList<List<PriorityInfo>>();
		pq = new PriorityQueue<PriorityInfo>();
		initialFromFile();
		int size = mstList.size();
		status = new Status[size];
		Arrays.fill(status, Status.UNSEEN);
		parent = new int[size];
		fringe_wt = new int[size];
		compCounter = 0;
	}
	
	public void mst(){
		int x = 0;
		status[x] = Status.TREE;
		parent[x] = -1;
		for (int i = 0; i < mstList.size() - 1; i++){
			for (PriorityInfo pi : mstList.get(x)){
				int w = pi.getVertex();
				if (status[w] == Status.UNSEEN){
					status[w] = Status.FRINGE;
					parent[w] = x;
					fringe_wt[w] = pi.getPriority();
					pq.add(pi);
				}
				//else if ((status[w] == Status.FRINGE) && (pi.getPriority() < fringe_wt[w])){
				else if ((status[w] == Status.FRINGE)){
					compCounter++;
					if (pi.getPriority() >= fringe_wt[w])
					 	break;
					pq.remove(new PriorityInfo(w, fringe_wt[w]));
					parent[w] = x;
					fringe_wt[w] = pi.getPriority();
					pq.add(new PriorityInfo(w, fringe_wt[w]));
				}
			}
			if (pq.isEmpty())
				return;
			x = pq.remove().getVertex();
			status[x] = Status.TREE;
		}
		int y = 0;
	}
	

	private void initialFromFile() throws FileNotFoundException{
		String path = "hw13.txt";
		Scanner sc = new Scanner(new File(path));
		//int v = Integer.parseInt(sc.nextLine());
		while(sc.hasNextLine())
		{
			String str = sc.nextLine();
			String split[] = str.split("\\s+");
			List<PriorityInfo> list = new ArrayList<PriorityInfo>();
			for (int i = 0; i < split.length;){
				PriorityInfo pi = new PriorityInfo(Integer.parseInt(split[i++]),Integer.parseInt(split[i++]));
				list.add(pi);
			}
			mstList.add(list);
		}
	}

}