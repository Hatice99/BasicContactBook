import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        ContactLogic contact_book = new ContactLogic();
        Scanner myObj = new Scanner(System.in);

        while(true){
            System.out.println("""
            Choose one action from below:
            1. Add contact
            2. View contact
            3. Update contact
            4. Delete contact
            5. Exit
                """);

    int selection_number = myObj.nextInt();
    myObj.nextLine(); // consume leftover newline

    switch (selection_number) {
        case 1:
            System.out.println("Enter the name");
            String name = myObj.nextLine();
            System.out.println("Enter the phone number");
            String phone_number = myObj.nextLine();
            System.out.println("Enter the email");
            String email = myObj.nextLine();
            contact_book.addContact(name, phone_number, email);
            System.out.println();
            break;
        case 2:
            contact_book.viewContact();
            break;
        case 3:
            System.out.println("Enter the index of the contact:");
            int index = myObj.nextInt();
            myObj.nextLine();
            System.out.println("Enter the name");
            String new_name = myObj.nextLine();
            System.out.println("Enter the phone number");
            String new_phone_number = myObj.nextLine();
            System.out.println("Enter the email");
            String new_email = myObj.nextLine();
            contact_book.editContact(index-1, new_name, new_phone_number, new_email);
            System.out.println();
            break;
        case 4:
            System.out.println("Enter the index of the contact:");
            int index_to_delete = myObj.nextInt();
            myObj.nextLine();
            contact_book.deleteContact(index_to_delete-1);
            System.out.println();
            break;
        case 5:
            System.out.println("Bye");
            myObj.close();
            return;
        default:
            System.out.println("Invalid choice!");
            System.out.println();
            break;
    }

    

        }

    }
}
