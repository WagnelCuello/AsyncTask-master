package com.example.wagnel.asynctask;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BlankFragment extends Fragment implements View.OnClickListener {
    private EditText etText;
    private Button btnStart;
    private TextView tvProcess, tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        etText = rootView.findViewById(R.id.et_text_ini);
        btnStart = rootView.findViewById(R.id.btnStart);
        tvProcess = rootView.findViewById(R.id.tvProcess);
        tvResult = rootView.findViewById(R.id.tvResult);

        btnStart.setOnClickListener(this);

        return  rootView;
    }

    @Override
    public void onClick(View view) {
        if (etText.getText().toString().trim() == "")
            Toast.makeText(getContext(), "Enter a value", Toast.LENGTH_SHORT).show();
        else {
            Boolean result = isPrime(Integer.parseInt(etText.getText().toString()));
            tvProcess.setText("Procesando...");

            if (result)
                tvResult.setText("'" + etText.getText() + "' es Primo");
            else
                tvResult.setText("'" + etText.getText() + "' no es Primo");
        }
    }

    // This method return true if num is prime
    private Boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        for (int i=2; i*i<=num; i+=2) {
            if(num%i==0)
                return false;
        }
        return true;
    }

    public void onPreExecute(){
        @SuppressLint("StaticFieldLeak")
        AsyncTask<String, Integer, Long> asyncTask = new AsyncTask<String, Integer, Long>() {
            @Override
            protected Long doInBackground(String... strings) {
                long ls = 0;
                for (String string: strings) {
                    Integer integer = new Integer(string);
                    publishProgress(integer);
                    ls += integer;
                }
                return ls;
            }
        };
        asyncTask.execute("1", "2", "3");
    }
}
