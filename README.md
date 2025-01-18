# DS
Word Composition Problem. Click to read

Longest Compound Word Program
Overview
This program is designed to find the longest compound word and the second-longest compound word from a list of words stored in a text file. A compound word is defined as a word that can be formed by concatenating two or more words from the same list. The program implements efficient techniques such as recursive checking, hash-based lookups, and a priority queue for sorting to optimize performance.

Key Features:
File Input: Reads words from a text file.
HashSet for Quick Lookups: Stores words in a set for O(1) lookups.
Recursive Validation: Ensures compound words are checked thoroughly.
Performance Tracking: Measures time taken to process the input file.

Design Decisions:
Priority Queue: Used to process longer words first, as the longest compound word must have the greatest length.





Prepare Input File:
Create a text file (e.g., Input_01.txt) and add one word per line.
Place the file in the src directory of your project.


Run the Program:
Open the project in your IDE.
Modify the input file path in the code to point to your input file.
Run the main method of the RefactoredQA class.

View the Output:
The program will display the longest compound word, the second-longest compound word, and the time taken to process the file in milliseconds.

Example Input and Output
Input File (Input_01.txt):
cat
cats
dog
catsdog
rat
ratcatdog
Output:(from file input_01.txt)
Longest Compound Word: ratcatdog
Second Longest Compound Word: catsdog
Time taken to process file: 12 milliseconds
