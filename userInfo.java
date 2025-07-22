public class userInfo {

    private String name;
    private int age;
    private String email;
    private boolean inActive;


    public userInfo() {
        this.name = name;
        this.age = age;
        this.email = email;
        this.inActive = inActive;
    }

    public String getName() {return name;};
    public int getAge() {return age;};
    public String getEmail() {return email;};
    public boolean isInActive() {return inActive;};

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }

    public void displayInfo() {
        // Print user information in a nice format
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("In Active: " + inActive);
    }
// Main method for testing
public static void main(String[] args) {

        //creating 3 users
        userInfo Ahmed= new userInfo();
        Ahmed.setName("Ahmed");
        Ahmed.setAge(23);
        Ahmed.setEmail("ahmed@gmail.com");
        Ahmed.setInActive(true);

    userInfo Salim= new userInfo();
    Salim.setName("Salim");
    Salim.setAge(21);
    Salim.setEmail("Salim@gmail.com");
    Salim.setInActive(true);


    userInfo Rashid= new userInfo();
    Rashid.setName("Rashid");
    Rashid.setAge(28);
    Rashid.setEmail("Rashid@gmail.com");
    Rashid.setInActive(false);
    // Display their information
    Ahmed.displayInfo();
    Salim.displayInfo();
    Rashid.displayInfo();

    //Test setters
    Ahmed.setEmail("Ahmed2@gmail.com");
    System.out.println("After changing Ahmed's email: " + Ahmed.getName());
    Ahmed.displayInfo();

    // Test your getters and setters
}
}

