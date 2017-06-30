//PART 2

package com.br.idwall.desafiostring;

public class PrincipalPartTwo {

    public static String separator = System.getProperty("line.separator");
	public static int characterPerLine = 40;

	public static void main(String[] args) {

		String originalText = "In the beginning God created the heavens" + " and the earth. Now the earth was"
				+ " formless and empty, darkness was over" + " the surface of the deep, and the Spirit"
				+ " of God was hovering over the waters." + " And God said, Let there be light, and"
				+ " there was light. God saw that the light" + " was good, and he separated the light"
				+ " from the darkness. God called the light" + " day, and the darkness he called"
				+ " night. And there was evening, and" + " there was morning - the first day.";

		formatText(originalText);
	}

	private static void formatText(String text) {

		int end = characterPerLine;
		int spacesPerWord = 0;
		int overSpace = 0;
		String[] words;

		while (end < text.length()) {

			end = text.lastIndexOf(" ", characterPerLine);
			words = text.substring(0, end).split(" ");
			spacesPerWord = (characterPerLine - end) / words.length;
			overSpace = characterPerLine - end + (spacesPerWord * words.length);

			for (String word : words) {
				System.out.print(word + " ");
				System.out.print((spacesPerWord-- > 0) ? " " : "");
				System.out.print((overSpace-- > 0) ? " " : "");
			}
			System.out.print(separator);
			text = text.substring(end + 1);

		}
		System.out.println(text);
	}

}
