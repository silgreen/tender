package com.example.tender.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tender.R;

public class SearchFragment extends Fragment {
    private RadioButton radioButtonCocktail;
    private RadioButton radioButtonFrullato;
    private EditText editTextNomeDrink;
    private EditText editTextIngrediente;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        radioButtonCocktail = view.findViewById(R.id.radioButtonCocktail);
        radioButtonFrullato = view.findViewById(R.id.radioButtonFrullato);
        editTextNomeDrink = view.findViewById(R.id.editTextDrinkName);
        editTextIngrediente = view.findViewById(R.id.editTextIngrediente);

        view.findViewById(R.id.buttonSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* metodo per la ricerca del drink per nome ingrediente o tipo di drink */

                //searchDrink(editTextNomeDrink.getText().toString(),
                //  editTextIngrediente.getText().toString(),
                //  getTextRadioButtonSelected());

                /* reindirizzamento ad un altro fragment con i risultati della ricerca */
            }
        });
        return view;
    }

    private String getTextRadioButtonSelected(){
        if(radioButtonCocktail.isChecked())return radioButtonCocktail.getText().toString();
        return radioButtonFrullato.getText().toString();
    }
}
