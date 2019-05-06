package com.dalton.collegeapp_dalton2019;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dalton.collegeapp_dalton2019.R;


public class FamilyMemberFragment extends Fragment {

   //    onCreateView method for FamilyMemberFragment - inflates view with fragment_family_member.xml, returns rootview    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle){
        super.onCreateView(inflater, view, bundle);
        View rootView = inflater.inflate(R.layout.fragment_family_member, view, false);
        return rootView;
    }
}
