package MST;

import java.io.FileNotFoundException;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//PriorityInfo pi1 = new PriorityInfo(3, 3);
		//PriorityInfo pi2 = new PriorityInfo(3, 3);
		//System.out.println(pi1.equals(pi2));
		MSTree mst = new MSTree();
		mst.mst();
		System.out.println(mst.compCounter);
	}

}
