package com.example.ganesh.designpatterns.builder;

/**
 * class is final
 * all variables are private and final
 * constructor is private
 * no setters
 * getters are not sharing changeable references
 * <p>
 * that is, User is immutable
 */
final public class User {

    // required
    private final String firstName;
    private final String lastName;

    // optional
    private final int age;
    private final String phone;
    private final String address;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //all getter, and NO setter to provide immutability
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: " + this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.phone + ", " + this.address;
    }

    public static class UserBuilder {

        //required
        private final String firstName;
        private final String lastName;

        //optional
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            User user = new User(this);
            validateUserObject(user);
            return user;
        }

        private void validateUserObject(User user) {
            if (user.getFirstName().length() <= 3) {
                throw new IllegalArgumentException("First Name should be longer than 3 characters.");
            }
        }
    }
}
