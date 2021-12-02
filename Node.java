
public class Node<T> {
 T data;
 Node<T> next;
 
 Node(T dataPortion){
	 data = dataPortion;
	 next = null;
 }
 Node(T dataPortion, Node<T> linkPortion){
	 data = dataPortion;
	 next = linkPortion;
 }
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
public Node<T> getNext() {
	return next;
}
public void setNextNode(Node<T> next) {
	this.next = next;
}
public Node<T> getNextNode(T givennode) {
	
	return null;
}
 
}
