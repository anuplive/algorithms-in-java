# Strings

Table of contents
=================
<!--ts-->
| Name                                                    |                                                                                           |                                                                               |                                                                                                               |                                                                                                                                         |                                                                   |                                                                 |                                                                       |                                               |   |
|---------------------------------------------------------|-------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------|-----------------------------------------------------------------|-----------------------------------------------------------------------|-----------------------------------------------|---|
| [Handy_Checks](Handy_Checks)                            |                                                                                           |                                                                               |                                                                                                               |                                                                                                                                         |                                                                   |                                                                 |                                                                       |                                               |   |
| [Simple Problems](#Simple-Problems)                     | [Regex Matching](#Regex-Matching)                                                         | [Fruits Basket](#Fruits-into-Baskets)                                         | [Longest Substring with maximum K Distinct Characters](#Longest-Substring-with-maximum-K-Distinct-Characters) |                                                                                                                                         |                                                                   |                                                                 |                                                                       |                                               |   |
| [Remove_Characters](#Remove_Characters)                 | [Remove Duplicates from a String](#Remove-Duplicates-from-a-String)                       | Whitespaces                                                                   |                                                                                                               |                                                                                                                                         |                                                                   |                                                                 |                                                                       |                                               |   |
| [SubSequence and Substring](#SubSequence-and-Substring) | [Dictionary Word Break Problem](#Dictionary-Word-Break-Problem)                           | [Longest Common Substring](#Longest-Common-Substring)                         | [Longest Common Subsequence](#Longest-Common-Subsequence)                                                     | [Minimum Deletions & Insertions to Transform a String Into Another](#Minimum-Deletions-&-Insertions-to-Transform-a-String-Into-Another) | [Shortest Common Super-sequence](#Shortest-Common-Super-sequence) | [Longest Repeating Subsequence](#Longest-Repeating-Subsequence) | [Edit Distance Transform s1 to s2](#Edit-Distance-Transform-s1-to-s2) | [Strings Interleaving](#Strings-Interleaving) |   |
| [Palindrome](#Palindrome)                               | [Longest Palindromic Subsequence](#Longest-Palindromic-Subsequence)                       | [Longest Palindromic Substring](#Longest-Palindromic-Substring)               | [Count of Palindromic Substrings](Count-of-Palindromic-Substrings)                                            | [Find all Palindrome Substrings](#Find-all-Palindrome-Substrings)                                                                       | [Palindromic Partitioning](#Palindromic-Partitioning)             |                                                                 |                                                                       |                                               |   |
| [String_Conversions](#String_Conversions)               | [String_To_Integer](#[String_To_Integer])                                                 | [ROMAN_to_INTEGER](#ROMAN_to_INTEGER)                                         | [INTEGER_to_ROMAN](#INTEGER_to_ROMAN)                                                                         | [INTEGER_to_BINARY](#INTEGER_to_BINARY)                                                                                                 | [BINARY_to_INTEGER](#BINARY_to_INTEGER)                           |                                                                 |                                                                       |                                               |   |
| [Permutations](#Permutations)                           | [Generate All possible Balanced Parentheses](#Generate-All-possible-Balanced-Parentheses) | [String Permutations by changing case](#String-Permutations-by-changing-case) | [Generate all the possible permutations of String](#Generate-all-the-possible-permutations-of-String)         | [String Permutations by changing case](#String-Permutations-by-changing-case)                                                           |                                                                   |                                                                 |                                                                       |                                               |   |
|                                                         |                                                                                           |                                                                               |                                                                                                               |                                                                                                                                         |                                                                   |                                                                 |                                                                       |                                               |   |




OLD 

| Label         | Link          | Links | Links | Links | Links | Links | Links |
| ------------- |:-------------:| -----:| -----:| -----:| -----:| -----:| -----:|
| [Handy Checks](#Handy_Checks) |      |     |    |    |     |     |     |
| [Remove Characters](#Remove-Characters) | |     |    |    |     |     |     |
| [Substring Use Cases](#Substring-Use-Cases) | Substrings | SubSequences  |    |    |     |     |     |
| [Palindrome](#Palindrome) | |     |    |    |     |     |     | 
| [Permutations](#Permutations) | Parenthesis  | String Combinations   |    |    |     |     |     | 
| [Sorting](#Sorting) | Char Frequency |     |    |    |     |     |     | 
<!--te-->
---
## Handy_Checks
- [Back to Top](#Table-of-contents)
```java
//[0-9] 48 - 57 , [A-Z] 65 - 90 and  [a-z] 97 - 122 
String s = "a*b*c";
s.length();
s.charAt(i);
s.indexOf('a');
s.indexOf("b*");
s.substring(start); // (start, s.length)
s.substring(start, end); // (start, end)
s.equals("something");
s.compare("something");
s.contains("someString");
s.codePointAt(index)// should be value between 0 - 65,538 valis Ascii character;
Character.isWhiteSpace("something");
Character.isLetterOrDigit('c');
List<String> sList = Arrays.asList(s.trim().split("\\s+"));
Collections.reverse(sList);
return String.join(" ", sList);

//String to Array
char[] arr = s.toCharArray();
String[] srt = s.split("\\.");
## Array to String
String s = new String (new char[]{'a', 'b'});
String result = String.join("delimiter", List<String>listOfString);
//String Builder  
StringBuilder sb = new StringBuilder();
sb.append("something");
sb.insert(int index, "String");
sb.deleteCharAt(int index)
sb.reverse();
sb.toString;
sb.length();

```

```java
if (str == null || str.length == 0 || str[0] == '\0')
          return "";
```


---

---

## Simple Problems
### Regex Matching
#### TC: O ( 2 ^ N) , MC: O ( 2^N)
- No Memoization 
- [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/Y5Rg4PkWKPW)
- [Back to Top](#Table-of-contents)
```java

public static boolean regxMatch(String s, String p) {
        return regxMatchRec(s, p);
        }
        
static boolean regxMatchRec(String text, String pattern) {
		// all of the text and the pattern has been consumed at the same time, so they match
		if (text.isEmpty() && pattern.isEmpty()) {
			return true;
		}

		// the pattern has been consumed, yet there is text left to consume, so it's a mismatch
		if (!text.isEmpty() && pattern.isEmpty()) {
			return false;
		}

		// this block deals with the asterisk wildcard in the pattern
		if (pattern.length() > 1 && pattern.charAt(1) == '*') {
			// when matching against the asterisk wildcard, we need two characters, one an actual
			// character and then the asterisk. So, we consume two characters from the pattern at
			// this point
			String remainingPattern = pattern.substring(2);
			String remainingText = text;

			for (int i = 0; i < text.length() + 1; ++i) {
				// checking the same text against the remaining pattern allows a match even if there
				// are 0 occurrences of the character present at pattern[0]
				if (regxMatchRec(remainingText, remainingPattern)) {
					return true;
				}

				if (remainingText.isEmpty()) {
					return false;
				}

				// if the current pattern character (pattern[0]) is not the dot wildcard
				// and if it is different from the current text character (remaining_text[0]),
				// report the mismatch
				if (pattern.charAt(0) != '.' && remainingText.charAt(0) != pattern.charAt(0)) {
					return false;
				}

				// current text character matched, moving on to check the next
				remainingText = remainingText.substring(1);
			}
		}

		if (text.isEmpty() || pattern.isEmpty()) {
			return false;
		}

		// # the same character appeared in the pattern and the text at the same time
		// or, the dot wildcard was encountered in the pattern, which allows us to
		// accept any character at this position in the text
		if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
			String remainingText = "";
			if (text.length() >= 2) {
				// consuming the matched character from the text
				remainingText = text.substring(1);
			}

			String remainingPattern = "";
			if (pattern.length() >= 2) {
				// consuming the matched character from the pattern
				remainingPattern = pattern.substring(1);
			}

			return regxMatchRec(remainingText, remainingPattern);
		}

		return false;
	}

	
```
---
#### TC: O (  M * N ) , MC: O (  M * N )
- witn Memoization
- [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/Y5Rg4PkWKPW)
- [Back to Top](#Table-of-contents)
```java
// Top down memoization
	// Memoization -> cache intermediate
	static HashMap<String, Boolean> cache = new HashMap<String, Boolean>();

	// marker i for text string and marker j for pattern string
	public static boolean dp(String text, String pattern, int i, int j) {
		String ijPair = String.valueOf(i) + String.valueOf(j);
		if (cache.containsKey(ijPair)) {
			return cache.get(ijPair);
		}

		// Base case 1
		// If i is out of bounds and j is out of bounds, then we have found our answer
		if (i >= text.length() && j >= pattern.length()) {
			return true;
		}

		// Base case 2
		// If i is not out of bounds but j is out of bound then return false,
		// there are some characters in text string that we haven't matched.
		if (j >= pattern.length()) {
			return false;
		}

		// The bool value of match will be True if there is a match otherwise it will be False
		Boolean match = (i < text.length() && // For match, the ith index must be less than the
												// length of the text string
				(text.charAt(i) == pattern.charAt(j) || // match between text[i] and pattern[j]
						pattern.charAt(j) == '.')); // current pattern character is the "."
													// wildcard, so any character in the text is
													// acceptable"


		// If the character present on index (j+1) in pattern string is a "*"
		if ((j + 1) < pattern.length() && pattern.charAt(j + 1) == '*') {
			// If either of them evaluates to True then we return true
			// Skipping "*" and recursively calling the dp function with the advanced indices
			Boolean bool1 = dp(text, pattern, i, j + 2);
			// use *, remember that we can only use the "*" if there is a match
			Boolean bool2 = (match && dp(text, pattern, i + 1, j));

			Boolean newBool = bool1 || bool2;
			if (cache.containsKey(ijPair)) {
				cache.replace(ijPair, newBool);
			} else {
				cache.put(ijPair, newBool);
			}
			return cache.get(ijPair);
		}

		// If we do not have a "*" character, then we are only looking for a match
		if (match) {
			if (cache.containsKey(ijPair)) {
				cache.replace(ijPair, dp(text, pattern, i + 1, j + 1));
			} else {
				cache.put(ijPair, dp(text, pattern, i + 1, j + 1));
			}
			return cache.get(ijPair);
		}

		// If there is neither a "*" nor a match, then we simply store False in cache
		if (cache.containsKey(ijPair)) {
			cache.replace(ijPair, false);
		} else {
			cache.put(ijPair, false);
		}

		return false;
	}

	public static boolean regxMatch(String text, String pattern) {
		cache.clear();
		return dp(text, pattern, 0, 0);
	}

```
### Fruits into Baskets
#### TC: O (  N) , MC: O ( N)
- Sliding Window 
- [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/NEwrOXBn9Bm)
- [Back to Top](#Table-of-contents)
```java
public static int findLength(char[] arr) {
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
      // shrink the sliding window, until we are left with '2' fruits in the frequency map
      while (fruitFrequencyMap.size() > 2) {
        fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
        if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
          fruitFrequencyMap.remove(arr[windowStart]);
        }
        windowStart++; // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
```
### Longest Substring with maximum K Distinct Characters
#### TC: O ( N) , MC: O ( N)
- Sliding Window
- [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/JQkYDWOVGky)
- [Back to Top](#Table-of-contents)
```java
public static int findLength(String str, int k) {
    if (str == null || str.length() == 0)
      throw new IllegalArgumentException();

    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    // in the following loop we'll try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
      // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
      while (charFrequencyMap.size() > k) {
        char leftChar = str.charAt(windowStart);
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++; // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
    }

    return maxLength;
  }
```

## String_Conversions
### String_To_Integer
- Main logic  Recursively call : ans=(ans*10 + c-'0'); // Main Logic
- [Leetcode](https://leetcode.com/problems/string-to-integer-atoi/discuss/1981557/JAVA-O(n)-solution-or-all-edge-cases-handled)
- [Back to Top](#Table-of-contents)
```java
public int myAtoi(String s) {
        s=s.trim();
        if(s.equals("")) return 0; // check for cases like "","      ".
        char[] charArr = s.toCharArray();
        
        int ans=0;
        boolean negflag=false;
        boolean posflag=false;
        if(charArr[0]=='-') negflag=true;
        else if(charArr[0]=='+') posflag=true;
        
        int start=(negflag||posflag)?1:0; // if 0 index has a symbol start from 1 
        while(start<charArr.length && charArr[start]=='0') start++; // remove any leading zeroes. like "00034"
        
        for(int i=start ; i<charArr.length ; i++){
            char c = charArr[i];
            
            if(Character.isDigit(c)){ // method of Character class to check digit. manually: c>='0' && c<='9'
                if(ans >  Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && c-'0' > Integer.MAX_VALUE%10)){ //condition for overflow. This condition is derived from the method of calculation of ans i.e. ans=(ans*10 + c-'0')
                    if(negflag) return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                ans=(ans*10 + c-'0'); // Main Logic 
                
            }
            else break; // check for Strings not beggining with digit. like "niecn cbc 34 cnc"
        }
         
        // System.out.println(ans);
        return negflag?-ans:ans;
    }
```

### ROMAN_to_INTEGER
- Use a HashMap, track pev and next
- [Leetcode](https://leetcode.com/problems/roman-to-integer/discuss/1969048/Java-Solution-oror-Easy-To-Understand-oror-Using-Map-If-Else-Switch)
- [Back to Top](#Table-of-contents)
```java
class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map =  Map.of( 
        'M',1000,'D',500,'C',100,'L',50,
        'X',10,'V',5,'I',1);
        
        int i = 0,j = 1, sum = 0;
        while(i < s.length()-1){
		
            int prev = map.get(s.charAt(i));
            int next = map.get(s.charAt(i+1));
			
            if(prev < next){
                sum -= prev;
            }
            else {
                sum += prev;
                
            }
            i++;
        }     
        
        sum += map.get(s.charAt(s.length()-1));
            
        return sum;
    }
}
```

### INTEGER_to_ROMAN
- [Leetcode](https://leetcode.com/problems/integer-to-roman/discuss/1968942/Simple-and-Easy-Java-Solution)
- [Back to Top](#Table-of-contents)
```java
 public String intToRoman(int num) {
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<symbols.length;i++){
            
            if(num>0){
                
                while(num>=numbers[i]){
                    num=num-numbers[i];
                    sb.append(symbols[i]);
                }
                
            }
        }
        
        return sb.toString();
    }
```
### INTEGER_to_BINARY
- Integer.toBinaryString(x); 
- s =  ( (n % 2 ) == 0 ? "0" : "1") +s; n = n / 2;
- [Back to Top](#Table-of-contents)
```java
public static string intToBinary(int n)
{
    String s = "";
    while (n > 0)
    {
        s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
        n = n / 2;
    }
    return s;
}
```
### BINARY_to_INTEGER
- int decimal=Integer.parseInt(binaryString,2);
- [Back to Top](#Table-of-contents)
```java
static int binaryToDecimal(String n)
    {
        String num = n;
        int dec_value = 0;
 
        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;
 
        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }
 
        return dec_value;
    }
```

## Remove_Characters
- if(!Character.isWhitespace(s[currIndex]))
- 
---
### Remove Duplicates from a String
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
static void removeDuplicates(char[] str){
    HashSet<Character> cSet = new HashSet<>();

    cSet.add(str[0]);
    int nextNonDuplicateIndex = 1;

    for (int currIndex = 1; currIndex < str.length -1 ; currIndex++){
      if (!cSet.contains(str[currIndex]))
            str[nextNonDuplicateIndex ++] = str[currIndex];
              
           cSet.add(str[currIndex]);  
    }

    str[nextNonDuplicateIndex] = '\0';

    }

```
---

## Palindrome
### Find all Palindrome Substrings
#### TC: O(n^2) , MC: O(1)
- take every index and expand around its center
- expansion can be (i-1, i +1) OR (i, i +1)
- [Back to Top](#Table-of-contents)
```java
public static void findPalindromesInSubString(String input, int j, int k,
			List<String> palindrome) {
		// comparing left and right side strings
		for (; j >= 0 && k < input.length(); --j, ++k) {
			// if not palindrome, skip the next iteration
			if (input.charAt(j) != input.charAt(k)) {
				break;
			}

			// storing the palindromes in result
			palindrome.add(input.substring(j, k + 1));
		}
	}

	// This function receives input string and returns the palindromes list
	public static List<String> findAllPalindromeSubstrings(String input) {
		List<String> palindrome = new ArrayList<String>();
		for (int i = 0; i < input.length(); ++i) {
			// left side comparison
			findPalindromesInSubString(input, i - 1, i + 1, palindrome);
			// right side comparison
			findPalindromesInSubString(input, i, i + 1, palindrome);
		}

		return palindrome;
	}

```
---

---
### Longest Palindromic Subsequence
#### TC: O(N^2) , MC: O(N^2)
- Notice when you call the dp
- [Back to Top](#Table-of-contents)
```java
public int findLPSLength(String st) {
    Integer[][] dp = new Integer[st.length()][st.length()];
    return findLPSLengthRecursive(dp, st, 0, st.length()-1);
  }

  private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
    if(startIndex > endIndex)
      return 0;

    // every sequence with one element is a palindrome of length 1
    if(startIndex == endIndex)
      return 1;
    // CHECK IF THE VALUE IS IN DP 
    if(dp[startIndex][endIndex] == null) {
      // case 1: elements at the beginning and the end are the same
      if(st.charAt(startIndex) == st.charAt(endIndex)) {
        dp[startIndex][endIndex] = 2 + findLPSLengthRecursive(dp, st, startIndex+1, endIndex-1);
      } else {
        // case 2: skip one element either from the beginning or the end
        int c1 =  findLPSLengthRecursive(dp, st, startIndex+1, endIndex);
        int c2 =  findLPSLengthRecursive(dp, st, startIndex, endIndex-1);
        dp[startIndex][endIndex] = Math.max(c1, c2);
      }
    }

    return dp[startIndex][endIndex];
  }

```
---

---
### Longest Palindromic Substring
#### TC: O(3n) , MC: O(n)
- NO MEMOIZATION
- [Back to Top](#Table-of-contents)
```java
public int findLPSLength(String st) {
    return findLPSLengthRecursive(st, 0, st.length() - 1);
  }

  private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
    if (startIndex > endIndex)
      return 0;

    // every string with one character is a palindrome
    if (startIndex == endIndex)
      return 1;

    // case 1: elements at the beginning and the end are the same
    if (st.charAt(startIndex) == st.charAt(endIndex)) {
      int remainingLength = endIndex - startIndex - 1;
      // check if the remaining string is also a palindrome
      if (remainingLength == findLPSLengthRecursive(st, startIndex + 1, endIndex - 1))
        return remainingLength + 2;
    }

    // case 2: skip one character either from the beginning or the end
    int c1 = findLPSLengthRecursive(st, startIndex + 1, endIndex);
    int c2 = findLPSLengthRecursive(st, startIndex, endIndex - 1);
    return Math.max(c1, c2);
  }

```
---
- With MEMOIZATION
- [Back to Top](#Table-of-contents)
```java
public int findLPSLength(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
        }

private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
        return 0;

        // every string with one character is a palindrome
        if (startIndex == endIndex)
        return 1;

        if (dp[startIndex][endIndex] == null) {
        // case 1: elements at the beginning and the end are the same
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
        int remainingLength = endIndex - startIndex - 1;
        // check if the remaining string is also a palindrome
        if (remainingLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1)) {
        dp[startIndex][endIndex] = remainingLength + 2;
        return dp[startIndex][endIndex];
        }
        }

        // case 2: skip one character either from the beginning or the end
        int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
        int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
        dp[startIndex][endIndex] = Math.max(c1, c2);
        }

        return dp[startIndex][endIndex];
        }
```
---

---
### Count of Palindromic Substrings
#### TC: O(n^2) , MC: O(n^2)
- Bottom up approach
- [Back to Top](#Table-of-contents)
```java
public int findCPS(String st) {
    // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
    // palindrome
    boolean[][] dp = new boolean[st.length()][st.length()];
    int count = 0;

    // every string with one character is a palindrome
    for (int i = 0; i < st.length(); i++) {
      dp[i][i] = true;
      count++;
    }

    for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
      for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
          // if it's a two character string or if the remaining string is a palindrome too
          if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
            dp[startIndex][endIndex] = true;
            count++;
          }
        }
      }
    }

    return count;
  }

```
---
### Minimum Deletions in a String to make it a Palindrome
#### TC: O(n^2) , MC: O(n^2)
- Bottom up approach
- [Back to Top](#Table-of-contents)
```java
/**
 * Code same as String.length - Longest Palindromic Subsequence
 */
```
### Palindromic Partitioning
#### TC: O(2^n) , MC: O(n)
- No Memoization
- [Grocking-Link](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gxxqrE2kKrY)
- [Back to Top](#Table-of-contents)
```java
 public int findMPPCuts(String st) {
    return this.findMPPCutsRecursive(st, 0, st.length()-1);
  }

  private int findMPPCutsRecursive(String st, int startIndex, int endIndex) {
    // we don't need to cut the string if it is a palindrome
    if(startIndex >= endIndex || isPalindrome(st, startIndex, endIndex))
      return 0;

    // at max, we need to cut the string into its 'length-1' pieces
    int minimumCuts = endIndex-startIndex;
    for (int i=startIndex; i <= endIndex; i++) {
      if(isPalindrome(st, startIndex, i)){
        // we can cut here as we have a palindrome from 'startIndex' to 'i'
        minimumCuts = Math.min(minimumCuts, 1 + findMPPCutsRecursive(st, i+1, endIndex));
      }
    }
    return minimumCuts;
  }

  private boolean isPalindrome(String st, int x, int y) {
    while(x < y) {
      if(st.charAt(x++) != st.charAt(y--))
        return false;
    }
    return true;
  }
```
---
#### TC: O(n^2) , MC: O(n^2)
- With Memoization
- [Grocking-Link](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gxxqrE2kKrY)
- [Back to Top](#Table-of-contents)
```java
public int findMPPCuts(String st) {
    Integer dp[][] = new Integer[st.length()][st.length()];
    Boolean dpIsPalindrome[][] = new Boolean[st.length()][st.length()];
    return this.findMPPCutsRecursive(dp, dpIsPalindrome, st, 0, st.length()-1);
  }

  private int findMPPCutsRecursive(Integer dp[][], Boolean dpIsPalindrome[][],
      String st, int startIndex, int endIndex) {

    if(startIndex >= endIndex || isPalindrome(dpIsPalindrome, st, startIndex, endIndex))
      return 0;

    if(dp[startIndex][endIndex] == null) {
      // at max, we need to cut the string into its 'length-1' pieces
      int minimumCuts = endIndex-startIndex;
      for (int i=startIndex; i <= endIndex; i++) {
        if(isPalindrome(dpIsPalindrome, st, startIndex, i)){
          // we can cut here as we have a palindrome from 'startIndex' to 'i'
          minimumCuts = Math.min(minimumCuts, 1+findMPPCutsRecursive(dp, dpIsPalindrome, st, i+1, endIndex));
        }
      }
      dp[startIndex][endIndex] = minimumCuts;
    }
    return dp[startIndex][endIndex];
  }

  private boolean isPalindrome(Boolean dpIsPalindrome[][], String st, int x, int y) {
    if(dpIsPalindrome[x][y] == null) {
      dpIsPalindrome[x][y]=true;
      int i=x, j=y;
      while(i < j) {
        if(st.charAt(i++) != st.charAt(j--)) {
          dpIsPalindrome[x][y]=false;
          break;
        }
        // use memoization to find if the remaining string is a palindrome
        if(i < j && dpIsPalindrome[i][j] != null) {
          dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
          break;
        }
      }
    }
    return dpIsPalindrome[x][y];
  }

```

## SubSequence and Substring
---
### Dictionary Word Break Problem
#### TC: O(2n), MC: O(n^2)
- Recursive call after the first part is found
- [Back to Top](#Table-of-contents)
```java
public static boolean canSegmentString(String inputString, Set<String> dictionary) {
		for (int i = 1; i <= inputString.length(); ++i) {
			String first = inputString.substring(0, i);

			// check if the first part exists in the dictionary
			if (dictionary.contains(first)) {
				String second = inputString.substring(i);
				if (inputString.isEmpty()) {
					return true;
				}

				// check if the second part exists in the dictionary
				if (dictionary.contains(second)) {
					return true;
				}

				// Recursive call
				if (canSegmentString(second, dictionary)) {
					return true;
				}
			}
		}
		return false;
	}

```
---

---
### Longest Common Substring
#### TC: O(3^(m + n )) , MC: O(m + n )
- No Memoization
- [Grocking -link](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RMkk7NwE44R)
- [Back to Top](#Table-of-contents)
```java
public int findLCSLength(String s1, String s2) {
        return findLCSLengthRecursive(s1, s2, 0, 0, 0);
        }

private int findLCSLengthRecursive(String s1, String s2, int i1, int i2, int count) {
        if(i1 == s1.length() || i2 == s2.length())
        return count;

        if(s1.charAt(i1) == s2.charAt(i2))
        count = findLCSLengthRecursive(s1, s2, i1+1, i2+1, count+1);

        int c1 = findLCSLengthRecursive(s1, s2, i1, i2+1, 0);
        int c2 = findLCSLengthRecursive(s1, s2, i1+1, i2, 0);

        return Math.max(count, Math.max(c1, c2));
        }
```
---
#### TC: O(m * n ) , MC: O(m * n )
- With Memoization
- [Grocking -link](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RMkk7NwE44R)
- [Back to Top](#Table-of-contents)
```java
public int findLCSLength(String s1, String s2) {
    int maxLength = Math.min(s1.length(), s2.length());
    Integer[][][] dp = new Integer[s1.length()][s2.length()][maxLength];
    return findLCSLengthRecursive(dp, s1, s2, 0, 0, 0);
  }

  private int findLCSLengthRecursive(Integer[][][] dp, String s1, String s2, int i1, int i2, int count) {
    if(i1 == s1.length() || i2 == s2.length())
      return count;

    if(dp[i1][i2][count] == null) {
      int c1 = count;
      if(s1.charAt(i1) == s2.charAt(i2))
        c1 = findLCSLengthRecursive(dp, s1, s2, i1+1, i2+1, count+1);
      int c2 = findLCSLengthRecursive(dp, s1, s2, i1, i2+1, 0);
      int c3 = findLCSLengthRecursive(dp, s1, s2, i1+1, i2, 0);
      dp[i1][i2][count] = Math.max(c1, Math.max(c2, c3));
    }

    return dp[i1][i2][count];
  }

```
---

---
### Longest Common Subsequence
#### TC: O(2 ^ (M + N)) , MC: O( M + N )
- Top Down No Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/B8Pq4ZnBN0N)
- [Back to Top](#Table-of-contents)
```java
public int findLCSLength(String s1, String s2) {
        return findLCSLengthRecursive(s1, s2, 0, 0);
        }

private int findLCSLengthRecursive(String s1, String s2, int i1, int i2) {
        if(i1 == s1.length() || i2 == s2.length())
        return 0;

        if(s1.charAt(i1) == s2.charAt(i2))
        return 1 + findLCSLengthRecursive(s1, s2, i1+1, i2+1);

        int c1 = findLCSLengthRecursive(s1, s2, i1, i2+1);
        int c2 = findLCSLengthRecursive(s1, s2, i1+1, i2);

        return Math.max(c1, c2);
        }
```
---
#### TC: O((M * N)) , MC: O( M * N )
- Top Down With Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/B8Pq4ZnBN0N)
- [Back to Top](#Table-of-contents)
```java
public int findLCSLength(String s1, String s2) {
    Integer[][] dp = new Integer[s1.length()][s2.length()];
    return findLCSLengthRecursive(dp, s1, s2, 0, 0);
  }

  private int findLCSLengthRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {
    if (i1 == s1.length() || i2 == s2.length())
      return 0;

    if (dp[i1][i2] == null) {
      if (s1.charAt(i1) == s2.charAt(i2))
        dp[i1][i2] = 1 + findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2 + 1);
      else {
        int c1 = findLCSLengthRecursive(dp, s1, s2, i1, i2 + 1);
        int c2 = findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2);
        dp[i1][i2] = Math.max(c1, c2);
      }
    }

    return dp[i1][i2];
  }

```
---
### Minimum Deletions & Insertions to Transform a String Into Another
#### TC:  , MC:
- String length - Longest Common SubSequence 
- Top Down Approach
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m27OkE8D08O)
- [Back to Top](#Table-of-contents)
```java
/**
 * String Length - Longest Common Subsequence
 */
```
---
### Shortest Common Super-sequence
#### TC: O(2 ^ (M + N)) , MC: O( M + N )
- Top Down No Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jjLPyLGnAR)
- [Back to Top](#Table-of-contents)
```java
public int findSCSLength(String s1, String s2) {
      return findSCSLengthRecursive(s1, s2, 0, 0);
  }

  private int findSCSLengthRecursive(String s1, String s2, int i1, int i2) {
    // if we have reached the end of a string, return the remaining length of the other string, 
    // as in this case we have to take all of the remaining other string
    if(i1 == s1.length())
      return s2.length()-i2;
    if(i2 == s2.length())
      return s1.length()-i1;

    if(s1.charAt(i1) == s2.charAt(i2))
      return 1 + findSCSLengthRecursive(s1, s2, i1+1, i2+1);

    int length1 = 1 + findSCSLengthRecursive(s1, s2, i1, i2+1);
    int length2 = 1 + findSCSLengthRecursive(s1, s2, i1+1, i2);

    return Math.min(length1, length2);
  }
```
---
#### TC: O(M * N) , MC: O( M * N )
- Top Down with Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jjLPyLGnAR)
- [Back to Top](#Table-of-contents)
```java
public int findSCSLength(String s1, String s2) {
    Integer[][] dp = new Integer[s1.length()][s2.length()];
    return findSCSLengthRecursive(dp, s1, s2, 0, 0);
  }

  private int findSCSLengthRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {
    // if we have reached the end of a string, return the remaining length of the other string, 
    // as in this case we have to take all of the remaining other string
    if(i1 == s1.length())
      return s2.length()-i2;
    if(i2 == s2.length())
      return s1.length()-i1;

    if(dp[i1][i2] == null) {
      if(s1.charAt(i1) == s2.charAt(i2))
        dp[i1][i2] = 1 + findSCSLengthRecursive(dp, s1, s2, i1+1, i2+1);
      else {
        int length1 = 1 + findSCSLengthRecursive(dp, s1, s2, i1, i2+1);
        int length2 = 1 + findSCSLengthRecursive(dp, s1, s2, i1+1, i2);
        dp[i1][i2] = Math.min(length1, length2);
      }
    }

    return dp[i1][i2];
  }

```
### Longest Repeating Subsequence
#### TC: O(2 ^ (N)) , MC: O( N )
- Top Down No Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/7npz2VooPl1)
- [Back to Top](#Table-of-contents)
```java
public int findLRSLength(String str) {
      return findLRSLengthRecursive(str, 0, 0);
  }

  private int findLRSLengthRecursive(String str, int i1, int i2) {
    if(i1 == str.length() || i2 == str.length())
      return 0;

    if(i1 != i2 && str.charAt(i1) == str.charAt(i2))
      return 1 + findLRSLengthRecursive(str, i1+1, i2+1);

    int c1 = findLRSLengthRecursive(str, i1, i2+1);
    int c2 = findLRSLengthRecursive(str, i1+1, i2);

    return Math.max(c1, c2);
  }
```
#### TC: O(N^2) , MC: O(N^2)
- Top Down with Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/7npz2VooPl1)
- [Back to Top](#Table-of-contents)
```java
public int findLRSLength(String str) {
    Integer[][] dp = new Integer[str.length()][str.length()];
    return findLRSLengthRecursive(dp, str, 0, 0);
  }

  private int findLRSLengthRecursive(Integer[][] dp, String str, int i1, int i2) {
    if(i1 == str.length() || i2 == str.length())
      return 0;

    if(dp[i1][i2] == null) {
      if(i1 != i2 && str.charAt(i1) == str.charAt(i2))
        dp[i1][i2] = 1 + findLRSLengthRecursive(dp, str, i1+1, i2+1);
      else {
        int c1 = findLRSLengthRecursive(dp, str, i1, i2+1);
        int c2 = findLRSLengthRecursive(dp, str, i1+1, i2);
        dp[i1][i2] = Math.max(c1, c2);
      }
    }

    return dp[i1][i2];
  }
```
### Edit Distance Transform s1 to s2  
#### TC: O(3 ^ (N + M)) , MC: O( N  + M)
- Top Down No Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gx2QMvEorYY)
- [Back to Top](#Table-of-contents)
```java
public int findMinOperations(String s1, String s2) {
    return findMinOperationsRecursive(s1, s2, 0, 0);
  }

  private int findMinOperationsRecursive(String s1, String s2, int i1, int i2) {

    // if we have reached the end of s1, then we have to insert all the remaining characters of s2
    if(i1 == s1.length())
      return s2.length() - i2;

    // if we have reached the end of s2, then we have to delete all the remaining characters of s1
    if(i2 == s2.length())
      return s1.length() - i1;

    // If the strings have a matching character, we can recursively match for the remaining lengths.
    if(s1.charAt(i1) == s2.charAt(i2))
      return findMinOperationsRecursive(s1, s2, i1+1, i2+1);

    int c1 = 1 + findMinOperationsRecursive(s1, s2, i1+1, i2); //perform deletion
    int c2 = 1 + findMinOperationsRecursive(s1, s2, i1, i2+1); //perform insertion
    int c3 = 1 + findMinOperationsRecursive(s1, s2, i1+1, i2+1); // perform replacement

    return  Math.min(c1, Math.min(c2, c3));
  }
```
---
#### TC: O((N * M)) , MC: O( m ∗ n + (m+n)) = O (M * N)
- Top Down with Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gx2QMvEorYY)
- [Back to Top](#Table-of-contents)
```java
public int findMinOperations(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
        return findMinOperationsRecursive(dp, s1, s2, 0, 0);
        }

private int findMinOperationsRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {

        if(dp[i1][i2] == null) {
        // if we have reached the end of s1, then we have to insert all the remaining characters of s2
        if(i1 == s1.length())
        dp[i1][i2] = s2.length() - i2;

        // if we have reached the end of s2, then we have to delete all the remaining characters of s1
        else if(i2 == s2.length())
        dp[i1][i2] = s1.length() - i1;

        // If the strings have a matching character, we can recursively match for the remaining lengths
        else if(s1.charAt(i1) == s2.charAt(i2))
        dp[i1][i2] = findMinOperationsRecursive(dp, s1, s2, i1+1, i2+1);
        else {
        int c1 = findMinOperationsRecursive(dp, s1, s2, i1+1, i2); //delete
        int c2 = findMinOperationsRecursive(dp, s1, s2, i1, i2+1); //insert
        int c3 = findMinOperationsRecursive(dp, s1, s2, i1+1, i2+1); //replace
        dp[i1][i2] = 1 + Math.min(c1, Math.min(c2, c3));
        }
        }

        return dp[i1][i2];
        }
```
---
### Strings Interleaving
#### TC: O(2 ^ (N + M)) , MC: O( N  + M)
- Top Down No Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RMM68YXRwEK)
- [Back to Top](#Table-of-contents)
```java
public boolean findSI(String m, String n, String p) {
    return findSIRecursive(m, n, p, 0, 0, 0);
  }

  private boolean findSIRecursive(String m, String n, String p, int mIndex, int nIndex, int pIndex) {

    // if we have reached the end of the all the strings
    if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
      return true;

    // if we have reached the end of 'p' but 'm' or 'n' still have some characters left
    if(pIndex == p.length())
      return false;

    boolean b1=false, b2=false;
    if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
      b1 = findSIRecursive(m, n, p, mIndex+1, nIndex, pIndex+1);

    if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
      b2 = findSIRecursive(m, n, p, mIndex, nIndex+1, pIndex+1);

    return b1 || b2;
  }

```
#### TC: O( (N * M)) , MC: O( N * M)
- Top Down with Memoiozation
- [Grocking](https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RMM68YXRwEK)
- [Back to Top](#Table-of-contents)
```java
public Boolean findSI(String m, String n, String p) {
    Map<String, Boolean> dp = new HashMap<>(); 
    return findSIRecursive(dp, m, n, p, 0, 0, 0);
  }

  private boolean findSIRecursive(Map<String, Boolean> dp, String m, String n, String p, 
    int mIndex, int nIndex, int pIndex) {

    // if we have reached the end of the all the strings
    if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
      return true;

    // if we have reached the end of 'p' but 'm' or 'n' still has some characters left
    if(pIndex == p.length())
      return false;

    String subProblemKey = mIndex + "-" + nIndex + "-" + pIndex;
    if(!dp.containsKey(subProblemKey)) {
      boolean b1=false, b2=false;
      if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
        b1 = findSIRecursive(dp, m, n, p, mIndex+1, nIndex, pIndex+1);
      
      if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
        b2 = findSIRecursive(dp, m, n, p, mIndex, nIndex+1, pIndex+1);
      
      dp.put(subProblemKey, b1 || b2);
    }
    
    return dp.get(subProblemKey);
  }
```
---

## Permutations
### String Permutations by changing case
#### TC: O(n * 2^N)  , MC: O(n * 2^N)
- [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/39ol03Z40wn)
- [Back to Top](#Table-of-contents)
```java
class LetterCaseStringPermutation {

  public static List<String> findLetterCaseStringPermutations(String str) {
    List<String> permutations = new ArrayList<>();
    if (str == null)
      return permutations;

    permutations.add(str);
    // process every character of the string one by one
    for (int i = 0; i < str.length(); i++) {
      if (Character.isLetter(str.charAt(i))) { // only process characters, skip digits
        // we will take all existing permutations and change the letter case appropriately
        int n = permutations.size();
        for (int j = 0; j < n; j++) {
          char[] chs = permutations.get(j).toCharArray();
          // if the current character is in upper case change it to lower case or vice versa
          if (Character.isUpperCase(chs[i]))
            chs[i] = Character.toLowerCase(chs[i]);
          else
            chs[i] = Character.toUpperCase(chs[i]);
          permutations.add(String.valueOf(chs));
        }
      }
    }
    return permutations;
  }

```
---
---
### Generate All possible Balanced Parentheses
#### TC: O (2 ^(2 ^ N)) , MC: O (4 ^ n)
- Recursive
- Some comment
- [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/q2qVQqMlg4y)
- [Back to Top](#Table-of-contents)
```java
public static List<String> generateValidParentheses(int num) {
    List<String> result = new ArrayList<String>();
    char[] parenthesesString = new char[2 * num];
    generateValidParenthesesRecursive(num, 0, 0, parenthesesString, 0, result);
    return result;
  }

  private static void generateValidParenthesesRecursive(int num, int openCount, int closeCount,
      char[] parenthesesString, int index, List<String> result) {

    // if we've reached the maximum number of open and close parentheses, add to the result
    if (openCount == num && closeCount == num) {
      result.add(new String(parenthesesString));
    } else {
      if (openCount < num) { // if we can add an open parentheses, add it
        parenthesesString[index] = '(';
        generateValidParenthesesRecursive(num, openCount + 1, closeCount, parenthesesString, index + 1, result);
      }

      if (openCount > closeCount) { // if we can add a close parentheses, add it
        parenthesesString[index] = ')';
        generateValidParenthesesRecursive(num, openCount, closeCount + 1, parenthesesString, index + 1, result);
      }
    }
  }

```
---
#### TC: O (2 ^ N)) , MC: O (N * 2 ^ N)
- Iterative
- Some comment
- [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/7n922LQDGgQ)
- [Back to Top](#Table-of-contents)
```java

class ParenthesesString {
    String str;
    int openCount; // open parentheses count
    int closeCount; // close parentheses count

    public ParenthesesString(String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            // if we've reached the maximum number of open and close parentheses, add to the result
            if (ps.openCount == num && ps.closeCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num) // if we can add an open parentheses, add it
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));

                if (ps.openCount > ps.closeCount) // if we can add a close parentheses, add it
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
            }
        }
        return result;
    }


```
---
### Generate all the possible permutations of String
#### TC: O(N∗N!), MC: O(N)
- Same as Array of numbers
- [Back to Top](#Table-of-contents)
```java
/**
 * Calling the function permute( inputString , "");
 */

static void permute(String s , String answer)
        {
        if (s.length() == 0)
        {
        System.out.print(answer + "  ");
        return;
        }

        for(int i = 0 ;i < s.length(); i++)
        {
        char ch = s.charAt(i);
        String left_substr = s.substring(0, i);
        String right_substr = s.substring(i + 1);
        String rest = left_substr + right_substr;
        permute(rest, answer + ch);
        }
  }
```
---
---
## Sorting
### Custom Sorting Frequency Sort
#### TC: O(N∗logN), MC: O(N)
- Characters will be sorted by their frequency 
- [Back to Top](#Table-of-contents)
```java
public static String sortCharacterByFrequency(String str) {
    // find the frequency of each character
    Map<Character, Integer> characterFrequencyMap = new HashMap<>();
    for (char chr : str.toCharArray()) {
      characterFrequencyMap.put(chr, characterFrequencyMap.getOrDefault(chr, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
        (e1, e2) -> e2.getValue() - e1.getValue());

    // add all characters to the max heap
    maxHeap.addAll(characterFrequencyMap.entrySet());

    // build a string, appending the most occurring characters first
    StringBuilder sortedString = new StringBuilder(str.length());
    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> entry = maxHeap.poll();
      for (int i = 0; i < entry.getValue(); i++)
        sortedString.append(entry.getKey());
    }
    return sortedString.toString();
  }
```
---


