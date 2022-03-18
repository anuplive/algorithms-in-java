# Recursion

Table of contents
=================
<!--ts-->
[]
<!--te-->


---

### IsPrime, Compute GCD
#### TC: O(n) , MC: O(1) 
- IsPrime(n, div)
  - if(n < 2 ) false
  - if(div == 1) true
  - if (n % div == 0) false 
  - else IsPrime(n, div -1)
IsPrime(n, n/2);
```
public static boolean isPrime(int num, int i) {
        // First base case
        if (num < 2) {
            return false;
        }
        // Second base case
        else if (i == 1) {
            return true;
        }
        // Third base case
        else if (num%i == 0) {
            return false;
        }
        // Recursive case
        else {
            return isPrime(num, i-1);
        }
    } 
```
---

### Find the GCD of a two numbers
#### TC:  , MC:
- GCD(n1, n2)
  - if (n1 == n2)
    - return n1;
  - if (n1 > n2)
    - return(n1 - n2, n2)
  - else
    - return(n1, n2 - n1)
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

