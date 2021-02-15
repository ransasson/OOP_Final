package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Memento {

	// private int sortBy;
	private TreeMap<String, Product> treemap;
	private LinkedHashMap<String, Product> linkedMap;
//	private final String FILE_NAME = "products.txt";
//	private OutputStream outputStream;
//	private ObjectOutputStream oos;
//	private FileInputStream inputStream;
//	private ObjectInputStream ois;

	public Memento(TreeMap<String, Product> treemap) {
		this.treemap = new TreeMap<String, Product>();
		this.treemap.putAll(treemap);

	}

	public Memento(LinkedHashMap<String, Product> linkedMap) {
		this.linkedMap = new LinkedHashMap<String, Product>();
		this.linkedMap.putAll(linkedMap);
	}

	public TreeMap<String, Product> getTreeMap() {
		return treemap;
	}

	public LinkedHashMap<String, Product> getLinked() {
		return linkedMap;
	}

}
