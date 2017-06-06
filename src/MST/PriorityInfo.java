package MST;

public class PriorityInfo implements Comparable<PriorityInfo>{

	private int vertex;
	private int priority;
	
	public PriorityInfo() {
		vertex = -1;
		priority = -1;
	}
	
	public PriorityInfo(int vertex, int priority){
		this.vertex = vertex;
		this.priority = priority;
	}

	@Override
	public int compareTo(PriorityInfo o) {
		// TODO Auto-generated method stub
		return priority > o.priority ? 1 : priority == o.priority ? 0 : -1;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}


	/**
	 * Override this method to implement priority queue remove method by remove specified element.
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj instanceof PriorityInfo){
			PriorityInfo pi = (PriorityInfo)obj;
			return vertex == pi.vertex;
		}
		return false;
	}
}
