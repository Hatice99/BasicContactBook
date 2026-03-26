import java.util.ArrayList;
import java.util.Iterator;

public class ContactLogic {
    private ArrayList<ContactDataModel> contacts = new ArrayList<>();

    public void addContact(String name, String phone_number, String email) {
        ContactDataModel contact = new ContactDataModel(name, phone_number, email);
        contacts.add(contact);
        System.out.print("Contact added successfully!");
    }

    public void deleteContact(int index) {
        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid index!");
        } else {
            ContactDataModel contact = contacts.remove(index);
            System.out.println("Contact deleted:" + contact.getName());
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

    }

    public void editContact(int index, String name, String phone_number, String mail) {
        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid index!");
        } else {
            ContactDataModel new_contact = contacts.get(index);
            new_contact.setName(name);
            new_contact.setPhone_number(phone_number);
            new_contact.setEmail(mail);
            System.out.println("Contact updated successfully!");
        }
    }

}
