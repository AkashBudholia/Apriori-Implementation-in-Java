import java.util.*;
import java.sql.*;

class Tuple {
	Set<Integer> itemset;
	int support;
	
	Tuple() {
		itemset = new HashSet<>();
		support = -1;
	}
	
	Tuple(Set<Integer> s) {
		itemset = s;
		support = -1;
	}
	
	Tuple(Set<Integer> s, int i) {
		itemset = s;
		support = i;
	}
}

class Apriori {
	static Set<Tuple> c;
	static Set<Tuple> l;
	static int d[][];
	static int min_support;
	
	public static void main(String args[]) throws Exception {
		getDatabase();
		c = new HashSet<>();
		l = new HashSet<>();
		Scanner scan = new Scanner(System.in);
		int i, j, m, n;
		System.out.println("Enter the minimum support (as an integer value):");
		min_support = scan.nextInt();
		Set<Integer> candidate_set = new HashSet<>();
		for(i=0 ; i < d.length ; i++) {
			System.out.println("Transaction Number: " + (i+1) + ":");
			for(j=0 ; j < d[i].length ; j++) {
				System.out.print("Item number " + (j+1) + " = ");
				System.out.println(d[i][j]);
				candidate_set.add(d[i][j]);
			}
		}
		
		Iterator<Integer> iterator = candidate_set.iterator();
		while(iterator.hasNext()) {
			Set<Integer> s = new HashSet<>();
			s.add(iterator.next());
			Tuple t = new Tuple(s, count(s));
			c.add(t);
		}
		
		prune();
		generateFrequentItemsets();
	}
	
	static int count(Set<Integer> s) {
		int i, j, k;
		int support = 0;
		int count;
		boolean containsElement;
		for(i=0 ; i < d.length ; i++) {
			count = 0;
			Iterator<Integer> iterator = s.iterator();
			while(iterator.hasNext()) {
				int element = iterator.next();
				containsElement = false;
				
				if(!containsElement) {
					break;
				}
			}
			if(count == s.size()) {
				support++;
			}
		}
		return support;
	}
	
	static void prune() {
		l.clear();
		Iterator<Tuple> iterator = c.iterator();
		while(iterator.hasNext()) {
			Tuple t = iterator.next();
			if(t.support >= min_support) {
				l.add(t);
			}
		}
		System.out.println(" L ");
		for(Tuple t : l) {
			System.out.println(t.itemset + " : " + t.support);
		}
	}
	
	static void generateFrequentItemsets() {
		boolean toBeContinued = true;
		int element = 0;
		int size = 1;
		Set<Set> candidate_set = new HashSet<>();
		while(toBeContinued) {
			candidate_set.clear();
			c.clear();
			
						temp.add(element);
						if(temp.size() != size) {
							Integer[] int_arr = temp.toArray(new Integer[0]);
							Set<Integer> temp2 = new HashSet<>();
							for(Integer x : int_arr) {
								temp2.add(x);
							}
							candidate_set.add(temp2);
							temp.remove(element);
						}
					}
				}
			}
			
		System.out.println("\n FINAL LIST ");
		for(Tuple t : l) {
			System.out.println(t.itemset + " : " + t.support);
		}
	}
	
	static void getDatabase() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "user";
		String userName = "root";
		String password = "root";
	
	
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url+dbName, userName, password);
		Statement s=con.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM apriori;");
		Map<Integer, List <Integer>> m = new HashMap<>();
		List<Integer> temp;
		while(rs.next()) {
			int list_no = Integer.parseInt(rs.getString(1));
			int object = Integer.parseInt(rs.getString(2));
			temp = m.get(list_no);
			if(temp == null) {
				temp = new LinkedList<>();
			}
			temp.add(object);
			m.put(list_no, temp);
		}
		
		Set<Integer> keyset = m.keySet();
		
		while(iterator.hasNext()) {
			temp = m.get(iterator.next());
			Integer[] int_arr = temp.toArray(new Integer[0]);
			d[count] = new int[int_arr.length];
			for(int i=0 ; i < d[count].length ; i++) {
				d[count][i] = int_arr[i].intValue();
			}
			count++;
		}
	}
}
