import java.util.*;

class Hostel_Manager {

    static class Student {
        int id;
        String name;
        String room;

        Student(int id, String name, String room) {
            this.id = id;
            this.name = name;
            this.room = room;
        }

        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Room: " + room;
        }
    }

    static class Hostel {
        Student[] students;
        int size;
        int capacity;

        Hostel() {
            capacity = 10; // Initial capacity
            students = new Student[capacity];
            size = 0; // Number of students currently in the array
        }

        void addStudent(int id, String name, String room) {
            // Check if the student ID already exists
            for (int i = 0; i < size; i++) {
                if (students[i].id == id) {
                    System.out.println("Student with ID " + id + " already exists.");
                    return;
                }
            }

            // Resize the array if it's full
            if (size == capacity) {
                capacity *= 2; // Double the capacity
                students = Arrays.copyOf(students, capacity);
            }

            // Add the new student
            students[size] = new Student(id, name, room);
            size++;
            System.out.println("Student added successfully!");
        }

        void viewStudents() {
            if (size == 0) {
                System.out.println("No students found.");
            } else {
                System.out.println("List of Students:");
                for (int i = 0; i < size; i++) {
                    System.out.println(students[i]);
                }
            }
        }

        void removeStudent(int id) {
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (students[i].id == id) {
                    // Shift elements to the left to remove the student
                    for (int j = i; j < size - 1; j++) {
                        students[j] = students[j + 1];
                    }
                    size--;
                    found = true;
                    System.out.println("Student removed successfully!");
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with ID " + id + " not found.");
            }
        }

        void searchStudent(int id) {
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (students[i].id == id) {
                    System.out.println("Student found: " + students[i]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with ID " + id + " not found.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hostel hostel = new Hostel();
        int choice;

        do {
            System.out.println("\nHostel Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Room Number: ");
                    String room = scanner.nextLine();
                    hostel.addStudent(id, name, room);
                    break;
                case 2:
                    hostel.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to remove: ");
                    int removeId = scanner.nextInt();
                    hostel.removeStudent(removeId);
                    break;
                case 4:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    hostel.searchStudent(searchId);
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}