package com.dalton.collegeapp_dalton2019;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.dalton.collegeapp_dalton2019.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePickerFragment extends DialogFragment {

    //    Variable instantiation for mDatePicker and constants DATE_ARGUMENT, and EXTRA_DATE_OF_BIRTH  //

    public static final String DATE_ARGUMENT = "date of birth";
    public static final String EXTRA_DATE_OF_BIRTH = "org.pltw.examples.collegeappanswerkey.dateofbirth";
    private DatePicker mDatePicker;

    //         On create, inflate with dialog_date_of_birth.xml, setup calendar, setup alert dialog  //
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_date_of_birth, null);

        Date date = (Date)(getArguments().getSerializable(DATE_ARGUMENT));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_of_birth);
        mDatePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Date of Birth")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Date date = new GregorianCalendar(mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth())
                                .getTime();
                        sendResult(Activity.RESULT_OK, date);
                    }
                })
                .create();
    }

    //      Create a new DatePickerFragment     //
    public static DatePickerFragment newInstance(Date date){
        Bundle args = new Bundle();
        args.putSerializable(DATE_ARGUMENT, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //    Provide date on request, if fragment not null creates intent     //
    private void sendResult(int resultCode, Date date){
        if (getTargetFragment() != null){
            Intent intent = new Intent();
            intent.putExtra(EXTRA_DATE_OF_BIRTH, date);
            getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
        }
    }
}