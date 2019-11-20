public class WordDefinitionPair {

	private String word;
	private String definition;

	public WordDefinitionPair(String w, String d) {
		this.word = w;
		this.definition = d;
	}

	public String getWord() {
		return this.word;
	}

	public String getDefinition() {
		return this.definition;
	}

	@Override
	public String toString() {

		return this.word + " " + this.definition;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		// null check
		if (o == null)
			return false;
//	    System.out.println("Here 1");
		// type check and cast
		if (getClass() != o.getClass())
			return false;
//	    System.out.println("Here 2");
		WordDefinitionPair w = (WordDefinitionPair) o;
		// field comparison
		return this.word.equals(w.word) && this.definition.equals(w.definition);
	}

}