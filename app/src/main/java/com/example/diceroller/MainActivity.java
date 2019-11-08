package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView p1;
    ArrayList<String> question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        p1 = (TextView)findViewById(R.id.counter);

        question = new ArrayList<>();
        question.add("If you could go anywhere in the world, where would you go?");
        question.add("If you were stranded on a desert island, what three things would you want to take with you?");
        question.add("If you could eat only one food for the rest of your life, what would that be?");
        question.add("If you won a million dollars, what is the first thing you would buy?");
        question.add("If you could spaned the day with one fictional character, who would it be?");
        question.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void RandomNo(View view)
    {
      Random Ran = new Random();
      int number = Ran.nextInt(5)+1;
      TextView mrtext = (TextView) findViewById(R.id.textView);
      String myString = String.valueOf(number);
        mrtext.setText(myString);

        EditText myText;
        myText = (EditText) findViewById(R.id.input);
        int numberinput= Integer.parseInt(myText.getText().toString());

        if (numberinput < 1 || numberinput >6)
        {
            Toast.makeText(this, " Wrong! Try again b", Toast.LENGTH_SHORT).show();
        }
        else if (numberinput == number)
        {
            Toast.makeText(this, " Congratulation!", Toast.LENGTH_SHORT).show();
            int counter = Integer.parseInt(p1.getText().toString());
            counter = counter +1;
            p1.setText(String.valueOf(counter));

        }

    }

    public void roll_the_dice (View view){
        Random Ran = new Random ();
        int number = Ran.nextInt(6)+1;
        String questions = question.get(number - 1);
        TextView mrtext = (TextView) findViewById(R.id.textView5);
        mrtext.setText(questions);

    }

}
