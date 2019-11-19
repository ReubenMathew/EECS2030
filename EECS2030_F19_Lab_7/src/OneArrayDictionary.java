/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {
	
	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict;
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] getWords() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] getDefinitions() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public WordDefinitionPair[] getEntries() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
}
