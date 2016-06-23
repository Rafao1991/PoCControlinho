package example.poccontrolinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ControlinhoControl controlinhoControl = (ControlinhoControl)findViewById(R.id.controlinho);
        controlinhoControl.initControl(new Controle_Conta());
        controlinhoControl.setSelectedItemEvent(new SelectedItemEvent() {
            @Override
            public <T> void onSelectItem(T value) {
                Toast.makeText(getBaseContext(), (String) value, Toast.LENGTH_SHORT).show();
            }
        });

        final ControlinhoControl controlinhoControl1 = (ControlinhoControl)findViewById(R.id.controlinho1);
        controlinhoControl1.initControl(new Controle_Cartao());
        controlinhoControl1.setSelectedItemEvent(new SelectedItemEvent() {
            @Override
            public <T> void onSelectItem(T value) {
                Toast.makeText(getBaseContext(), (String) value, Toast.LENGTH_SHORT).show();
            }
        });

        final ControlinhoControl controlinhoControl2 = (ControlinhoControl)findViewById(R.id.controlinho2);
        controlinhoControl2.initControl(new Controle_Conta());
        controlinhoControl2.setSelectedItemEvent(new SelectedItemEvent() {
            @Override
            public <T> void onSelectItem(T value) {
                Toast.makeText(getBaseContext(), (String) value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
