export class User {

    userId :number;
    firstName :string;
    lastName :string;
    userName :string;
    password :string;
    isEmployee :number;
    address :string;
    email :string;

    constructor(userId :number, firstName :string, lastName :string, userName :string,
        password :string, isEmployee :number, address :string, email :string) {
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.userName = userName;
            this.password = password;
            this.isEmployee = isEmployee;
            this.address = address;
            this.email = email;
        }

}