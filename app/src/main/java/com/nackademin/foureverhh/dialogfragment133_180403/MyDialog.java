package com.nackademin.foureverhh.dialogfragment133_180403;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MyDialog extends DialogFragment implements View.OnClickListener {

    Button yes,no;
    Communicator communicator;

    //Let the Communicator work on the current context,the MainActivity.java
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (Communicator) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dialog,null);
        setCancelable(false);//Make the dialog fragment can not be cancelled
        yes = view.findViewById(R.id.yes);
        no = view.findViewById(R.id.no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.yes:
                dismiss(); //To cancel the dialog fragment
                communicator.onDialogMessage("Yes is clicked");
                //Toast.makeText(getActivity(),"Yes is clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.no:
                dismiss(); //To cancel the dialog fragment
                communicator.onDialogMessage("No is clicked");
                //Toast.makeText(getActivity(),"No is clicked",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    interface Communicator{
        void onDialogMessage(String message);
    }
}
