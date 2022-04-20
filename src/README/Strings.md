# Strings

Table of contents
=================
<!--ts-->


| Label         | Link          | Links | Links | Links | Links | Links | Links |
| ------------- |:-------------:| -----:| -----:| -----:| -----:| -----:| -----:|
| [Handy Checks](#Handy_Checks) |      |     |    |    |     |     |     |
| [Remove Characters](#Remove-Characters) | |     |    |    |     |     |     |
| [Substring Use Cases](#Substring-Use-Cases) | Substrings | SubSequences  |    |    |     |     |     |
| [Palindrome](#Palindrome) | |     |    |    |     |     |     | 
| [Permutations](#Permutations) | |     |    |    |     |     |     | 
| [Sorting](#Sorting) | |     |    |    |     |     |     | 
<!--te-->
---
## Handy Checks
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
## Remove Characters
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
## Substring Use Cases
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
#### TC: O(m*n) , MC: O(n)
- [Video](#_https://www.youtube.com/watch?v=Lj90FqNCIJE&t=1623s)
- [Playlist](#_https://www.youtube.com/c/JavaAidTutorials/playlists)
- Note this is not SUB Sequence !!
- This solution is with memoization
- Top Down Approach
- [Back to Top](#Table-of-contents)
```java
public int findLCSubStringLength(String s1, String s2) {
        int maxLength = Math.min(s1.length(), s2.length());
        Integer[][][] dp = new Integer[s1.length()][s2.length()][maxLength];
        return findLCSLengthRecursive(dp, s1, s2, 0, 0, 0);
        }

private int findLCSubStringLengthRecursive(Integer[][][] dp, String s1, String s2, int i1, int i2, int count) {
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
- Bottom up Approach
```java
 public int findLCSubStringLength(String s1, String s2) {
    int[][] dp = new int[s1.length()+1][s2.length()+1];
    int maxLength = 0;
    for(int i=1; i <= s1.length(); i++) {
      for(int j=1; j <= s2.length(); j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = 1 + dp[i-1][j-1];
          maxLength = Math.max(maxLength, dp[i][j]);
        }
      }
    }
    return maxLength;
  }

```
---

---
### Longest Common Subsequence
#### TC: O(M*N) , MC: O(n*m)
- Recursive and Memoiozation
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
- Iterative , Bottom UP 
```java
public int findLCSLength(String s1, String s2) {
    int[][] dp = new int[s1.length()+1][s2.length()+1];
    int maxLength = 0;
    for(int i=1; i <= s1.length(); i++) {
      for(int j=1; j <= s2.length(); j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1))
          dp[i][j] = 1 + dp[i-1][j-1];
        else
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        
        maxLength = Math.max(maxLength, dp[i][j]);
      }
    }
    return maxLength;
  }

```
### Minimum Deletions & Insertions to Transform a String into another
#### TC:  , MC:
- String length - LCSubSequence 
- Bottom up Approach
- [Back to Top](#Table-of-contents)
```java
public void findMDI(String s1, String s2) {
    int c1 = findLCSLength(s1, s2);
    System.out.println("Minimum deletions needed: " + (s1.length() - c1));
    System.out.println("Minimum insertions needed: " + (s2.length() - c1));
  }
  
  private int findLCSLength(String s1, String s2) {
    int[][] dp = new int[s1.length()+1][s2.length()+1];
    int maxLength = 0;
    for(int i=1; i <= s1.length(); i++) {
      for(int j=1; j <= s2.length(); j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1))
          dp[i][j] = 1 + dp[i-1][j-1];
        else
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        
        maxLength = Math.max(maxLength, dp[i][j]);
      }
    }
    return maxLength;
  }


```
---

## Palindrome
---
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
## Permutations
---
### String Permutations by changing case
#### TC: O(n * 2^N)  , MC:
- Some comment
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
#### TC:  , MC:
- Some comment
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

### Generate all the possible permutations of String
#### TC: O(N∗N!), MC: O(N∗N!)
- Same as Array of numbers
- [Back to Top](#Table-of-contents)
```java
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        perm(result, nums, 0, nums.length - 1);
        return result;
    }

    public void perm(List<List<Integer>> result, int[] nums, int start, int end) {
        if (start >= end) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, start, i);
                perm(result, nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}



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


