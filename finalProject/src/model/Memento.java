package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Memento {

	//private int sortBy;
	private TreeMap<String, Product> treemap;
	private LinkedHashMap<String, Product> linkedMap;
//	private final String FILE_NAME = "products.txt";
//	private OutputStream outputStream;
//	private ObjectOutputStream oos;
//	private FileInputStream inputStream;
//	private ObjectInputStream ois;
	
	
	public Memento(TreeMap<String, Product> treemap) {
		this.treemap = treemap;
	}

	public Memento(LinkedHashMap<String, Product> linkedMap) {
		this.linkedMap = linkedMap;
	}
	
	
	public TreeMap<String, Product> getTreeMap(){
		return treemap;
	}
	
	public LinkedHashMap<String, Product> getLinked(){
		return linkedMap;
	}
	

}
