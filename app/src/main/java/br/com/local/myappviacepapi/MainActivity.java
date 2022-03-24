package br.com.local.myappviacepapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button btnBuscarCep;
    EditText txtCep;
    TextView Cep;
    TextView Logradouro;
    TextView Complemento;
    TextView Bairro;
    TextView Cidade;
    TextView Estado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCep = findViewById(R.id.txtCep);
        Cep = findViewById(R.id.Logradouro);
        Logradouro = findViewById(R.id.Logradouro);
        Complemento = findViewById(R.id.Logradouro);
        Bairro = findViewById(R.id.Logradouro);
        Cidade = findViewById(R.id.Logradouro);
        Estado = findViewById(R.id.Estado);
        btnBuscarCep = findViewById(R.id.btnBuscaCep);

        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String endereco = txtCep.getText().toString().trim();

                try {
                    //preencher o cep no lblResposta do layout
                    CEP retorno = new HttpService(txtCep.getText().toString().trim()).execute().get();
                    Cep.setText("Cep: "+retorno.getCep());
                    Logradouro.setText("Logradouro: "+retorno.getLogradouro());
                    Complemento.setText("Complemento: "+retorno.getComplemento());
                    Bairro.setText("Bairro" +retorno.getBairro());
                    Cidade.setText("Cidade" +retorno.getLocalidade());
                    Estado.setText("Estado" +retorno.getUf());

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });

    }
}