package com.example.rkarthikraj.sqltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText userinput;
    TextView sqlmessage;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userinput = (EditText)findViewById(R.id.userinput);
        sqlmessage=(TextView)findViewById(R.id.sqlmessage);
        dbHandler=new MyDBHandler(this, "products.db" , null  , 1);

        printDatabase();
    }
    public void onClickAdd(View view)
    {
        Products product=new Products(userinput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    public void  onClickDelete(View view)
    {
        String inputText=userinput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }


    public void printDatabase()
    {
        sqlmessage.setText(dbHandler.databaseToString());
        userinput.setText("");
    }


}
