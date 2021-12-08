import java.util.Hashtable;

public class HashMap<T extends Comparable<T>> {

	private int Size_hash_Table_hash;
	private EntryNode[] Table_hash;
	/** object From Node class */
	private int Size_now = 0;
	private int Elemant_in_Number;

	public HashMap(int Size_in_array) {
		this.Size_hash_Table_hash=Size_in_array;
		Table_hash = new EntryNode[Size_in_array];
//		for (int i = 0; i < Size_in_array; i++)
//			Table_hash[i] = null;
//		Size_hash_Table_hash = Size_in_array;
//		Size_now = 0;
	}

	public void makeEmpty() {
		/***
		 * Use if you want the array to be empty
		 */
		for (int i = 0; i < Table_hash.length; i++)// loop for Array =0
			Table_hash[i] = null;// empty Array equal NULL
		Size_now = 0;// now Array on size equal Zeroo
	}

	/** Method insize return in_size */
	public int getSize_now() {
		return Size_now;// return in_size
	}

	/** Method insize return Size_hash_Table_hash */
	public int getSize_hash_Table_hash() {
		return Size_hash_Table_hash;// return Size_hash_Table_hash
	}

	/** Return roott */
	public EntryNode[] getTable_hash() {
		return Table_hash;
	}

	/** set setTable_hash */
	public void setTable_hash(EntryNode[] table_hash) {
		Table_hash = table_hash;
	}

	/** Return roott */
	public int getElemant_in_Number() {
		return Elemant_in_Number;
	}

	/** set setElemant_in_Number */
	public void setElemant_in_Number(int elemant_in_Number) {
		Elemant_in_Number = elemant_in_Number;
	}

	/** set setSize_hash_Table_hash */
	public void setSize_hash_Table_hash(int size_hash_Table_hash) {
		Size_hash_Table_hash = size_hash_Table_hash;
	}

	/** set setSize_now */
	public void setSize_now(int size_now) {
		Size_now = size_now;
	}

	public boolean inside_the_matrix(String key_Node) {
		/**
		 * if contains not equal null
		 **/
		return get(key_Node) != null;
	}

	public String get(String keyHash_) {
		int i = 1;
		/**
		 * mapped by a particular key mentioned in the parameter. It returns NULL when
		 * the table contains no such mapping for the key.
		 */
		int your_location_in_Size = getHashTable(keyHash_);// call function indexd
		while ((Table_hash[your_location_in_Size] != null)
				&& (Table_hash[your_location_in_Size].getStatusNode() != 0)) {
			if (Table_hash[your_location_in_Size].getKeyName().equals(keyHash_))
				return Table_hash[your_location_in_Size].getvalueGender();
			your_location_in_Size = (your_location_in_Size + i * i) % Size_hash_Table_hash;
		}
		return null;
	}

	public void remove(String key) {
		/** in Method It is done until the data is deleted **/
		int i_indexs = 1;// indexs in_array
		if (!inside_the_matrix(key))// if Array_Hash equal NULL--->return ->End in Mehod
			return;// End in Mehod

		int IndexsHash = getHashTable(key);// call method in hastable
		while ((Table_hash[IndexsHash] != null) && (Table_hash[IndexsHash].getStatusNode() != 0)
				&& (!Table_hash[IndexsHash].getKeyName().equals(key)))// Seach in data -->Name and gender
			IndexsHash = (IndexsHash + i_indexs * i_indexs) % Size_hash_Table_hash;// shredding process for distribution
																					// Size

		Size_now--; // insize =insize-1
		// Table_hash[IndexsHash].getStatusNode()==2;
	}

	public String find(String nameandKey, String genderValus) {
		/** The search process for the name and gender in this Method **/
		int i_indexs = 1;
		int hashSize = getTableHashNode(nameandKey, genderValus);
		while ((((((Table_hash[hashSize] != null) && (Table_hash[hashSize].getStatusNode() != 0)
				&& (!Table_hash[hashSize].getKeyName().equals(nameandKey)))
				|| ((Table_hash[hashSize].getKeyName().equals(nameandKey)))))) && //
				((Table_hash[hashSize].getvalueGender().equals(genderValus))))// Seach in data -->Name and gender
			hashSize = ((((((getTableHashNode(nameandKey, genderValus)))) + ((i_indexs * i_indexs)))
					% Size_hash_Table_hash));// shredding process for distribution Size

		if ((Table_hash[hashSize] == null) || (Table_hash[hashSize].getStatusNode() != 0))// Seach in data -->Name and
																							// gender
			return null;// print NULL
		else
			return Table_hash[hashSize].getKeyName();// print KEYNAME
	}
//	public boolean isEmpty() {
//		Table_hash[Size_hash_Table_hash].getStatusNode()==0;
//	}

	/***
	 * insert in HashTable_Array ---->name and gender and adding in Heap_Max
	 * --->freq and yerrs in this Method
	 ***/
	public void insert2(String nameKey, String gendarvalus, Baby_frequencies f) {
		/***
		 * insert in HashTable_Array ---->name and gender and adding in Heap_Max
		 * --->freq and yerrs in this Method
		 ***/
		/**** if size in array */
		/**
		 * if number of elements larger than the (0.65) of size then do rehash method it
		 * will call the rehash method that was created
		 */
		if (Elemant_in_Number > (Size_hash_Table_hash * 0.65))// 0.65-->Large from a text to three quarters
			rehash();// Call function rehash ..... work rehash in Method

		int IndexsHash = getTableHashNode(nameKey, gendarvalus);// call function IndexsHash-- work in size

		int i_indexd = 0;
		/***
		 * if Array_Hash_table not equal zero an pointer equal one
		 **/
		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
			/**
			 * if key&&valus equal in Arguomant
			 **/

			if (Table_hash[IndexsHash].getKeyName().equals(nameKey)
					&& Table_hash[IndexsHash].getvalueGender().equals(gendarvalus))
				break;// Stop
			/**
			 * shredding process for distribution Size
			 **/
			IndexsHash = ((getTableHashNode(nameKey, gendarvalus)) + i_indexd * i_indexd) % Size_hash_Table_hash;
			i_indexd++;// indexinSize ++
		}
		/**
		 * Work in Find in key&&Valus
		 **/
		if (Table_hash[IndexsHash] == null || Table_hash[IndexsHash].getStatusNode() != 1) {
			// if key&&Valus is null in array -->insert name and gendr && baby..freq&&year
			Table_hash[IndexsHash] = new EntryNode(nameKey, gendarvalus, (byte) 1);// insert name and gendr && baby
			Table_hash[IndexsHash].getHeap().add_heap(f);// insert freq&&year
		} else {
			// if key&&Valus is not null in array -->insert name and gendr &&
			// baby..freq&&year
			Table_hash[IndexsHash].getHeap().add_heap(f);// insert freq&&year
		} // end if

	}

	
	
	
	public void inserta_name_and_gender_record(String namekey, String gendarvalus) {
		/***
		 * insert in HashTable_Array ---->name and gender
		 * 
		 * in this Method
		 ***/
		/**** if size in array */
		/**
		 * if number of elements larger than the (0.65) of size then do rehash method it
		 * will call the rehash method that was created
		 */
		if (Elemant_in_Number > (Size_hash_Table_hash * 0.65))// 0.65-->Large from a text to three quarters
			rehash();// Call function rehash ..... work rehash in Method

		int IndexsHash = getTableHashNode(namekey, gendarvalus);// call function IndexsHash-- work in size

		int i_indexd = 0;
		/***
		 * if Array_Hash_table not equal zero an pointer equal one
		 **/
		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
			/**
			 * if key&&valus equal in Arguomant
			 **/
			if (Table_hash[IndexsHash].getKeyName().equals(namekey)
					&& Table_hash[IndexsHash].getvalueGender().equals(gendarvalus))
				break;// stop
			/**
			 * shredding process for distribution Size
			 **/
			IndexsHash = ((getTableHashNode(namekey, gendarvalus)) + i_indexd * i_indexd) % Size_hash_Table_hash;
			i_indexd++;
		}
		/* Work in Find in key&&Valus */
		if (Table_hash[IndexsHash] == null || Table_hash[IndexsHash].getStatusNode() != 1) {
			Table_hash[IndexsHash] = new EntryNode(namekey, gendarvalus, (byte) 1);// insert record name and genaret
		}

	}

	public void insert_year_and_freq(String namekey, String gendarvales, Baby_frequencies f) {
		/***
		 * insert leat searhc in in heap_max_Array ---->yare and freq
		 * 
		 * in this Method
		 ***/
		/**** if size in array */
		/**
		 * if number of elements larger than the (0.65) of size then do rehash method it
		 * will call the rehash method that was created
		 */
		if (Elemant_in_Number > (Size_hash_Table_hash * 0.65))// 0.65-->Large from a text to three quarters
			rehash();// Call function rehash ..... work rehash in Method

		int IndexsHash = getTableHashNode(namekey, gendarvales);// call function IndexsHash-- work in size

		int i_indexd = 0;
		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
			/**
			 * if key&&valus equal in Arguomant
			 **/
			if (Table_hash[IndexsHash].getKeyName().equals(namekey)
					&& Table_hash[IndexsHash].getvalueGender().equals(gendarvales))
				break;// stop
			/**
			 * shredding process for distribution Size
			 **/
			IndexsHash = ((getTableHashNode(namekey, gendarvales)) + i_indexd * i_indexd) % Size_hash_Table_hash;
			i_indexd++;
		}
		/* Work in Find in key&&Valus */

		if (Table_hash[IndexsHash] != null || Table_hash[IndexsHash].getStatusNode() == 1) {
			// Table_hash[IndexsHash] = new EntryNode(namekey, gendarvales, (byte)1);
			Table_hash[IndexsHash].getHeap().add_heap(f);// leat search record -->insert freq and year record
		}
//		} else {
//			Table_hash[IndexsHash].getHeap().add(f);
//		}

	}

	public void insert(String namekey, String gendarvalue, Baby_frequencies f) {
		/***
		 * insert in HashTable_Array ---->name and gender and adding in Heap_Max
		 * --->freq and yerrs in this Method
		 ***/
		/**** if size in array */
		/**
		 * if number of elements larger than the (0.65) of size then do rehash method it
		 * will call the rehash method that was created
		 */
		if (Elemant_in_Number > (Size_hash_Table_hash / 2))// 0.65-->Large from a text to three quarters
			rehash();// Call function rehash ..... work rehash in Method

		int IndexsHash = getHashTable(namekey);// call function IndexsHash-- work in size

		int i_indexd = 0;
		/***
		 * if Array_Hash_table not equal zero an pointer equal one
		 **/
		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
			/**
			 * if key&&valus equal in Arguomant
			 **/

			if (Table_hash[IndexsHash].getKeyName().equals(namekey)
					&& Table_hash[IndexsHash].getvalueGender().equals(gendarvalue))
				break;// Stop
			/**
			 * shredding process for distribution Size
			 **/
			IndexsHash = ((getTableHashNode(namekey, gendarvalue)) + i_indexd * i_indexd) % Size_hash_Table_hash;
		}
		Size_now++;
		/**
		 * Work in Find in key&&Valus
		 **/
		if (Table_hash[IndexsHash] == null || Table_hash[IndexsHash].getStatusNode() != 1) {
			Table_hash[IndexsHash] = new EntryNode(namekey, gendarvalue, (byte) 1);
			Table_hash[IndexsHash].getHeap().add_heap(f);
		} else {
			Table_hash[IndexsHash].getHeap().add_heap(f);
		}

	}

	public String Delete_name_record(String namekey, String gendervalus) {
		/***
		 * remove record leat searhc in nameAndGender in heap_max_Array ---->yare and
		 * freq
		 * 
		 * in this Method
		 ***/
		/**** if size in array */
		/**
		 * if number of elements larger than the (0.65) of size then do rehash method it
		 * will call the rehash method that was created
		 */
		if (Elemant_in_Number > (Size_hash_Table_hash * 0.65))// 0.65-->Large from a text to three quarters
			rehash();// Call function rehash ..... work rehash in Method

		int IndexsHash = getTableHashNode(namekey, gendervalus);// call function IndexsHash-- work in size

		int i_indexd = 0;
		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
			/**
			 * if key&&valus equal in Arguomant
			 **/
			if (Table_hash[IndexsHash].getKeyName().equals(namekey)
					&& Table_hash[IndexsHash].getvalueGender().equals(gendervalus))
				break;// stop
			/**
			 * shredding process for distribution Size
			 **/
			IndexsHash = ((getTableHashNode(namekey, gendervalus)) + i_indexd * i_indexd) % Size_hash_Table_hash;
			i_indexd++;
		}
		/* Work in Find in key&&Valus and pointer equal one */
		if (Table_hash[IndexsHash] != null || Table_hash[IndexsHash].getStatusNode() == 1) {
			// Table_hash[IndexsHash] = new HashEntry(name, gendar, (byte)1);
			// Table_hash[IndexsHash].getHeap().add(f);
			Table_hash[IndexsHash].setDeleteStatusNode();
			return "Done";
		}
		return null;
	}

	public String Search_record(String namekey, String gendervalus) {

		if (Elemant_in_Number > (Size_hash_Table_hash * 0.65))// 0.65-->Large from a text to three quarters
			rehash();// Call function rehash ..... work rehash in Method

		int IndexsHash = getTableHashNode(namekey, gendervalus);// call function IndexsHash-- work in size

		int i_indexd = 0;
		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
			/**
			 * if key&&valus equal in Arguomant
			 **/
			if (Table_hash[IndexsHash].getKeyName().equals(namekey)
					&& Table_hash[IndexsHash].getvalueGender().equals(gendervalus))
				break;// stop
			/**
			 * shredding process for distribution Size
			 **/
			IndexsHash = ((getTableHashNode(namekey, gendervalus)) + i_indexd * i_indexd) % Size_hash_Table_hash;
			i_indexd++;
		}
		/* Work in Find in key&&Valus and pointer equal one */

		if (Table_hash[IndexsHash] == null || Table_hash[IndexsHash].getStatusNode() != 1) {
			/* Work in Find in key&&Valus and pointer equal one */
			// Table_hash[IndexsHash] = new HashEntry(name, gendar, (byte)1);
			// Table_hash[IndexsHash].getHeap().add(f);
			return null;
		} else {
			if (Table_hash[IndexsHash].getStatusNode() != 2)// if pointer not equal two
				return Table_hash[IndexsHash].toString();// print record in find
		}

		return null;// not equal recoed

	}

	public String Name_with_max_frequency_record(String name, String gender) {
		return gender;
//		if (Elemant_in_Number > (Size_hash_Table_hash * 0.65))
//			rehash();// rehashing -->call function
//
//		int IndexsHash = getTableHashNode(name, gender);
//
//		int i = 0;
//		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
//			if (Table_hash[IndexsHash].getKeyName().equals(name)
//					&& Table_hash[IndexsHash].getvalueGender().equals(gender))
//				break;
//			IndexsHash = ((getTableHashNode(name, gender)) + i * i) % Size_hash_Table_hash;
//			i++;
//		}
//
//		if (Table_hash[IndexsHash] != null || Table_hash[IndexsHash].getStatusNode() == 1) {
//			// Table_hash[IndexsHash] = new HashEntry(name, gendar, (byte)1);
//			// Table_hash[IndexsHash].getHeap().add(f);
//			return Table_hash[IndexsHash].getKeyName() + "," + Table_hash[IndexsHash].getvalueGender() + ","
//					+ Table_hash[IndexsHash].getHeap().printSortMax();
//		}
//		return null;
		
		
		
		
		
	}

	
	
	public boolean updateRecord(String nameKey,String gendarvalus, int sY,int sF,int newf,int newy) {
		/***
		 * insert in HashTable_Array ---->name and gender and adding in Heap_Max
		 * --->freq and yerrs in this Method
		 ***/
		/**** if size in array */
		/**
		 * if number of elements larger than the (0.65) of size then do rehash method it
		 * will call the rehash method that was created
		 */
		// function rehash ..... work rehash in Method

		int IndexsHash = getTableHashNode(nameKey, gendarvalus);// call function IndexsHash-- work in size

		int i_indexd = 0;
		/***
		 * if Array_Hash_table not equal zero an pointer equal one
		 **/
		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
			/**
			 * if key&&valus equal in Arguomant
			 **/

			if (Table_hash[IndexsHash].getKeyName().equals(nameKey)
					&& Table_hash[IndexsHash].getvalueGender().equals(gendarvalus))
				break;// Stop
			/**
			 * shredding process for distribution Size
			 **/
			IndexsHash = ((getTableHashNode(nameKey, gendarvalus)) + i_indexd * i_indexd) % Size_hash_Table_hash;
			i_indexd++;// indexinSize ++
		}
		/**
		 * Work in Find in key&&Valus
		 **/
		if (Table_hash[IndexsHash] != null || Table_hash[IndexsHash].getStatusNode() == 1) {
			//return true;
			return Table_hash[IndexsHash].getHeap().updat(new Baby_frequencies(sF, sY),newf,newy);//.getHeap().update(new Baby_frequencies(newF,newY));
			 //return true;
//			EntryNode node=null;
//			//(Baby_frequencies[]) node.getHeap();
//			Baby_frequencies[] curr=Table_hash[IndexsHash].getHeap().getgetHeap_max_Table();
//			for (int i = 1; i < curr.length; i++) {
//				if (curr[i] != null) {
//					if ((curr[i].getFreq()) == sF && curr[i].getYear() == sY) {
//						return true;
//					}
//					
//		} 
//			}
			}

		
		return false;
		
	}
	

	public String Update_a_names_year_freq(String name, String gender) {
		if (Elemant_in_Number > (Size_hash_Table_hash * 0.65))
			rehash();

		int IndexsHash = getTableHashNode(name, gender);

		int i = 0;
		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
			if (Table_hash[IndexsHash].getKeyName().equals(name)
					&& Table_hash[IndexsHash].getvalueGender().equals(gender))
				break;
			IndexsHash = ((getTableHashNode(name, gender)) + i * i) % Size_hash_Table_hash;
			i++;
		}

		if (Table_hash[IndexsHash] != null || Table_hash[IndexsHash].getStatusNode() == 1) {
			// Table_hash[IndexsHash] = new HashEntry(name, gendar, (byte)1);
			// Table_hash[IndexsHash].getHeap().add(f);

			return Table_hash[IndexsHash].getKeyName() + "," + Table_hash[IndexsHash].getvalueGender() + ","
					+ Table_hash[IndexsHash].getHeap().printSort();

		}
		return null;
	}


	private int getTableHashNode(String nameKay, String gendarValus) {
		int sumSize_ = 0;
		/**
		 * You are required to count the frequency of all the characters in this string.
		 */
		String recordString = nameKay + " " + gendarValus;// def in record
		for (int i = 0; i < recordString.length(); i++) {
			/**
			 * integer “x” with an integer “y” denoted as ‘(x<<y)’ is equivalent to
			 * multiplying x with 2^y (2 raised to power y).
			 */
			sumSize_ = (sumSize_ << 5) + recordString.charAt(i);// charAt(i) + 32^i
		}
		/**
		 * shredding process for distribution Size
		 **/
		sumSize_ %= Size_hash_Table_hash;
		/* if larg in zero indexs inArray ++ **/
		if (sumSize_ < 0) {
			sumSize_ = sumSize_ + Size_hash_Table_hash;
		}
		return sumSize_;/* print sizearray **/
	}

	public int getHashTable(String keyHash) {
		/**
		 * Here, it will take O(n) time (where n is the number of strings) to access a
		 * specific string. This shows that the IndexsHashfunction is not a good
		 * IndexsHashfunction.
		 */
		int hashValnode = 0;
		for (int i = 0; i < keyHash.length(); i++) {
			/**
			 * integer “x” with an integer “y” denoted as ‘(x<<y)’ is equivalent to
			 * multiplying x with 2^y (2 raised to power y).
			 */
			hashValnode = (2 << 5) * hashValnode + keyHash.charAt(i);
		}
		/**
		 * shredding process for distribution Size ** hashValnode %=
		 * Size_hash_Table_hash; /*if larg in zero indexs inArray ++
		 **/
		if (hashValnode < 0) {
			hashValnode += Size_hash_Table_hash;
		}
		return hashValnode;/* print sizearray **/
	}

	/***
	 * 
	 * For the first step, time taken depends on the K and the IndexsHashfunction.
	 * For example, if the key is a string “abcd”, then it’s IndexsHashfunction may
	 * depend on the length of the string. But for very large values of n, the
	 * number of entries into the map, length of the keys is almost negligible in
	 * comparison to n so IndexsHashcomputation can be considered to take place in
	 * constant time, i.e, O(1). For the second step, traversal of the list of K-V
	 * pairs present at that index needs to be done. For this, the worst case may be
	 * that all the n entries are at the same index. So, time complexity would be
	 * O(n). But, enough research has been done to make IndexsHashfunctions
	 * uniformly distribute the keys in the array so this almost never happens. So,
	 * on an average, if there are n entries and b is the size of the array there
	 * would be n/b entries on each index. This value n/b is called the load factor
	 * that represents the load that is there on our map. This Load Factor needs to
	 * be kept low, so that number of entries at one index is less and so is the
	 * complexity almost constant, i.e., O(1).
	 **/
	private void rehash() {
		HashMap newList;
		newList = new HashMap(nextPrime(2 * Table_hash.length));
		/*
		 * calling the insert function for each node in temp as the new list is now the
		 * bucketArray ---Copy Table_hash over
		 ***/
		for (int i = 0; i < Table_hash.length; i++)
			// Now size is made zero
			// and we loop through all the nodes in the original bucket list(temp)
			// and insert it into the new list
			if ((Table_hash[i] != null) && (Table_hash[i].getStatusNode() == 1)) {
				newList.insert2(Table_hash[i].getKeyName(), Table_hash[i].getvalueGender(), null);// Initialised not to
																									// null
			}
		// head of the chain at that index
		Table_hash = newList.Table_hash;
		Size_hash_Table_hash = newList.Size_hash_Table_hash;
	}

	private static int nextPrime(int NumberSize) {
		/**
		 * Internal method to find a prime number at least as large as n. number the
		 * starting number (must be positive). a prime number larger than or equal to
		 * number.
		 */
		if (NumberSize % 2 == 0)// number is Even sizeArray++
			NumberSize++;
		for (; !isPrime(NumberSize); NumberSize += 2)
			;
		return NumberSize;
	}

	private static boolean isPrime(int numberSize) {
		/**
		 * Internal method to test if a number is prime. Not an efficient algorithm.
		 */
		if (numberSize == 1 || numberSize % 2 == 0)// if size [1] or size is even is fales
			return false;// print false
		if (numberSize == 2 || numberSize == 3)// if size [2] or[3] is true
			return true;// print true
		for (int i = 3; i * i <= numberSize / 2; i += 2)
			if (numberSize % i == 0)
				return false;
		return true;
	}

	public String Max() {
		// int Max=((Baby_frequencies)Table_hash.getHeap()).getFreq();

		return null;

	}
	
	
	
	
	public EntryNode maxFrequency(){
		int max=0;
		EntryNode maxNode=null;
	for (EntryNode node:this.Table_hash) {
		if (node!=null && node.getHeap()!=null){
			Baby_frequencies baby= (Baby_frequencies) node.getHeap().getgetHeap_max_Table()[1];
			int temp= baby.getFreq();
			if (temp>max){
				max=temp;
				maxNode=node;
			}
		}
	}
		return maxNode;

	}
	
	
	

	/**
	 * int max=0; int sum_freq=0; // int min= local.getData().getFreq(); // Node mi=
	 * local.getList().getHead(); String name=""; if(local != null) { //Initializing
	 * min with head node data Node<Baby_frequencies> Currant =
	 * local.getList().getHead();
	 * 
	 * //If current node's data is smaller than max //Then, replace value of max
	 * with current node's data while(Currant != null) { //min.getData().getFreq()
	 * sum_freq +=Currant.getData().getFreq(); Currant=Currant.getNext();
	 * }if(min<sum_freq) {
	 * 
	 * min=sum_freq; mi=local;
	 * 
	 * } //sum=sum+Currant.getData().getFreq(); maxNode(local.getLeft());
	 * maxNode(local.getRight()); } return mi;
	 **/
	
	
	
	
	
	public String Update_name_yearandfreq_record(String nameKay, String gendarValus, Baby_frequencies f, int newf,
			int yers) {
		/***
		 * insert in HashTable_Array ---->name and gender and adding in Heap_Max
		 * --->freq and yerrs in this Method
		 ***/
		/**** if size in array */
		/**
		 * if number of elements larger than the (0.65) of size then do rehash method it
		 * will call the rehash method that was created
		 */
		if (Elemant_in_Number > (Size_hash_Table_hash * 0.65))// 0.65-->Large from a text to three quarters
			rehash();// Call function rehash ..... work rehash in Method

		int IndexsHash = getTableHashNode(nameKay, gendarValus);// call function IndexsHash-- work in size

		int i_indexd = 0;
		/***
		 * if Array_Hash_table not equal zero an pointer equal one
		 **/
		while (Table_hash[IndexsHash] != null && Table_hash[IndexsHash].getStatusNode() == 1) {
			/**
			 * if key&&valus equal in Arguomant
			 **/

			if (Table_hash[IndexsHash].getKeyName().equals(nameKay)
					&& Table_hash[IndexsHash].getvalueGender().equals(gendarValus))
				break;// Stop
			/**
			 * shredding process for distribution Size
			 **/
			IndexsHash = ((getTableHashNode(nameKay, gendarValus)) + i_indexd * i_indexd) % Size_hash_Table_hash;
			i_indexd++;// indexinSize ++
		}
		/**
		 * Work in Find in key&&Valus
		 **/
		if (Table_hash[IndexsHash] == null || Table_hash[IndexsHash].getStatusNode() != 1) {
			// if key&&Valus is null in array -->insert name and gendr && baby..freq&&year
			Table_hash[IndexsHash] = new EntryNode(nameKay, gendarValus, (byte) 1);// insert name and gendr && baby
			Table_hash[IndexsHash].getHeap().add_heap(f);// insert freq&&year
		} else {
			if (IndexsHash != 0) {
				MaxHeap ff = Table_hash[IndexsHash].getHeap();

			}
		} // end if
		return gendarValus;
	}

	
	
	public void Add_Year_freq(String name,String ge,Baby_frequencies baby) {
		int hash2 = getTableHashNode(name, ge);
		int i = 0;
		//  while array[hash2] not equal null do
		while (Table_hash[hash2] != null ) {
			// check if array of data equal the data -- >( taken as parameter) 
			if (Table_hash[hash2].getKeyName().equals(name) && Table_hash[hash2].getvalueGender().equals(ge))
				break; // break
			hash2 = (getTableHashNode(name, ge) + i * i) % Size_hash_Table_hash; //  do the quadratic hash method
			i++;  //  post increment  for  << i >>
		}
		// check if array[hash2] equal null  or the status not equal 1 
		if (Table_hash[hash2] != null || Table_hash[hash2].getStatusNode() == 1) {
			if(Table_hash[hash2].getStatusNode()!=2)
			Table_hash[hash2].getHeap().add_heap(baby); // update freq info
		
		}
	}
	public void printtableArray() {
		for (int i = 0; i < Table_hash.length; i++) {
			if (Table_hash[i] != null && (Table_hash[i].getStatusNode() != 2 || Table_hash[i].getStatusNode() == 1)) {
				System.out.println(Table_hash[i]);
			}
			if (Table_hash[i] == null) {
				System.out.println("Null");
			}
		}
	}

	public void printHash_tostring() {
		for (int i = 0; i < Table_hash.length; i++)
			if ((Table_hash[i] != null) && (Table_hash[i].getStatusNode() == 1))
				System.out.println(i + " , " + Table_hash[i].getKeyName() + " , " + Table_hash[i].getvalueGender());
	}
}