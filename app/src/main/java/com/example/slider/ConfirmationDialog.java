package com.example.slider;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class ConfirmationDialog extends DialogFragment {

    ConfirmationDialogListener listener = null;

    private String message;
    private String positiveButtonMessage;
    private String negativeButtonMessage;

    public ConfirmationDialog(String message, String positiveButtonMessage) {
        this.message = message;
        this.positiveButtonMessage = positiveButtonMessage;
    }

    public ConfirmationDialog(String message, String positiveButtonMessage, String negativeButtonMessage) {
        this.message = message;
        this.positiveButtonMessage = positiveButtonMessage;
        this.negativeButtonMessage = negativeButtonMessage;
    }

    @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setMessage(message);
            builder.setPositiveButton(positiveButtonMessage, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (listener != null) listener.onPositiveButtonClick();
                }
            });
            if (negativeButtonMessage != null) {
                builder.setNegativeButton(negativeButtonMessage, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (listener != null) listener.onNegativeButtonClick();
                    }
                });
            }
            return builder.create();
        }


        public interface ConfirmationDialogListener {
        void onPositiveButtonClick();
        void onNegativeButtonClick();
    }

}