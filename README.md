
# BasicContactBook

BasicContactBook is a simple Java application for managing a list of contacts. It allows users to add, view, update, or delete contact information using a text-based interface.

## Features
- Add new contacts
- View all contacts
- Update existing contacts
- Delete contacts
- Store contacts in a text file (`contacts.txt`)


## Project Structure

The main files are:

- `contacts.txt`: Stores all contact information in plain text format.
- `Main.java`: The entry point of the application.
- `ContactLogic.java`: Contains the logic for adding, viewing, updating, and deleting contacts.
- `ContactDataModel.java`: Defines the data structure for a contact.

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Compiling the Project
1. Open a terminal and navigate to the project directory.
2. Compile the source files:
	```
	javac -d bin src/*.java
	```

### Running the Application
1. Run the program from the `bin` directory:
	```
	java -cp bin Main
	```

## Usage
- Follow the on-screen prompts to manage contacts.
- Contacts are saved in `contacts.txt` in the project root.

