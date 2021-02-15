package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Model {
	private int sortBy;
	private TreeMap<String, Product> treemap;
	private LinkedHashMap<String, Product> linkedMap;
	private final String FILE_NAME = "products.txt";
	private OutputStream outputStream;
	private ObjectOutputStream oos;
	private FileInputStream inputStream;
	private ObjectInputStream ois;
	private Memento memento;

	public Model() {
		File file = new File(FILE_NAME);
		try {
			outputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oos = new ObjectOutputStream(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ois = new ObjectInputStream(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/// reading the map from file
		// if(file.exists())
		// readMapFromFile();
	}

	public void UpdateCatalogNum(String catalog, String name, int storeCost, int customerCost, String customerName,
			String phoneNumber, boolean updates) {
		memento = getMemento();
		Customer customer = new Customer(customerName, phoneNumber, updates);
		Product product = new Product(name, storeCost, customerCost, customer);
		if (sortBy != 3) {
			if (!treemap.containsKey(catalog)) { /// no such catalog, need to create new
				treemap.put(catalog, product);
			} else {
				for (Map.Entry<String, Product> e : treemap.entrySet()) {
					if (e.getKey().compareTo(catalog) == 0) {
						e.setValue(product);
					}
				}
			}
		} else {
			if (!linkedMap.containsKey(catalog)) {
				linkedMap.put(catalog, product);
			} else {
				for (Entry<String, Product> e : linkedMap.entrySet()) {
					if (e.getKey().compareTo(catalog) == 0) {
						e.setValue(product);
					}
				}
			}

		}

		/// saving the map to file
		saveMapToFile();

	}

	public void setSort(int sort) {
		sortBy = sort;
		if (sortBy == 1) {
			treemap = new TreeMap<String, Product>(new SortByAsc());
		} else if (sortBy == 2) {
			treemap = new TreeMap<String, Product>(new SortByDesc());
		} else {
			linkedMap = new LinkedHashMap<String, Product>();
		}
	}

	private void saveMapToFile() {
		if (sortBy != 3) {
			for (Map.Entry<String, Product> e : treemap.entrySet()) {
				System.out.println(e.getKey());
				System.out.println(e.getValue().getStroreCost());
			}
		} else {
			for (Entry<String, Product> e : linkedMap.entrySet()) {
				System.out.println(e.getKey());
				System.out.println(e.getValue().getStroreCost());
			}
		}

//		if (sortBy != 3) {
//			try {
//				oos.writeObject(treemap);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			try {
//				oos.writeObject(linkedMap);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		try {
//			oos.flush();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			oos.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			outputStream.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private void readMapFromFile() {
		if (sortBy != 3) {
			try {
				treemap = (TreeMap<String, Product>) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				linkedMap = (LinkedHashMap<String, Product>) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Memento getMemento() {
		if (sortBy != 3) {
			return new Memento(treemap);
		} else {
			return new Memento(linkedMap);
		}
	}

	public void setMemento() {
		if (sortBy != 3) {
			this.treemap.clear();
			this.treemap.putAll(memento.getTreeMap());
		} else {
			this.linkedMap.clear();
			this.linkedMap.putAll(memento.getLinked());
		}
	}
}
