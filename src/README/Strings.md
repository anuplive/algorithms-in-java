# Strings

Table of contents
=================
<!--ts-->
* [Handy Checks](#Handy_Checks)
* [Two Pointer](#Two_Pointer)
* [Removing Elements](#Removing_Elements)
<!--te-->

---
## Handy Checks

```
if (str == null || str.length == 0 || str[0] == '\0')
          return "";
```


---
## Two Pointer
 - Left and Right Pointer move towards each other.   
---
### Reverse Words in a Sentence
#### TC: O(N) , MC: O(1)
- Left and Right Pointer move towards each other.
```
public static void strRev(char[] str, int start, int end) {
		if (str == null || str.length < 1) {
			return;
		}
    	while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
```
---
## Removing Elements
---
### Removing Duplictaes 
#### TC: O(N) , MC: O(N)
- Has Two Pointers:  runner and nextNonDuplicate and a charSet
    - nextNonDuplicate can start from 0 or 1
    - Start Iteration for runner 
        - if (!charSet.contains(str[runner]))
            - str[nextNonDuplicate ++] = str[runner]
              and charSet.add(str[runner])
    - End the string with '\0' character
```
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
### Remove White Spaces from a String
#### TC:  , MC:
- if (!Character.isWhitespace(str[currIndex]))
```
static void removeWhiteSpaces (char[] s) {

    int nextNonWhiteSpaceCharacter = 0;

    for(int currIndex = 0; currIndex < s.length; currIndex++){
      if(!Character.isWhitespace(s[currIndex]))
        s[nextNonWhiteSpaceCharacter++] = s[currIndex];
    } 
    s[nextNonWhiteSpaceCharacter] = '\0'; 

  } 
```
---
## Substring Problems 
    - Take the substring and then make an equals check
        if match do This
        else do That
        
---
### Word Break Problem
    Return true if the input string can be segmented. Otherwise false if it can not be segmented.
    Words dictionary: ["apple", "pear", "pier", "pie"]
    Input string: "applepie"
#### TC: O(2^n) , MC: O(n^2)
- Iterate from start of String where start = 1
- str.substring(0, start) and check the dictionary. 
  - if present check for remaining substring 
    - str.substring(start)
```
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
### Find all Palindrome Substrings
#### TC: O(n^3) , MC: O(1)
- Brute force each iteration and check for palindrome
```
public static boolean isPalindrome(String input, int start, int last) {
		while (last > start) {
			if (input.charAt(start) != input.charAt(last))
				return false;
			start++;
			last--;
		}
		return true;
	}

	// This function receives input string and returns the palindromes list
	public static List<String> findAllPalindromeSubstrings(String input) {
		List<String> palindrome = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				// storing the palindromes in palindromes array
				if (isPalindrome(input, i, j)) {
					palindrome.add(input.substring(i, j+1));
				}
			}
		}

		return palindrome;
	} 
```
---
### Another Solution
#### TC: O(N^2)  , MC: O(1)
- For each index expand from the left and right side and check for palindromes
- Saves one loop 
```
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
			// Expanding for odd length palindrome eg bab
			findPalindromesInSubString(input, i - 1, i + 1, palindrome);
			// Expanding for Even length palindrome aabb
			findPalindromesInSubString(input, i, i + 1, palindrome);
		}

		return palindrome;
	} 
```

---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```

