package com.example.tender.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tender.R;
import com.example.tender.communication.SocketClient;
import com.example.tender.entities.User;

public class ProfiloFragment extends Fragment {
    private TextView textViewNomeUtente;
    private TextView textViewPortafoglio;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profilo, container, false);
        textViewNomeUtente = view.findViewById(R.id.textViewNomeUtenteProfilo);
        textViewPortafoglio = view.findViewById(R.id.textViewPortafoglio);

        /*
        textViewNomeUtente.setText(new User().getUsername());
        textViewPortafoglio.setText(Double.toString(new User().getPortafoglio()));
         */

        view.findViewById(R.id.buttonAddMoney).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view.getContext());

            }
        });
        view.findViewById(R.id.buttonLogOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //LOG OUT
            }
        });
        return view;
    }

    private void showDialog(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Aggiungi soldi");
        builder.setMessage("Inserisci quante euro vuoi aggiungere");

        final EditText text = new EditText(context);
        text.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        builder.setView(text);

        builder.setPositiveButton("Aggiungi", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                SocketClient socketClient = new SocketClient(getContext());
                socketClient.startAggiungiDenaro(Double.parseDouble(text.toString()));
            }
        });
        builder.setNegativeButton("Cancella", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        builder.create().show();
    }
}
