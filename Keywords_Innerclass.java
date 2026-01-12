/**
 * Java Exam Prep: Keywords and Inner Classes
 */

// --- KEYWORDS ---

// this: Refers to the current class instance; used to resolve ambiguity between instance variables and parameters.
// super: Refers to the immediate parent class; used to call parent constructors or access parent methods/fields.
// final: Prevents modification; used for constants (variables), preventing method overriding, or stopping class inheritance.

// --- INNER CLASSES (Exam Focus - 5 Marks) ---

/*
 * Why use Inner Classes?
 * 1. Logical Grouping: Keeps classes used in only one place together, increasing encapsulation.
 * 2. Access: Inner classes can access all members (including private) of the outer class.
 */

// 1. Member Inner Class: A non-static class declared inside another class; requires an instance of the outer class to be created.
// 2. Static Nested Class: Declared with 'static'; it can access only static members of the outer class and doesn't need an outer instance.
// 3. Anonymous Inner Class: A class without a name used to override methods or implement interfaces on the fly.

// --- ANONYMOUS INNER CLASS USING INTERFACE ---

/*
 * Q: How to use an Anonymous Inner Class with an Interface?
 * A: It allows you to provide an immediate implementation of an interface without creating a separate named class.
 * Proper Syntax Example:
 * Greeting g = new Greeting() { 
 * public void sayHello() { System.out.println("Hello Exam!"); } 
 * };
 */

public class JavaKeywords {
    public static void main(String[] args) {
        System.out.println("Exam prep content for Keywords and Inner Classes.");
    }
}