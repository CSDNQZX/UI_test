package com.mining.modle.Dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mining.R;

/**
 * Created by Administrator on 2019-4-21.
 */

public class EditNameDialogFragment  extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.dialog_ok_layout, container);
        //getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE); //
        return view;
    }
}

