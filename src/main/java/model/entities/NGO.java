package model.entities;

public class NGO {
    private String cnpj;
    private String name;
    private String phone;
    private String email;
    private Address address;
    private NGORepresentative ngoRepresentative;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public NGORepresentative getNgoRepresentative() {
        return ngoRepresentative;
    }

    public void setNgoRepresentative(NGORepresentative ngoRepresentative) {
        this.ngoRepresentative = ngoRepresentative;
    }
}
