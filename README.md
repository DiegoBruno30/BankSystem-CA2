# Bank Employee Management System

**CCT College Dublin**  
H.Dip in Computing - Continuous Assessment 2  
Modules: Algorithms & Constructs / Software Development Fundamentals

**Student:** Diego Bruno Evangelista dos Santos  
**Student Number:** 2025145  
**Submission Date:** November 2025  
**Lecturers:** Ken Healy / Taufique Ahmed

---

## 📋 Project Overview

This project is a command-line based Bank Employee Management System developed in Java. The system demonstrates the practical application of data structures, sorting and searching algorithms, and software engineering principles within a banking organizational context.

The application manages employee records across multiple departments and hierarchical levels, providing functionality for data organization, information retrieval, record maintenance, and hierarchy visualization.

---

## 🎯 Features

### Core Functionality
- **Employee Sorting**: Alphabetical organization using recursive Merge Sort algorithm
- **Employee Search**: Fast retrieval using Binary Search algorithm
- **Add Employee Records**: Interactive input with validation for manager types and departments
- **Hierarchy Visualization**: Binary tree structure displaying organizational levels
- **Menu-Driven Interface**: User-friendly console navigation using enums

### Technical Highlights
- Recursive Merge Sort (O(n log n) performance)
- Binary Search (O(log n) complexity)
- Level-order binary tree insertion
- Input validation and error handling
- File I/O for data loading

---

## 🏗️ System Architecture

### Class Structure
```
CA_2/
├── MainApp.java              # Main program controller
├── Employee.java             # Core employee data class
├── Manager.java              # Manager information
├── Department.java           # Department details
├── EmployeeBinaryTree.java   # Binary tree implementation
├── TreeNode.java             # Tree node structure
├── ManagerType.java          # Manager type enum
├── DepartmentName.java       # Department enum
└── MenuOption.java           # Menu options enum
```

### Data Structures Used
- **ArrayList**: Dynamic employee list storage
- **Binary Tree**: Hierarchical organization representation
- **Queue**: Level-order tree traversal
- **Enums**: Type-safe option selection

---

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or higher
- Apache NetBeans IDE (recommended)
- Text file with employee names (Applicants_Form.txt provided)

### Running the Application

1. **Clone the repository:**
```bash
   git clone https://github.com/DiegoBruno30/BankSystem-CA2.git
```

2. **Open in NetBeans:**
   - File → Open Project
   - Navigate to project folder
   - Select CA2_BankSystem

3. **Run the program:**
   - Right-click on MainApp.java
   - Select "Run File"

4. **When prompted:**
   - Enter filename: `Applicants_Form.txt`
   - Select menu options (1-5)

### Menu Options
```
1. Sort Employee List       - Displays first 20 employees alphabetically
2. Search for Employee      - Find employee by name
3. Add New Employee         - Add record with validation
4. Create Employee Hierarchy - Generate binary tree (requires 20+ employees)
5. Exit Program             - Close application
```

---

## 🧪 Sample Data

The system includes `Applicants_Form.txt` with 35 employee names (Game of Thrones characters) for testing purposes. The file format is simple:
```
Jon Snow
Daenerys Targaryen
Tyrion Lannister
...
```

---

## 🔍 Algorithm Justification

### Merge Sort Selection
- **Performance**: Guaranteed O(n log n) in all cases
- **Stability**: Maintains relative order of equal elements
- **Recursion**: Meets assignment requirement for recursive algorithm
- **Reliability**: No worst-case performance degradation

### Binary Search Selection
- **Efficiency**: O(log n) time complexity
- **Scalability**: Performance advantage increases with dataset size
- **Practicality**: 6 comparisons for 35 employees vs. potentially 35 with linear search

---

## 📊 Project Statistics

- **Total Classes**: 9
- **Lines of Code**: ~600+
- **Git Commits**: 11+
- **Test Data**: 35 employee records
- **Supported Operations**: 5 main functions

---

## 📚 Documentation

Complete documentation is provided in two separate submissions:

### Algorithms & Constructs Documentation
- Algorithm selection justification (500 words)
- Performance analysis
- Implementation screenshots
- References

### Software Development Fundamentals Documentation
- 5 Use Cases with diagrams
- 2 UML Diagrams (Class Diagram, Activity Diagram)
- Functional and Non-Functional Requirements
- 5 User Stories with acceptance criteria
- 3 Unit Test specifications

---

## 🧑‍💻 Development Process

### Version Control
- Consistent commit messages following development stages
- Incremental feature implementation
- Bug fixes documented in commit history
- Code cleanup and documentation improvements

### Testing Approach
- Manual testing of all menu options
- Validation testing for user inputs
- Edge case handling (empty lists, invalid choices)
- Binary tree verification with various dataset sizes

---

## 🎓 Learning Outcomes Demonstrated

### Algorithms & Constructs
✅ Evaluation and selection of appropriate algorithms  
✅ Implementation of recursive algorithms  
✅ Understanding of time complexity (Big O notation)  
✅ Data structure selection and implementation

### Software Development Fundamentals
✅ System requirements determination using UML  
✅ Use case development and specification  
✅ User story creation with acceptance criteria  
✅ Unit test design and documentation

---

## 📖 References

### Books
- Cormen, T.H., Leiserson, C.E., Rivest, R.L. and Stein, C. (2022) *Introduction to Algorithms*. 4th edn. Cambridge: MIT Press.
- Goodrich, M.T., Tamassia, R. and Goldwasser, M.H. (2014) *Data Structures and Algorithms in Java*. 6th edn. Hoboken: John Wiley & Sons.
- Sommerville, I. (2016) *Software Engineering*. 10th edn. Harlow: Pearson Education Limited.

### Online Resources
- Oracle Java Documentation: https://docs.oracle.com/javase/tutorial/
- GeeksforGeeks Algorithms: https://www.geeksforgeeks.org/
- Baeldung Java Tutorials: https://www.baeldung.com/

---

## 📝 Notes

### Known Limitations
- Manager and Department classes exist but are not fully integrated
- Employee stores manager and department as strings rather than object references
- Current implementation uses temporary data assignments when loading from file

### Future Enhancements
- Integration of Manager and Department as object references
- Database connectivity for persistent storage
- GUI implementation using JavaFX
- Export functionality for reports
- Advanced search filters (by department, manager type)

---

## 📄 License

This project is submitted as coursework for CCT College Dublin.  
All rights reserved - Academic Use Only.

---

## 📧 Contact

**Student:** Diego Bruno Evangelista dos Santos  
**Student Number:** 2025145  
**Institution:** CCT College Dublin  
**Programme:** H.Dip in Computing  

---

## 🙏 Acknowledgments

- Lecturers: Ken Healy and Taufique Ahmed for guidance and support
- CCT College Dublin for providing the learning resources
- Game of Thrones character names used as sample data

---

*Last Updated: November 2025*
