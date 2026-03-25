import java.util.ArrayList;

public class ContactLogic {
    private ArrayList<ContactDataModel> contacts = new ArrayList<>();

    public void addContact(String name, String phone_number, String email){
        ContactDataModel contact = new ContactDataModel(name, phone_number, email);
        contacts.add(contact);
        System.out.print("Contact added successfully!");
    }

    public void deleteContact(int index){
        if(index <= 0 || index > contacts.size()){
            System.out.println("Invalid index!");
        }
        else{
            ContactDataModel contact = contacts.remove(index);
            System.out.println("Contact deleted:" + contact.getName());
        }
    }


    
}
