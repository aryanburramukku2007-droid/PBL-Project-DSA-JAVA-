# PBL-Project-DSA-JAVA-
Product review ranking system for smart decisions
ReviewRanker – Smart Product Review Ranking System

Overview:-

ReviewRanker is a Java console-based application that manages products and their reviews while ranking them using a smart scoring algorithm. The system allows users to add products, submit reviews, search products, filter by category, and view ranked products based on ratings and review counts.
The ranking mechanism combines average rating and number of reviews to produce a smarter score so that products with many good reviews rank higher than those with very few ratings.
The project demonstrates the use of Object-Oriented Programming, collections, and sorting algorithms in Java.

Features:-
=
• Add new products with category information

• Add user reviews with rating and comment

• Search products by name

• Filter products by category

• Display all added products

• Smart product ranking based on ratings and review count

• Console-based interactive menu system

Technologies Used:-
=
Java

Object-Oriented Programming (OOP)

Java Collections Framework (ArrayList)

Searching and Sorting Algorithms

Scanner for user input

Linked List, Queue

Stack, HAshing

Project Structure
=
ReviewRanker.java

 ├── Review class

 │     Stores reviewer name, rating, and comment
 
 │
 
 ├── Product class
 
 │     Stores product details and list of reviews
 
 │     Calculates average rating and smart score
 
 │
 
 └── ReviewRanker class
       Main system controller with menu options

Smart Ranking Algorithm:-
=
The ranking of products is calculated using a Smart Score formula:

Smart Score =
(0.7 × Average Rating)
+
(0.3 × log(Number of Reviews + 1) × normalization factor)

This method ensures:

Highly rated products rank higher

Products with more reviews gain credibility

Fair ranking between popularity and quality

Menu Options:-
=
1 Add Product

2 Add Review

3 Search Product

4 Filter Category

5 Show Rankings

6 View Added Products

7 Exit

Example Output:-
=
===== ReviewRanker System =====
1 Add Product

2 Add Review

3 Search Product

4 Filter Category

5 Show Rankings

6 View Added Products

7 Exit

Choose option:

Learning Outcomes:-
=
This project demonstrates:

Java class design

Use of ArrayList for data storage

Searching and filtering techniques

Sorting objects using custom comparators

Implementation of ranking algorithms

Future Improvements:-
=
• Add graphical user interface (GUI)

• Store data using a database

• Add user authentication system

• Implement web-based version of the system

• Add recommendation system for products

Author:-
=
Burramukku.Aryan

Computer Science Engineering
