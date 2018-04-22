package models;

import java.util.ArrayList;

public class NodePlace {

	private Place place;
	private ArrayList<NodePlace> nodes;
	
	public NodePlace(Place place) {
		this.place = place;
		nodes = new ArrayList<>();
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public ArrayList<NodePlace> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<NodePlace> nodes) {
		this.nodes = nodes;
	}
	
	public void addNode(NodePlace nodePlace) {
		nodes.add(nodePlace);
	}

	@Override
	public String toString() {
		return "NodePlace [place=" + place + ", nodes=" + nodes + "]";
	}
}