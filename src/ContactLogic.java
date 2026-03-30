import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// Handles the logic for managing contacts (add, view, update, delete, file operations)
public class ContactLogic {
    // List to store all contacts
    private ArrayList<ContactDataModel> contacts = new ArrayList<>();

    // Validates user input for contact fields
    public boolean validateInput(String name, String phone_number, String email) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            return false;
        } else if (!email.contains("@")) {
            System.out.println("Mail should include /@!");
            return false;
        } else if (!phone_number.matches("\\d+")) {
            System.out.println("Phone number should only include digits!");
            return false;
        }
        return true;
    }

    // Checks for duplicate contacts by name, phone, or email
    public boolean isDuplicate(String name, String phone_number, String email) {
        for (ContactDataModel c : contacts) {
            if (c.getName().equals(name) || c.getPhone_number().equals(phone_number) || c.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    // Saves all contacts to contacts.txt
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contacts.txt"))) {
            for (ContactDataModel c : contacts) {
                writer.write(c.getName() + "," +
                        c.getPhone_number() + "," +
                        c.getEmail() + "\n");
            }
            writer.close();
            System.out.println("Contacts saved!");

        } catch (IOException e) {
            System.out.println("Error while saving contacts!");
        }
    }

    // Loads contacts from contacts.txt at startup
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String phone = parts[1];
                String email = parts[2];

                contacts.add(new ContactDataModel(name, phone, email));

            }

        } catch (IOException e) {
            System.out.println("Error while loading contacts!");
        }
    }

    public void addContact(String name, String phone_number, String email) {
        if (!validateInput(name, phone_number, email)) {
            return;
        } else if (isDuplicate(name, phone_number, email)) {
            System.out.println("COntact already exists!");
            return;
        }

        ContactDataModel contact = new ContactDataModel(name, phone_number, email);
        contacts.add(contact);
        System.out.print("Contact added successfully!");
        System.out.println();
    }

    public void deleteContact(String name) {

        for (int i = 0; i < contacts.size(); i++) {
            ContactDataModel c = contacts.get(i);

            if (c.getName().equals(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted:" + c.getName());
            }
        }
        System.out.println("Contact not found!");

    }

    public void viewContact() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty");
            return;
        }

        Iterator<ContactDataModel> it = contacts.iterator();

        while (it.hasNext()) {
            ContactDataModel contact = it.next();

            System.out.println("Name:" + contact.getName());
            System.out.println("Phone Number:" + contact.getPhone_number());
            System.out.println("Email:" + contact.getEmail());
            System.out.println();
        }
        System.out.println();

    }

    public void editContact(String name_to_edit, String name, String phone_number, String email) {
        if (!validateInput(name, phone_number, email)) {
            return;
        } else if (isDuplicate(name, phone_number, email)) {
            System.out.println("Contact already exists!");
            return;
        }

        for (ContactDataModel c : contacts) {
            if (c.getName().equals(name_to_edit)) {
                c.setName(name);
                c.setPhone_number(phone_number);
                c.setEmail(email);
                System.out.println("Contact updated successfully!");
            }
        }

        System.out.println();
    }

}
