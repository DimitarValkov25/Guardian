public class Person {
    private String type;
    private String name;
    private String lastName;
    private Integer age;
    private String address;
    private Integer phoneNumber;
    private String gender;
    //private enum SpecialProperty { salary, pension, kid };
    //private SpecialProperty specialProperty;

    public Person(String type,String name, String lastName, Integer age, String gender,String address, Integer phoneNumber){
        this.type=type;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        //this.specialProperty = specialProperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
