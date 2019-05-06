package com.dalton.collegeapp_dalton2019;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.dalton.collegeapp_dalton2019.R;

public class FamilyMemberActivity extends FragmentActivity {

    //    onCreate method for FamilyMemberActivity - Creates a new SiblingFragment or GuardianFragment based off of the intent provided     //
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_member);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = null;// = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            if (getIntent().getStringExtra(FamilyMember.EXTRA_RELATION).equals(Guardian.class.getName())) {
                fragment = new GuardianFragment();
                fm.beginTransaction()
                        .add(R.id.fragmentContainer, fragment)
                        .commit();
            }
            else if (getIntent().getStringExtra(FamilyMember.EXTRA_RELATION).equals(Sibling.class.getName())) {
                fragment = new SiblingFragment();
                fm.beginTransaction()
                        .add(R.id.fragmentContainer, fragment)
                        .commit();
            }
        }
    }


}
