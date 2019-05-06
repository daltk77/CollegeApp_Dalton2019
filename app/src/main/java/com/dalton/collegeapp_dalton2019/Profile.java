package com.dalton.collegeapp_dalton2019;

import java.util.Date;

public class Profile {

   //    Variable instantiation for FirstName, LastName, Email, ObjectId, dateOfBirth, and constant PHOTOFILENAME     //
    String mFirstName;
    String mLastName;
    String mEmail;
    String mObjectId;
    Date dateOfBirth;
    public final static String PHOTOFILENAME = "IMG_PROFILE.jpg";

    //    Getter for Profile object FirstName     //
    public String getFirstName() {
        return mFirstName;
    }

    //    Setter for Profile object FirstName     //
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    //    Getter for Profile object LastName     //
    public String getLastName() {
        return mLastName;
    }

    //    Getter for Profile object LastName     //
    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    //    Getter for Profile object Email     //
    public String getEmail() {
        return mEmail;
    }

    //    Setter for Profile object Email     //
    public void setEmail(String email) {
        mEmail = email;
    }

    //    Constructor for a new Profile object with parameters - firstName and lastName     //
    public Profile(String firstName, String lastName){
        mFirstName = firstName;
        mLastName = lastName;
    }

    //    Constructor for a new Profile object that creates a new Date object     //
    public Profile(){
        dateOfBirth = new Date();
    }

    //    Setter for Profile object ObjectId     //
    public void setObjectId(String objectId) {
        mObjectId = objectId;
    }

    //    Getter for Profile object ObjectId     //
    public String getObjectId() {
        return mObjectId;
    }

    //    Getter for Profile object constant PHOTOFILENAME     //
    public String getPhotoFilename(){
        return PHOTOFILENAME;
    }
}