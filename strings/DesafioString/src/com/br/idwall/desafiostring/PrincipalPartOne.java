//PART 1

package com.br.idwall.desafiostring;

public class PrincipalPartOne {

	public static String separator = System.getProperty("line.separator");
	public static int characterPerLine = 40;

	public static void main(String[] args) {

		String originalText = "In the beginning God created the heavens" + " and the earth. Now the earth was"
				+ " formless and empty, darkness was over" + " the surface of the deep, and the Spirit"
				+ " of God was hovering over the waters." + " And God said, Let there be light, and"
				+ " there was light. God saw that the light" + " was good, and he separated the light"
				+ " from the darkness. God called the light" + " day, and the darkness he called"
				+ " night. And there was evening, and" + " there was morning - the first day.";

		String[] wordArray = originalText.trim().split(" ");

		formatText(characterPerLine, wordArray);

	}

	private static void formatText(int characterPerLine, String[] wordArray) {
		StringBuilder builder = new StringBuilder(characterPerLine);
		for (int i = 0; i < wordArray.length; i++) {

			String word = wordArray[i];

			if ((builder.length() + word.length()) >= characterPerLine) {
				builder.append(separator);
				System.out.print(builder.toString());
				builder = new StringBuilder(word);
			} else {

				builder.append((builder.length() == 0 ? "" : " ") + word);
			}

		}
		System.out.println(builder.toString());
	}

}
