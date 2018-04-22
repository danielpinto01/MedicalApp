package models;

public class MyTree {

	private NodePlace rootTree;

	public MyTree(NodePlace rootTree) {
		this.rootTree = rootTree;
	}

	public void addNode(NodePlace fatherNode, NodePlace childNode) {
		fatherNode.addNode(childNode);
	}

	public void print() {
		print(rootTree, "");
	}
	
	private void print(NodePlace fatherNode, String info) {
		if (fatherNode != null) {
			System.out.println(info + fatherNode);
			for (NodePlace node : fatherNode.getNodes()) {
				print(node, info + "-");
			}
		}
	}

	public NodePlace searchNode(Place place) {
		return searchNode(place, rootTree);
	}

	private NodePlace searchNode(Place place, NodePlace nodePlace) {
		if (nodePlace != null) {
			if (nodePlace.getPlace() == place) {
				return nodePlace;
			}else {
				for (NodePlace place2 : nodePlace.getNodes()) {
					if (place2.getPlace() == place)  {
						return place2;
					}else {
						if (searchNode(place, place2) != null) {
							return searchNode(place, place2);
						}
					}
				}

			}
		}
		return null;
	}
}