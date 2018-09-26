package com.railwayy;

public class TrainDetails {
	
	int train_id;
	String train_name;
	String source;
	String dest;
	int cost;
	public int getTrain_id() {
		return train_id;
	}
	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "TrainDetails [train_id=" + train_id + ", train_name="
				+ train_name + ", source=" + source + ", dest=" + dest
				+ ", cost=" + cost + "]";
	}
	public TrainDetails(int train_id, String train_name, String source,
			String dest, int cost) {
		super();
		this.train_id = train_id;
		this.train_name = train_name;
		this.source = source;
		this.dest = dest;
		this.cost = cost;
	}
	
	

}
