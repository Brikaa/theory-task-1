import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  // Match substrings beginning with zero or more a's and ending with a `b`
  // Match floating point numbers
  // Match strings starting with "The" and ending with "Spain"
  // Match HTML headers
  // Create test cases that output "Found X in Y: [(x1, y1), (x2, y2), ...]" or
  // "Did not find X in Y"
  // Where X is the needle, Y is the haystack, xi is the starting index of the ith
  // match, yi is the ending index of the
  // ith match
  // https://emkc.org/s/00RSKN

  private static void printMatchingSubstrings(String haystack, Pattern pattern) {
    Matcher m = pattern.matcher(haystack);
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    while (m.find()) {
      if (!first) {
        sb.append(", ");
      }
      first = false;
      sb.append(haystack.substring(m.start(), m.end()));
    }
    System.out.println("Matching substrings of \"" + pattern + "\" in \"" + haystack + "\": " + sb.toString());
  }

  public static void main(String[] args) {
    Pattern endsWithB = Pattern.compile("a*b");
    printMatchingSubstrings("aaaabaaaacaaaabbc", endsWithB);
    Pattern floatingPoint = Pattern.compile("[+-]?\\d+\\.+\\d+");
    printMatchingSubstrings("1.2 1.3 -1.2 +1.3 3.4.5 3.a", floatingPoint);
    Pattern theSpain = Pattern.compile("^The.*Spain$");
    printMatchingSubstrings("The weather is good in Spain", theSpain);
    printMatchingSubstrings("the weather is good in Spain", theSpain);
    printMatchingSubstrings("TheSpain", theSpain);
    printMatchingSubstrings("The Spain", theSpain);
    printMatchingSubstrings("He said: \"The weather is good in Spain\"", theSpain);
    printMatchingSubstrings("He said The weather was good in Spain", theSpain);
    Pattern htmlHeaders = Pattern.compile("<[hH][1-6]>.*</[hH][1-6]>");
    printMatchingSubstrings("<H1>Hello World</h1> <h2>this is a valid header</h2> <h7>this is an invalid header</h7>",
        htmlHeaders);
  }
}
