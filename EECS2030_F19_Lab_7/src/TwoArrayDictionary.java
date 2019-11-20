/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {

	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary

	String[] words;
	String[] definitions;
	WordDefinitionPair[] wd;

	public TwoArrayDictionary() {
		words = new String[100];
		definitions = new String[100];
		wd = new WordDefinitionPair[100];

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0 ? true : false;
	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		String[] w = getWords();
		for (int i = 0; i < count; i++) {
			if (w[i].equals(word))
				return getDefinitions()[i];
		}
		throw new WordNotInDictionaryException(word);
	}

	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		for (String w : getWords())
			if (w == word)
				throw new WordAlreadyExistsInDictionaryException(word);

		if (this.count == this.MAX_CAPACITY) {
			throw new DictionaryFullException(word + " " + definition);
		}
		this.words[count] = word;
		this.definitions[count] = definition;
		this.wd[count] = new WordDefinitionPair(word, definition);
		this.count++;

	}

	private static void pop(String[] array, String pop) {
		int offset = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == pop) {
				offset++;
			}
			array[i] = array[i + offset];
		}
	}

	private static void pairPop(WordDefinitionPair[] array, String pop) {
		int offset = 0;
		for (int i = 0; i < array.length - 1; i++) {
			try {
				if (array[i].getWord().equals(pop)) {
					offset++;
				}
				array[i] = array[i + offset];
			} catch (NullPointerException e) {

			}
		}
	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		for (int i = 0; i < count; i++)
			if (words[i] == word) {
				String def = definitions[i];
				pop(words, word);
				pop(definitions, def);
				pairPop(wd, word);
//				System.out.println(Arrays.toString(getDefinitions()));
				this.count--;
				return def;
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
			n[i] = words[i];
		return n;
	}

	@Override
	public String[] getDefinitions() {
		String[] n = new String[count];
		if (count == 0) {
			return n;
		}
		for (int i = 0; i < count; i++)
			n[i] = definitions[i];

		return n;
	}

	@Override
	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] n = new WordDefinitionPair[count];
		if (count == 0) {
			return n;
		}
		for (int i = 0; i < count; i++)
			n[i] = wd[i];

		return n;

	}

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
}
