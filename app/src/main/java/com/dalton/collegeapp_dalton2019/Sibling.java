package com.dalton.collegeapp_dalton2019;

public class Sibling extends FamilyMember {

    //    Getter for Sibling object LastName     //
    public String getLastName() {
        return mLastName;
    }

    //    Setter for Sibling object LastName     //
    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

  //    Getter for Sibling object FirstName     //
    public String getFirstName() {
        return mFirstName;
    }

   //    Setter for Sibling object FirstName     //
    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    //    Constructor for a new Sibling object that calls super, providing a default firstname and lastname     //
    public Sibling(){
        super();
    }

    //    Constructor for a new Sibling object that uses parameters to set firstName and lastName     //
    public Sibling(String firstName, String lastName){
        super(firstName, lastName);
    }

    //    Constructor for a new Sibling object that uses parameters to set firstName, lastName, and Occupation     //
    public Sibling(String firstName, String lastName, String occupation){
        super(firstName, lastName);
    }

    //    Returns an easy to read String format for a Sibling object     //
    @Override
    public String toString(){
        return "Sibling: "+ getFirstName() + " "+ getLastName();
    }

}
