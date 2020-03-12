package ie.gmit;

public class Employee {
    private String name = "";
    private String phone = "";
    private String ID = "";
    private int age = 0;

    public Employee (String name, String phone, String ID, int age) {
        setName(name);
        setPhone(phone);
        setID(ID);
        setAge(age);
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name.length() < 3 || name.length() > 25)
            throw new IllegalArgumentException("Name must have a minmium of 3 characters and a maximum of 25");
        else
            this.name = name;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) {
        if (phone.length() == 8)
            this.phone = phone;
        else
            throw new IllegalArgumentException("Phone number must be 8 digits");

    }

    public String getID() { return ID; }

    public void setID(String ID) {
        if (ID.length() == 5)
            this.ID = ID;
        else
            throw new IllegalArgumentException("ID must be unique with 5 digits");
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age <= 16)
            throw new IllegalArgumentException("Employee must be over the age of 16");
        else
            this.age = age;
    }
}
