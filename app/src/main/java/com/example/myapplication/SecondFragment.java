package com.example.myapplication;

import static com.example.myapplication.R.id.subtotalLicores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    int[] PreciosLicores ={45900,40900,16900,75400};
    int[] PreciosGaseosas ={3800,3000,34000,40000};
    int[] PreciosJugos ={24000,16000,36000};
    int[] PreciosAguas ={28000,28000,20000};
    int valorLicores=0;
    int valorGaseosas=0;
    int valorJugos=0;
    int valorAguas=0;
    int cantidadLicores=1;
    int cantidadAguas=1;
    int cantidadGaseosas=1;
    int cantidadJugos=1;
    int SubtotalLicores=0;
    int SubtotalGaseosas=0;
    int SubtotalJugos=0;
    int SubtotalAguas=0;
    int Total=0;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonContinuarSecondfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragmentDirections.ActionSecondFragmentToThirdFragment action=SecondFragmentDirections.actionSecondFragmentToThirdFragment(Total);
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(action);
            }
        });
        Spinner Licores = view.findViewById(R.id.spinnerLicores);
        Spinner Gaseosas = view.findViewById(R.id.spinnerGaseosas);
        Spinner Jugos = view.findViewById(R.id.spinnerJugos);
        Spinner Aguas = view.findViewById(R.id.spinnerAguas);

        String[] OpcionesLicores ={"","Poker Bt x36","Aguila Bt x36","Redds Lt x8","Corona Bt x24"};
        String[] OpcionesGaseosas ={"","Coca Cola 3LT","Manzana 3LT","Postobon 250CC X24","Coca Cola 250CC X24"};
        String[] OpcionesJugos ={"","Hit Surtido x24","Tampico Bolsa x36","Gaterode Bt x8"};
        String[] OpcionesAguas ={"","Manantial Bt x16","Brisa Bt x16","Cristalina Bt x24"};

        int[] PreciosLicores ={0,45900,40900,16900,75400};
        int[] PreciosGaseosas ={0,3800,3000,34000,40000};
        int[] PreciosJugos ={0,24000,16000,36000};
        int[] PreciosAguas ={0,28000,28000,20000};

        ArrayAdapter<String> adapterLicores = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item,OpcionesLicores);
        ArrayAdapter<String> adapterGaseosas = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item,OpcionesGaseosas);
        ArrayAdapter<String> adapterJugos = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item,OpcionesJugos);
        ArrayAdapter<String> adapterAguas = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item,OpcionesAguas);

        Licores.setAdapter(adapterLicores);
        Gaseosas.setAdapter(adapterGaseosas);
        Jugos.setAdapter(adapterJugos);
        Aguas.setAdapter(adapterAguas);

        TextView SubTotalLicores=view.findViewById(R.id.subtotalLicores);
        TextView SubTotalGaseosas=view.findViewById(R.id.subtotalGaseosas);
        TextView SubTotalJugos=view.findViewById(R.id.subtotalJugos);
        TextView SubTotalAguas=view.findViewById(R.id.subtotalAguas);
        TextView TotalValue=view.findViewById(R.id.totalValue);

        Licores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                valorLicores=PreciosLicores[i];
                SubTotalLicores.setText("Subtotal:$"+String.valueOf(valorLicores*cantidadLicores));
                SubtotalLicores=cantidadLicores*valorLicores;
                Total=SubtotalLicores+SubtotalAguas+SubtotalGaseosas+SubtotalJugos;
                TotalValue.setText(String.valueOf(Total));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                SubTotalLicores.setText("Subtotal:$0");

            }
        });
        Gaseosas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                valorGaseosas=PreciosGaseosas[i];
                SubTotalGaseosas.setText("Subtotal:$"+String.valueOf(valorGaseosas*cantidadGaseosas));
                SubtotalGaseosas=cantidadGaseosas*valorGaseosas;
                Total=SubtotalLicores+SubtotalAguas+SubtotalGaseosas+SubtotalJugos;
                TotalValue.setText(String.valueOf(Total));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                SubTotalGaseosas.setText("Subtotal:$0");

            }
        });
        Jugos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                valorJugos=PreciosJugos[i];
                SubTotalJugos.setText("Subtotal:$"+String.valueOf(valorJugos*cantidadJugos));
                SubtotalJugos=valorJugos*cantidadJugos;
                Total=SubtotalLicores+SubtotalAguas+SubtotalGaseosas+SubtotalJugos;
                TotalValue.setText(String.valueOf(Total));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                SubTotalJugos.setText("Subtotal:$0");

            }
        });
        Aguas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                valorAguas=PreciosAguas[i];
                SubTotalAguas.setText("Subtotal:$"+String.valueOf(valorAguas*cantidadAguas));
                SubtotalAguas=valorAguas*cantidadAguas;
                Total=SubtotalLicores+SubtotalAguas+SubtotalGaseosas+SubtotalJugos;
                TotalValue.setText(String.valueOf(Total));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                SubTotalAguas.setText("Subtotal:$0");

            }
        });

        SeekBar cantidadLicoresSeek=view.findViewById(R.id.seekBarLicores);
        SeekBar cantidadGaseosasSeek=view.findViewById(R.id.seekBarGaseosas);
        SeekBar cantidadJugosSeek=view.findViewById(R.id.seekBarJugos);
        SeekBar cantidadAguasSeek=view.findViewById(R.id.seekBarAguas);
        TextView cantidadLicoresText=view.findViewById(R.id.cantidadLicores);
        TextView cantidadGaseosasText=view.findViewById(R.id.cantidadGaseosas);
        TextView cantidadJugosText=view.findViewById(R.id.cantidadJugos);
        TextView cantidadAguasText=view.findViewById(R.id.cantidadAguas);

        cantidadLicoresSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cantidadLicoresText.setText("Cantidad:"+i);
                cantidadLicores=i;
                SubTotalLicores.setText("Subtotal:$"+String.valueOf(valorLicores*cantidadLicores));
                SubtotalLicores=cantidadLicores*valorLicores;
                Total=SubtotalLicores+SubtotalAguas+SubtotalGaseosas+SubtotalJugos;
                TotalValue.setText(String.valueOf(Total));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        cantidadAguasSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cantidadAguasText.setText("Cantidad:"+i);
                cantidadAguas=i;
                SubTotalAguas.setText("Subtotal:$"+String.valueOf(valorAguas*cantidadAguas));
                SubtotalAguas=valorAguas*cantidadAguas;
                Total=SubtotalLicores+SubtotalAguas+SubtotalGaseosas+SubtotalJugos;
                TotalValue.setText(String.valueOf(Total));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        cantidadGaseosasSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cantidadGaseosasText.setText("Cantidad:"+i);
                cantidadGaseosas=i;
                SubTotalGaseosas.setText("Subtotal:$"+String.valueOf(valorGaseosas*cantidadGaseosas));
                SubtotalGaseosas=cantidadGaseosas*valorGaseosas;
                Total=SubtotalLicores+SubtotalAguas+SubtotalGaseosas+SubtotalJugos;
                TotalValue.setText(String.valueOf(Total));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        cantidadJugosSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cantidadJugosText.setText("Cantidad:"+i);
                cantidadJugos=i;
                SubTotalJugos.setText("Subtotal:$"+String.valueOf(valorJugos*cantidadJugos));
                SubtotalJugos=valorJugos*cantidadJugos;
                Total=SubtotalLicores+SubtotalAguas+SubtotalGaseosas+SubtotalJugos;
                TotalValue.setText(String.valueOf(Total));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}