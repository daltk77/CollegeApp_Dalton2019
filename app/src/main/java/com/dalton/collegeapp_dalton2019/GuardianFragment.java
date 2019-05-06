package com.dalton.collegeapp_dalton2019;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.dalton.collegeapp_dalton2019.R;

public class GuardianFragment extends Fragment {

    //    Variable instantiation for elements on layout file, Guardian object, and constant string TAG    //
    private TextView mFirstNameTextView, mLastNameTextView, mOccupationTextView;
    private EditText mFirstNameEditText, mLastNameEditText, mOccupationEditText;
    private Button mSubmitButton;
    private Guardian mGuardian;
    private final String TAG = "GUARDIAN_FRAGMENT";

    //    onCreateView inflates layout with fragment_guardian.xml, links layout elements in code, logic for onClickListeners, saves to backendless, returns rootview     //
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_guardian, container, false);

        mGuardian = new Guardian("FirstName", "LastName", "Occupation");

        mFirstNameTextView = (TextView) rootView.findViewById(R.id.guardian_first_name);
        mLastNameTextView = (TextView) rootView.findViewById(R.id.guardian_last_name);
        mOccupationTextView = (TextView) rootView.findViewById(R.id.guardian_occupation);
        mFirstNameEditText = (EditText) rootView.findViewById(R.id.guardian_first_name_edit);
        mLastNameEditText = (EditText) rootView.findViewById(R.id.guardian_last_name_edit);
        mOccupationEditText = (EditText) rootView.findViewById(R.id.guardian_occupation_edit);
        mSubmitButton = (Button) rootView.findViewById(R.id.guardian_submit_button);

        mFirstNameTextView.setText(mGuardian.getFirstName());
        mLastNameTextView.setText(mGuardian.getLastName());
        mOccupationTextView.setText(mGuardian.getOccupation());

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFirstNameEditText.getText().length() > 0){
                    String firstName = mFirstNameEditText.getText().toString();
                    mGuardian.setFirstName(firstName);
                    mFirstNameTextView.setText(firstName);
                    mFirstNameEditText.setText("");
                }

                if(mLastNameEditText.getText().length() > 0){
                    String lastName = mLastNameEditText.getText().toString();
                    mGuardian.setLastName(lastName);
                    mLastNameTextView.setText(lastName);
                    mLastNameEditText.setText("");
                }

                if(mOccupationEditText.getText().length() > 0){
                    String occupation = mOccupationEditText.getText().toString();
                    mGuardian.setOccupation(occupation);
                    mOccupationTextView.setText(occupation);
                    mOccupationEditText.setText("");
                }
                Backendless.Persistence.save(mGuardian, new AsyncCallback<Guardian>() {
                    @Override
                    public void handleResponse(Guardian guardian) {
                        Log.i(TAG, "Saved" + guardian.toString());
                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Log.i(TAG, backendlessFault.toString());
                    }
                });

            }
        });

        return rootView;
    }

    //    Retrieves intent and sets elements on layout file to properties of guardian     //
    @Override
    public void onStart(){
        int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX, -1);
        if (index != -1){
            mGuardian = (Guardian)Family.getFamily().getFamilyList().get(index);
            mFirstNameTextView.setText(mGuardian.getFirstName());
            mLastNameTextView.setText(mGuardian.getLastName());
            mOccupationTextView.setText(mGuardian.getOccupation());
        }
        super.onStart();
    }
}