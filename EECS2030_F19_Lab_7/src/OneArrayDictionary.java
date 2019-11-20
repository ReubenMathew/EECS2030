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

	public OneArrayDictionary() {
		dict = new WordDefinitionPair[MAX_CAPACITY];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.count == 0 ? true : false;
	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {

		for (WordDefinitionPair w : getEntries()) {
			if (w.getWord().equals(word)) {
				return w.getDefinition();
			}
		}

		throw new WordNotInDictionaryException(word);
	}

	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		if (count == 100)
			throw new DictionaryFullException(word);
		for (String w : getWords()) {
			if (w.equals(word)) {
				throw new WordAlreadyExistsInDictionaryException(word);
			}
		}
		dict[count] = new WordDefinitionPair(word, definition);
//			System.out.println(dict[count].toString());
		count++;
	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		for (WordDefinitionPair w : getEntries()) {
			if (w.getWord().equals(word)) {
				String ret = w.getDefinition();
				int offset = 0;
				for (int i = 0; i < dict.length - 1; i++) {
					try {
						if (dict[i].getWord().equals(word)) {
							offset++;
						}
						dict[i] = dict[i + offset];
					} catch (NullPointerException e) {

					}
				}
				count--;
				return ret;
			}
		}

		throw new WordNotInDictionaryException(word);
	}

	@Override
	public String[] getWords() {
		String[] n = new String[count];
		if (count == 0) {
			return n;
		}
		for (int i = 0; i < count; i++)
			n[i] = dict[i].getWord();
		return n;
	}

	@Override
	public String[] getDefinitions() {
		String[] n = new String[count];
		if (count == 0) {
			return n;
		}
		for (int i = 0; i < count; i++)
			n[i] = dict[i].getDefinition();

		return n;
	}

	@Override
	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] n = new WordDefinitionPair[count];
		if (count == 0) {
			return n;
		}
		for (int i = 0; i < count; i++)
			n[i] = dict[i];

		return n;
	}

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
}
