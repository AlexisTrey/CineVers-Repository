/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class Admin {
    private String id;
    private String firstName;
    private String lastName;
    private String documentType;   // CC, TI, CE, etc.
    private String documentNumber;
    private String email;
    private String phone;
    private String password;
    private Role role;
    private City city;

    public Admin(String id, String firstName, String lastName, String documentType, String documentNumber, String email, String phone, String password, Role role, City city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.city = city;
    }

    public Admin() {
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
    
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
    
    public boolean hasRole(String roleName) {
        return this.role.getName().equalsIgnoreCase(roleName);
    }

    @Override
    public String toString() {
        return "Admin: " + firstName + " " + lastName +
                " | Rol: " + role.getName() +
                " | Ciudad: " + city.getName();
    }
    
}
