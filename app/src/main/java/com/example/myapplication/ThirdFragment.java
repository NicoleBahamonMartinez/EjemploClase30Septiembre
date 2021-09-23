package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int ValorPedido;
    private String tipoIdentificacion;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ValorPedido=ThirdFragmentArgs.fromBundle(getArguments()).getValorPedido();
        return inflater.inflate(R.layout.fragment_third, container, false);

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView valorPedidoValue=view.findViewById(R.id.valorPedidoValue);
        valorPedidoValue.setText("$"+ValorPedido);
        EditText name= view.findViewById(R.id.editTextTextPersonName);
        EditText email=view.findViewById(R.id.editTextTextEmailAddress);
        EditText phone=view.findViewById(R.id.editTextPhone);
        EditText address=view.findViewById(R.id.editTextTextPostalAddress);
        EditText identification=view.findViewById(R.id.editTextNumber);
        RadioGroup rg=view.findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.ccRadio:
                        tipoIdentificacion="C.C:";
                        break;
                    case R.id.tiRadio:
                        tipoIdentificacion="T.I:";
                        break;
                    case R.id.ppRadio:
                        tipoIdentificacion="Pasaporte:";
                        break;
                    case R.id.CERadio:
                        tipoIdentificacion="C.E:";
                        break;
                }
            }
        });
        view.findViewById(R.id.fnPedido).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] datosEntregar={name.getText().toString(),email.getText().toString(),phone.getText().toString(),address.getText().toString(),String.valueOf(ValorPedido),tipoIdentificacion,identification.getText().toString()};
                ThirdFragmentDirections.ActionThirdFragmentToFifthFragment action=ThirdFragmentDirections.actionThirdFragmentToFifthFragment(datosEntregar);
                NavHostFragment.findNavController(ThirdFragment.this).navigate(action);

            }
        });
    }
}