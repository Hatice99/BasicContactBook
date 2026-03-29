import java.util.ArrayList;
import java.util.Iterator;

public class ContactLogic {
    private ArrayList<ContactDataModel> contacts = new ArrayList<>();

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

    public boolean isDuplicate(String name, String phone_number, String email) {
        for (ContactDataModel c : contacts) {
            if (c.getName().equals(name) || c.getPhone_number().equals(phone_number) || c.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
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

    public void deleteContact(int index) {
        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid index!");
        } else {
            ContactDataModel contact = contacts.remove(index);
            System.out.println("Contact deleted:" + contact.getName());
            System.out.println();
        }
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
        }
        System.out.println();

    }

    public void editContact(int index, String name, String phone_number, String email) {
        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid index!");
        } else {
            if (!validateInput(name, phone_number, email)) {
                return;
            } else if (isDuplicate(name, phone_number, email)) {
                System.out.println("COntact already exists!");
                return;
            }
            ContactDataModel new_contact = contacts.get(index);
            new_contact.setName(name);
            new_contact.setPhone_number(phone_number);
            new_contact.setEmail(email);
            System.out.println("Contact updated successfully!");
            System.out.println();
        }
    }

}
