package eecs2030.lab4;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to implement LZW compression (encoding) and decompression (decoding) of 
 * a given input string.
 * 
 * 
 * <p>
 * The LZWCompressor maintains a list of characters representing an input sequence to be 
 * encoded/decoded. It also maintains a local LZWDictionary, which is initialized with unique
 * characters from the input sequence, and is used to encode/decode the input sequence.
 * <p>
 * 
 * <p>
 * Class invariant: The LZWDictionary always holds only the initial single character 
 * patterns as its entries (i.e. it may grow during encode/decode operations, however must
 * be reset to its initial state after an encode/deco          de operation).
 * </p> 
 * 
 * 
 * @author eecs2030
 *
 */
public class LZWCompressor {

	// FIELDS
	// input sequence to be encoded
	// dictionary to use when encoding/decoding
	String input;
	public LZWDictionary d;

	/**
	 * Initialize this LZWCompressor to encode/decode a specified input string.
	 * 
	 * 
	 * <p>
	 * A list of characters is initialized from the sequence of characters specified in
	 * a provided string.  The unique characters from this string are also used to initialize
	 * an LZWDictionary maintained and used by the LZWCompressor when encoding/decoding
	 * </p>
	 * 
	 * 
	 * 
	 * @param input a string representing an input sequence of characters to be encoded/decoded
	 * 
	 * @throws an IllegalArgumentException if the input string is empty
	 * 
	 */
	public LZWCompressor(String input) {

		if (input.length()==0)
			throw new IllegalArgumentException();
		this.input = input;
		d = new LZWDictionary(this.input);

	}


	/**
	 * Returns the original input sequence to be encoded/decoded by this LZWCompressor
	 * 
	 * @return a string representing the original input sequence
	 * 
	 */
	public String getInput() {

		return this.input;

	}


	/**
	 * Returns the dictionary used by this LZWCompressor
	 * 
	 * @return a reference to the LZWDictionary used by this LZWCompressor
	 */
	public LZWDictionary getDictionary() {

		return this.d;
		
	}



	/**
	 * Generates an LZW encoding of the input sequence
	 * 
	 * 
	 * <p>
	 * Uses the LZW encoding algorithm given in the lab4 specification
	 * 
	 * @return a list of integers representing the sequence of codes (indexes of character 
	 * patterns) learned by an LZWDictionary during the encoding process
	 * 
	 */
	
	public List<Integer> encode() {
		List<Integer> encoded = new ArrayList<>();
		String w = String.valueOf(this.input.charAt(0));
		for (int i = 1; i < this.input.length(); i++) {
			String c = String.valueOf(this.input.charAt(i));
//			System.out.println(w + " " + c + " " + d.toString());
			String wc = w+c;
			if (this.d.contains(wc)) {
				w = wc;
			} else {
				encoded.add(this.d.indexOf(w));
				this.d.add(wc);
				w = c;
			}
		}
		encoded.add(this.d.indexOf(w));
		d = new LZWDictionary(this.input);
//		System.out.println(d.toString());
		return encoded;
	}







	/**
	 * Decodes an LZW encoding to generate the original input sequence
	 * 
	 * 
	 * <p>
	 * Uses the LZW decoding algorithm given in the lab4 specification
	 * 
	 * @param encoded a list of integers representing a sequence of codes (indexes 
	 * of character patterns) learned by an LZWDictionary during the encoding process
	 * 
	 * @return a string representation of the decoded input sequence
	 * 
	 * @throws an IllegalArgumentException if encoded is an empty list
	 * 
	 */
	
	public String decode(List<Integer> encoded) {
		d = new LZWDictionary(this.input);
		if (encoded.size() == 0)
			throw new IllegalArgumentException();
		
		String out = "";
		
		int prev = encoded.get(0);
		out += d.get(prev);
		String s;
		int next;
		for (int i = 1; i < encoded.size(); i++) {
			next = encoded.get(i);
			if (d.hasIndex(next)) {
				s = d.get(next);
			} else {
				s = d.get(prev);
				String c = String.valueOf(s.charAt(0));
				s += c;				
			}
			
			out += s;
			
			String entry = d.get(prev) + String.valueOf(s.charAt(0));
			this.d.add(entry);
			prev = next;
			
//			s += this.d.getList().get(i);
		}
//		System.out.println(out);
		//		System.out.println(encoded.toString());
//		System.out.println(d.getList().toString());
//		for (int i : encoded) {
//			s += this.d.getList().get(i);
//		}
		d = new LZWDictionary(this.input);
		return out;
		
	}






	/**
	 * Returns the compression ratio of an encoding
	 * 
	 * 
	 * <p> 
	 * The compression ration (CR) is defined as the number of characters in the input
	 * sequence, divided by the number of codes in the encoded version of the input sequence
	 * </p>
	 * 
	 * 
	 * @return a double representing the compression ratio
	 * 
	 */
	public double compressionRatio() {
//		System.out.println(this.input + " " +  this.encode());
		return ((double) this.input.length() / (double) this.encode().size());
		
	}




	/**
	 * Some simple test cases that can be run independently of the junit tester
	 * 
	 */
	public static void main(String[] args) {

		LZWCompressor codec = new LZWCompressor("ababababa");

//		codec = new LZWCompressor("#@$*@#($*@#$@(#*$@(#*$@#$");
//		codec = new LZWCompressor("the fat the cat the bat the rat the mat the sat the tat");
//		codec = new LZWCompressor("1231411212312312312124312413");
//		codec = new LZWCompressor("thefatthecatthebattheratthematthesatthetatthefatthecatthebattheratthematthesatthe");



		// ENCODE
		System.out.println("original input sequence: " + codec.getInput());
		List<Integer> enc = codec.encode();
		System.out.println("encoded sequence: " + enc);
		System.out.println("compression ratio: " + codec.compressionRatio());
		System.out.println("-------------------");


		// DECODE
		String dec = codec.decode(enc);
		System.out.println("decoded sequence: " + dec);
		System.out.println("successful decode = " + dec.equals(codec.getInput()));


	}
}
