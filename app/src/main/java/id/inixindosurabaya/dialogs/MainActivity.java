package id.inixindosurabaya.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 1. inisialisasi komponen
    Button btn_dialog_alert, btn_dialog_listview, btn_dialog_radio, btn_dialog_checkbox;
    TextView txt_display_film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. mengenali komponen
        btn_dialog_alert = findViewById(R.id.btn_dialog_alert);
        btn_dialog_listview = findViewById(R.id.btn_dialog_listview);
        btn_dialog_radio = findViewById(R.id.btn_dialog_radio);
        btn_dialog_checkbox = findViewById(R.id.btn_dialog_checkbox);
        txt_display_film = findViewById(R.id.txt_display_film);

        // 3. event handling

        // event handling button dialog alert
        btn_dialog_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // membuat dialog alert
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Default Alert Dialog")
                        .setMessage("This is default alert dialog.")
                        .setPositiveButton("YES",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(),
                                                "Button YES is clicked", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("NO",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(),
                                                "Button NO is clicked", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNeutralButton("CANCEL",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(),
                                                "Button CANCEL is clicked", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setCancelable(false)
                        .show();
            }
        });

        // event handling button dialog listview
        btn_dialog_listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // memanggil array
                final String[] peoples = getResources()
                        .getStringArray(R.array.peoples);

                // membuat dialog kombinasi dengan listview
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Listview Alert Dialog")
                        .setItems(peoples, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // toast untuk memunculkan nama yg dipilih
                                Toast.makeText(getApplicationContext(),
                                        "You are click: " + peoples[which],
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("YES", null)
                        .setCancelable(false)
                        .show();
            }
        });

        // event handling button dialog radio
        btn_dialog_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // memanggil array gender
                final String[] gender = getResources()
                        .getStringArray(R.array.gender);

                // item yg default terpilih
                int item = 0;
                final int[] checkedItem = {0};

                // membuat array sebagai list
                final List<String> genderLists = Arrays.asList(gender);

                // membuat alert dialog kombinasi dengan radio
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose Your Gender")
                        .setSingleChoiceItems(gender, item,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // toast menampilkan index gender yg dipilih
                                        checkedItem[0] = which;
                                        Toast.makeText(getApplicationContext(),
                                                "Index gender: " + which,
                                                Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setPositiveButton("YES",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(),
                                                "Your gender is: "
                                                        + genderLists.get(checkedItem[0]),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setCancelable(false)
                        .show();
            }
        });

        // event handling button dialog checkbox
        btn_dialog_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // memanggil array films
                String[] films = getResources()
                        .getStringArray(R.array.films);

                // status checkbox tidak ada yg dicentang
                final boolean[] checkedItem = {
                        false, false, false, false, false
                };

                // membuat array films menjadi list
                final List<String> filmLists = Arrays.asList(films);

                // membuat dialog kombinasi dengan checkbox
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Film List")
                        .setMultiChoiceItems(films, checkedItem,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                    }
                                })
                        .setPositiveButton("YES",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        int x = 0;
                                        while (x < checkedItem.length) {
                                            boolean checked = checkedItem[x];
                                            if (checked) {
                                                txt_display_film.setText(txt_display_film.getText() +
                                                        filmLists.get(x) + "\n");
                                            }
                                            x++;
                                        }
                                    }
                                })
                        .setCancelable(false)
                        .show();
            }
        });
    }
}
