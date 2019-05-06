package com.dalton.collegeapp_dalton2019;

public abstract class FamilyMember {

    //    Variable instantiation for FirstName, LastName, constant EXTRA_RELATION, and constant EXTRA_INDEX     //
    String mFirstName;
    String mLastName;
    public static final String EXTRA_RELATION = "org.pltw.examples.collegeapp.relation";
    public static final String EXTRA_INDEX = "org.pltw.examples.collegeapp.index";

    //    Getter for FamilyMember object String FirstName     //
    public String getFirstName() {
        return mFirstName;
    }

    //    Setter for FamilyMember object String FirstName     //
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    //    Getter for FamilyMember object String LirstName     //
    public String getLastName() {
        return mLastName;
    }

    //    Setter for FamilyMember object String LastName     //
    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    //    Creates a FamilyMember with default parameters    //
    public FamilyMember(){
        mFirstName = "Family";
        mLastName = "Member";
    }

    //    Creates a FamilyMember object with given parameters     //
    public FamilyMember(String firstName, String lastName){
        mFirstName = firstName;
        mLastName = lastName;
    }

    //    Gets a familyMember in an easy to read string format      //
    @Override
    public String toString(){
        return "Family Member: "+ getFirstName() + " "+ getLastName();
    }

    //    Overrides standard .equals method to test if instance names of FamilyMember objects match eachother      //
    @Override
    public boolean equals(Object o) {
        if ((o instanceof Guardian) && (this instanceof Guardian)) {

            if (((Guardian)o).getFirstName().equals(this.getFirstName()) && ((Guardian)o).getLastName().equals(this.getLastName())) {
                return true;
            }
        }
        else if ((o instanceof Sibling) && (this instanceof Sibling)) {

            if (((Sibling)o).getFirstName().equals(this.getFirstName())&& ((Sibling)o).getLastName().equals(this.getLastName())) {
                return true;
            }
        }
        return false;
    }
}
