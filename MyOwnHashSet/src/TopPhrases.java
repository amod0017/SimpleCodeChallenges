import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This question is solution will only work if there are lot of duplicate
 * phrases and all can be saved in current memory in HashMap. So here I am
 * reading in small chunk of a big file and adding it in a Map.
 *
 * If HashMap is too big to be saved in memory than Multiple nodes are required
 * which will count the word frequency after loading pieces of file. To hold the
 * result we can use a common cache between different nodes, for e.g. infinispan
 * which is a distributed in-memory key/value data store.
 *
 * Overall complexity of this algorithm will be o(n). (Complexity of sorting map
 * in descending order is ignored bcz it ideally will be quite less than n.)
 *
 * @author amod0
 *
 */
public class TopPhrases {

	private static final String PIPE = "\\|";
	private static final int ONE = 1;

	private static final String COMMA = ",";

	private static final String inputFileName = "C:\\Users\\amod0\\Documents\\GitHub\\SimpleCodeChallenges\\MyOwnHashSet\\src\\lines.txt";
	private static final String outFileName = "C:\\Users\\amod0\\Documents\\GitHub\\SimpleCodeChallenges\\MyOwnHashSet\\src\\output.txt";

	/**
	 * Read chunk of large file and send it to
	 *
	 * @param inputFileName
	 * @return
	 * @throws IOException
	 */
	public static Map<String, Integer> top100k(final String inputFileName) throws IOException {

		// if one phrase repeats more than 2.1 Billion times then replace
		// Integer with Long
		Map<String, Integer> phrases = new LinkedHashMap<>();

		try (InputStream inputStream = new FileInputStream(inputFileName);
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

			// read line by line, parsing, adding to hash map and counting
			String line;
			while ((line = bufferedReader.readLine()) != null) {

				final String[] linePhrases = line.split(PIPE);

				for (final String phrase : linePhrases) {

					if (phrases.containsKey(phrase)) {
						phrases.put(phrase, phrases.get(phrase) + ONE);
					} else {
						phrases.put(phrase, ONE);
					}
				}
			}
		} catch (final IOException ex) {
			throw ex;
		}

		// Sort the collection and get the 100000 phrases.
		phrases = sortByValue(phrases);

		return phrases;
	}

	/**
	 * This method takes an input map and returns an ordered map which is sorted
	 * by values in descending order.
	 *
	 * @param map
	 * @return
	 */
	private static Map<String, Integer> sortByValue(final Map<String, Integer> map) {
		final List<Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Object>() {
			@Override
			@SuppressWarnings("unchecked")
			public int compare(final Object o1, final Object o2) {
				return -1 * ((Comparable<Integer>) ((Map.Entry<String, Integer>) (o1)).getValue())
						.compareTo(((Map.Entry<String, Integer>) (o2)).getValue());
			}
		});

		final Map<String, Integer> result = new LinkedHashMap<>();
		for (final Entry<String, Integer> entry2 : list) {
			final Map.Entry<String, Integer> entry = entry2;
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

	public static void main(final String[] args) throws Exception {

		Map<String, Integer> phrases = null;
		try {
			// get phrases in hash map
			phrases = TopPhrases.top100k(inputFileName);
		} catch (final Exception ex) {
			throw ex;
		}

		// write result to file
		try (Writer writer = Files.newBufferedWriter(Paths.get(outFileName))) {

			for (final String key : phrases.keySet()) {
				writer.write((new StringBuilder(key)).append(COMMA).append(phrases.get(key))
						.append(System.lineSeparator()).toString());
			}
		}

		System.out.println("completed");
	}
}