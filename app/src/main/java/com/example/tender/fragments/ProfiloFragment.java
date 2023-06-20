package com.example.tender.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.tender.R;
import com.example.tender.communication.SocketClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class ProfiloFragment extends Fragment {
    private TextView textViewNomeUtente;
    private TextView textViewPortafoglio;
    float portafoglio;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profilo, container, false);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Profilo");
        }
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        textViewNomeUtente = view.findViewById(R.id.textViewNomeUtenteProfilo);
        textViewPortafoglio = view.findViewById(R.id.textViewPortafoglio);

        String username = preferences.getString("username","UTENTE");
        portafoglio = preferences.getFloat("portafoglio",0.0f);

        textViewNomeUtente.setText(username);
        textViewPortafoglio.setText(String.format(Locale.getDefault(),"$%.2f",portafoglio));

        view.findViewById(R.id.buttonAddMoney).setOnClickListener(view12 -> showDialog(view12.getContext()));

        view.findViewById(R.id.buttonLogOut).setOnClickListener(view1 -> {
            SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("logged",false);
            editor.apply();
            Navigation.findNavController(view1).navigate(R.id.loginFragment2);
            BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.nav_view);
            bottomNavigationView.setVisibility(View.GONE);
        });
        return view;
    }

    private void showDialog(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Carica credito portafoglio");
        builder.setMessage("Inserisci l'importo da caricare");

        final EditText text = new EditText(context);
        text.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        builder.setView(text);

        builder.setPositiveButton("Aggiungi", (dialog, id) -> {
            SocketClient socketClient = new SocketClient(getContext());
            float addDenaro = Float.parseFloat(text.getText().toString());
            socketClient.requestAggiungiDenaro(addDenaro);
            portafoglio += addDenaro;
            SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putFloat("portafoglio",portafoglio);
            editor.apply();
            textViewPortafoglio.setText(String.format(Locale.getDefault(),"$%.2f",portafoglio));
            Toast.makeText(context, "Credito caricato correttamente!", Toast.LENGTH_SHORT).show();

        });
        builder.setNegativeButton("Cancella", (dialog, id) -> dialog.cancel());

        builder.create().show();
    }
}
