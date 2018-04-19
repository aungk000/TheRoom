package me.aungkooo.theroom.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.aungkooo.theroom.R;
import me.aungkooo.theroom.Utils;
import me.aungkooo.theroom.database.User;
import me.aungkooo.theroom.listener.OnDialogDismissListener;

/**
 * Created by Ko Oo on 18/4/2018.
 */

public class DialogNewUser extends DialogFragment
{
    @BindView(R.id.edit_username) TextInputEditText editUsername;
    @BindView(R.id.edit_email) TextInputEditText editEmail;
    @BindView(R.id.btn_add_new_user) Button btnAdd;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_new_user, (ViewGroup) getView());
        builder.setView(view);

        ButterKnife.bind(this, view);

        final OnDialogDismissListener listener = (OnDialogDismissListener) getActivity();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(Utils.get(editUsername), Utils.get(editEmail));
                listener.onDialogDismissed(user);

                dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setWindowAnimations(R.style.DialogAnimation);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        return dialog;
    }
}
